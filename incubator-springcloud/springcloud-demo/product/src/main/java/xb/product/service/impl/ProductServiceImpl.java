package xb.product.service.impl;

import com.google.gson.Gson;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xb.product.DTO.CartDTO;
import xb.product.dataobject.ProductInfo;
import xb.product.enums.ProductStatusEnum;
import xb.product.enums.ResultEnum;
import xb.product.exception.ProductException;
import xb.product.repository.ProductInfoRepository;
import xb.product.service.ProductService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductInfoRepository productInfoRepository;

    @Autowired
    AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> list) {
        return productInfoRepository.findByProductIdIn(list);
    }

    @Override

    public void decreaseStock(List<CartDTO> cartDTOList) {
        List<ProductInfo> list = decreaseStockProcess(cartDTOList);
        //发送消息
        amqpTemplate.convertAndSend("productInfo", new Gson().toJson(list));
    }

    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<CartDTO> cartDTOList) {
        List<ProductInfo> list = new ArrayList<>();
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            //判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //判断库存是否足够
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
            list.add(productInfo);
        }
        return list;
    }
}

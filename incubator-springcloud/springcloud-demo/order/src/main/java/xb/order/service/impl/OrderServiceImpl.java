package xb.order.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import xb.order.client.ProductClient;
import xb.order.dataobject.OrderDetail;
import xb.order.dataobject.OrderMaster;
import xb.order.dataobject.ProductInfo;
import xb.order.dto.CartDTO;
import xb.order.dto.OrderDTO;
import xb.order.enums.OrderStatus;
import xb.order.enums.PayStatus;
import xb.order.enums.ResultEnum;
import xb.order.exception.OrderException;
import xb.order.repository.OrderDetailRepository;
import xb.order.repository.OrderMasterRepository;
import xb.order.service.OrderService;
import xb.order.utils.KeyUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    ProductClient productClient;
    @Autowired
    OrderMasterRepository orderMasterRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    /*1.参数校验
    2.查询商品信息
    3.计算总价
    4.扣库存
    5.订单入库*/
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        /*
            传入的orderDTO中的orderDetail只有一部分信息，需要在这里将信息补全
         */
        String orderId = KeyUtil.genUniqueKey();
        //查询商品信息
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);
        BigDecimal amount = BigDecimal.ZERO;
        //计算总价
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for (ProductInfo productInfo : productInfoList) {
                if (orderDetail.getProductId().equals(productInfo.getProductId())) {
                    amount = new BigDecimal(orderDetail.getProductQuantity()).multiply(productInfo.getProductPrice()).add(amount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        log.info("amount is {}" + amount);
        //扣库存
        List<CartDTO> cartDTOS = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        log.info("cartDtoList is {}" + cartDTOS);
        productClient.decreaseStock(cartDTOS);
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(amount);
        orderMaster.setOrderStatus(OrderStatus.NEW.getCode());
        orderMaster.setPayStatus(PayStatus.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }

    @Override
    public OrderDTO finishi(String orderId) {
        //校验订单是否存在
        Optional<OrderMaster> orderMasterOptional = orderMasterRepository.findById(orderId);
        if(!orderMasterOptional.isPresent()){
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        //判断订单状态
        OrderMaster orderMaster = orderMasterOptional.get();
        if(!OrderStatus.NEW.getCode().equals(orderMaster.getOrderStatus())){
            throw new OrderException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态为已完结
        orderMaster.setOrderStatus(OrderStatus.FINISH.getCode());
        orderMasterRepository.save(orderMaster);
        //查询订单详情
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if(CollectionUtils.isEmpty(orderDetailList)){
            throw new OrderException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}

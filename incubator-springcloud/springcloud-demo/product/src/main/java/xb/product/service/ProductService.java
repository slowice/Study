package xb.product.service;

import xb.product.DTO.CartDTO;
import xb.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {
    /*
     * 查询所有上架商品
     * */
    List<ProductInfo> findUpAll();

    //根据Id集合查商品集合
    List<ProductInfo> findList(List<String> list);

    void decreaseStock(List<CartDTO> cartDTOList);
}

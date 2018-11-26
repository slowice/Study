package xb.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import xb.order.dataobject.ProductInfo;
import xb.order.dto.CartDTO;

import java.util.List;

@FeignClient(name = "product",fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {
    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);

    //触发服务降级时，实际会执行以下方法
    @Component
    static class ProductClientFallback implements ProductClient{

        @Override
        public String productMsg() {
            return null;
        }

        @Override
        public List<ProductInfo> listForOrder(List<String> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<CartDTO> cartDTOList) {

        }
    }
}

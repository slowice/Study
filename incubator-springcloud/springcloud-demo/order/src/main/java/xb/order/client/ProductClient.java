package xb.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import xb.order.dataobject.ProductInfo;

import java.util.Arrays;
import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {
    @GetMapping("/msg")
    String productMsg();

    @GetMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);
}

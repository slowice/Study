package xb.order.controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import xb.order.VO.ResultVO;
import xb.order.client.ProductClient;
import xb.order.converter.OrderForm2OrderDTO;
import xb.order.dataobject.ProductInfo;
import xb.order.dto.CartDTO;
import xb.order.dto.OrderDTO;
import xb.order.enums.ResultEnum;
import xb.order.exception.OrderException;
import xb.order.form.OrderForm;
import xb.order.service.OrderService;
import xb.order.utils.ResultVOUtil;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductClient productClient;

    /*1.参数校验
    2.根据传入的商品ID查询商品信息
    3.计算总价
    4.扣库存
    5.订单入库*/
    @PostMapping("/create")
    //BindingResult用于表单认证
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("创建订单参数不正确，orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        //通过一个转换方法，完成前端参数与service参数的转换
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);

        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("购物车为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }

    @GetMapping("/getProductList")
    public String getProductlist() {
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("be6b8230c47911e88118ef302013fbb6"));
        System.out.println(new Gson().toJson(productInfoList));
        return new Gson().toJson(productInfoList);
    }

    @GetMapping("/decreaseStock")
    public String decreaseStock() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("8461c072c47911e88118ef302013fbb6", 2)));
        return "ok";
    }

    @PostMapping("/finish")
    public ResultVO finish(@RequestParam("orderId") String orderId){
        return ResultVOUtil.success(orderService.finishi(orderId));
    }
}

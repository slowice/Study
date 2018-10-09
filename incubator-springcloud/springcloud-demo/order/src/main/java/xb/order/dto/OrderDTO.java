package xb.order.dto;

import lombok.Data;
import xb.order.dataobject.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {
    private String orderId;
    //购买人信息
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    //订单总价
    private BigDecimal orderAmount;
    //订单状态
    private Integer orderStatus;
    private Integer payStatus;
    //订单详情
    List<OrderDetail> orderDetailList;
}

package xb.order.dto;

import lombok.Data;
import xb.order.dataobject.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;

    List<OrderDetail> orderDetailList;
}

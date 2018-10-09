package xb.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class OrderDetail {
    @Id
    private String detailId;
    private String orderId;
    //订单会拷贝一份商品的部分信息，因为商品信息是会变的，但是订单是不会变的
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
    private String productIcon;
}

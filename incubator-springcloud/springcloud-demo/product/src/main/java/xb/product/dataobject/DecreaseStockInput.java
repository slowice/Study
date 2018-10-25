package xb.product.dataobject;

import lombok.Data;

@Data
public class DecreaseStockInput {
    private String productId;
    private Integer productQuantity;
}

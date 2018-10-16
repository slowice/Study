package xb.mall.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {
    @Id
    private String id;
    private String name;
    private Integer stock;
    private String imgPath;
    private BigDecimal price;
    private String description;
}

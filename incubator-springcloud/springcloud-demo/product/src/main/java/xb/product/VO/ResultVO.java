package xb.product.VO;

import lombok.Data;

import java.util.Map;

@Data
public class ResultVO<T> {
    private String code;
    private String msg;
    private T data;
}

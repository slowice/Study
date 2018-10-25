package xb.order.message;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import xb.order.dataobject.ProductInfo;

import java.lang.reflect.Type;
import java.util.List;

@Component
@Slf4j
public class ProductInfoReceiver {
    private static final String PRODUCT_STOCK = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        Type type = new TypeToken<List<ProductInfo>>() {
        }.getType();
        List<ProductInfo> productInfoList = new Gson().fromJson(message, type);

        for (ProductInfo productInfo : productInfoList) {
            log.info("**********************" + productInfo);
            stringRedisTemplate.opsForValue().set("productInfo", String.valueOf(productInfo.getProductStock()));
        }
    }
}

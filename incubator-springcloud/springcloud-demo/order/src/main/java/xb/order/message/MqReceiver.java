package xb.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MqReceiver {

    @RabbitListener(queues = "myQueue")
    public void process(String message){
        log.info("MqReceiver: {}" + message);
    }

}

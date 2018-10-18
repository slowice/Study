package xb.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MqReceiver {

    //1.基础版@RabbitListener(queues = "myQueue")
    //2.自动添加Queue@RabbitListener(queuesToDeclare = @Queue("myQueue"))
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message){
        log.info("MqReceiver: {}" + message);
    }

    //消息的分组接收
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myComputer"),
            key = "computer",
            exchange = @Exchange("myOrder")
    ))
    public void computerProcess(String message) {
        log.info("MqReceiver: {}" + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myFruit"),
            key = "fruit",
            exchange = @Exchange("myOrder")
    ))
    public void fruitProcess(String message) {
        log.info("MqReceiver: {}" + message);
    }
}

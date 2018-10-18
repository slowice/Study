package xb.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class mqTest extends  OrderApplicationTests{
    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("myQueue","now " + new Date());
    }

    //对发送的消息添加路由，发往指定的queue
    @Test
    public void sendComputer() {
        amqpTemplate.convertAndSend("myOrder", "computer", "我是电脑订单");
    }

    @Test
    public void sendFruit() {
        amqpTemplate.convertAndSend("myOrder", "fruit", "我是水果订单");
    }
}

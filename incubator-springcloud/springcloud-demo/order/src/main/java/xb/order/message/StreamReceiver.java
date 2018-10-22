package xb.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

//@Component
//@EnableBinding(Sink.class)
@Slf4j
public class StreamReceiver {
    //@StreamListener(Sink.INPUT)
    //@SendTo("input2")
    public void processInput(Object message) {
        log.info("StreamReceiver message of processInput:{}", message);
    }

//    @StreamListener("output")
//    public void processOutput(Object message){
//        log.info("StreamReceiver message of processOutput:{}",message);
//    }
}

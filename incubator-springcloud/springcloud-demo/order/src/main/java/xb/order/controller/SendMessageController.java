package xb.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xb.order.message.StreamClient;

import java.util.Date;

@RestController
@EnableBinding({Source.class})
public class SendMessageController {
    @Autowired
    @Qualifier("output")
    MessageChannel output;

    @GetMapping("/sendMessage")
    public void process() {
        String message = "now " + new Date();
        output.send(MessageBuilder.withPayload(message).build());
    }
}

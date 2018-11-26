package xb.kafka_demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kafka")
public class TestController {
    @Autowired
    private SimpleProducer simpleProducer;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${kafka.topic.default}")
    private  String topic;

    @PostMapping
    public String sendKafka(){

        return null;
    }
}

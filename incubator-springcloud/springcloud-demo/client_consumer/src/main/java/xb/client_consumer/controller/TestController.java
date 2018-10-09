package xb.client_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public void consumer() {
        String response = restTemplate.getForEntity("http://client-producer/getTest", String.class).getBody();
        System.out.println(response);
    }
}

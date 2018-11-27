package xb.dockerjavademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerjavademoApplication {

    @GetMapping("/test")
    public String test(){
        return "aaaaaaaaaaaaa";
    }

    public static void main(String[] args) {
        SpringApplication.run(DockerjavademoApplication.class, args);
    }
}

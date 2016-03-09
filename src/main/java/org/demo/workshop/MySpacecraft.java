package org.demo.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class MySpacecraft {

    @RequestMapping("/")
    String home() {
        return "I can fly!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MySpacecraft.class, args);
    }
}

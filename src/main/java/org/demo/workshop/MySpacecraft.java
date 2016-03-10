package org.demo.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableFeignClients
public class MySpacecraft {

    @Autowired
    private HearingAid hearingAid;

    @Autowired
    private Logbook logbook;

    @RequestMapping("/say-hello/{spacecraft}")
    Message sayHello(@PathVariable String spacecraft) {
        Message receivedMessage = hearingAid.getAnswerFrom(spacecraft);
        logbook.save(receivedMessage);
        return receivedMessage;
    }

    @RequestMapping("/my-logbook")
    Iterable<Message> myLogbook(
        @RequestParam(value = "planet", required = false) String planet) {
        Iterable<Message> messages;
        if (planet != null) {
            messages = logbook.findByPlanet(planet);
        } else {
            messages = logbook.findAll();
        }
        return messages;
    }

    @RequestMapping("/answer")
    Message answer() {
        return new Message("Hello!", "Earth");
    }

    @RequestMapping("/")
    String home() {
        return "I can fly!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MySpacecraft.class, args);
    }
}

package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    String msg = null;

    @GetMapping("/")
    public String sayHello(){
        return msg;
    }
    @GetMapping("/DellEMC")
    public String sayHelloDell(){
        return "HelloDellEMC";
    }

    @Autowired
    public  WelcomeController(@Value("${Welcome.message}") final String message) {
        this.msg = message;
    }

}

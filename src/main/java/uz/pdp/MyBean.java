package uz.pdp;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    public void hi(){
        System.out.println("===== MyBean hi method worked. =====");
    }

    @PostConstruct
    private void init(){
        System.out.println("MyBean.... initialized.");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("MyBean.... destroyed.");
    }
}

package uz.pdp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uz.pdp.MyBean;

@Configuration
public class MyConfig {

    @Bean(name = "myBean", initMethod = "init", destroyMethod = "destroy")
    public MyBean myBean(){
        return new MyBean();
    }
}

// @Bean vs @Component
// @Bean - method level foydalaniladi
// @Component - class level da foydalaniladi

package uz.pdp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uz.pdp.MyBean;
import uz.pdp.MyBean2;

@Configuration
public class MyConfig2 {

    @Bean
    public MyBean2 myBean2(MyBean myBean){
        return new MyBean2(myBean);
    }
}

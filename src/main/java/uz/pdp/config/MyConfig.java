package uz.pdp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uz.pdp.MyBean;
import uz.pdp.MyBean2;

@Configuration
public class MyConfig {

    @Bean(name = "myBean", initMethod = "init", destroyMethod = "destroy")
    public MyBean myBean(){
        return new MyBean();
    }

    @Bean
    public MyBean2 myBean2(MyBean myBean){
        return new MyBean2(myBean);
    }
}

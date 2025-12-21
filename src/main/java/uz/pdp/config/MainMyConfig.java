package uz.pdp.config;

import org.springframework.context.annotation.*;
import uz.pdp.DbInit;
import uz.pdp.DbInitCondition;

@Configuration
@Import({MyConfig.class, MyConfig2.class})
@ImportResource(locations = "classpath:ioc-settings.xml")
@PropertySource("classpath:application.properties")
public class MainMyConfig {

    @Bean(name = "dbInit", initMethod = "init", destroyMethod = "destroy")
    @Conditional(DbInitCondition.class)
    public DbInit dbInit(){
        return new DbInit();
    }
}

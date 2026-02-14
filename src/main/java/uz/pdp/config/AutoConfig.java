package uz.pdp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"uz.pdp","uz.pdp.repository"})
public class AutoConfig {
}

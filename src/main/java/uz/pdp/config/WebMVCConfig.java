package uz.pdp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("uz.pdp")
@EnableWebMvc
public class WebMVCConfig implements WebMvcConfigurer {
}

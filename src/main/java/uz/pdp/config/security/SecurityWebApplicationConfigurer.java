package uz.pdp.config.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationConfigurer extends AbstractSecurityWebApplicationInitializer {
    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }
}

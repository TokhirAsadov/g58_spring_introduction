package uz.pdp.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.pdp.entity.AuthUser;

@Component
public class SessionUser {

    public AuthUser getUser(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication.getPrincipal() instanceof CustomUserDetails customUserDetails){
            return customUserDetails.getAuthUser();
        }
        return null;
    }

    public Integer getUserId(){
        AuthUser user = getUser();
        return user != null ? user.getId() : null;
    }

}

package uz.pdp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.pdp.config.security.CustomUserDetails;
import uz.pdp.config.security.SessionUser;
import uz.pdp.entity.AuthUser;

@Controller
@ResponseBody
public class AuthenticationUserInfoController {
    private final SessionUser sessionUser;

    public AuthenticationUserInfoController(SessionUser sessionUser) {
        this.sessionUser = sessionUser;
    }

    @GetMapping("/auth/userinfo")
    public String getUserInfo() {
//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
//        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
//        AuthUser authUser = customUserDetails.getAuthUser();
//        System.out.println("User ID: " + authUser.getId());
//        System.out.println("Username: " + authUser.getUsername());
//        customUserDetails.getAuthorities().forEach(System.out::println);
        AuthUser user = sessionUser.getUser();
        if (user == null) {
            return "No authenticated user found.";
        }
        System.out.println("User ID: " + user.getId());
        System.out.println("Username: " + user.getUsername());
        user.getRoles().forEach(role -> System.out.println("Role: " + role.getCode()));
        return "Authenticated user info accessed successfully!";
    }



    @GetMapping("/auth/userinfo2")
    public String getUserInfo2(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        AuthUser user = customUserDetails.getAuthUser();
        if (user == null) {
            return "No authenticated user found.";
        }
        System.out.println("User ID: " + user.getId());
        System.out.println("Username: " + user.getUsername());
        user.getRoles().forEach(role -> System.out.println("Role: " + role.getCode()));
        return "Authenticated user info accessed successfully!";
    }

}

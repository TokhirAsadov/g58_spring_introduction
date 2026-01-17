package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {

    // /auth/login
    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("auth/login");
    }

    // /auth/login
    @GetMapping("/logout")
    public ModelAndView logoutPage() {
        return new ModelAndView("auth/logout");
    }

    // /auth/register
//    @GetMapping("/register")
//    public ModelAndView registerPage() {
//        return new ModelAndView("auth/register");
//    }
}

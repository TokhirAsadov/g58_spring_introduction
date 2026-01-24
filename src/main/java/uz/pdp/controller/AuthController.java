package uz.pdp.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.dao.AuthUserDao;
import uz.pdp.entity.AuthUser;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthUserDao authUserDao;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthUserDao authUserDao, PasswordEncoder passwordEncoder) {
        this.authUserDao = authUserDao;
        this.passwordEncoder = passwordEncoder;
    }

    // /auth/login
    @GetMapping("/login")
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("auth/login");
        modelAndView.addObject("errorMessage", error);
        return modelAndView;
    }

    // /auth/login
    @GetMapping("/logout")
    public ModelAndView logoutPage() {
        return new ModelAndView("auth/logout");
    }

    // /auth/register
    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("auth/register");
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute AuthUser authUser) {
        System.out.println("Registering user: " + authUser);
        Integer id = authUserDao.save(AuthUser.builder()
                .username(authUser.getUsername())
                .password(passwordEncoder.encode(authUser.getPassword()))
//                .role("USER")
                .build());
        System.out.println("Saved user id: " + id);
        return new ModelAndView("redirect:/auth/login");
    }
}

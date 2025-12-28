package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.dto.UserCreator;

import java.util.UUID;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/homeModel/{userId}")
    public ModelAndView homeHome(
            @PathVariable(name = "userId") UUID id,
            @RequestParam(name = "username",required = false) String username,
            @RequestParam(name = "email", required = false) String email
    ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("email",email);
        modelAndView.addObject("uuid",id);
        modelAndView.addObject("username",username == null ? "anonymous": username);
        return modelAndView;
    }

    @PostMapping("/userCreator")
    public ModelAndView homePost(
            @RequestBody UserCreator creator
    ){
        System.out.println(creator);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("firstName",creator.firstName());
        modelAndView.addObject("lastName",creator.lastName());
        modelAndView.addObject("age",creator.age());
        return modelAndView;
    }

    @DeleteMapping("/home")
    public String homeDelete(){
        return "<h1>Hello Pdp</h1>";
    }

    @PutMapping("/home")
    public String homePut(){
        return "<h1>Hello Pdp</h1>";
    }
}

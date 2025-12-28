package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/homeModel")
    public ModelAndView homeHome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("username","asadov");
        return modelAndView;
    }

    @PostMapping("/home")
    public String homePost(){
        return "<h1>Hello Pdp</h1>";
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

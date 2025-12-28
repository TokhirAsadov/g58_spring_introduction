package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "<h1>Hello Pdp</h1>";
    }

    @GetMapping("/home/home")
    public String homeHome(){
        return "<h1>Hello Pdp { /home/home }</h1>";
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

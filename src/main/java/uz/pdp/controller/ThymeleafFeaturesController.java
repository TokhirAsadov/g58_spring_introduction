package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.dto.UserCreator;

@Controller
public class ThymeleafFeaturesController {

    @GetMapping("/text")
    public ModelAndView text(){
        ModelAndView modelAndView = new ModelAndView("text");
        modelAndView.addObject("user","ALi Valiyev");
        return modelAndView;
    }

    @GetMapping("/se")
    public ModelAndView se(){
        ModelAndView modelAndView = new ModelAndView("se");
        modelAndView.addObject("full_name","ALi Valiyev");
        modelAndView.addObject("user",new UserCreator(1,"Asadov", "Tohir",40));
        return modelAndView;
    }

    @GetMapping("/literals")
    public ModelAndView literals(){
        ModelAndView modelAndView = new ModelAndView("literals");
        modelAndView.addObject("full_name","ALi Valiyev");
        modelAndView.addObject("user",new UserCreator(1,"Asadov", "Tohir",40));
        return modelAndView;
    }
    @GetMapping("/arithmetics_operations")
    public ModelAndView arithmetics_operations(){
        ModelAndView modelAndView = new ModelAndView("arithmetics_operations");
        modelAndView.addObject("full_name","ALi Valiyev");
        modelAndView.addObject("user",new UserCreator(1,"Asadov", "Tohir",40));
        return modelAndView;
    }
    @GetMapping("/comparators")
    public ModelAndView comparators(){
        ModelAndView modelAndView = new ModelAndView("comparators");
        modelAndView.addObject("full_name","ALi Valiyev");
        modelAndView.addObject("user",new UserCreator(1,"Asadov", "Tohir",40));
        return modelAndView;
    }

}

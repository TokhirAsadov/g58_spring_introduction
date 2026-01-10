package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.dto.UserCreator;

import java.util.List;

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
    @GetMapping("/no_operation_token")
    public ModelAndView no_operation_token(){
        ModelAndView modelAndView = new ModelAndView("no_operation_token");
//        modelAndView.addObject("full_name","ALi Valiyev");
        modelAndView.addObject("user",new UserCreator(1,"Asadov", "Tohir",40));
        return modelAndView;
    }
    @GetMapping("/setter_values")
    public ModelAndView setter_values(){
        ModelAndView modelAndView = new ModelAndView("setter_values");
        modelAndView.addObject("user",new UserCreator(1,"Asadov", "Tohir",40));
        return modelAndView;
    }
    @GetMapping("/appending_prepending")
    public ModelAndView appending_prepending(){
        ModelAndView modelAndView = new ModelAndView("appending_prepending");
        modelAndView.addObject("colors", List.of("success", "danger", "info","warning"));
        return modelAndView;
    }
    @GetMapping("/fixed_value")
    public ModelAndView fixed_value(){
        ModelAndView modelAndView = new ModelAndView("fixed_value");
        modelAndView.addObject("premium", true);
        return modelAndView;
    }
    @GetMapping("/each")
    public ModelAndView each(){
        ModelAndView modelAndView = new ModelAndView("each");
        modelAndView.addObject("username", "Tohir Asadov");
        modelAndView.addObject("colors", List.of("success", "danger", "info","warning"));
        modelAndView.addObject("users", List.of(
                new UserCreator(1,"John", "Doe",40),
                new UserCreator(2,"Aliyev", "Vali",12),
                new UserCreator(3,"Eshmatov", "Toshmat",40)
        ));
        return modelAndView;
    }

    @GetMapping("/conditional")
    public ModelAndView conditional(){
        ModelAndView modelAndView = new ModelAndView("conditional");
        modelAndView.addObject("role","User1");
        return modelAndView;
    }

}

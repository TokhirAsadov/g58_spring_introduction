package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CSRFTestController {

    @PostMapping("/test")
    public String testCsrf() {
        return "CSRF test successful!";
    }

}

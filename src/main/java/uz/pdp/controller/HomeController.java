package uz.pdp.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class HomeController {
    private final MessageSource messageSource;

    public HomeController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/home")
    public String home(@RequestParam(name = "lang", required = false) String lang) {
        String message = messageSource.getMessage(
                "welcome",
                null,
                Locale.forLanguageTag(lang != null ? lang : "uz")
        );

        String message2 = messageSource.getMessage(
                "welcome2",
                new Object[]{"Umar"},
                Locale.forLanguageTag(lang != null ? lang : "uz")
        );
        String message3 = messageSource.getMessage(
                "welcome3",
                new Object[]{"Umar","Usmon","Ali"},
                Locale.forLanguageTag(lang != null ? lang : "uz")
        );
        System.out.println("Message: " + message);
        System.out.println("Message2: " + message2);
        System.out.println("Message3: " + message3);
        return "home";
    }
}

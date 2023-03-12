package dev.jlkeesh.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;

@Controller
public class UseTextController {


    private final MessageSource messageSource;

    public UseTextController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/usetext")
    public String timeIS(Model model) {
        model.addAttribute("message", "Hello PDP!");
        model.addAttribute("message2", "<h1>Hello PDP!</h1>");
        return "usetext";
    }

    @GetMapping("/template")
    public String template(Model model, @RequestParam(name = "lang", required = false) String language, @CookieValue(name = "language",required = false) String lang) {
        lang = Objects.requireNonNullElse(language, lang);
        System.out.println(lang);
        String en = messageSource.getMessage("welcome.message2",new Object[] {"Elshod"}, new Locale(lang));
        System.out.println(en);
        return "template";
    }

}

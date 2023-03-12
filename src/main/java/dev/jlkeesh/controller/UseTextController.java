package dev.jlkeesh.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
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
    public String template(Model model, @RequestParam(name = "lang", required = false) String language, @CookieValue(name = "language", required = false) String lang) {
        lang = Objects.requireNonNullElse(language, lang);
        System.out.println(lang);
        String en = messageSource.getMessage("welcome.message2", new Object[]{"Elshod"}, new Locale(lang));
        System.out.println(en);
        return "template";
    }

    @GetMapping("/blog")
    public String blogPage(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog";
    }

    @PostMapping("/blog")
    public String saveBlog(@Valid @ModelAttribute("blog") Blog blog, BindingResult errors) {
        if (errors.hasErrors()) {
            return "blog";
        }
        if (!blog.getTitle().equals(blog.getTitle2())){
            errors.rejectValue("title","Title and Title2 must match");
            errors.rejectValue("title2","Title and Title2 must match");
            return "blog";
        }
        System.out.println("blog = " + blog);
        return "redirect:/blog";
    }

}

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
class Blog {

    @NotBlank(message = "Title can not be blank")
    @Size(min = 10, max = 20, message = "Title size must be between {min} and {max}")
    String title;

    @NotBlank(message = "Title can not be blank")
    @Size(min = 10, max = 20, message = "Title size must be between {min} and {max}")
    String title2;
    @NotBlank(message = "Body can not be blank")
    String body;
}
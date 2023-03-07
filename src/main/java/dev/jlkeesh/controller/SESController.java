package dev.jlkeesh.controller;

import dev.jlkeesh.domain.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SESController {

    @GetMapping("/ses")
    public String timeIS(Model model) {
        Blog blog1 = new Blog("1", "8-mart", "bugun 8-mart", "Manguberdi Fastazyor");
        Blog blog2 = new Blog("2", "Turkey", "Earthq", "xyz");
        Blog blog3 = new Blog("3", "Uktamning Galstyugi", "Yoxud Qizil Galstyuk nimani anglatadi",
                "Elshod ga gapirmeylar");
        model.addAttribute("blog", blog1);
        model.addAttribute("blogs", List.of(blog1, blog2, blog3));
        model.addAttribute("students", List.of());
        return "ses";
    }

}

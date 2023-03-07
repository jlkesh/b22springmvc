package dev.jlkeesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class UseTextController {

    @GetMapping("/usetext")
    public String timeIS(Model model) {
        model.addAttribute("message", "Hello PDP!");
        model.addAttribute("message2", "<h1>Hello PDP!</h1>");
        return "usetext";
    }

}

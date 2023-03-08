package dev.jlkeesh.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    @PreAuthorize("hasRole('ADMIN')")
    public String homePage() {
        return "main";
    }
    @GetMapping("/home2")
    public String homePage2() {
        return "main2";
    }
}

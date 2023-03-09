package dev.jlkeesh.controller;

import dev.jlkeesh.config.security.AuthUserUserDetails;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    @PreAuthorize("hasRole('T()')")
    /*@Secured("ADMIN")*/
    public String hasAdminRole(Model model) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("userid", user.getId());
        return "main";
    }

    @GetMapping("/home2")
    @PreAuthorize("hasRole('ADMIN')")
    public String homePage2() {
        return "main2";
    }
}

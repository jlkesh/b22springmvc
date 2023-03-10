package dev.jlkeesh.controller;

import dev.jlkeesh.CustomRuntimeException;
import dev.jlkeesh.config.security.AuthUserUserDetails;
import dev.jlkeesh.config.security.UserSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class HomeController {

    private final UserSession userSession;

    public HomeController(UserSession userSession) {
        this.userSession = userSession;
    }

    @GetMapping("/home")
    public String hasAdminRole(Model model) {
        var s = "{bcrypt}$sdjvbhksnfbpgdhjnvlworhgeirnkvmd";
        var ss = "{noop}passwor";
        System.out.println("userSession.getUser().getId() = " + userSession.getId());
        return "home";
    }

    @GetMapping("/home2")
    public String homePage2() {
        if (new Random().nextBoolean()) {
            throw new CustomRuntimeException("Just For Fun Exception");
        }
        return "main2";
    }

/*    @ExceptionHandler(CustomRuntimeException.class)
    public String exception(Model model, CustomRuntimeException e) {
        model.addAttribute("error", e.getMessage());
        return "error";
    }*/
}

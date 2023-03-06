package dev.jlkeesh;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping(value = "/time")
    @ResponseBody
    public String timeIS() {
        return "Time is : " + LocalDateTime.now();
    }

    @GetMapping(value = "/main")
    public String main(@AuthenticationPrincipal User user) {
        System.out.println(user);
        return "main";
    }

}

package dev.jlkeesh;

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
    public String main() {
        return "main";
    }

}

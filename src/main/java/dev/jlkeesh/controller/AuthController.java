package dev.jlkeesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/register")
    public ModelAndView registerPage() {
        var mav = new ModelAndView();
        mav.setViewName("auth/register");
        return mav;
    }

}

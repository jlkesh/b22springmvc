package dev.jlkeesh.controller;

import dev.jlkeesh.UserRegisterDTO;
import dev.jlkeesh.domain.AuthUser;
import dev.jlkeesh.repository.AuthUserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AuthUserRepository authUserRepository;

    public AuthController(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    @GetMapping("/register")
    public ModelAndView registerPage() {
        var mav = new ModelAndView();
        mav.setViewName("auth/register");
        return mav;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserRegisterDTO dto) {
        System.out.println("dto = " + dto);
        AuthUser authUser = AuthUser.builder()
                .username(dto.username())
                .password(dto.password())
                .email(dto.email())
                .role("USER")
                .build();
        authUserRepository.save(authUser);
        return "redirect:/login";
    }

}
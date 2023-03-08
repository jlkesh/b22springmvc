package dev.jlkeesh.controller;

import dev.jlkeesh.UserRegisterDTO;
import dev.jlkeesh.domain.AuthUser;
import dev.jlkeesh.repository.AuthUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthUserRepository authUserRepository, PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public ModelAndView registerPage() {
        var mav = new ModelAndView();
        mav.setViewName("auth/register");
        return mav;
    }
    @GetMapping("/login")
    public ModelAndView loginPage() {
        var mav = new ModelAndView();
        mav.setViewName("auth/login");
        return mav;
    }

    @GetMapping("/logout")
    public ModelAndView logoutPage() {
        var mav = new ModelAndView();
        mav.setViewName("auth/logout");
        return mav;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserRegisterDTO dto) {
        AuthUser authUser = AuthUser.builder()
                .username(dto.username())
                .password(passwordEncoder.encode(dto.password()))
                .email(dto.email())
                .role("USER")
                .build();
        authUserRepository.save(authUser);
        return "redirect:/login";
    }

}
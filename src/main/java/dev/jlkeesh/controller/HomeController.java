package dev.jlkeesh.controller;

import dev.jlkeesh.CustomRuntimeException;
import dev.jlkeesh.config.security.AuthUserUserDetails;
import dev.jlkeesh.config.security.UserSession;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
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
    /*@RolesAllowed("ADMIN")*/
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

    @GetMapping("/upload")
    public String uploadPage() {
        return "uploadfile";
    }

    @PostMapping("/upload")
    public String upload(@ModelAttribute UserDTO dto,  @RequestParam("file[]") MultipartFile[] files) throws IOException {
        System.out.println(dto);
        for (MultipartFile file : files) {
            Files.copy(file.getInputStream(), Path.of("/home/jlkesh/Desktop", file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        }
        return "redirect:/upload";
    }
}

record UserDTO(String fname, String lname) {
}
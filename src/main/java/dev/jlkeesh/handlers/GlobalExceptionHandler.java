package dev.jlkeesh.handlers;

import dev.jlkeesh.CustomRuntimeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("dev.jlkeesh")
public class GlobalExceptionHandler {
    @ExceptionHandler({CustomRuntimeException.class,})
    public String exception(Model model, RuntimeException e) {
        model.addAttribute("error", e.getMessage());
        return "error";
    }
}

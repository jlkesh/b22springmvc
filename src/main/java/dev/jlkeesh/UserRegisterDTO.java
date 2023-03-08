package dev.jlkeesh;

public record UserRegisterDTO(String username, String password, String confirmPassword, String email) { }

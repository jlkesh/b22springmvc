package dev.jlkeesh.authuser;

public record UserRegisterDTO(String username, String password, String confirmPassword, String email) { }

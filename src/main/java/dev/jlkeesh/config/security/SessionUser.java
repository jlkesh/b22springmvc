package dev.jlkeesh.config.security;

import dev.jlkeesh.authuser.AuthUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SessionUser {
    private final HttpServletRequest request;

    public SessionUser(HttpServletRequest request) {
        this.request = request;
    }

    public AuthUser getUser() {
        return AuthUser.builder().id("ef53983d-9e57-40f8-9f3b-416d404850ee").build();
    }

    public String getId() {
        return getUser().getId();
    }
}

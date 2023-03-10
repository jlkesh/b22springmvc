package dev.jlkeesh.config.security;

import dev.jlkeesh.domain.AuthUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserSession {
    public AuthUser getUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        var authUserDetails = authentication.getPrincipal();
        if (authUserDetails instanceof AuthUserUserDetails a)
            return a.getAuthUser();
        return null;
    }

    public String getId() {
        AuthUser user = getUser();
        if (user != null)
            return user.getId();
        return null;
    }
}

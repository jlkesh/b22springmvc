package dev.jlkeesh.config.security;

import dev.jlkeesh.domain.AuthUser;
import dev.jlkeesh.repository.AuthUserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final AuthUserRepository authUserRepository;

    public CustomAuthenticationProvider(@Lazy AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = String.valueOf(authentication.getPrincipal());
        String password = String.valueOf(authentication.getCredentials());

        if (Objects.isNull(username) || Objects.isNull(password))
            throw new BadCredentialsException("Bad Credentials");

        AuthUser authUser = authUserRepository.findByUsernameIgnoreCase(username);

        if (Objects.isNull(authUser))
            throw new BadCredentialsException("Bad Credentials");

        if (!authUser.getPassword().equals(password))
            throw new BadCredentialsException("Bad Credentials");

        return new UsernamePasswordAuthenticationToken(username, null, List.of());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}

package dev.jlkeesh.config.security;

import dev.jlkeesh.authuser.AuthUser;
import dev.jlkeesh.authuser.AuthUserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(@Lazy AuthUserRepository authUserRepository, PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
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

        if (!passwordEncoder.matches(password, authUser.getPassword()))
            throw new BadCredentialsException("Bad Credentials");

        String role = authUser.getRole();

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));
        return new UsernamePasswordAuthenticationToken(username, null, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}

package dev.jlkeesh.config.security;

import dev.jlkeesh.domain.AuthUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class AuthUserUserDetails implements UserDetails {

    private final AuthUser authUser;

    public AuthUserUserDetails(AuthUser authUser) {
        this.authUser = authUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + authUser.getRole()));
    }

    @Override
    public String getPassword() {
        return authUser.getPassword();
    }


    public AuthUser getAuthUser() {
        return authUser;
    }

    public String getId() {
        return authUser.getId();
    }

    @Override
    public String getUsername() {
        return authUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !authUser.getStatus().equals(AuthUser.Status.BLOCKED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return AuthUser.Status.ACTIVE.equals(authUser.getStatus());
    }
}

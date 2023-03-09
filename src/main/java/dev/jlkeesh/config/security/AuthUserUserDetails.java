package dev.jlkeesh.config.security;

import dev.jlkeesh.domain.AuthPermission;
import dev.jlkeesh.domain.AuthRole;
import dev.jlkeesh.domain.AuthUser;
import javassist.Loader;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

public class AuthUserUserDetails implements UserDetails {

    private final AuthUser authUser;

    public AuthUserUserDetails(AuthUser authUser) {
        this.authUser = authUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authRoles = Objects.requireNonNullElse(authUser.getAuthRoles(), Collections.<AuthRole>emptySet());
        var authorities = new ArrayList<SimpleGrantedAuthority>();
        authRoles.forEach(authRole -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + authRole.getCode()));
            Collection<AuthPermission> authPermissions = Objects.requireNonNullElse(authRole.getAuthPermissions(), Collections.<AuthPermission>emptySet());
            authPermissions.forEach(authPermission -> {
                authorities.add(new SimpleGrantedAuthority(authPermission.getCode()));
            });
        });
        return authorities;
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

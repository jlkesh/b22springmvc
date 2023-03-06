package dev.jlkeesh.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthUserService implements UserDetailsService {
    Map<String, String> users = Map.of(
            "john", "123",
            "jlkesh", "123",
            "bratan", "123",
            "elshod", "8"
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        for (String key : users.keySet()) {
            if (key.equals(username)) {
                return new User(key, users.get(key), List.of());
            }
        }
        return null;
    }
}

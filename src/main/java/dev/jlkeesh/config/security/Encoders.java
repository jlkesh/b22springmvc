package dev.jlkeesh.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
public class Encoders {

    @Bean
    public PasswordEncoder passwordEncoder() {
        Map<String, PasswordEncoder> map = new HashMap<>();
        map.put("bcrypt", new BCryptPasswordEncoder());
        map.put("noop", NoOpPasswordEncoder.getInstance());
        return new DelegatingPasswordEncoder("bcrypt", map);
    }
}

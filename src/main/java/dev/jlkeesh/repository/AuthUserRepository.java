package dev.jlkeesh.repository;

import dev.jlkeesh.config.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, String> {
    AuthUser findByUsernameIgnoreCase(String username);
}

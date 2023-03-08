package dev.jlkeesh.repository;

import dev.jlkeesh.domain.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AuthUserRepository extends JpaRepository<AuthUser, String> {
    Optional<AuthUser> findByUsernameIgnoreCase(String username);
}

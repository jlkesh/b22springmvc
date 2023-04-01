package dev.jlkeesh.authuser;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthUserRepository extends JpaRepository<AuthUser, String> {
    AuthUser findByUsernameIgnoreCase(String username);
}

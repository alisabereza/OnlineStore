package com.berezovska.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.berezovska.store.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, java.util.UUID> {
    Optional<User> findByEmail(String email);
}

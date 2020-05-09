package com.berezovska.store.service.impl;

import com.berezovska.store.controller.exception.UserAlreadyExistsException;
import com.berezovska.store.controller.exception.UserNotExistsException;
import com.berezovska.store.model.User;
import com.berezovska.store.model.UserRole;
import com.berezovska.store.model.UserStatus;
import com.berezovska.store.repository.UserRepository;
import com.berezovska.store.service.UserService;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public @Data class UserServiceImpl implements UserService {
    private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAll() {
        LOG.debug("getAllUsers: ");
        return userRepository.findAll();
    }

    @Override
    public User getById(UUID id) {
        LOG.debug("getUser: id="+ id);
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotExistsException(String.format("User with id = %s not found", id)));
    }

    @Override
    public void save(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("There is an account with that email address: " + user.getEmail());
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUserRole(UserRole.ROLE_CUSTOMER);
        user.setStatus(UserStatus.ACTIVE);
        userRepository.save(user);
    }

    @Override
    public void delete(UUID id) {
    userRepository.deleteById(id);
    }

    @Override
    public User update(User entity) {
        return userRepository.save(entity);
    }


    public User getByEmail(String email) {
        LOG.debug(String.format("getUser: email=%s", email));
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotExistsException("User not found by specified email"));
    }
    @Override
    public void setPassword(User user, String password) {
        String passwordHash = bCryptPasswordEncoder.encode(password);
        user.setPassword(passwordHash);
    }

    public String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }


}

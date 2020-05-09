package com.berezovska.store.service;

import com.berezovska.store.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService extends BaseService<User> {

    User getByEmail(String email);
    List<User> getAll();
    User getById(UUID id);
    void save(User user);
    void delete(UUID id);
    User update(User user);
    void setPassword(User user, String password);
}

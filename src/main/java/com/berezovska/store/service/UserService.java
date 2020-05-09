package com.berezovska.store.service;

import com.berezovska.store.model.User;

public interface UserService extends BaseService<User> {

    User getByEmail(String email);

    void setPassword(User user, String password);
}

package com.akhambir.dao;

import com.akhambir.model.User;

public interface UserDao {

    User addUser(User user);

    User updateUser(User user);

    User findById(Long id);

    User findByToken(String token);

    User findByEmail(String email);
}

package com.java.app.service;

import com.java.app.entity.User;
import static com.java.app.util.AppEnum.ROLE;

import java.util.List;

public interface IUserService extends BaseService<User> {

    User findByEmail(String email);
    List<User> findByRole(ROLE role);
}

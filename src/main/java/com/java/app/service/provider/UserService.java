package com.java.app.service.provider;

import java.util.List;

import com.java.app.entity.User;
import com.java.app.service.IUserService;
import com.java.app.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static com.java.app.util.AppEnum.ROLE;

@Service
public class UserService implements IUserService {

    @Autowired private UserRepository repository;

    private static final User OBJECT = null;

    @Override
    public User save(User entity) {
        return repository.save(entity);
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id).orElse(OBJECT);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).orElse(OBJECT);
    }

    @Override
    public List<User> findByRole(ROLE role) {
        return (List<User>) repository.findByRole(role);
    }
}

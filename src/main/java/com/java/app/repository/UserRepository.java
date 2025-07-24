package com.java.app.repository;

import java.util.Optional;

import com.java.app.entity.User;

import static com.java.app.util.AppEnum.ROLE;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Iterable<User> findByRole(ROLE role);
    Optional<User> findByEmail(String email);
}

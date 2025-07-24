package com.java.app.repository;

import java.util.Optional;

import com.java.app.entity.Team;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    Optional<Team> findByName(String name);
}

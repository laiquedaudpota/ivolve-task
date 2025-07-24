package com.java.app.service.provider;

import java.util.List;

import com.java.app.entity.Team;
import com.java.app.service.ITeamService;
import com.java.app.repository.TeamRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TeamService implements ITeamService {

    @Autowired private TeamRepository repository;

    private static final Team OBJECT = null;

    @Override
    public Team save(Team entity) {
        return repository.save(entity);
    }

    @Override
    public Team getById(Long id) {
        return repository.findById(id).orElse(OBJECT);
    }

    @Override
    public List<Team> getAll() {
        return (List<Team>) repository.findAll();
    }

    @Override
    public Team findByName(String name) {
        return repository.findByName(name).orElse(OBJECT);
    }
}

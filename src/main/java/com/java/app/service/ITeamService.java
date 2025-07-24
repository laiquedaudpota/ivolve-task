package com.java.app.service;

import com.java.app.entity.Team;

public interface ITeamService extends BaseService<Team> {
    Team findByName(String name);
}

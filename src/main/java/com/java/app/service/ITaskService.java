package com.java.app.service;

import java.util.Date;
import java.util.List;

import com.java.app.entity.Task;
import com.java.app.entity.Team;
import com.java.app.entity.User;

import static com.java.app.util.AppEnum.STATUS;
import static com.java.app.util.AppEnum.PRIORITY;

public interface ITaskService extends BaseService<Task> {

    List<Task> findByTeam(Team team);
    List<Task> findByTeamAndDueDate(Team team, Date dueDate);
    List<Task> findByTeamAndStatus(Team team, STATUS status);
    List<Task> findByTeamAndPriority(Team team, PRIORITY priority);
    List<Task> findByTeamAndStatusAndPriority(Team team, STATUS status, PRIORITY priority);

    List<Task> findByStatus(STATUS status);
    List<Task> findByPriority(PRIORITY priority);
    List<Task> findByStatusAndPriority(STATUS status, PRIORITY priority);

    List<Task> findByUser(User user);
    List<Task> findByUserAndStatus(User user, STATUS status);
    List<Task> findByUserAndDueDate(User user, Date dueDate);
    List<Task> findByUserAndPriority(User user, PRIORITY priority);
    List<Task> findByUserAndStatusAndPriority(User user, STATUS status, PRIORITY priority);
}

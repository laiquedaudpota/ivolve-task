package com.java.app.repository;

import java.util.Date;

import com.java.app.entity.Task;
import com.java.app.entity.Team;
import com.java.app.entity.User;

import static com.java.app.util.AppEnum.STATUS;
import static com.java.app.util.AppEnum.PRIORITY;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Iterable<Task> findByTeam(Team team);
    Iterable<Task> findByTeamAndDueDate(Team team, Date dueDate);
    Iterable<Task> findByTeamAndStatus(Team team, STATUS status);
    Iterable<Task> findByTeamAndPriority(Team team, PRIORITY priority);
    Iterable<Task> findByTeamAndStatusAndPriority(Team team, STATUS status, PRIORITY priority);

    Iterable<Task> findByStatus(STATUS status);
    Iterable<Task> findByPriority(PRIORITY priority);
    Iterable<Task> findByStatusAndPriority(STATUS status, PRIORITY priority);

    Iterable<Task> findByUser(User user);
    Iterable<Task> findByUserAndStatus(User user, STATUS status);
    Iterable<Task> findByUserAndDueDate(User user, Date dueDate);
    Iterable<Task> findByUserAndPriority(User user, PRIORITY priority);
    Iterable<Task> findByUserAndStatusAndPriority(User user, STATUS status, PRIORITY priority);
}

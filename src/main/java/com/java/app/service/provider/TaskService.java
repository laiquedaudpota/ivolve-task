package com.java.app.service.provider;

import java.util.Date;
import java.util.List;

import com.java.app.entity.Task;
import com.java.app.entity.Team;
import com.java.app.entity.User;
import com.java.app.service.ITaskService;
import com.java.app.repository.TaskRepository;

import static com.java.app.util.AppEnum.STATUS;
import static com.java.app.util.AppEnum.PRIORITY;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TaskService implements ITaskService {

    @Autowired private TaskRepository repository;

    private static final Task OBJECT = null;

    @Override
    public Task save(Task entity) {
        return repository.save(entity);
    }

    @Override
    public Task getById(Long id) {
        return repository.findById(id).orElse(OBJECT);
    }

    @Override
    public List<Task> getAll() {
        return (List<Task>) repository.findAll();
    }

    @Override
    public List<Task> findByTeam(Team team) {
        return (List<Task>) repository.findByTeam(team);
    }

    @Override
    public List<Task> findByTeamAndDueDate(Team team, Date dueDate) {
        return (List<Task>) repository.findByTeamAndDueDate(team, dueDate);
    }

    @Override
    public List<Task> findByTeamAndStatus(Team team, STATUS status) {
        return (List<Task>) repository.findByTeamAndStatus(team, status);
    }

    @Override
    public List<Task> findByTeamAndPriority(Team team, PRIORITY priority) {
        return (List<Task>) repository.findByTeamAndPriority(team, priority);
    }

    @Override
    public List<Task> findByTeamAndStatusAndPriority(Team team, STATUS status, PRIORITY priority) {
        return (List<Task>) repository.findByTeamAndStatusAndPriority(team, status, priority);
    }

    @Override
    public List<Task> findByUser(User user) {
        return (List<Task>) repository.findByUser(user);
    }

    @Override
    public List<Task> findByUserAndStatus(User user, STATUS status) {
        return (List<Task>) repository.findByUserAndStatus(user, status);
    }

    @Override
    public List<Task> findByUserAndDueDate(User user, Date dueDate) {
        return (List<Task>) repository.findByUserAndDueDate(user, dueDate);
    }

    @Override
    public List<Task> findByUserAndPriority(User user, PRIORITY priority) {
        return (List<Task>) repository.findByUserAndPriority(user, priority);
    }

    @Override
    public List<Task> findByUserAndStatusAndPriority(User user, STATUS status, PRIORITY priority) {
        return (List<Task>) repository.findByUserAndStatusAndPriority(user, status, priority);
    }

    @Override
    public List<Task> findByStatus(STATUS status) {
        return (List<Task>) repository.findByStatus(status);
    }

    @Override
    public List<Task> findByPriority(PRIORITY priority) {
        return (List<Task>) repository.findByPriority(priority);
    }

    @Override
    public List<Task> findByStatusAndPriority(STATUS status, PRIORITY priority) {
        return (List<Task>) repository.findByStatusAndPriority(status, priority);
    }
}

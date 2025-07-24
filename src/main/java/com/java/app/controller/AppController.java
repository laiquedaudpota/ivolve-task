package com.java.app.controller;

import java.util.List;

import com.java.app.entity.Task;
import com.java.app.entity.Team;
import com.java.app.entity.User;
import com.java.app.service.ITaskService;
import com.java.app.service.ITeamService;
import com.java.app.service.IUserService;

import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import static com.java.app.util.AppUtil.*;
import static com.java.app.util.AppEnum.*;
import static com.java.app.util.AppConstant.*;

@Controller
public class AppController {

    @Autowired private Environment environment;

    @Autowired private ITaskService taskService;
    @Autowired private ITeamService teamService;
    @Autowired private IUserService userService;

    /**
     * This method is used for routing on index page
     * @param model
     * @return Page
     */
    @GetMapping("/")
    public String index(Model model) {
        String appName = environment.getProperty(PROP_APP_NAME_KEY);
        String appVersion = environment.getProperty(PROP_APP_VERSION_KEY);
        model.addAttribute(KEY_APP_NAME, appName);
        model.addAttribute(KEY_APP_VERSION, appVersion);
        return VIEW_PAGE_INDEX;
    }

    /**
     * This method is used for fetching userList
     * @return ResponseEntity<String> type object / it is basically API standard response object
     */
    @ResponseBody
    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers() {
        return getFinalizedResponse(MSG_DATA_FOUND, userService.getAll());
    }

    /**
     * This method is used for fetching user by email
     * @return ResponseEntity<String> type object / it is basically API standard response object
     */
    @ResponseBody
    @GetMapping("/users/{email}")
    public ResponseEntity<String> getUsersByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);
        if (isNotNull(user)) {
            return getFinalizedResponse(MSG_DATA_FOUND, user);
        }
        return getFinalizedResponse(MSG_DATA_NOT_FOUND);
    }

    /**
     * This method is for fetching tasks which are assigned to the given user
     * @return ResponseEntity<String> type object / it is basically API standard response object
     */
    @ResponseBody
    @GetMapping("/users/{id}/tasks")
    public ResponseEntity<String> getUsersByEmail(@PathVariable Long id) {
        return getAllTasks(null, id, null, null);
    }

    /**
     * This method is for adding/saving a new user
     * @return ResponseEntity<String> type object / it is basically API standard response object
     */
    @ResponseBody
    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        if (isNotNull(user)) {
            userService.save(user);
            return getFinalizedResponse(MSG_DATA_SAVED, Boolean.TRUE);
        }
        return getFinalizedResponse(MSG_BAD_REQUEST);
    }

    /**
     * This method is for fetching teamList
     * @return ResponseEntity<String> type object / it is basically API standard response object
     */
    @ResponseBody
    @GetMapping("/teams")
    public ResponseEntity<String> getAllTeams() {
        return getFinalizedResponse(MSG_DATA_FOUND, teamService.getAll());
    }

    /**
     * This method is for fetching team by given name
     * @return ResponseEntity<String> type object / it is basically API standard response object
     */
    @ResponseBody
    @GetMapping("/teams/{name}")
    public ResponseEntity<String> getTeamByName(@PathVariable String name) {
        Team team = teamService.findByName(name);
        if (isNotNull(team)) {
            return getFinalizedResponse(MSG_DATA_FOUND, team);
        }
        return getFinalizedResponse(MSG_DATA_NOT_FOUND);
    }

    /**
     * This method is for adding/saving a new team
     * @return ResponseEntity<String> type object / it is basically API standard response object
     */
    @ResponseBody
    @PostMapping("/teams")
    public ResponseEntity<String> addTeam(@RequestBody Team team) {
        if (isNotNull(team)) {
            teamService.save(team);
            return getFinalizedResponse(MSG_DATA_SAVED, Boolean.TRUE);
        }
        return getFinalizedResponse(MSG_BAD_REQUEST);
    }

    /**
     * This method is used for fetching taskList by given criteria combination params
     * @param teamId optional
     * @param userId optional
     * @param status optional
     * @param priority optional
     * @return ResponseEntity<String> type object / it is basically API standard response object
     */
    @ResponseBody
    @GetMapping("/tasks")
    public ResponseEntity<String> getAllTasks(
            @RequestParam(name = "teamId", required = false) Long teamId,
            @RequestParam(name = "userId", required = false) Long userId,
            @RequestParam(name = "status", required = false) String status,
            @RequestParam(name = "priority", required = false) String priority) {

        List<Task> tasks = null;

        STATUS enumStatus = findAnyStatus(status);
        PRIORITY enumPriority = findAnyPriority(priority);

        // Filtering tasks by team, status, and priority
        if (isNotNull(teamId) && isNotNull(enumStatus) && isNotNull(enumPriority)) {
            Team team = new Team(teamId);
            tasks = taskService.findByTeamAndStatusAndPriority(team, enumStatus, enumPriority);
            return getFinalizedResponse(MSG_DATA_FOUND, tasks);
        }

        // Filtering tasks by user, status, and priority
        if (isNotNull(userId) && isNotNull(enumStatus) && isNotNull(enumPriority)) {
            User user = new User(userId);
            tasks = taskService.findByUserAndStatusAndPriority(user, enumStatus, enumPriority);
            return getFinalizedResponse(MSG_DATA_FOUND, tasks);
        }

        // Filtering tasks by status, and priority
        if (isNotNull(enumStatus) && isNotNull(enumPriority)) {
            tasks = taskService.findByStatusAndPriority(enumStatus, enumPriority);
            return getFinalizedResponse(MSG_DATA_FOUND, tasks);
        }

        // Filtering tasks by status
        if (isNotNull(enumStatus)) {
            tasks = taskService.findByStatus(enumStatus);
            return getFinalizedResponse(MSG_DATA_FOUND, tasks);
        }

        // Filtering tasks by priority
        if (isNotNull(enumPriority)) {
            tasks = taskService.findByPriority(enumPriority);
            return getFinalizedResponse(MSG_DATA_FOUND, tasks);
        }

        // Filtering tasks by team
        if (isNotNull(teamId)) {
            Team team = new Team(teamId);
            tasks = taskService.findByTeam(team);
            return getFinalizedResponse(MSG_DATA_FOUND, tasks);
        }

        // Filtering tasks by team
        if (isNotNull(userId)) {
            User user = new User(userId);
            tasks = taskService.findByUser(user);
            return getFinalizedResponse(MSG_DATA_FOUND, tasks);
        }

        // Returning all tasks in case of direct url without any params
        tasks = taskService.getAll();

        return getFinalizedResponse(MSG_DATA_FOUND, tasks);
    }

    /**
     * This method is used for fetching task by given id
     * @param id required
     * @return ResponseEntity<String> type object / it is basically API standard response object
     */
    @ResponseBody
    @GetMapping("/tasks/{id}")
    public ResponseEntity<String> getTaskById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        if (isNotNull(task)) {
            return getFinalizedResponse(MSG_DATA_FOUND, task);
        }
        return getFinalizedResponse(MSG_DATA_NOT_FOUND);
    }

    /**
     * This method is used for adding/saving a new task
     * @param task required
     * @return ResponseEntity<String> type object / it is basically API standard response object
     */
    @ResponseBody
    @PostMapping("/tasks")
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        if (isNotNull(task)) {
            taskService.save(task);
            return getFinalizedResponse(MSG_DATA_SAVED, Boolean.TRUE);
        }
        return getFinalizedResponse(MSG_BAD_REQUEST);
    }

    /**
     * This method is used for updating task by given field values
     * @param id required
     * @param task required
     * @return ResponseEntity<String> type object / it is basically API standard response object
     */
    @ResponseBody
    @PutMapping("/tasks/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return saveOrUpdateTask(id, task);
    }

    /**
     * This method is used for updating task by given status field value
     * @param id required
     * @param task required
     * @return ResponseEntity<String> type object / it is basically API standard response object
     */
    @ResponseBody
    @PutMapping("/tasks/{id}/status")
    public ResponseEntity<String> updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return saveOrUpdateTask(id, task);
    }


    /**
     * This method is generalized/generic for all task update operations
     * @param id required
     * @param task required
     * @return ResponseEntity<String> type object / it is basically API standard response object
     */
    private ResponseEntity<String> saveOrUpdateTask(Long id, Task task) {
        Task taskEntity = isNull(id) ? null : taskService.getById(id);
        if (isNotNull(taskEntity)) {
            // Setting title if exist
            if (isNotNullNorEmptyString(task.getTitle())) {
                taskEntity.setTitle(task.getTitle());
            }

            // Setting description if exist
            if (isNotNullNorEmptyString(task.getDescription())) {
                taskEntity.setDescription(task.getDescription());
            }

            // Setting status if exist
            if (isNotNull(task.getStatus())) {
                taskEntity.setStatus(task.getStatus());
            }

            // Setting priority if exist
            if (isNotNull(task.getPriority())) {
                taskEntity.setPriority(task.getPriority());
            }

            // Setting dueDate if exist
            if (isNotNull(task.getDueDate())) {
                taskEntity.setDueDate(task.getDueDate());
            }

            // Setting user/assignedTo if exist
            if (isNotNull(task.getUser())) {
                taskEntity.setUser(task.getUser());
            }

            // Setting team if exist
            if (isNotNull(task.getTeam())) {
                taskEntity.setTeam(task.getTeam());
            }

            taskService.save(taskEntity);
            return getFinalizedResponse(MSG_DATA_UPDATED, Boolean.TRUE);
        } else {
            taskService.save(task);
            return getFinalizedResponse(MSG_DATA_SAVED, Boolean.TRUE);
        }
    }
}

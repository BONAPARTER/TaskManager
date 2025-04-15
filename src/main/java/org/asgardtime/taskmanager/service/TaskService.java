package org.asgardtime.taskmanager.service;

import org.asgardtime.taskmanager.model.Task;
import org.asgardtime.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectService projectService;
    private final UserService userService;

    @Autowired
    public TaskService(TaskRepository taskRepository, ProjectService projectService, UserService userService) {
        this.taskRepository = taskRepository;
        this.projectService = projectService;
        this.userService = userService;
    }

    @Transactional
    public Task createTask(Task task, Long projectId, Long assigneeId) {
        task.setProject(projectService.getProjectById(projectId));
        task.setAssignee(userService.getUserById(assigneeId));
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByProject(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    public List<Task> getTasksByAssignee(Long assigneeId) {
        return taskRepository.findByAssigneeId(assigneeId);
    }
}
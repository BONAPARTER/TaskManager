package org.asgardtime.taskmanager.controller;

import org.asgardtime.taskmanager.model.Task;
import org.asgardtime.taskmanager.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final ProjectService projectService;
    private final UserService userService;

    public TaskController(TaskService taskService, ProjectService projectService, UserService userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("users", userService.getAllUsers());
        return "tasks/add";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task,
                          @RequestParam Long projectId,
                          @RequestParam Long assigneeId) {
        taskService.createTask(task, projectId, assigneeId);
        return "redirect:/tasks";
    }
}
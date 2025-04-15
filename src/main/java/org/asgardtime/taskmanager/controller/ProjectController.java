package org.asgardtime.taskmanager.controller;

import org.asgardtime.taskmanager.model.Project;
import org.asgardtime.taskmanager.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("")
    public String getAllProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "projects/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("project", new Project());
        return "projects/add";
    }

    @PostMapping("/add")
    public String addProject(@ModelAttribute Project project) {
        projectService.createProject(project);
        return "redirect:/projects";
    }
}
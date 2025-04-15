package org.asgardtime.taskmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.TODO;

    private LocalDate dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private User assignee;

    public enum TaskStatus {
        TODO, IN_PROGRESS, DONE
    }

    // Убедитесь, что эти методы присутствуют
    public void setProject(Project project) {
        this.project = project;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }
}
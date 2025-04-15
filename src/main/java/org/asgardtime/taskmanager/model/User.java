package org.asgardtime.taskmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Task> assignedTasks;

    public User() {}

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
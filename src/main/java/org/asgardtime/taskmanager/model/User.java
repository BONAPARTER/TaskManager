package org.asgardtime.taskmanager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER; // Добавляем поле "role"

    @OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Task> assignedTasks;

    public User() {}

//    public User(String username, String email, String role) {
//        this.username = username;
//        this.email = email;
//        this.role = role;
//    }

    public enum UserRole {
        USER, ADMIN
    }
}
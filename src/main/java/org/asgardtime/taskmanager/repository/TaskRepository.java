package org.asgardtime.taskmanager.repository;

import org.asgardtime.taskmanager.model.Task;
import org.asgardtime.taskmanager.model.User;
import org.asgardtime.taskmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll();

    Optional<Task> findById(Long id);

    Task save(Task task);

    void deleteById(Long id);

    List<Task> findByProject(Project project);

    List<Task> findByAssignee(User assignee);

    List<Task> findByAssigneeId(Long assigneeId);

    List<Task> findByProjectId(Long projectId);
}
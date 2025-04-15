package org.asgardtime.taskmanager.repository;

import org.asgardtime.taskmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Дополнительные методы можно добавить здесь, если нужно
}
package com.app.todoserver.repository;

import com.app.todoserver.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository  extends JpaRepository<Task,Integer> {
}

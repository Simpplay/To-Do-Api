package me.imsimpplay.todo_api.task.repository;

import me.imsimpplay.todo_api.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // It does not provide anything to this context, but makes it more readable
public interface TaskRepository extends JpaRepository<Task, Long>
{
}

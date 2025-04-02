package prince.app.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prince.app.todoapp.models.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {
}

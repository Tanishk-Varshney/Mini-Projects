package prince.app.todoapp.services;

import org.springframework.stereotype.Service;
import prince.app.todoapp.models.Task;
import prince.app.todoapp.repository.TaskRepo;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepo taskRepository;

    public TaskService(TaskRepo taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createtask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}

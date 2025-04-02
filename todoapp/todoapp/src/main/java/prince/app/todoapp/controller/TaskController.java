package prince.app.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import prince.app.todoapp.services.TaskService;
import prince.app.todoapp.models.Task;


import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public  String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public  String createTasks(@RequestParam String title){
        taskService.createtask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public  String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public  String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }
}

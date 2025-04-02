package prince.app.todoapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
//import org.springframework.data.annotation.Id;
import jakarta.persistence.Id;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String title;
    private  boolean completed;
}

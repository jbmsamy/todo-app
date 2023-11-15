/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academy.learnprogramming.entity;
import java.time.LocalDate;
import java.util.Objects;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;


/**
 *
 * @author Jayabaskar Munusamy
 */
@Entity
public class Todo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @NotEmpty(message="Task must not be empty.")
    @Size(min=10, message="Task must not be less than 10 characters.")
    private String task;
    
    @NotEmpty(message="Due must be set")
    @JsonbDateFormat(value="yyyy-MM-dd0")
    @FutureOrPresent
    private LocalDate   dueDate;
    
    @PastOrPresent
    private LocalDate   completionDate;
    private LocalDate   createdDate;
    
    private boolean completed;
    
    @PrePersist
    public void init(){
        this.createdDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.task);
        hash = 47 * hash + Objects.hashCode(this.dueDate);
        hash = 47 * hash + Objects.hashCode(this.completionDate);
        hash = 47 * hash + Objects.hashCode(this.createdDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Todo other = (Todo) obj;
        if (!Objects.equals(this.task, other.task)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dueDate, other.dueDate)) {
            return false;
        }
        if (!Objects.equals(this.completionDate, other.completionDate)) {
            return false;
        }
        return Objects.equals(this.createdDate, other.createdDate);
    }
    
    
    @Override
    public String toString() {
        return "Todo{" + "id=" + id + ", task=" + task + ", dueDate=" + dueDate + ", completionDate=" + completionDate + ", createdDate=" + createdDate + '}';
    }
    
    
}

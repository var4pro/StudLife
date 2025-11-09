// TaskStudentState.java
package org.stud_life;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "task_student_state")
@IdClass(TaskStudentStateId.class) // Указываем, что используем составной ключ
@Setter
@Getter
public class TaskStudentState {
    @Id
    @ManyToOne
    @JoinColumn(name = "student_id") // Имя колонки в БД для внешнего ключа на User
    private User student;

    @Id
    @ManyToOne
    @JoinColumn(name = "task_id") // Имя колонки в БД для внешнего ключа на Task
    private Task task;

    @Column(name = "is_completed", nullable = false)
    private boolean completed = false; // По умолчанию задача не выполнена

    public TaskStudentState(User student, Task task) {
        this.student = student;
        this.task = task;
    }

    public TaskStudentState() {}
}
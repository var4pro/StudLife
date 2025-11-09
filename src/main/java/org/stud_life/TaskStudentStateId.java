package org.stud_life;

import java.io.Serializable;
import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// Класс не является Entity! Это просто встраиваемый объект.
@Setter
@Getter
@EqualsAndHashCode
public class TaskStudentStateId implements Serializable {
    private Integer student; // Поле должно называться как поле в TaskStudentState, ссылающееся на User
    private Integer task;    // Поле должно называться как поле в TaskStudentState, ссылающееся на Task

    // Конструктор по умолчанию, геттеры/сеттеры, equals и hashCode обязательны!

    public TaskStudentStateId() {}

    public TaskStudentStateId(Integer studentId, Integer taskId) {
        this.student = studentId;
        this.task = taskId;
    }
}
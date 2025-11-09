package org.stud_life;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size; // Для валидации размера строки, если используете
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "group") // Имя таблицы для группы
@Setter
@Getter
public class Group {
    @Id // Используем String id как первичный ключ
    @Column(name = "id", length = 9, nullable = false, unique = true) // Ограничиваем длину 9 символами
    @Size(min = 9, max = 9, message = "Group ID must be exactly 9 characters long") // Пример валидации
    private String id;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true) // <-- ПОЧИНЕНО
    private List<Task> groupTasks = new ArrayList<>();

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> students = new ArrayList<>();

    public Group(String id) {
        this.id = id;
    }
    public Group() {}

    public void addStudent(User student) {
        this.students.add(student);
        student.setGroup(this); // Устанавливаем ссылку на эту группу в студенте
    }

    public void removeStudent(User student) {
        this.students.remove(student);
        student.setGroup(null); // Снимаем ссылку на группу
    }

    // Вспомогательные методы для управления групповыми задачами
    public void addGroupTask(Task task) {
        this.groupTasks.add(task);
    }

    public void removeGroupTask(Task task) {
        this.groupTasks.remove(task);
    }

}
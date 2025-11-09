package org.stud_life;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main{
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
//        List<Task> csTasks = new ArrayList<>(){{
//            add(new Task());
//        }};
//        List<Task> physicsTasks = new ArrayList<>(){{
//            add(new Task());
//        }};
//        List<Task> mathTasks = new ArrayList<>(){{
//            add(new Task());
//        }};
//        List<Task> historyTasks = new ArrayList<>(){{
//            add(new Task());
//        }};
//        List<Task> algorithmsTasks = new ArrayList<>(){{
//            add(new Task());
//        }};
//        List<User> students = new ArrayList<>(){{
//            add(new User());
//        }};
//    }
//    private List<Task> createTasksForGroup(Group group) {
//        List<Task> tasks = new ArrayList<>();
//        LocalDateTime now = LocalDateTime.now();
//
//        // Информатика
//        tasks.add(new Task(TaskType.HOMEWORK, (byte) 10, "Информатика_ДЗ1", now.plusDays(10)));
//        tasks.add(new Task(TaskType.HOMEWORK, (byte) 10, "Информатика_ДЗ2", now.plusDays(24)));
//        tasks.add(new Task(TaskType.LAB_WORK,      (byte) 20, "Информатика_ЛР1", now.plusDays(31)));
//        tasks.add(new Task(TaskType.LAB_WORK,      (byte) 20, "Информатика_ЛР2", now.plusDays(45)));
//        tasks.add(new Task(TaskType.COURSEWORK,    (byte) 15, "Информатика_Реферат1", now.plusDays(52)));
//
//        // Физика
//        tasks.add(new Task(TaskType.HOMEWORK, (byte) 10, "Физика_ДЗ1", now.plusDays(12)));
//        tasks.add(new Task(TaskType.LAB_WORK,      (byte) 20, "Физика_ЛР1", now.plusDays(26)));
//        tasks.add(new Task(TaskType.LAB_WORK,      (byte) 20, "Физика_ЛР2", now.plusDays(40)));
//        tasks.add(new Task(TaskType.COURSEWORK,    (byte) 15, "Физика_Реферат1", now.plusDays(54)));
//
//        // МатАнализ
//        tasks.add(new Task(TaskType.HOMEWORK, (byte) 10, "МатАнализ_ДЗ1", now.plusDays(15)));
//        tasks.add(new Task(TaskType.HOMEWORK, (byte) 10, "МатАнализ_ДЗ2", now.plusDays(29)));
//        tasks.add(new Task(TaskType.COURSEWORK,    (byte) 15, "МатАнализ_Реферат1", now.plusDays(48)));
//
//        // История
//        tasks.add(new Task(TaskType.HOMEWORK, (byte) 10, "История_ДЗ1", now.plusDays(17)));
//        tasks.add(new Task(TaskType.COURSEWORK,    (byte) 15, "История_Реферат1", now.plusDays(35)));
//        tasks.add(new Task(TaskType.COURSEWORK,    (byte) 15, "История_Реферат2", now.plusDays(58)));
//
//        // Алгоритмы
//        tasks.add(new Task(TaskType.HOMEWORK, (byte) 10, "Алгоритмы_ДЗ1", now.plusDays(20)));
//        tasks.add(new Task(TaskType.HOMEWORK, (byte) 10, "Алгоритмы_ДЗ2", now.plusDays(34)));
//        tasks.add(new Task(TaskType.LAB_WORK,      (byte) 20, "Алгоритмы_ЛР1", now.plusDays(49)));
//        tasks.add(new Task(TaskType.COURSEWORK,    (byte) 15, "Алгоритмы_Реферат1", now.plusDays(62)));
//
//        return tasks;
    }
}
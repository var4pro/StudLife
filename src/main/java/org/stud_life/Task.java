package org.stud_life;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "task")
@Setter
@Getter
public class Task{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
    @SequenceGenerator(name = "gen", allocationSize = Integer.MAX_VALUE)
    @Column(name = "id", columnDefinition = "INT")
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "task_type", columnDefinition = "SMALLINT")
    private TaskType taskType;

    @Column(name = "cost", columnDefinition = "SMALLINT")
    private byte cost;

    @Column(name = "description", columnDefinition = "VARCHAR")
    private String description;

    @Column(name = "deadline", columnDefinition = "TIMESTAMP")
    private LocalDateTime deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    public Task(){}
    public Task(TaskType taskType, byte cost, String description, LocalDateTime deadline, Group group) {
        this.taskType = taskType;
        this.cost = cost;
        this.description = description;
        this.deadline = deadline;
        this.group = group;
    }
}
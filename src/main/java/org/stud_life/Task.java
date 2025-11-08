package org.stud_life;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
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
}
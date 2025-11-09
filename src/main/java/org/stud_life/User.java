package org.stud_life;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_sequence", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Column(name = "name", columnDefinition = "VARCHAR(100)", nullable = false) @NotBlank
    private String name;

    @Column(name = "point_0", columnDefinition = "INT", nullable = false)
    private int point0 = 0;

    @Column(name = "point_1", columnDefinition = "INT", nullable = false)
    private int point1 = 0;

    @Column(name = "point_2", columnDefinition = "INT", nullable = false)
    private int point2 = 0;

    @Column(name = "point_3", columnDefinition = "INT", nullable = false)
    private int point3 = 0;

    @Column(name = "point_4", columnDefinition = "INT", nullable = false)
    private int point4 = 0;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TaskStudentState> taskStates = new HashSet<>();

    public User() {
    }
}
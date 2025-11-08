package org.stud_life;

import lombok.Getter;

public enum TaskType{
    LAB_WORK(0),
    HOMEWORK(1),
    COURSEWORK(2),
    TEST(3),
    EXAM(4);

    @Getter
    private final int value;

    TaskType(int value){
        this.value = value;
    }
}
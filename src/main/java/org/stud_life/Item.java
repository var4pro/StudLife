package org.stud_life;

import lombok.Getter;

public enum Item{
    CS(0),
    PHYSICS(1),
    MATH_ANYLITICS(2),
    HISTORY(3),
    ALGORITHMS(4);

    @Getter
    private final int value;

    Item(int value){
        this.value = value;
    }
}
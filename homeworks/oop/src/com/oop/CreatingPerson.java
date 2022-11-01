package com.oop;
// comment
public interface CreatingPerson {
    default Person createPerson(String[] param) {
        return new Person(
                Integer.parseInt(param[0]),
                param[1],
                Integer.parseInt(param[2]),
                param[3],
                param[4]
        );
    }
}

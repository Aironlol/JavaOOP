package com.oop;

public interface CreatingPerson {
    static Person create(String[] param) {
        int id = Integer.parseInt(param[0]);
        String name = param[1];
        int age = Integer.parseInt(param[2]);
        String hairColor = param[3];
        String eyeColor = param[4];
        return new Person(id, name, age, hairColor, eyeColor);
    }
}

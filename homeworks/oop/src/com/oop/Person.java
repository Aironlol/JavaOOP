package com.oop;

import java.util.Arrays;

public class Person {

    private int id;
    private String name;
    private int age;
    private String hairColor;
    private String eyeColor;
    // comment
    public Person(int id, String name, int age, String hairColor, String eyeColor) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
    }

    public String getPerson() {
        return String.format(
                """
                        %s
                        Age: %d
                        Hair: %s
                        Eyes: %s
                        """,
                name, age, hairColor, eyeColor
        );
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }
}

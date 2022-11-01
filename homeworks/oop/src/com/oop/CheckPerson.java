package com.oop;

import java.util.Arrays;
// comment
public interface CheckPerson {

    static boolean check(Person person) {
        boolean result = true;

        String[] validHairColor = {
                "Black",
                "Blonde",
                "Platinum-blonde",
                "Strawberry-blonde",
                "Red",
                "Brown",
        };
        String[] validEyeColor = {
                "Brown",
                "Blue",
                "Violet",
                "Hazel",
        };

        if (person.getId() < 0) {
            System.out.println("The Id value cannot be negative.");
            result = false;
        }
        if ((person.getName().length() == 0) || (person.getName().length() > 30)) {
            System.out.println("The name value can contain from 1 to 30 characters.");
            result = false;
        }
        if (person.getAge() < 0 || person.getAge()>99) {
            System.out.println("The age value can be from 0 to 99.");
            result = false;
        }
        if (!Arrays.asList(validHairColor).contains(person.getHairColor())){
            System.out.println("The hair color may be as follows: " + Arrays.toString(validHairColor));
            result = false;
        }
        if (!Arrays.asList(validEyeColor).contains(person.getEyeColor())){
            System.out.println("The eye color may be as follows: " + Arrays.toString(validEyeColor));
            result = false;
        }
        return result;
    }
}

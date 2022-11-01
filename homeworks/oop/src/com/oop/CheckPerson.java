package com.oop;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;

public interface CheckPerson {

    static String check(Person person, Writer writer) throws IOException {
//        Writer writer = new PrintWriter(System.out);
        String result = "true";

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
            writer.write("The Id value cannot be negative.\n");
            result = "false";
        }
        if ((person.getName().length() == 0) || (person.getName().length() > 30)) {
            writer.write("The name value can contain from 1 to 30 characters.\n");
            result = "false";
        }
        if (person.getAge() < 0 || person.getAge()>99) {
            writer.write("The age value can be from 0 to 99.\n");
            result = "false";
        }
        if (!Arrays.asList(validHairColor).contains(person.getHairColor())){
            writer.write("The hair color may be as follows: " + Arrays.toString(validHairColor) + "\n");
            result = "false";
        }
        if (!Arrays.asList(validEyeColor).contains(person.getEyeColor())){
            writer.write("The eye color may be as follows: " + Arrays.toString(validEyeColor) + "\n");
            result = "false";
        }
        writer.flush();
        return result;
    }
}

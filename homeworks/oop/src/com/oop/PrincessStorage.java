package com.oop;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public interface PrincessStorage {
    static Map<Integer, Person> getAllPrincess() throws IOException {
        Map<Integer, Person> map = new HashMap<>();
        File resourcesFile = new File(String.join(File.separator, "resources", "disney-princesses.txt"));

        if (resourcesFile.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(resourcesFile));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    String[] personFields = line.replace(" | ", "&").split("&");
                    Person person = CreatingPerson.create(personFields);
                    if (Objects.equals(CheckPerson.check(person, Writer.nullWriter()), "true")) {
                        map.put(person.getId(), person);
                    }
                }
                System.out.println("The file has been added.");
            } catch (Exception e) {
                System.out.println("The file was not added.");
            }
            reader.close();
        } else {
            System.out.println("The file was not found");
        }
        return map;
    }
}

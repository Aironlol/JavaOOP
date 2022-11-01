package com.oop;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;

public class PrincessesCollections {

    private final Map<Integer, Person> map;

    public PrincessesCollections(Map<Integer, Person> map) {
        this.map = map;
    }

    public String getPersonsList() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            result.append(entry.getKey()).append(". ").append(entry.getValue().getPerson()).append("\n");
        }
        return result.toString();
    }

    public void addPerson(Person person) {
        map.put(person.getId(), person);
    }

    public String getPerson(int id) throws IOException {
        return map.get(id).getPerson();
    }

    public void updatePerson (Person person) {
                Person updatedPerson = map.get(person.getId());
                updatedPerson.setId(person.getId());
                updatedPerson.setName(person.getName());
                updatedPerson.setAge(person.getAge());
                updatedPerson.setHairColor(person.getHairColor());
                updatedPerson.setEyeColor(person.getEyeColor());
    }

    public void removePerson(int id) {
        map.remove(id);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean containsKey(int key) {
        return map.containsKey(key);
    }

    public Person get(int id) {
        return map.get(id);
    }
}

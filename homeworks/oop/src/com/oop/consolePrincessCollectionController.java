package com.oop;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Scanner;

public class consolePrincessCollectionController {

    private PrincessesCollections princessesCollections;
    private Scanner scanner;
    private Writer writer;


    public consolePrincessCollectionController(
            PrincessesCollections princessesCollections,
            Scanner scanner,
            Writer writer
    ) {
        this.princessesCollections = princessesCollections;
        this.scanner = scanner;
        this.writer = writer;
    }

    public void run() throws IOException {
        String SYNTAX_ERROR = "Syntax error\n";
        Field[] FIELDS = Person.class.getDeclaredFields();
        ReadConsole readConsole;
        String[] validField;
        String command;

        do {
            readConsole = new ReadConsole(scanner.nextLine());
            validField = readConsole.getValidField();
            command = readConsole.getCommand();
            boolean VALID_FILED_NOT_NULL = validField != null;
            boolean CHECK = (VALID_FILED_NOT_NULL) && (validField.length == FIELDS.length);
            int id;
            if (VALID_FILED_NOT_NULL) {
                id = Integer.parseInt(validField[0]);
            } else {
                id = 0;
            }

            switch (command) {
                case "list" -> {
                    if ((VALID_FILED_NOT_NULL)) {
                        writer.write(SYNTAX_ERROR);
                    } else {
                        if (!princessesCollections.isEmpty()) {
                          writer.write(this.princessesCollections.getPersonsList());
                        } else {
                            writer.write("Collection is empty\n");
                        }
                    }
                }
                case "add" -> {
                    if (CHECK) {
                        Person person = CreatingPerson.create(validField);

                        if (Objects.equals(CheckPerson.check(person, writer), "true")) {

                            if (!princessesCollections.containsKey(person.getId())) {
                                this.princessesCollections
                                        .addPerson(Objects.requireNonNull(CreatingPerson.create(validField)));
                                writer.write(String.format("Princess %s has been added.\n", person.getName()));
                            } else {
                                writer.write("The Princess exists.\n");
                            }

                        } else {
                            writer.write("Princess has not been added.\n");
                        }

                    } else {
                        writer.write(SYNTAX_ERROR);
                    }
                }
                case "get" -> {
                    if (VALID_FILED_NOT_NULL) {

                        if (princessesCollections.containsKey(id)) {
                            writer.write(this.princessesCollections.getPerson(id));;
                        } else {
                            writer.write("Id was not found.\n");
                        }

                    } else {
                        writer.write(SYNTAX_ERROR);
                    }
                }
                case "update" -> {
                    if (CHECK) {
                        Person person = CreatingPerson.create(validField);

                        if (princessesCollections.containsKey(person.getId())
                                && Objects.equals(CheckPerson.check(person, writer), "true")) {

                            writer.write(String.format("Princess %d %s has been updated.%n",
                                    princessesCollections.get(person.getId()).getId(),
                                    princessesCollections.get(person.getId()).getName()));
                            this.princessesCollections.updatePerson(person);
                        } else {
                            writer.write("Princess was not found.\n");
                        }

                    } else {
                        writer.write(SYNTAX_ERROR);
                    }
                }
                case "delete" -> {
                    if (VALID_FILED_NOT_NULL) {

                        if (princessesCollections.containsKey(id)) {
                            writer.write(String.format("Princess \"%s\" has been removed%n",
                                    princessesCollections.get(id).getName()));
                            this.princessesCollections.removePerson(id);
                        } else {
                            writer.write("Princess was not found.\n");
                        }

                    } else {
                        writer.write(SYNTAX_ERROR);
                    }
                }
                case "help" -> writer.write("list\nadd\nget\nupdate\ndelete\nexit\n");
                case "exit" -> {
                }
                default -> writer.write("The command does not exist.\n");
            }
            writer.flush();
        } while (!command.equals("exit"));
    }

}

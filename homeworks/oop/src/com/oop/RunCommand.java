package com.oop;

import java.lang.reflect.Field;
import java.util.Objects;
// comment
public class RunCommand implements CreatingPerson{

    private ReadConsole readConsole;
    private PrincessesCollections princessesCollections;

    public RunCommand(ReadConsole readConsole, PrincessesCollections princessesCollections) {
        this.readConsole = readConsole;
        this.princessesCollections = princessesCollections;
    }

    public void run() {
        String SYNTAX_ERROR = "Syntax error";
        Field[] FIELDS = Person.class.getDeclaredFields();
        String[] validField = readConsole.getValidField();
        String command = readConsole.getCommand();
        boolean VALID_FILED_NOT_NULL = validField != null;
        boolean CHECK = (VALID_FILED_NOT_NULL) && (validField.length == FIELDS.length);

        switch (command) {
            case "list" -> {
                if ((VALID_FILED_NOT_NULL)){
                    System.out.println(SYNTAX_ERROR);
                } else {
                    this.princessesCollections.getPersonsList();
                }
            }
            case "add" -> {
                if (CHECK)  {
                    this.princessesCollections.addPerson(Objects.requireNonNull(createPerson(validField)));
                } else  {
                    System.out.println(SYNTAX_ERROR);
                }
            }
            case "get" -> {
                if (VALID_FILED_NOT_NULL)  {
                    this.princessesCollections.getPerson(Integer.parseInt(validField[0]));
                } else {
                    System.out.println(SYNTAX_ERROR);
                }
            }
            case "update" -> {
                if (CHECK) {
                    this.princessesCollections.updatePerson(createPerson(validField));
                } else {
                    System.out.println(SYNTAX_ERROR);
                }
            }
            case "delete" -> {
                if (VALID_FILED_NOT_NULL) {
                    this.princessesCollections.removePerson(Integer.parseInt(validField[0]));
                } else {
                    System.out.println(SYNTAX_ERROR);
                }
            }
            case "help" -> System.out.println("list\nadd\nget\nupdate\ndelete\nexit");
            case "exit" -> {}
            default -> System.out.println("The command does not exist");
        }
    }
}

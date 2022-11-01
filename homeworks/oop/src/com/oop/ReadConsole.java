package com.oop;
// comment
public class ReadConsole {

    private final String string;

    public ReadConsole(String string) {
        this.string = string;
    }

    public String getCommand() {
        String[] stroke;
        stroke = string.split(" ", 2);
        return stroke[0];
    }

    public String[] getValidField() {
        String[] stroke;
        stroke = string.split(" ", 2);
        if (!(stroke.length == 1)) {
            String[] result = ReadingStroke.readConsoleStroke(stroke[1]);

            if (result.length == 1 && CheckingType.isNumber(result[0])) {
                return result;
            }

            if (result.length == 5 && CheckingType.isNumber(result[0]) && CheckingType.isNumber(result[2])) {
                return result;
            } else {
                System.out.println("Check the data.");
            }
        }
        return null;
    }
}

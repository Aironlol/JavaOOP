package com.oop;

import java.lang.reflect.Field;
// comment
public interface ReadingStroke {

    static String[] readConsoleStroke(String stroke) {
        try {
            if (stroke.contains("\"")) {
                String tmp;
                while (stroke.contains("\"")) {
                    String betweenSymbols = (tmp = stroke.substring(0, stroke.lastIndexOf('\"')))
                            .substring(tmp.lastIndexOf('\"')) + "\"";
                    stroke = stroke.replace(
                            betweenSymbols,
                            betweenSymbols.replace(" ", "^").replace("\"", "")
                    );
                }
            }
            String[] result = stroke.split(" ");
            for (int i = 0; i < result.length; i++) {
                if (result[i].contains("^")) {
                    result[i] = result[i].replace("^", " ");
                }
            }
            return result;
        } catch (Exception e) {
            throw new StringIndexOutOfBoundsException("Errors");
        }
    }
}

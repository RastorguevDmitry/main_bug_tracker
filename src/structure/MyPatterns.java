package structure;

import java.util.regex.Pattern;

public class MyPatterns {
    enum PATTERN {Project, User, Issue}

    ;

    private static Pattern patternALL = Pattern.compile("[><]"); // регулярные выражения


    public static String getDateFromString(String stringDate, PATTERN pattern) {

        String returnString[] = patternALL.split(stringDate);

        switch (pattern) {
            case Project:
                return returnString[2];
            case User:
                return returnString[6];
            case Issue:
                return returnString[10];
        }
        return "0";

    }


}
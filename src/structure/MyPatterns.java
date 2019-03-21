package structure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatterns {
    enum PATTERN {Project, User, Issue};


   // private static Pattern patternProject = Pattern.compile("<Project>*</Project>"); // регулярные выражения
    private static Pattern patternProject = Pattern.compile("<Project>([^>])+<"); // регулярные выражения
    private static Pattern patternUser = Pattern.compile("<User>([^>])+<"); // регулярные выражения
    private static Pattern patternIssue = Pattern.compile("<Issue>.+<"); // регулярные выражения
    private static Pattern patternALL = Pattern.compile(">.+<"); // регулярные выражения


    public static String getDateFromString(String stringDate, PATTERN pattern) throws Exception {
        Matcher matcher = null;
        switch (pattern) {

            case Project:  matcher = patternProject.matcher(stringDate); break;
            case User:  matcher = patternUser.matcher(stringDate); break;
            case Issue:  matcher = patternIssue.matcher(stringDate); break;
        }
        if (matcher.find()) {
            String returnString = "";
            switch (pattern) {
                case Project:  returnString = stringDate.substring(matcher.start() + 9, matcher.end() - 1); break;
                case User:    returnString =stringDate.substring(matcher.start() + 6, matcher.end() - 1); break;
                case Issue:   returnString = stringDate.substring(matcher.start() + 7, matcher.end() - 1); break;
            }

            return returnString;
        }
        throw new Exception("Cant extract");
    }

//<Project> </Project><User></User><Issue></Issue>

//    private static Pattern patternPoiskaNomeraPZ = Pattern.compile("\\b\\d{9}\\b"); // регулярные выражения
//
//    public static String getDateFromString(String stringDate) throws Exception {
//        Matcher matcher = patternPoiskaNomeraPZ.matcher(stringDate);
//        if (matcher.find()) {
//            return matcher.group();
//        }
//        throw new Exception("Cant extract");
//    }
//
//    private static Pattern patternPoiskaNomeraZakupkiEIS = Pattern.compile("\\d{11}"); // поиск номера закупки ЕИС
//
//    public static String getNomerZakupkiEISFromString(String stringDate) throws Exception {
//        Matcher matcher = patternPoiskaNomeraZakupkiEIS.matcher(stringDate);
//        if (matcher.find()) {
//            return matcher.group();
//        }
//        return "0";
//    }

}
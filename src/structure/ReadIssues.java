package structure;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static structure.Issue.issue;
import static structure.Issue.uniqIssueText;
import static structure.Project.uniqProjectName;
import static structure.User.uniqUserName;

public class ReadIssues {


    public static int isAlredeRead = 0;


    public static void ReadAllIssuesFromFile() throws Exception {
        if (isAlredeRead == 1) return; //issue.clear();

        //запись из файла в Лист
        List<String> lines = Files.readAllLines(Paths.get("input.txt"), Charset.defaultCharset());

        //разбор считанных из файла данных на класссы
        for (String line : lines) {

            String project = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.Project);
            Project projectClassProject = new Project(project);

            String user = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.User);
            User userClassUser = new User(user);

            String issueText = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.Issue);
            Issue issueClassIssue = new Issue(projectClassProject, userClassUser, issueText);
            issue.add(issueClassIssue);

        }
        isAlredeRead = 1;
//        String text = Integer.toString(c);
//        PrintWriter out = new PrintWriter("output.txt");
//        out.println(text);
//        out.close();
    }

    public static void printAllIssues() throws Exception {
        ReadAllIssuesFromFile();
        for (Issue issue : issue) {
            System.out.println(issue);
        }
    }


}

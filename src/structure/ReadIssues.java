package structure;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadIssues {

    public static ArrayList<Issue> issue = new ArrayList<>();


    public String[] ReadAllIssuesToString() {
        String[] issuesToString = new String[this.issue.size()];
        int i = 0;
        for (Issue issue : this.issue
        ) {
            issuesToString[i] = issue.project.getProjectName() + " " + issue.user.getUserName() + " " + issue.getIssueText();
            i++;
        }

        return issuesToString;
    }


    public void ReadAllIssuesFromFile() throws Exception {

        //запись из файла в Лист
        List<String> lines = Files.readAllLines(Paths.get("input.txt"), Charset.defaultCharset());


        //разбор считанных из файла данных на класссы
        for (String line : lines) {
            String project = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.Project);
            Project projectClassProject = new Project(project);
//            System.out.print(project + " - ");

            String user = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.User);
            User userClassUser = new User(user);
//            System.out.print(user + " - ");

            String issueText = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.Issue);
//            System.out.println(issueText);
            Issue issueClassIssue = new Issue(projectClassProject, userClassUser, issueText);
            issue.add(issueClassIssue);
        }



//        String text = Integer.toString(c);
//        PrintWriter out = new PrintWriter("output.txt");
//        out.println(text);
//        out.close();


    }


}

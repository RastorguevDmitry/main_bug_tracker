package structure;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadAllIssues {
    // Issue issue[];
   public ArrayList<Issue> issue = new ArrayList<>();


    User user1 = new User(1, "User1");
    User user2 = new User(2, "User2");

    Project project1 = new Project(1, "Project1");


    Project project2 = new Project(2, "Project2");

    Issue issue1 = new Issue(1, "Сделать мир лучше", project1, user1);
    Issue issue2 = new Issue(2, "Сделать мир лучше еще раз", project2, user1);


    public ReadAllIssues() {
        issue.add(issue1);
        issue.add(issue2);
    }

    public String[] ReadAllIssuesToString() {
        String[] issuesToString = new String[this.issue.size()];
        int i = 0;
        for (Issue issue: this.issue
             ) {
            issuesToString[i]= issue.project.getProjectName() + " " +  issue.user.getUserName() + " " + issue.getIssueText();
            i++;
        }

        return issuesToString;
    }


    public List<String> ReadAllIssuesFromFileToString() throws Exception {

        //запись из файла в Лист
        List<String> lines = Files.readAllLines(Paths.get("input.txt"), Charset.defaultCharset());

//        //Массив для возврата
//        String[] issuesToString= new String[lines.size()];
//        issuesToString = lines.toArray(issuesToString);

        for (String line:
        lines) {
            String project = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.Project);
            System.out.print(project + " - ");
            String user = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.User);
            System.out.print(user + " - ");
            String issue = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.Issue);
            System.out.println(issue);
        }


        return lines;

//        String text = Integer.toString(c);
//        PrintWriter out = new PrintWriter("output.txt");
//        out.println(text);
//        out.close();



    }


}

package structure;

import java.util.ArrayList;

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
            issuesToString[i]= issue.getIssueID() + " " + issue.getIssueText();

        }
        issue.add(issue1);
        issue.add(issue2);
        return issuesToString;
    }


//    public static ArrayList<Issue> toArray() {
//    }
}

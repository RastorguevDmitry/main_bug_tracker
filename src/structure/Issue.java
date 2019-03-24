package structure;

import java.util.ArrayList;
import java.util.HashSet;

import static structure.ReadFromFile.ReadAllIssues;
import static structure.ReadFromFile.isAlredeRead;

public class Issue {

    public static HashSet<String> uniqIssueText = new HashSet<>();
    public static ArrayList<Issue> issue = new ArrayList<>();

    int issueID;

    String issueText;

    int projectID;
    int userID;

    Project project;
    User user;

    public Issue() {
    }

    public Issue(Project project, User user, String issueText) {
        this.issueText = issueText;
        this.project = project;
        this.user = user;
        uniqIssueText.add(issueText);
    }

    public Issue(int issueID, String issueText, int projectID, int userID) {
        this.issueID = issueID;
        this.issueText = issueText;
        this.projectID = projectID;
        this.userID = userID;
    }

    public Issue(int issueID, String issueText, Project project, User user) {
        this.issueID = issueID;
        this.issueText = issueText;
        this.project = project;
        this.user = user;
    }

    public static void printUniqIssueText() throws Exception {
        if (isAlredeRead == 0) ReadAllIssues(ReadFromFile.READFROM.FILE);

        for (String issue : uniqIssueText) {
            System.out.println("--> " + issue);
        }
    }


    @Override
    public String toString() {
        return project.getProjectName() + " - " + user.getUserName() + " - " + issueText;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public String getIssueText() {
        return issueText;
    }

    public void setIssueText(String issueText) {
        this.issueText = issueText;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

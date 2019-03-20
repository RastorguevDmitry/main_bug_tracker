package structure;

public class Issue {


    int issueID;
    String issueText;
    int projectID;
    int userID;

    public Issue() {
    }

    public Issue(int issueID, String issueText, int projectID, int userID) {
        this.issueID = issueID;
        this.issueText = issueText;
        this.projectID = projectID;
        this.userID = userID;
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
}

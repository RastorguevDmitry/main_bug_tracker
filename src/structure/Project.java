package structure;

public class Project {
    int projectID;

    String projectName;

    public Project(int projectID, String projectName) {
        this.projectID = projectID;
        this.projectName = projectName;
    }

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}

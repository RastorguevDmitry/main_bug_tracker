package structure;

import servises.ReadFromFile;

import java.util.HashSet;

import static servises.ReadFromFile.*;



public class Project {
    public static HashSet<String> uniqProjectName = new HashSet<>();

    int projectID;
    String projectName;

    public Project(int projectID, String projectName) {
        this.projectID = projectID;
        this.projectName = projectName;
    }


    public static void printUniqProjectName() throws Exception {

        if (isAlredeRead == 0) ReadAllIssues(ReadFromFile.READFROM.FILE);

        for (String projectName : uniqProjectName) {
            System.out.println("--> " + projectName);
        }
    }


    public Project(String projectName) {
        this.projectName = projectName;
        uniqProjectName.add(projectName);
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

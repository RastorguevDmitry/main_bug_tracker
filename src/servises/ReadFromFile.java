package servises;

import DB.servises.ReadFromTable;
import DB.servises.WriteInTable;
import structure.Issue;
import structure.Project;
import structure.User;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static structure.Issue.issue;

public class ReadFromFile {

    public enum READFROM {DB, FILE}


    public static int isAlredeRead = 0;

    public static void ReadAllIssues(READFROM readfrom) throws Exception {
        if (isAlredeRead == 1) return; //issue.clear();
        //запись из файла в Лист
        List<String> lines = Files.readAllLines(Paths.get("input.txt"), Charset.defaultCharset());
        WriteInTable writeInTable = new WriteInTable();
        //разбор считанных из файла данных на класссы

        for (String line : lines) {

            String project = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.Project);
            Project projectClassProject = new Project(project);

            String user = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.User);
            User userClassUser = new User(user);

            String issueText = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.Issue);
            Issue issueClassIssue = new Issue(projectClassProject, userClassUser, issueText);

            switch (readfrom) {
                case DB:
                    writeInTable.writeInTable("projects","nameProject", project);
                    projectClassProject.setProjectID(ReadFromTable.getID("projects", "nameProject" , project));

                    writeInTable.writeInTable("users", "nameUser", user);
                    userClassUser.setUserID(ReadFromTable.getID("users", "nameUser" , user));

                    writeInTable.writeInTable("issues", userClassUser.getUserID(),
                            projectClassProject.getProjectID(), issueText);
                    break;

                case FILE:
                    issue.add(issueClassIssue);
                    break;
            }
        }
        isAlredeRead = 1;

    }

    public static void printAllIssues() throws Exception {
        ReadAllIssues(READFROM.FILE);
        for (Issue issue : issue) {
            System.out.println(issue);
        }
    }

}

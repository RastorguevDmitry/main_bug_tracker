package structure;

import DB.ReadFromTable;
import DB.WriteInTable;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadIssues {

    public static int isAlredeRead = 0;

    public static void ReadAllIssuesFromFile() throws Exception {
        if (isAlredeRead == 1) return; //issue.clear();

        //запись из файла в Лист
        List<String> lines = Files.readAllLines(Paths.get("input.txt"), Charset.defaultCharset());
        WriteInTable writeInTable = new WriteInTable();
        //разбор считанных из файла данных на класссы
        for (String line : lines) {

            String project = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.Project);
            Project projectClassProject = new Project(project);
            writeInTable.writeInTable("projects","nameProject", project);
            projectClassProject.setProjectID(ReadFromTable.getID("projects", "nameProject" , project));

            String user = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.User);
            User userClassUser = new User(user);
            writeInTable.writeInTable("users", "nameUser", user);
            userClassUser.setUserID(ReadFromTable.getID("users", "nameUser" , user));

            String issueText = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.Issue);
            Issue issueClassIssue = new Issue(projectClassProject, userClassUser, issueText);
            writeInTable.writeInTable("issues", userClassUser.userID,
                    projectClassProject.getProjectID(), issueText);

        }
        isAlredeRead = 1;

    }






}

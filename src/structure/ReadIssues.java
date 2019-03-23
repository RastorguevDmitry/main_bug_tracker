package structure;

import DB.WriteInTable;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static DB.ReadFromTable.getID;
import static structure.Issue.issue;
import static structure.Project.uniqProjectName;

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
            projectClassProject.setProjectID(getID("projects", "nameProject" , project));

            String user = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.User);
            User userClassUser = new User(user);
            writeInTable.writeInTable("users", "nameUser", user);
            userClassUser.setUserID(getID("users", "nameUser" , user));

            String issueText = MyPatterns.getDateFromString(line, MyPatterns.PATTERN.Issue);
            Issue issueClassIssue = new Issue(projectClassProject, userClassUser, issueText);
            writeInTable.writeInTable("users", "nameUser", user);
            writeInTable.writeInTable("issues", userClassUser.userID,
                    projectClassProject.getProjectID(), issueText);

            // issue.add(issueClassIssue);

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

//    public static void writeInDB() throws Exception {
//        ReadAllIssuesFromFile();
//        WriteInTable writeInTable = new WriteInTable();
//
//
//        uniqProjectName
//        writeInTable.writeInTable();
//
//
//        for (Issue issue : issue) {
//            System.out.println(issue);
//        }
//    }

}

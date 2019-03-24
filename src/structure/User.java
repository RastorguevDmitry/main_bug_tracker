package structure;

import java.util.HashSet;

import static structure.ReadFromFile.ReadAllIssues;
import static structure.ReadFromFile.isAlredeRead;

public class User {
    public static HashSet<String> uniqUserName = new HashSet<>();

    int userID;
    String userName;

    public User(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    public User(String userName) {
        this.userName = userName;
      uniqUserName.add(userName);
    }

    public static void printUniqUserName() throws Exception {
        if (isAlredeRead == 0) ReadAllIssues(ReadFromFile.READFROM.FILE);
        for (String user : uniqUserName) {
            System.out.println("--> " + user);
        }
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

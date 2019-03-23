package DB;

import structure.MyPatterns;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static structure.Project.uniqProjectName;
import static structure.User.uniqUserName;

public class ReadFromTable {
    public ReadFromTable() {
    }

    public void ReadFromProjectTable() throws SQLException, ClassNotFoundException {

        IssuesDB issuesDB = new IssuesDB();
        Connection connection = issuesDB.getConnection();
        Statement statement = connection.createStatement();


        String query = "select * from projects";
        ResultSet resultSet = statement.executeQuery(query);
        uniqProjectName.clear();

        while (resultSet.next()) {
            System.out.println("--> " + resultSet.getString("nameProject"));

//            Customer customer = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
//            customerList.add(customer);
        }
    }

    public void ReadFromUsersTable() throws SQLException, ClassNotFoundException {

        IssuesDB issuesDB = new IssuesDB();
        String query = "select * from users";
        Connection connection = issuesDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        uniqUserName.clear();

        while (resultSet.next()) {
            uniqProjectName.add(resultSet.getString("nameProject"));
//            Customer customer = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
//            customerList.add(customer);
        }
    }

    public ReadFromTable(String query) throws SQLException, ClassNotFoundException {

        IssuesDB issuesDB = new IssuesDB();

        Connection connection = issuesDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
//            Customer customer = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
//            customerList.add(customer);
        }
    }


    public void ReadFromTable(MyPatterns.PATTERN pattern) throws SQLException, ClassNotFoundException {

        IssuesDB issuesDB = new IssuesDB();
        Connection connection = issuesDB.getConnection();
        Statement statement = connection.createStatement();

        String stringForQuery = "";
        String stringNameColumn="";
        switch (pattern) {
            case Project:
                stringForQuery = "projects";
                stringNameColumn = "nameProject";
                break;
            case User:
                stringForQuery = "users";
                stringNameColumn = "nameUser";
                break;
            case Issue:
                stringForQuery = "issues";
                stringNameColumn = "nameProject";
                break;
        }


        String query = "select * from " + stringForQuery;
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println("--> " + resultSet.getString(stringNameColumn));

        }
    }


    public static int getID(String table, String column, String name) throws SQLException, ClassNotFoundException {
        IssuesDB issuesDB = new IssuesDB();
        Connection connection = issuesDB.getConnection();
        Statement statement = connection.createStatement();
        String query = "select * from " + table + " where " + column + " = '" + name +"'";
        ResultSet resultSet = statement.executeQuery(query);
       // System.out.println(query);
        if(resultSet.next()) return resultSet.getInt("id");

        return -1;
    }


}

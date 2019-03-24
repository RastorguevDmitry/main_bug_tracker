import DB.IssuesDB;
import DB.ReadFromTable;
import structure.ReadIssues;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        try {
            IssuesDB issuesDB = new IssuesDB();
            issuesDB.createTables();
            ReadIssues.ReadAllIssuesFromFile();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL !");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC драйвер для СУБД не найден!");
        }

        System.out.println("Система отслеживания ошибок");
        printMainText();

        while (true) {
            int input_numder = scanner.nextInt();
            ReadFromTable readFromTable = new ReadFromTable();
            switch (input_numder) {
                case 0:
                    System.out.println("Выход...");
                    ReadFromTable.dropAllTable();
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Проект - Пользователь - Запись об ошибке");
                    int returnValue = ReadFromTable.printReport();
                    //Вывод всех записей напрямую из файла
                    // ReadIssues.printAllIssues();
                    break;
                case 2:
                    System.out.println("Список проектов:");
                    readFromTable.ReadFromTable(ReadFromTable.TABLE.Project);
                    //поиск проектов
                    // structure.Project.printUniqProjectName();
                    break;
                case 3:
                    System.out.println("Список пользователей:");
                    readFromTable.ReadFromTable(ReadFromTable.TABLE.User);
                    //поиск пользователей
                    // printUniqUserName();
                    break;
                case 4:
                    System.out.println("Список ошибок:");
                    readFromTable.ReadFromTable(ReadFromTable.TABLE.Issue);
                    //поиск пользователей
                    // printUniqIssueText();
                    break;
                case 5:
                    ReportMenu();
                    break;
            }
            printMainText();
        }


        // для десктопного приложения
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    new MainWindow();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });

    }

    public static void printMainText() {
        System.out.print("Для отображения данных введите соответствующее число:\n" +
                "--> все данные           - 1\n" +
                "--> список проектов      - 2\n" +
                "--> список пользователей - 3\n" +
                "--> список ошибок        - 4\n" +
                "--> сформировать отчет   - 5\n" +
                "--> выйти из программы   - 0\n");
    }

    public static void ReportMenu() throws Exception {
        System.out.print("Введите название проекта (для возврата введите 0):  ");
        scanner.nextLine();
        String inputProject = scanner.nextLine();
        if (inputProject.equals("0")) return;
        //при чтении из файла
//        if (!uniqProjectName.contains(inputProject)) {
//            System.out.println("Не существует введенного проекта");
//            return;
//        }
        System.out.print("Введите имя пользователя (для возврата введите 0):  ");
        String inputUser = scanner.nextLine();
        if (inputUser.equals("0")) return;
        //при чтении из файла
//        if (!uniqUserName.contains(inputUser)) {
//            System.out.println("Не существует введенного пользователя");
//            return;
//        }
        System.out.println("\"" + inputUser + "\" по проекту \"" + inputProject + "\" добавил следующие записи:");

        int returnValue = ReadFromTable.printReport(inputProject, inputUser);
//        //данные из файла уже считаны?
//        if (structure.ReadIssues.isAlredeRead == 0) structure.ReadIssues.ReadAllIssuesFromFile();
//
//        //поиск записей при чтении из файла
//        Collection<Issue> issues = issue;
//        //поиск по issues, где User с UserName = введенному имени и Project с ProjectName = введенному названию проекта
//        List<Issue> findIssues = issues.stream().filter((p) ->
//                p.getUser().getUserName().equals(inputUser)
//                        && p.getProject().getProjectName().equals(inputProject)).collect(Collectors.toList());
//
        if (returnValue == 0)
            System.out.println("Записи не найдены");
        //при чтении из файла
//        else {
//
//            System.out.println("\"" + inputUser + "\" по проекту \"" + inputProject + "\" добавил следующие записи:");
//
//
//            for (Issue findIssue : findIssues
//            ) {
//                System.out.println("--> " + findIssue.getIssueText());
//            }
//        }

    }

}
import structure.Issue;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static structure.Issue.*;
import static structure.Project.*;
import static structure.ReadIssues.*;
import static structure.User.*;


public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {


        System.out.println("Система отслеживания ошибок");
        printMainText();

        while (true) {
            int input_numder = scanner.nextInt();
            switch (input_numder) {
                case 0:
                    System.out.println("Выход...");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Проект - Пользователь - Запись об ошибке");
                    //Вывод всех записей
                    printAllIssues();
                    break;
                case 2:
                    System.out.println("Список проектов:");
                    //поиск проектов
                    printUniqProjectName();
                    break;
                case 3:
                    System.out.println("Список пользователей:");
                    //поиск пользователей
                    printUniqUserName();
                    break;
                case 4:
                    System.out.println("Список ошибок:");
                    //поиск пользователей
                    printUniqIssueText();
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
        if (!uniqProjectName.contains(inputProject)) {
            System.out.println("Не существует введенного проекта");
            return;
        }
        System.out.print("Введите имя пользователя (для возврата введите 0):  ");
        String inputUser = scanner.nextLine();
        if (inputUser.equals("0")) return;
        if (!uniqUserName.contains(inputUser)) {
            System.out.println("Не существует введенного пользователя");
            return;
        }

        //данные из файла уже считаны?
        if (isAlredeRead == 0) ReadAllIssuesFromFile();

        //поиск записей
        Collection<Issue> issues = issue;
        //поиск по issues, где User с UserName = введенному имени и Project с ProjectName = введенному названию проекта
        List<Issue> findIssues = issues.stream().filter((p) ->
                p.getUser().getUserName().equals(inputUser)
                        && p.getProject().getProjectName().equals(inputProject)).collect(Collectors.toList());

        if (findIssues.isEmpty())
            System.out.println("\"" + inputUser + "\" по проекту \"" + inputProject + "\" записей не вносил");
        else {

            System.out.println("\"" + inputUser + "\" по проекту \"" + inputProject + "\" добавил следующие записи:");


            for (Issue findIssue : findIssues
            ) {
                System.out.println("--> " + findIssue.getIssueText());
            }
        }


    }


}
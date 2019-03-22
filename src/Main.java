import structure.ReadIssues;

import java.util.List;
import java.util.Scanner;

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
                    allIssues();
                    break;
                case 2:
                    System.out.println("Список проектов");
                    //поиск проектов
                    break;
                case 3:
                    System.out.println("Список пользователе");
                    //поиск пользователей

                    break;
                case 4:
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
                "--> все данные         - 1\n" +
                "--> проекты            - 2\n" +
                "--> пользователи       - 3\n" +
                "--> сформировать отчет - 4\n" +
                "--> выйти из программы - 0\n");
    }


    public static void allIssues() throws Exception {
        // список issues
        List<String> listOfIssues = new ReadIssues().ReadAllIssuesFromFileToString();

        //Массив для вывода
        String[] issuesToString = new String[listOfIssues.size()];
        issuesToString = listOfIssues.toArray(issuesToString);
    }


    public static void ReportMenu() {
        System.out.print("Введите название проекта (для возврата введите 0):  ");
        scanner.nextLine();
        String inputProject = scanner.nextLine();
        if (inputProject.equals("0")) return;
        System.out.print("Введите имя пользователя (для возврата введите 0):  ");
        String inputUser = scanner.nextLine();
        if (inputUser.equals("0")) return;
        System.out.println("\"" + inputUser + "\" в проект \"" + inputProject + "\" добавил следующие записи:");

        //поиск записей
    }


}
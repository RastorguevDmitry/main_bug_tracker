import structure.ReadAllIssues;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        // список issues
        List<String> listOfIssues = new ReadAllIssues().ReadAllIssuesFromFileToString();

        //Массив для вывода
        String[] issuesToString= new String[listOfIssues.size()];
        issuesToString = listOfIssues.toArray(issuesToString);


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


}
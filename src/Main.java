import structure.Issue;
import structure.Project;
import structure.User;

import java.io.IOException;

public class Main {



    public static void main(String[] args) throws Exception {





        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MainWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }


}
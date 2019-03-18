import structure.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow  extends JFrame {
    //основное окно
    private JPanel mainWindow = new JPanel();

    //для вывода списка ошибок
    private JList issuesList = new JList();
    private JScrollPane listOfIssuesScroll = new JScrollPane(issuesList);

    // панель кнопок
    private JPanel buttonsPanel = new JPanel();
    private Button buttonAddNewIssues = new Button("Добавить ошибку");
    private Button buttonReport = new Button("Создать отчет");


//        //часть для работы с ПЗ
//        private JPanel panelForPZ = new JPanel();
//        private Button buttonNewFindPZ = new Button("Обновить план закупок");
//        //часть для работы с Извещениями
//        private JPanel panelForIzvescheniya = new JPanel();
//        private Button buttonNewFindIzvescheniya = new Button("Найти объявленные закупки");
//        //часть для работы с Договорами
//        private JPanel panelForDogovory = new JPanel();
//        private Button buttonForDogovory = new Button("Найти договоры");
//
//    private JTextField newProject = new JTextField(10);
  //      public static String dateBegin, dateEnd;


        public MainWindow() {
            super("Система контроля ошибок");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(true);
            // mainWindow.setLayout( new BorderLayout(5,5));
            mainWindow.setLayout(new GridLayout(3, 1, 5, 5));
            mainWindow.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            panelForPZ.setLayout(new GridLayout(1, 3, 5, 5));
            panelForIzvescheniya.setLayout(new GridLayout(1, 3, 5, 5));
            panelForDogovory.setLayout(new GridLayout(1, 3, 5, 5));

            // Слушатель нажатия кнопки "Найти объявленные закупки"
            buttonNewFindIzvescheniya.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            buttonNewFindPZ.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
//                        ParserPZ parserPZ = new ParserPZ();
//                        DialogWindow dialogWindow = new DialogWindow(MyWindow.this, parserPZ.filePath);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });

// слушатель нажатия кнопки Найти объявленные закупки
            buttonNewFindIzvescheniya.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                         } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });

            //  добавление кнопок в панели
            panelForPZ.add(buttonNewFindPZ);
            panelForIzvescheniya.add(buttonNewFindIzvescheniya);
            panelForDogovory.add(buttonForDogovory);


            // mainWindow.setLayout(new GridLayout());

            // добавление панелей в основоное окно

            mainWindow.add(panelForPZ);
            mainWindow.add(panelForIzvescheniya);
            mainWindow.add(panelForDogovory);

            // mainWindow.add(panelForIzvescheniya,BorderLayout.SOUTH);


            getContentPane().add(mainWindow);
            setSize(600, 600);
            setLocationRelativeTo(null); // посередине
            setVisible(true);

        }


    }

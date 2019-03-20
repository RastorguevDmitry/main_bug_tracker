import structure.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    //основное окно
    private JPanel mainWindow = new JPanel();

    //для вывода списка ошибок
    private JList issuesList = new JList();
    private JScrollPane listOfIssuesScroll = new JScrollPane(issuesList);

    // панель кнопок
    private JPanel buttonsPanel = new JPanel();
    private Button buttonAddNewIssues = new Button("Добавить ошибку");
    private Button buttonReport = new Button("Создать отчет");

    private ArrayList<String> listOfIssues = new ArrayList<>();


    public MainWindow() {
        super("Система контроля ошибок");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        // mainWindow.setLayout( new BorderLayout(5,5));
        mainWindow.setLayout(new BorderLayout(5, 5));
        mainWindow.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5, ));

        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));

        //окно диалога создания новой записи
        JDialog createNewIssuesDialog = new JDialog(MainWindow.this, "Создание новой записи", true);
        JPanel createNewIssuesPanel = new JPanel();

        // Слушатель нажатия кнопки "Добавить ошибку"
        buttonAddNewIssues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Слушатель нажатия кнопки "Создать отчет"
        buttonReport.addActionListener(new ActionListener() {
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

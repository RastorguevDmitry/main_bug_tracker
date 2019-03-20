import structure.Issue;
import structure.Project;
import structure.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

public class MainWindow extends JFrame {


    User user1 = new User(1, "User1");
    User user2 = new User(2, "User2");

    Project project1 = new Project(1, "Project1");
    Project project2 = new Project(2, "Project2");

    Issue issue1 = new Issue(1, "Сделать мир лучше", project1.getProjectID(), user1.getUserID());
    Issue issue2 = new Issue(2, "Сделать мир лучше еще раз", project2.getProjectID(), user1.getUserID());

    //основное окно
    private JPanel catalogIssues = new JPanel();

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
        // catalogIssues.setLayout( new BorderLayout(5,5));
        catalogIssues.setLayout(new BorderLayout(5, 5));
        catalogIssues.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5 ));

        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));

        //окно диалога создания новой записи
        JDialog createNewIssuesDialog = new JDialog(MainWindow.this, "Создание новой записи", true);
        JPanel createNewIssuesPanel = new JPanel();
        createNewIssuesDialog.add(createNewIssuesPanel);

// список файлов
        String issue[] = {issue1.getIssueText(), issue2.getIssueText()};

        listOfIssuesScroll.setPreferredSize(new Dimension(400, 500)); //минимальный размер
        issuesList.setListData(issue);
        issuesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //можно выделять несколько элементов

        //слушатель нажатия на элемент листа
        issuesList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


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
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // добавление кнопок в панель кнопок
        buttonsPanel.add(buttonAddNewIssues);
        buttonsPanel.add(buttonReport);

        // добавление панелей в основоное окно
        catalogIssues.setLayout(new BorderLayout());
        catalogIssues.add(listOfIssuesScroll, BorderLayout.CENTER);
        catalogIssues.add(buttonsPanel, BorderLayout.SOUTH);


        getContentPane().add(catalogIssues);
        setSize(600, 600);
        setLocationRelativeTo(null); // посередине
        setVisible(true);

    }


}

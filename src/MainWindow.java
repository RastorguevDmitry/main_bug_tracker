import structure.Issue;
import structure.ReadAllIssues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {



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

        // список issues


        ReadAllIssues listOfIssues = new ReadAllIssues();
        ArrayList<Issue> listOfIssues1 = listOfIssues.issue;


        //String issue[] = listOfIssues1.toArray();
        //toArray():
        String issue[] = listOfIssues.ReadAllIssuesToString();


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

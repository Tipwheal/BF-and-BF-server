package ui;

import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

import javax.swing.*;

import rmi.RemoteHelper;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 377542095280692385L;
    private RemoteHelper helper = RemoteHelper.getInstance();
    private JMenuItem runItem;
    private JTextArea codeArea;
    private JTextArea paramArea;
    private JTextArea outputArea;

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu runMenu = new JMenu("Run");
        runItem = new JMenuItem("Run");
        runItem.addActionListener(new MyActionListener());
        runMenu.add(runItem);
        JMenu whatMenu = new JMenu("What");
        JMenu versionMenu = new JMenu("Version");
        menuBar.add(fileMenu);
        menuBar.add(runMenu);
        menuBar.add(whatMenu);
        menuBar.add(versionMenu);
        this.setJMenuBar(menuBar);

        codeArea = new JTextArea();
        JScrollPane codeScrollPane = new JScrollPane(codeArea);
        codeScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        codeScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.getContentPane().add(codeScrollPane, BorderLayout.CENTER);

        Box box = new Box(BoxLayout.X_AXIS);
        paramArea = new JTextArea();
        paramArea.setRows(6);
        JScrollPane paramScrollPane = new JScrollPane(paramArea);
        paramScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        paramScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        outputArea = new JTextArea();
        outputArea.setRows(6);
        outputArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        outputScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        outputScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        box.add(paramScrollPane);
        box.add(outputScrollPane);
        this.getContentPane().add(box, BorderLayout.SOUTH);

        int x = 600;
        int y = 400;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(((int) dimension.getWidth() - x) / 2, ((int) dimension.getHeight() - y) / 2, x, y);
        this.setVisible(true);
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == runItem) {
                String code = codeArea.getText();
                String param = paramArea.getText();
                try {
                    outputArea.setText(helper.getExecuteService().execute(code, param));
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}

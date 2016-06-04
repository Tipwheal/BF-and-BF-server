package ui;

import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

import javax.swing.*;

import rmi.RemoteHelper;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 377542095280692385L;
	private JTextArea textArea;
	private JLabel resultLabel;

	public MainFrame() {
		// 创建窗体
		JFrame frame = new JFrame("BF Client");
		frame.setLayout(new BorderLayout());

		JMenuBar menuBar = new JMenuBar();
		MyMenu fileMenu = new MyMenu("File");
		menuBar.add(fileMenu);
		fileMenu.addItems("New","Open","Save","Exit");
		for(JMenuItem item:fileMenu.getItems()) {
			item.addActionListener(new MenuItemActionListener());
		}
		frame.setJMenuBar(menuBar);
		
		MyMenu runMenu = new MyMenu("Run");
		runMenu.addItems("Execute");
		for(JMenuItem item:runMenu.getItems()) {
			item.addActionListener(new MenuItemActionListener());
		}
		menuBar.add(runMenu);

		textArea = new JTextArea();
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setBackground(Color.LIGHT_GRAY);
		frame.add(textArea, BorderLayout.CENTER);

		// 显示结果
		resultLabel = new JLabel();
		resultLabel.setText("result");
		frame.add(resultLabel, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLocation(400, 200);
		frame.setVisible(true);
	}
	
	class MenuItemActionListener implements ActionListener {
		/**
		 * 子菜单响应事件
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("Open")) {
				textArea.setText("Open");
			} else if (cmd.equals("Save")) {
				textArea.setText("Save");
			} else if (cmd.equals("Run")) {
				resultLabel.setText("Hello, result");
			}
		}
	}

	class SaveActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String code = textArea.getText();
			try {
				RemoteHelper.getInstance().getIOService().writeFile(code, "admin", "code");
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

	}
}

package ui;

import java.util.*;
import javax.swing.*;

public class MyMenu extends JMenu{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5169437388893161371L;

	public MyMenu(String string) {
		setText(string);
	}

	public void addItems(String ... items){
		for(String str:items) {
			JMenuItem item = new JMenuItem(str);
			add(item);
		}
	}
	
	public ArrayList<JMenuItem> getItems() {
		ArrayList<JMenuItem> list = new ArrayList<>();
		for(int i = 0;i<this.getItemCount();i++) {
			list.add(this.getItem(i));
		}
		return list;
	}
	
	
}

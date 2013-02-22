package view.menu;

/**
 * This class displays the 'File' drop down sub-menu for the tool bar.
 * @version     2.1                
 * @since       21 Feb 2013         
 */

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FileMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private JMenuItem exitItem;
	
	public FileMenu(String text) {
		super(text);
		//loadTasksFromFile();
		addItems();
	}
	
	private void addItems(){
		exitItem = new JMenuItem("Exit");
		add(exitItem);
	}
	
	public JMenuItem getExitItem() {
		return exitItem;
	}
	


}

package view.menu;

/**
 * This class displays the 'Edit' drop down sub-menu for the tool bar.
 * @version     2.1                
 * @since       21 Feb 2013         
 */

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class EditMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	private JMenu ViewMenu;
	public EditMenu(String text){
		super(text);
		addItems();
	}
	private void addItems(){
		ViewMenu = new JMenu("View");
		JMenuItem dayView = new JMenuItem("Day");
		JMenuItem calendarView = new JMenuItem("Month");
		ViewMenu.add(dayView);
		ViewMenu.add(calendarView);
		add(ViewMenu);
	}
	public JMenu getViewMenu(){
		return ViewMenu;
	}
}

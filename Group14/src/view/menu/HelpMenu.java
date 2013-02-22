package view.menu;

/**
 * This class displays the 'Help' drop down sub-menu for the tool bar.
 * @version     2.1                
 * @since       21 Feb 2013         
 */

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class HelpMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private JMenuItem aboutItem;
	
	public HelpMenu(String text){
		super(text);
		addItem();
	}
	private void addItem(){
		aboutItem = new JMenuItem("About");
		add(aboutItem);
	}
	public JMenuItem getAboutItem(){
		return aboutItem;
	}

}

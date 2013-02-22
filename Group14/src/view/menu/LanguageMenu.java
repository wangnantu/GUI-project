package view.menu;

/**
 * This class displays the 'Language' drop down sub-menu for the tool bar.
 * @version     2.1                
 * @since       21 Feb 2013         
 */

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LanguageMenu extends JMenu{

	private static final long serialVersionUID = 1L;
	
	private JMenuItem Ch;
	private JMenuItem En;
	private JMenuItem In;
	private JMenuItem Se;
	
	public LanguageMenu(String text){
		super(text);
		addItem();
	}
	private void addItem(){
		Ch = new JMenuItem("Chinese");
		En = new JMenuItem("English");
		In = new JMenuItem("Indonesian");
		Se = new JMenuItem("Swedish");
		add(Ch);
		add(En);
		add(In);
		add(Se);
	}
}

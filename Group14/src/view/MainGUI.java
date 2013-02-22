package view;

/**
 * This class initiates the main gui.
 * @version     2.3                
 * @since       22 Feb 2013         
 */

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import view.dialog.Dialog;
import view.menu.TMenuBar;


public class MainGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 * 
	 */
	
	//public static DataHandlingXML data;
	private TMenuBar tMenuBar = new TMenuBar();
	



	public MainGUI() {
		//data = new DataHandlingXML();
		super("Task Manager");
		MainWindow window = new MainWindow();
		setJMenuBar(tMenuBar);
		add(window);
		this.setSizeAndCentralizeMe(640, 400);
	    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					if (Dialog.popupConfirmDialog("Do you really want to Exit?") == true) {
						System.out.println("TaskManager Exit.");
						System.exit(0);
					}
				}
	        });
	    this.setVisible(true);
			
			
				
	}

	
	public TMenuBar getTMenuBar() {
		return tMenuBar;
	}
	
	private void setSizeAndCentralizeMe(int width, int height) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(width, height);
		this.setLocation(screenSize.width / 2 - width / 2, screenSize.height/ 2 - height / 2);
	}
	
	


}

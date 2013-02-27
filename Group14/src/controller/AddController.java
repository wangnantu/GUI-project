package controller;

/**
 * This class handles the addition of tasks controller.
 * @version     2.1                
 * @since       21 Feb 2013         
 */

import view.MainWindow;
import model.*;

public class AddController {

	public AddController() {};
	
	public void addTask(Task task) {
		DataHandlingXML.getHandler().addTask(task);
		MainWindow.getTaskList().update(new TaskListController());
	}
}

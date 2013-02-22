package controller;

/**
 * 
 * @version     2.1                
 * @since       21 Feb 2013         
 */

import model.DataHandlingXML;
import model.Task;
import view.MainWindow;

public class TaskContainerController {

	public TaskContainerController() {
	}
	
	public void removeTask(Task task) {
		DataHandlingXML.getHandler().removeTask(task);
		
		/*This line updates the main window with the changed tasks
		 * This is probably not the neatest way to solve the problem,
		 * an idea would be to in some way pass a reference of the main window
		 * to the controller and the update it, that way a fixed name for the 
		 * main window isn't needed.
		 */
		MainWindow.getTaskList().update(new TaskListController());
	}
	
	public void changeTask(Task change, Task changeInto) {
		DataHandlingXML.getHandler().changeTask(change, changeInto);
	}
}

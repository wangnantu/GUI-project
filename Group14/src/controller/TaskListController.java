package controller;

/**
 * This class handles the task list controller.
 * @version     2.1                
 * @since       21 Feb 2013         
 */

import java.util.ArrayList;

import model.DataHandlingXML;
import model.Task;

public class TaskListController {
	
	public TaskListController() {
	}
	
	public ArrayList<Task> getTasks() {
		return DataHandlingXML.getHandler().getTasks();
	}
}

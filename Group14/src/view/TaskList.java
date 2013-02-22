package view;

/**
 * This class will display every task that have been stored in the list of tasks.
 * @version     2.3                
 * @since       22 Feb 2013         
 */

import javax.swing.*;

import controller.TaskContainerController;
import controller.TaskListController;
import model.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class TaskList extends JScrollPane {
	
	private ArrayList<Task> tasks;
	private ArrayList<TaskContainer> taskContainers;
	private JPanel taskPane;
	private TaskContainerController taskCC = new TaskContainerController();

	
	public TaskList(TaskListController controller) {
		
		taskContainers = new ArrayList<TaskContainer>();
		
		taskPane = new JPanel();
		taskPane.setLayout(new GridLayout(0,1,0,1));
		taskPane.setBackground(Color.black);
		
		// Get the tasks from the data handler
		tasks = controller.getTasks();
	
		//Make task containers from the imported tasks
		Iterator taskIterator = tasks.iterator();
		while(taskIterator.hasNext())
			taskContainers.add(new TaskContainer((Task)taskIterator.next(), this.taskCC));
		
		//Add to the task pane
		Iterator taskContainerIterator = taskContainers.iterator();
		while(taskContainerIterator.hasNext())
			taskPane.add((TaskContainer)taskContainerIterator.next());
		
		// Display the items on the scroll pane
		setColumnHeaderView(new TitlesBar());
		setViewportView(taskPane);
	}
	
	public void update(TaskListController controller) {
		
		// Clear the existing taskPane before adding the tasks again
		taskPane = null;
		taskPane = new JPanel();
		taskPane.setLayout(new GridLayout(0,1,0,1));
		taskPane.setBackground(Color.black);
		
		taskContainers = new ArrayList<TaskContainer>();
		
		// Get the tasks from the data handler
		tasks = controller.getTasks();
	
		//Make task containers from the imported tasks
		Iterator taskIterator = tasks.iterator();
		
		while(taskIterator.hasNext()) {
			if (! tasks.contains(taskIterator.hasNext()))
				taskContainers.add(new TaskContainer((Task)taskIterator.next(), this.taskCC));
		}
		
		//Add to the task pane
		Iterator taskContainerIterator = taskContainers.iterator();
		
		while(taskContainerIterator.hasNext())
				taskPane.add((TaskContainer)taskContainerIterator.next());
		
		//Add to scroll pane
		setColumnHeaderView(new TitlesBar());
		setViewportView(taskPane);
	}
	
}

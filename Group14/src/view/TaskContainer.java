package view;

/**
 * This class contains the tab that displays each task.
 * @version     2.3                
 * @since       22 Feb 2013         
 */

import model.Task;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import view.dialog.Dialog;

import controller.EditController;
import controller.TaskContainerController;

public class TaskContainer extends JPanel implements ActionListener {
	
	private JLabel labelP, categoryP, priorityP, dueTimeP;
	private JButton remove, edit;
	private Task task;
	private TaskContainerController taskCC;
	private JCheckBox checkCompleted;
	
	
	public TaskContainer(Task task, TaskContainerController taskCC) {
		
		//Maybe set the controllers as static variables somewhere?
		this.taskCC=taskCC;
		this.task = task;
		
		//Sets the properties of the buttons
		checkCompleted = new JCheckBox("", task.getCompleted());
		checkCompleted.addActionListener(this);
		checkCompleted.setBackground(new Color(237,245,243));
		
		edit = new JButton(new ImageIcon("Graphics/editButton.png"));
		remove = new JButton(new ImageIcon("Graphics/deleteButton.png"));
		edit.setBackground(Color.white);
		remove.setBackground(Color.white);
		
		edit.setSize(new Dimension(10,10));
		edit.addActionListener(this);
		
		remove.setSize(10, 10);
		remove.addActionListener(this);
		
		//sets the properties of the container
		setLayout(new GridLayout(1,7));
		setBackground(new Color(237,245,243));
		setPreferredSize(new Dimension(500,40));
		
		//sets the properties of the Labels
		
		labelP = new JLabel(task.getLabel());
		labelP.setHorizontalAlignment(JLabel.LEFT);
		
		categoryP = new JLabel(task.getCategory());
		categoryP.setHorizontalAlignment(JLabel.LEFT);
		
		priorityP = new JLabel(task.getPriority());
		priorityP.setHorizontalAlignment(JLabel.LEFT);
		
		dueTimeP = new JLabel(task.getDateFormated());
		dueTimeP.setHorizontalAlignment(JLabel.LEFT);
		
		// Add all the components
		setPreferredSize(new Dimension(600, 40));
		add(checkCompleted);
		add(labelP); add(categoryP); add(priorityP); add(dueTimeP);
		add(edit); add(remove);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == remove) {
			if (Dialog.popupConfirmDialog("Do you really want to remove this Task?") == true){
				taskCC.removeTask(task);
			}
		}
		else if(e.getSource() == edit) {
			new EditWindow(new EditController(), task); 
		}
		else if(e.getSource() == checkCompleted) {
			Task tempTask = task;
			tempTask.setCompleted(checkCompleted.isSelected());
				taskCC.changeTask(task,tempTask);
		}
		
		
	}
}
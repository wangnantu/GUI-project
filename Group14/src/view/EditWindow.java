package view;

/**
 * This class will constitute the edit window.
 * The different components are declared directly as instance variables.
 * @version     2.3                
 * @since       22 Feb 2013         
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Task;

import com.toedter.calendar.JDateChooser;

import controller.EditController;

public class EditWindow extends JFrame implements ActionListener {
	
	private Task task;
	private EditController editController;
	private JTextField title = new JTextField(15);

	private JComboBox category = new JComboBox();
	private JComboBox priority = new JComboBox();
	
	private JTextArea notes = new JTextArea(5,15);
	
	private JLabel titleL = new JLabel("Title: ");
	private JLabel reminder	= new JLabel("Reminder: ");
	private JLabel categoryL = new JLabel("Category: ");
	private JLabel priorityL = new JLabel("Priority: ");
	private JLabel notesL = new JLabel("Notes: ");
	
	private JButton done = new JButton("Done");
	
	private JDateChooser calendar = new JDateChooser();
	
	public EditWindow(EditController editC, Task task) {
		
		this.task = task;
		setVisible(true);
		this.editController = editC;
		
		setBackground(new Color(119,215,233));
		
		//Add categories and priorities from a separate model class
		category.addItem("Work"); category.addItem("School");
		category.addItem("Entertainment");
		
		priority.addItem("Low"); 
		priority.addItem("Medium");
		priority.addItem("High");
		
		setLayout(new GridBagLayout());
		setBackground(Color.gray);
		this.setSizeAndCentralizeMe(640, 400);
		GridBagConstraints con = new GridBagConstraints();
		con.anchor = GridBagConstraints.WEST;
		
		setInfo(task);
		
		// Add title
		con.gridy = 0; con.gridx = 0;
		con.insets = new Insets(10,0,10,30);
		add(titleL,con);
		con.gridy = 0; con.gridx = 1;
		con.insets = new Insets(10,0,10,30);
		add(title,con);
		
		// Add reminder
		con.gridy = 1; con.gridx = 0;
		con.insets = new Insets(0,0,10,30);
		add(reminder,con);
		
		con.gridy =1; con.gridx = 1;
		con.insets = new Insets(0,0,10,50);
		calendar.setCalendar(Calendar.getInstance());
		Calendar cal = calendar.getCalendar();
		add(calendar,con);
		calendar.setPreferredSize(new Dimension(120,30));
		//Calendar cal = calendar.getCalendar();

		/*
        //converts date and time into string from calendar object
        Date taskDate = cal.getTime();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String taskdate = dateFormat.format(taskDate);
       
        Date date = dateFormat.parse(datestr); //str from element
		*/
		
		//Add category
		con.gridy = 2; con.gridx = 0;
		con.insets = new Insets(0,0,10,30);
		add(categoryL, con);
		con.gridy = 2; con.gridx = 1;
		con.insets = new Insets(0,0,10,30);
		add(category, con);
		
		//Add priority
		con.gridy = 3; con.gridx = 0;
		con.insets = new Insets(0,0,10,30);
		add(priorityL, con);
		con.gridy = 3; con.gridx = 1;
		con.insets = new Insets(0,0,10,30);
		add(priority, con);
		
		// Add notes
		con.gridy = 4; con.gridx = 0;
		con.insets = new Insets(0,0,0,30);
		add(notesL, con);
		con.gridy = 4; con.gridx = 1;
		con.anchor=GridBagConstraints.NORTHWEST;
		con.insets = new Insets(0,0,0,30);
		add(notes, con);
		
		con.gridy = 5; con.gridx = 3;
		con.insets = new Insets(0,0,20,20);
		add(done, con);
		done.addActionListener(this);
		
		pack();
	}
	
	public void setInfo (Task task) {
		title.setText(task.getLabel());
		category.setSelectedItem(task.getCategory());
		priority.setSelectedItem(task.getPriority());
		if (task.getDate() != null)
			calendar.setDate(task.getDate());
	}
	
	//Listener method
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == done) {
			
			Task tempTask = new Task(title.getText(),
					category.getItemAt(category.getSelectedIndex()).toString(), 
					priority.getItemAt(priority.getSelectedIndex()).toString(), 
					"ccccccc", calendar.getDate());
			
				editController.changeTask(task,tempTask);
			
			dispose();
			
		}
	}
	private void setSizeAndCentralizeMe(int width, int height) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(width, height);
		this.setLocation(screenSize.width / 2 - width / 2, screenSize.height/ 2 - height / 2);
	}
}

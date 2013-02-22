package view;

import javax.swing.*;

import view.menu.TMenuBar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import controller.AddController;
import controller.TaskListController;


public class MainWindow extends JPanel implements ActionListener {
	
	private JButton calendar, timer, add, day, month;
	private static TaskList taskList = new TaskList(new TaskListController());
	
	
	public MainWindow() {
		
		//Initialize the buttons
		calendar = new JButton("Calendar");
		timer = new JButton("Timer");
		add = new JButton(new ImageIcon("Graphics/addButton.png"));
		add.setBackground(new Color(0,255,0));
		add.addActionListener(this);
		day = new JButton("Day view");
		month = new JButton("Month view");
		
		setBackground(new Color(119,215,233));
		setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();
		
		/*//menuBar
		con.gridx = 0; con.gridy = 0;
		con.gridwidth=1;
		con.anchor = GridBagConstraints.NORTHWEST;
		add(menuBar, con);*/
		
		/*//Calendar button
		con.gridx = 0; con.gridy = 1;
		con.anchor = GridBagConstraints.NORTHWEST;
		con.insets = new Insets(10,10,10,0);
		add(calendar, con);
		
		//Timer button
		con.gridx = 1; con.gridy = 1;
		con.anchor = GridBagConstraints.NORTHWEST;
		con.insets = new Insets(10,0,10,0);
		add(timer, con);
		
		//Day view button
		con.gridx = 0; con.gridy = 2;
		con.anchor = GridBagConstraints.WEST;
		con.insets = new Insets(10,10,0,0);
		add(day, con);
		
		//Month
		con.gridx = 1; con.gridy = 2;
		con.anchor = GridBagConstraints.WEST;
		con.insets = new Insets(10,0,0,0);
		add(month, con); */
		
		//Add
		con.gridx = 2; con.gridy = 2;
		con.anchor = GridBagConstraints.EAST;
		con.insets = new Insets(10,20,10,10);
		add(add, con);
		
		//Task list
		con.gridx = 0; con.gridy = 3;
		con.gridwidth = 3;
		con.weightx = 1;
		con.weighty =1;
		con.fill = GridBagConstraints.BOTH;
		con.anchor = GridBagConstraints.SOUTHWEST;
		con.insets = new Insets(0,10,10,10);
		add(taskList, con);
		
	}
	
	public static TaskList getTaskList() {
		return taskList;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == add) {
			new AddWindow(new AddController());
		}
	}

}

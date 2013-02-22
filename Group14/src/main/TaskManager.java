package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainGUI;
import view.dialog.Dialog;


//try to merge with master
public class TaskManager {

	private MainGUI gui;
	public TaskManager() {
		gui = new MainGUI();
		Dialog.setProgramFrame(gui);
		addComponentListeners();
	}
	
	public static void main(String[] args) {
		TaskManager app = new TaskManager();
	}
	
	private void addComponentListeners(){
		addExitMenuListener();
		addHelpMenuListener();
	}

	private void addExitMenuListener(){
	    gui.getTMenuBar().getFileMenu().getExitItem().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (Dialog.popupConfirmDialog("Do you really want to Exit?") == true) {
							System.out.println("TaskManager Exit.");
							System.exit(0);
						}
					}
				});
	}
	
	private void addHelpMenuListener(){
		gui.getTMenuBar().getHelpMenu().getAboutItem().addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						Dialog.popupMessageDialog("Task Tracker is a To-Do Manager to keep track of your daily errands. \n\t This intuitive widget allows you to create, edit and delete tasks you need to do. \n\t Version: 2.0 \n\t Date: 22 February 2013 \n\t Build id: 20130222-1300 \n\t (c) Copyright Group14:Task Trackers.  All rights reserved. \n\t Visit http://www.tasktrackers.org");
					}
					
				}
				);
	}

}

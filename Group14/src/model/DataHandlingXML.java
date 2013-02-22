package model;
//test
/**
 * This class handles the data and xml methods for the TO-DO application.
 * @version     2.3                
 * @since       22 Feb 2013         
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class DataHandlingXML {

	private static DataHandlingXML handler;
	private ArrayList<Task> tasks;
	private Document doc;

	public DataHandlingXML() {
		//
		tasks = new ArrayList<Task>();

		SAXBuilder builder = new SAXBuilder();

		File f = new File("./db.xml");

		//check if file exists
		if (f.exists()) {
			//build the xml document from the file
			System.out.println("build the xml document from the file");
			try {        
				doc = builder.build(new File("./db.xml"));
			} catch (Exception ex) {
				Logger.getLogger(DataHandlingXML.class.getName()).log(Level.SEVERE, null, ex);
			}

			Element root = doc.getRootElement();
			List<Element> eleList = root.getChildren();
			for (int i=0; i<eleList.size(); i++) {
				tasks.add(convertEleToTask(eleList.get(i)));   
			}
		}
		else {
			//create a new xml document
			System.out.println("Trying to create new xml file");
			doc = new Document();
			Element e = new Element("root");
			e.setText("DataHandlingXML root");
			doc.addContent(e);
		}
	}

	/**
     * Method to add a task to tasklist and database xml file.
     * @param newTask     the task to be added
     */
	public void addTask(Task newTask) {
		if (newTask.getLabel() != "")
			tasks.add(newTask);
			addTasktoXML(newTask);
	}

	/**
     * Method to remove a task from tasklist and database xml file.
     * @param task     the task to be removed
     */
	public void removeTask(Task task) {
		int index = -1;
		if (tasks.contains(task)) {
			index = tasks.indexOf(task);
			tasks.remove(task);
			editTask(index, null);
		}
	}

	/**
     * Method to edit a task in tasklist and database xml file.
     * @param targetTask     task to be replaced
     * @param changeInto     task with new information
     */
	public void changeTask(Task targetTask, Task changeInto) {
		int index = tasks.indexOf(targetTask);
		tasks.set(index, changeInto);
		editTask(index, changeInto);
	}

	/**
     * Method to retrieve all tasks in tasklist.
     * @return      tasks
     */
	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public static DataHandlingXML getHandler() {
		if (handler == null) {
			handler = new DataHandlingXML();
		}
		return handler;
	}

	/**
	 * Converts an element in the xml document into a task object
	 * @param e     element from the xml document
	 * @return      task object
	 */
	private Task convertEleToTask (Element e) {
		String datestr = e.getChildText("Reminder");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		Date date = new Date();

		try {
			date = dateFormat.parse(datestr);
		} catch (ParseException ex) {
			Logger.getLogger(DataHandlingXML.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		Task task = new Task(e.getChildText("Label"), e.getChildText("Category"), e.getChildText("Priority"), "AAAAAAAAA", date);

		return task;
	}

	/**
	 * Adds a task into the xml database
	 * @param t     the task to add
	 */
	public void addTasktoXML(Task t) {
		Element root = doc.getRootElement();
		root.addContent(createElement(t));;
		writeFile();  
	}

	/**
     * Method to update the database xml file with the edited task.
     *@param t     		   the task to edit
     *@param editRowNum    row number of the task
     */
	void editTask(int editRowNum, Task t) {
		Element root = doc.getRootElement();
		List allChild = root.getChildren();
		allChild.remove(editRowNum);
		
		if (t != null) {
			allChild.add(editRowNum, createElement(t));
		}

		writeFile();
	}
	
	/**
     * Method to update the database xml file by removing the chosen task.
     * @param selectedRow    row number of the task to be removed
     */
    void removeTask(int selectedRow) {
        Element root = doc.getRootElement();
        List allChild = root.getChildren();
        allChild.remove(selectedRow);
               
        writeFile();
    }
    
	/**
	 * Method to write the document into a text file.
	 */
	private void writeFile() {
		FileWriter opstream;
		try {
			opstream = new FileWriter(new File ("./db.xml"));
			XMLOutputter outp = new XMLOutputter();
			System.out.println("WRITING XML FILE");
			outp.setFormat(Format.getPrettyFormat());
			outp.output(doc, opstream);
			outp.output(doc, System.out);
		} catch (IOException ex) {
			Logger.getLogger(DataHandlingXML.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	/**
     * Method to create a task element in the database xml file.
     * @param t     the task to add
     */
	private Element createElement(Task t) {
		//initialize the required elements for a task
		Element task = new Element("Task");
		Element label = new Element("Label");
		Element priority = new Element ("Priority");
		Element category = new Element ("Category");
		Element reminder = new Element ("Reminder");

		//converts date and time into string from calendar object
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String taskdate = dateFormat.format(t.getDate());

		//input string into the respective elements
		label.setText(t.getLabel());
		priority.setText(t.getPriority());
		category.setText(t.getCategory());
		reminder.setText(taskdate);

		//link the sub elements to the task element
		task.addContent(label);
		task.addContent(priority);
		task.addContent(category);
		task.addContent(reminder);

		return task;
	}


}

package model;

/**
 * The Task class represents a task in the TO-DO manager.
 * @version     2.3                
 * @since       22 Feb 2013         
 */



import java.text.DateFormat;
import java.util.Date;
//merge
public class Task {

	private String label, category, priority, dueTime;
	private boolean completed = false;
	private Date remind;
	private DateFormat form = DateFormat.getDateTimeInstance();
	
	public Task(String label, String category, String priority, String dueTime, Date reminderDate) {
		
		this.label = label;
		this.category = category;
		this.priority = priority;
		this.dueTime = dueTime;
		this.completed = false;
		this.remind = reminderDate;
		
	}
	
	// Declare methods for proper time formatting and handling
	
	/**
     * Sets the name of the task.
     *
     * @param label          The name of the task
     */
	public void setLabel(String newLabel) {
		label = newLabel;
	}
	
	/**
     * Returns the name of the task.
     *
     * @return  the name of the task
     */
	public String getLabel() {
		return label;
	}
	
	/**
     * Sets the type of task.
     *
     * @param category      The type of task
     */
	public void setCategory(String newCategory) {
		category = newCategory;
	}
	
	/**
     * Returns the type of task.
     *
     * @return    the type of task
     */
	public String getCategory() {
		return category;
	}
	
	/**
     * Sets the priority of the task.
     *
     * @param priority	the priority of the task
     */
	public void setPriority(String newPriority) {
		category = newPriority;
	}
	
	/**
     * Returns the priority of the task.
     *
     * @return  the priority of the task.
     */
	public String getPriority() {
		return priority;
	}
	
	/**
     * Sets the time the task is to be completed by.
     *
     * @param  dueTime 		The time the task is to be completed by
     */
	public void setDueTime(String newDueTime) {
		category = newDueTime;
	}
	
	/**
     * Returns the time the task is to be completed by.
     *
     * @return  the time the task is to be completed by.
     */
	public String getDueTime() {
		return dueTime;
	}
	
	/**
     * Sets that the task has been completed.
     */
	public void setCompleted(boolean status) {
		completed = status;
	}
	
	/**
     * Checks if the task has been completed.
     *   
     * @return  the completion status of the task
     */
	public boolean getCompleted() {
		return completed;
	}
	
	/**
     * Sets the date the task is to be completed by.
     *
     * @param  reminderDate 		The date the task is to be completed by.
     */
	public void setDate(Date reminderDate) {
		remind = reminderDate;
	}
	
	/**
     * Returns the date the task is to be completed by.
     *
     * @return  	the date the task is to be completed by.
     */
	public Date getDate () {
		return remind;
	}
	
	public String getDateFormated () {
		if (remind != null)
			return form.format(remind);
		else
			return null;
	}
	
	public String toString() {
		return "{" + label + ", " + category +", " + priority + ", " + form.format(remind) + "}";
	}
	
}

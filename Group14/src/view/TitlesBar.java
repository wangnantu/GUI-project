package view;

/**
 * This class initiates the column titles of the task list table.
 * @version     2.3                
 * @since       22 Feb 2013         
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class TitlesBar extends JPanel {

	private JLabel title = new JLabel();
	private JLabel category = new JLabel();
	private JLabel priority = new JLabel();
	private JLabel dueTime = new JLabel();
	private JLabel edit = new JLabel();
	private JLabel remove = new JLabel();
	private JLabel completed = new JLabel();
	
	public TitlesBar() {
		
		setLayout(new GridLayout(1,7));
		setBackground(new Color(175,234,245));
		
		completed.setText("Done");
		completed.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
		
		title.setText("Title");
		title.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
		
		category.setText("Category");
		category.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
		
		priority.setText("Priority");
		priority.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
		
		dueTime.setText("Due");
		dueTime.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
		
		edit.setText("");
		edit.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
		
		remove.setText("");
		remove.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 15));
		add(completed);
		add(title); add(category); add(priority); add(dueTime); add(edit); add(remove);
	}
}

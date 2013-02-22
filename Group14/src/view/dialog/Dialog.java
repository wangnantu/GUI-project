package view.dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Dialog {

private static String dialogTitle = "TaskManager";

	
	private static JFrame programFrame;

	/**
	 * 
	 * @param programFrame
	 */
	public static void setProgramFrame(JFrame programFrame) {
		Dialog.programFrame = programFrame;
	}


	/**
	 * <P>
	 * pop-up a confirmation dialog
	 * </P>
	 * 
	 * @param promptWord:message
	 *            show to user
	 * @return True:user choose OK,False:user choose Cancel
	 */
	public static boolean popupConfirmDialog(String promptWord) {
		Object[] options = {"Yes","No"};
		boolean retval = (boolean) (JOptionPane.showOptionDialog(programFrame,
				promptWord, dialogTitle, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_NO_OPTION);
		return retval;
	}

	/**
	 * <P>
	 * pop-up a confirmation of exit dialog
	 * </P>
	 * 
	 * @param promptWord:message
	 *            show to user
	 * @return True:user choose OK,False:user choose Cancel
	 */
	public static boolean popupConfirmCancelDialog(String promptWord) {
		boolean retval = (boolean) (JOptionPane.showConfirmDialog(programFrame,
				promptWord, dialogTitle, JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION);
		return retval;
	}

	/**
	 * <P>
	 * pop-up a message dialog
	 * </P>
	 * 
	 * @param promptWord:message
	 *            show to user
	 */
	public static void popupMessageDialog(String promptWord) {
		Object[] options = {"OK"}; 
		JOptionPane.showOptionDialog(programFrame, promptWord, dialogTitle,
				JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
	}

	/**
	 * <P>
	 * pop-up a error message dialog
	 * </P>
	 * 
	 * @param promptWord:message
	 *            show to user
	 */
	public static void popupErrorDialog(String promptWord) {
		JOptionPane.showMessageDialog(programFrame, promptWord, dialogTitle,
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * <P>
	 * pop-up a warning message dialog
	 * </P>
	 * 
	 * @param promptWord:message
	 *            show to user
	 */
	public static void popupWarningDialog(String promptWord) {
		JOptionPane.showMessageDialog(programFrame, promptWord, dialogTitle,
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * <P>
	 * pop-up a question message dialog
	 * </P>
	 * 
	 * @param promptWord:message
	 *            show to user
	 */
	public static void popupQuestionDialog(String promptWord) {
		JOptionPane.showMessageDialog(programFrame, promptWord, dialogTitle,
				JOptionPane.QUESTION_MESSAGE);
	}

	/**
	 * <P>
	 * pop-up a input dialog
	 * </P>
	 * 
	 * @param promptWord:message
	 *            show to user
	 * @return the information user input
	 */
	public static String popupInputDialog(String promptWord) {
		return JOptionPane.showInputDialog(programFrame, promptWord,
				dialogTitle, JOptionPane.OK_CANCEL_OPTION);
	}

	public static void setDialogTitle(String dialogTitle) {
		Dialog.dialogTitle = dialogTitle;
	}

	public static JFrame getProgramFrame() {
		return programFrame;
	}

}

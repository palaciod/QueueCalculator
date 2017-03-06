package code;

import javax.swing.SwingUtilities;
/**
 * Main class is for the Calculator.
 * It creates a new Model and View object upon invoking the main method.
 * The view is added to the Model.
 * @author Daniel Palacio
 *
 */
public class Main {
	/**
	 * Creates new View object that contains information regarding the calculator
	 * within Model.
	 * @param args - Array of Strings
	 */
	
	
	public static void main(String[] args){
		Model m = new Model();
		SwingUtilities.invokeLater(new View(m));

	
	}
}

package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * Contains variables and methods for creating a GUI button that will store
 * operators and operands of type char.
 * @author Daniel Palacio
 *
 */
public class NumberListener implements ActionListener{
	private JButton jb;
	private Model m;
	/**
	 * Calls upon the {@code Model} reference to store the string within the JButton to the queue
	 * as a char.
	 * @param _m - Instance of the {@code Model}.
	 * @param _jb - Instance of the {@code JButton}
	 */
	public NumberListener(Model _m,JButton _jb){
		m = _m;
		jb = _jb;
	}
	/**
	 * Calls upon the {@code Model} reference to store a character, which is converted from 
	 * string to a queue in {@code Model}.
	 * @param e - Unused, specified by {@code ActionListener}
	 */
	@Override
	
	public void actionPerformed(ActionEvent e) {
		String num = jb.getText();
		char number = num.charAt(0);
		m.addToQ(number);
		
		
		System.out.println(m.size());
		
		//System.out.println(m.top());
		
	}

}

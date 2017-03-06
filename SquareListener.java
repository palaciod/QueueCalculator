package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * Contains variables and methods for creating a GUI button that will perform 
 * the square operation on a given double object.
 * @author Daniel Palacio
 *
 */
public class SquareListener implements ActionListener{
	private Model m;
	private JButton jb;	
	/**
	 * Calls upon the containing class's {@code m} reference to try to perform 
	 * the square (^2) operation.
	 * @param _m - Instance of the {@code Model}.
	 * @param _jb - Instance of the {@code JButton}.
	 */
	public SquareListener(Model _m,JButton _jb){
		m = _m;
		jb = _jb;
	}
	/**
	 * Calls upon the {@code Model} reference to perform the 
	 * square operation on a given number. It evaluates a single number at a time.
	 * @param e - Unused, specified by {@code ActionListener}.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(m.size()!=0){
			double x = Integer.parseInt(m.aValue());
			double answer = m.square(x);
			m.addToStoreAnswer(answer);
			
		
		m.outputView();
		}
			
		
	}

}

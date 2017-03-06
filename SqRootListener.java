package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * Contains variables and methods for creating a GUI button that will perform 
 * the square root operation on a given double object,
 * @author Daniel Palacio
 *
 */
public class SqRootListener implements ActionListener{
	private Model m;
	private JButton jb;
	/**
	 * Calls upon the containing class's {@code m} reference to try to perform
	 * the square root operation.
	 * @param _m - Instance of the {@code Model}.
	 * @param _jb - Instance of the {@code JButton}.
	 */
	public SqRootListener(Model _m,JButton _jb){
		m = _m;
		jb = _jb;
	}
	/**
	 * Calls upon the {@code Model} reference to perform the square root operation on a given number.
	 * It evaluates a single number at a time.
	 * @param e - Unused, specified by {@ActionListener}.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(m.size()!=0){
			double x = Integer.parseInt(m.aValue());
			double answer = m.sqroot(x);
			m.addToStoreAnswer(answer);
			
		
		m.outputView();
		}
		
	}

}

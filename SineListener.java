package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * Contains variables and methods for creating a GUI button that will perform
 * the sine operation on a given number.
 * @author Daniel Palacio
 *
 */
public class SineListener implements ActionListener{
	private Model m;
	private JButton jb;
	/**
	 * Calls upon the {@code Model} reference to perform the Sine operation
	 * on a given number. It only evaluates a single number at a time.
	 * @param _m - Instance of the {@code Model}.
	 * @param _jb - Instance of the code {@code JButton}.
	 */
	public SineListener(Model _m,JButton _jb){
		m = _m;
		jb = _jb;
	}
	/**
	 * Calls upon the {@code Model} reference to perform cosine operation.
	 * @param e - Unused, specified by {@code ActionListener}.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(m.size()!=0){
			double x = Integer.parseInt(m.aValue());
			double answer = m.sin(x);
			m.addToStoreAnswer(answer);
			
		
		m.outputView();
		}
	}

}

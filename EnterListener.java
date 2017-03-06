package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
/**
 * Contains variables and methods for creating a GUI button that will evaluate the expression.
 * @author Daniel Palacio
 *
 */
public class EnterListener implements ActionListener{
	private Model m;
	private JButton jb;
	private JLabel jl;
	/**
	 * Initialized the JButton's {@code Model} reference by the {@code Model} passed into it,
	 * sets the inputs in queue to be evaluated. 
	 * @param _m - Instance of the {@code Model}.
	 * @param _jb - Instance of the {@code JButton}.
	 */
	public EnterListener(Model _m,JButton _jb){
		m = _m;
		jb = _jb;
		
	}
	/**
	 * Calls upon the containing class's {@code m} reference to try to evaluate the expression within the queue that holds 
	 * the inputs. Listener enables the {@code Model} instance's to add the answer of the evaluated expression in a second queue called
	 * answerStore within {@code Model}.
	 * @param e - Unused here, but specified by {@code ActionListener}.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {		
			m.addToStoreAnswer(m.answer());		
			m.outputView();
	}

}

package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * Contains variables and methods for creating a GUI button that will allow the user to clear the 
 * inputs within the queue.
 * @author Daniel Palacio
 *
 */
public class ClearListener implements ActionListener {
	private Model m;
	private JButton jb;
	private int count=0;
	/**
	 * Defines the behavior of the containing Clear JButton when clicked by implementing the {@code ActionListener} interface. 
	 * This handler enables the {@code m}'s current information to be completely cleared by creating an association relationship between the two classes.
	 * @param _m - A reference to the {@code Model} to remove the current contents.
	 * @param _jb - A reference to the {@code JButton} that will be cleared.
	 */
	public ClearListener(Model _m,JButton _jb){
		m = _m;
		jb = _jb;
		
	}
	/**
	 * Calls upon the containing class's {@code m} reference to try to clear its current text by setting the text
	 * to "";
	 * @param e - Unused, but specified by {@code ActionListener}
	 */
	@Override
	
	public void actionPerformed(ActionEvent e) {
		m.outputView();
		m.clear();
		count++;
		
		if(count==1){
			
			m.clearAnswerStore();
			count=0;
		}
		
		
		
	}

}

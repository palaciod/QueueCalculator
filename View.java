package code;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * <h1>View</h1> 
 * Contains the variables and methods for representing the Model in a graphical user interface consisting of 
 * number pad, functions pad, and answer display.
 * @author Daniel Palacio
 *
 */
public class View implements Runnable {
	private Model _m;
	
	private JFrame window;
	private JLabel outputLabel;
	
	
	/**
	 * Initializes the {@code View} with a reference to the {@code Model} being used and initialized most instance variables;
	 * the rest are initialized in {@code run()}
	 * @param m - A reference to the {@code Model} being used.
	 */
	public View(Model m){
		_m = m;
	}
	/**
	 * Updates {@code View} with a reference to the updated {@code JLabel} outputLabel.
	 */
	public void updateOutputView(){
		updateOutputLabel(outputLabel);
		
	}
	
	/**
	 * Updates the {@code JLabel} containing the evaluated expression. Resets text of {@code JLabel} after initializing the Clear JButton twice 
	 * and then initializing the enter JButton.
	 * @param jl - The JLabel that will be updated.
	 */
	
	public void updateOutputLabel(JLabel jl){
		if(_m.isAnswerQueueEmpty()==true){
			jl.setText("" + "0");
		}else{
			jl.setText(""+ Double.toString(_m.getStoreAnswer()));
			jl.setForeground(Color.BLUE);
			
		}
		
		
	}
	/**
	 * Sets up and displays all of the GUI components: initializes the main window, sets the layouts of the main window and sub-panels, and 
	 * sub-panels, and adds components like Clear, Enter, Sin, Cos, Tan, square, and square root buttons.
	 */
	@Override
	public void run() {
		// ** Reminder: Organize!!!**
		window = new JFrame("Calculator");
		JPanel inputView = new JPanel();
		JPanel outputView = new JPanel();
		
		JPanel numberPad = new JPanel();
		JPanel operatorView = new JPanel();
		JPanel sideFunctionView = new JPanel();
		JButton sin = new JButton("sin");
		JButton cos = new JButton("cos");
		JButton tan = new JButton("tan");
		
		JButton log = new JButton("lg");
		
		JButton sqroot = new JButton("√");
		JButton sq = new JButton("^2");
		outputLabel = new JLabel("0");
		sideFunctionView.setLayout(new GridLayout(4,2));
		sideFunctionView.add(sin);
		sideFunctionView.add(cos);
		sideFunctionView.add(tan);
		
		sideFunctionView.add(log);
		
		sideFunctionView.add(sqroot);
		sideFunctionView.add(sq);
		outputView.add(outputLabel);
		
		
		
		_m.addObserver(this);
		
		JButton one = new JButton("1");
		JButton two = new JButton("2");
		JButton three = new JButton("3");
		JButton four = new JButton("4");
		JButton five = new JButton("5");
		JButton six = new JButton("6");
		JButton seven = new JButton("7");
		JButton eight = new JButton("8");
		JButton nine = new JButton("9");
		JButton zero = new JButton("0");
		JButton clear = new JButton("Clear");
		JButton enter = new JButton("Enter");
		JButton plusButton = new JButton("+");
		JButton minusButton = new JButton("-");
		JButton divideButton = new JButton("/");
		JButton timesButton = new JButton("*");
		window.setLayout(new GridLayout(0,1));
		window.add(sideFunctionView);
		window.add(outputView);
		window.add(numberPad);
		
		
		numberPad.setLayout(new GridLayout(1,2));
		numberPad.add(inputView);
		numberPad.add(operatorView);
		operatorView.setLayout(new GridLayout(4,1));
		operatorView.add(timesButton);
		operatorView.add(divideButton);
		operatorView.add(plusButton);
		operatorView.add(minusButton);
		inputView.setLayout(new GridLayout(4,3));
		
		inputView.add(one);
		inputView.add(two);
		inputView.add(three);
		inputView.add(four);
		inputView.add(five);
		inputView.add(six);
		inputView.add(seven);
		inputView.add(eight);
		inputView.add(nine);
		inputView.add(zero);
		inputView.add(clear);
		inputView.add(enter);
		
		//Action Listener
		sin.addActionListener(new SineListener(_m,sin));
		cos.addActionListener(new CosineListener(_m,cos));
		tan.addActionListener(new TanListener(_m,tan));
		sq.addActionListener(new SquareListener(_m,sq));
		log.addActionListener(new LogListener(_m,log));
		sqroot.addActionListener(new SqRootListener(_m,sqroot));
		plusButton.addActionListener(new NumberListener(_m,plusButton));
		minusButton.addActionListener(new NumberListener(_m,minusButton));
		divideButton.addActionListener(new NumberListener(_m,divideButton));
		timesButton.addActionListener(new NumberListener(_m,timesButton));
		one.addActionListener(new NumberListener(_m,one));
		two.addActionListener(new NumberListener(_m,two));
		three.addActionListener(new NumberListener(_m,three));
		four.addActionListener(new NumberListener(_m,four));
		five.addActionListener(new NumberListener(_m,five));
		six.addActionListener(new NumberListener(_m,six));
		seven.addActionListener(new NumberListener(_m,seven));
		eight.addActionListener(new NumberListener(_m,eight));
		nine.addActionListener(new NumberListener(_m,nine));
		zero.addActionListener(new NumberListener(_m,zero));
		clear.addActionListener(new ClearListener(_m,clear));
		//outputLabel.setText("");
		
		enter.addActionListener(new EnterListener(_m,enter));
		
		window.setVisible(true);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

}

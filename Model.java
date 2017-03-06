package code;


import java.util.LinkedList;
import java.util.Queue;




/**
 * <h1>Model</h1> The underlying model that the graphical user interface displays.
 * @author Daniel Palacio
 *
 */
public class Model {
	private Queue<String> inputQueue;
	private Queue<Double> answerStore;
	private Queue<Object> queue;
	private View observer;
	public Model(){
		inputQueue = new LinkedList<String>();
		queue = new LinkedList<Object>();
		answerStore = new LinkedList<Double>();
		
	}
	/**
	 * Adds objects of type char/character to queue.
	 * @param e - reference to the character stored within each JButton in the number pad in 
	 * the view.
	 */
	public void addToQ(char e){
		queue.add(e);
	}
	/**
	 * Returns the Queue for testing purposes.
	 * @return Queue that holds the input values.
	 */
	public Queue<Object> getQ(){
		return queue;
	}
	/**
	 * Returns the size of the queue as an integer.
	 * @return Size of the queue, this is for testing purposes and functionality.
	 */
	public int size(){
		return queue.size();
	}
	/**
	 * Returns first in Queue.
	 * @return First character in queue that holds input values.
	 */
	public Character firstInQ(){
		return  (Character) queue.peek();
	}
	
	/**
	 * Clears the queue that holds the input values.
	 */
	public void clear(){
	if(queue.isEmpty()==false){
		queue.clear();
	}else{
		System.out.println("Queue is already empty!");
	}
	
	}
	/**
	 * Returns a boolean determining whether the first object
	 * within the queue is an operand.
	 * @return True if it's an operand. Returns false if it's an operator.
	 */
	public boolean is_Operand(){
		return Character.isDigit( (Character) queue.peek());
		}
	
		/**
		 * Returns a boolean determining whether the first object 
		 * within the queue is an operator
		 * @return True if it's an operator. Returns false if it's an operand.
		 */
	public boolean as_Operator(){
		if((Character)queue.peek()=='+'){
			return true;
		}
		if((Character)queue.peek()=='-'){
			return true;
		}
		if((Character)queue.peek()=='*'){
			return true;
		}
		if((Character)queue.peek()=='/'){
			return true;
		}
		return false;
	}
	/**
	 * Returns a string representing the left side of the operator of the expression. 
	 * @return String version of the left side of the operator in the expression.
	 */
	public String aValue(){
		
		String a = "";
		while(!queue.isEmpty()){
			if(as_Operator()){
				break;
			}
			a = a + queue.remove().toString();
			
		}
		
		return a;
	}
	/**
	 * Iterates though the queue until it finds the operator and returns it as a char.
	 * @return Operator as a char.
	 */
	public char getOperator(){
		char op = 0;
		while(!queue.isEmpty()){
			
			if(as_Operator()){
				op =  (char) queue.remove();
				break;
			}
			//queue.remove();
		}
		
		return op;
	}
	
	
	
	/**
	 * Returns a string representing the right side of the operator of the expression. 
	 * @return String version of the right side of the operator in the expression.
	 */
	public String bValue(){
		String b = "";

		while(!queue.isEmpty()){

			b = b + queue.remove();

		}	
		return b;
	}
	/**
	 * Returns the evaluation of the expression by converting strings A and B to objects of type double.
	 * Checks which operator function to perform on expression by using a case statement.
	 * @return Evaluated double of String A and String B.
	 */
	public double answer(){
		double val = 0;
		String _a = aValue();
		Character op = getOperator();
		String _b = bValue();
		if(_a==""){
			System.out.println("No A input!");
			return val;
		}
		if(op==0){
			System.out.println("No Operator input!");
			return val;
		}
		if(_b==""){
			System.out.println("No B input!");
			return val;
		}
		double a = Double.parseDouble(_a);
		double b = Double.parseDouble(_b);
		
		
		
		switch(op.charValue()){
		case '+':
			val = a+b;
			return val;
		case '-':
			val = a-b;
			return val;
		case '*':
			val = a*b;
			return val;
		case '/':
			val = a/b;
			return val;
		
		}
		
		
	return val;
	}
	/**
	 * Stores the evaluated expression to a new queue called anserStore. 
	 * @param answer - The value of the evaluated expression.
	 */
	public void addToStoreAnswer(double answer){
		answerStore.add(answer);
	}
	/**
	 * Returns the answer by returning the first in the answerStore queue.
	 * @return First in answerStore.
	 */
	public double getStoreAnswer(){
		
		return answerStore.peek();
	}
	/**
	 * Returns a boolean to check if answerStore is empty.
	 * @return True if empty, or false if not.
	 */
	public boolean isAnswerQueueEmpty(){
		return answerStore.isEmpty();
	}
	/**
	 * Clears the answerStore queue to allow a new answer to be inserted.
	 */
	public void clearAnswerStore(){
		if(answerStore.isEmpty()){
			System.out.println("No Answer Has Been Evaluated");
			
		}else{
			answerStore.clear();	
		}
		
	}
	/**
	 * Returns the current size of the answerStore queue.
	 * @return Size of answerStore.
	 */
	public int sizeOfAnswerStore(){
		return answerStore.size();
	}
	/**
	 * Updates the view to correspond with the new evaluated expression.
	 */
	public void outputView(){
		observer.updateOutputView();
	}
	/**
	 * An association relationship between Model and View. 
	 * @param view - Updates the current view.
	 */
	public void addObserver(View view){
		observer = view;
	}
	/**
	 * Returns the evaluated expression after performing the sine function on the given double(number).
	 * 
	 * @param number - The specified double that you wish to perform the operation on.
	 * @return Double value of sine(number).
	 */
	public double sin(double number){
		return Math.sin(number);
	}
	/**
	 * Returns the evaluated expression after performing the cosine function on the given double(number).
	 * @param number - The specified double that you wish to perform the operation on.
	 * @return Double value of cosine(number).
	 */
	public double cos(double number){
		return Math.cos(number);
	}
	/**
	 * Returns the evaluated expression after performing the tangent function on the given double(number).
	 * @param number - The specified double that you wish to perform the operation on.
	 * @return Double value of tan(number).
	 */
	public double tan(double number){
		return Math.tan(number);
	}
	/**
	 * Returns the evaluated expression after performing the square root function on the given double(number).
	 * @param number - The specified double that you wish to perform the operation on.
	 * @return Double value of √ (number).
	 */
	public double sqroot(double number){
		return Math.sqrt(number);
	}
	/**
	 * Returns the evaluated expression after performing the log function on the given double(number).
	 * @param number - The specified double that you wish to perform the operation on.
	 * @return Double value of log(number).
	 */
	public double log(double number){
		return Math.log(number);
	}
	/**
	 * Returns the evaluated expression after performing the square function on the given double(number).
	 * @param number - The specified double that you wish to perform the operation on.
	 * @return Double value of number^2.
	 */
	public double square(double number){
		return number*number;
	}
	
	
	
}
	
	
	


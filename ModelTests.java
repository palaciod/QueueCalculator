package tests;

import static org.junit.Assert.*;



import org.junit.Test;

import code.Model;
/**
 * @author Daniel Palacio
 */
public class ModelTests {
	private Model m;
	
	@Test
	public void trueIntTest() {
		m = new Model();
		m.addToQ('5');
		m.addToQ('+');
		m.addToQ('5');
		boolean val  = m.is_Operand();
		assertTrue(val==true);
		
	}
	@Test
	public void falseIntTest(){
		m = new Model();
		m.addToQ('5');
		m.addToQ('+');
		boolean val = m.is_Operand();
		assertTrue(val==true);
	}
	
	@Test
	public void firstValTest(){
		m = new Model();
		m.addToQ('5');
		char n = m.firstInQ();
		assertEquals(n,'5');
	}
	@Test
	public void bMatchStringTest(){
	m = new Model();
	m.addToQ('3');
	m.addToQ('2');
	m.addToQ('+');
	m.addToQ('2');
	m.addToQ('2');
	String a = m.aValue();
	Character op = m.getOperator();
	String b = m.bValue();
	String twentyTwo = "22";
	assertTrue(b.equals(twentyTwo));
	}
	
	
	@Test
	public void aMatchStringTest(){
		m = new Model();
		m.addToQ('5');
		m.addToQ('1');
		m.addToQ('+');
		m.addToQ('3');
		String a = "51";
		assertTrue(m.aValue().equals(a));
	}
	@Test
	public void operatorTest(){
		m = new Model();
		//m.addToQ('5');
		m.addToQ('*');
		boolean val = m.as_Operator();
		assertTrue(val==true);
	}
	
	
	@Test
	public void checkOperator(){
		m = new Model();
		m.addToQ('2');
		m.addToQ('+');
		m.addToQ('3');
		Character op = '+';
		String a = m.aValue();
		Character operator = m.getOperator();
		assertTrue(op.equals(operator));
	}
	@Test
	public void anserTest(){
		m = new Model();
		m.addToQ('2');
		m.addToQ('+');
		m.addToQ('2');
		double answer = m.answer();
		int _answer = 4;
		assertTrue(answer==_answer);
	}

}

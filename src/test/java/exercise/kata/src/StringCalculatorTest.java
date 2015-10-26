package exercise.kata.src;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {
	private static StringCalculator cal;

	@BeforeClass
	public static void setUp(){
		cal= StringCalculator.getInstance();
	}

	@Test
	public void whenNumberIsCorrect() {
		assertEquals(10,cal.add("5,5"));
	}
	
	@Test
	public void whenNumberIsEmpty() {
		assertEquals(0,cal.add(""));
	}
	
	@Test
	public void whenHaveOneNumber() {
		assertEquals(2,cal.add("2"));
	}
	
	@Test()
	public void whenNumber2Numbers() {
		assertEquals(5,cal.add("2,3"));
	}

	@Test()
	public void whenNumberOfNumberIsUnknow() {
		assertEquals(2+3+3+5+6+7+2,cal.add("2,3,3,5,6,7,2"));
	}
	
	@Test()
	public void whenNewLineInsteadOfCommas() {
		assertEquals(9,cal.add("1\n2,3\n3"));
	}
	
	@Test()
	public void whenChangeOtherDelimiter() {
		assertEquals(7,cal.add("//;\n2;5"));
	}
	
	@Test
	public void whenNumberContainNegative() {
		String exMessage="";
	    try {
	        cal.add("-3,6,4,-2");
	    } catch (RuntimeException e) {
	    	exMessage = e.getMessage();
	    }
	    Assert.assertEquals("Negatives not allowed: [-3, -2]", exMessage);
	}
	
	@Test()
	public void whenIgnoreBiggerThan1000() {
		assertEquals(9,cal.add("//;1;3,1000,1001\n5"));
	}
	 
	
	
	
}

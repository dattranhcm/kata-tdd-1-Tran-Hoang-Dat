package exercise.kata.src;

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
	
	
	public void whenHaveOneNumber() {
		assertEquals(2,cal.add("2"));
	}
	
	@Test(expected = RuntimeException.class)
	public void whenNumberMore2Numbers() {
		assertEquals(9,cal.add("2,3,4"));
	}

	@Test(expected = RuntimeException.class)
	public void whenNumberIsCorrectFormat() {
		assertEquals(0,cal.add("2,cal"));
	}
	
}

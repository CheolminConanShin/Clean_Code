import static org.junit.Assert.*;

import org.junit.Test;


public class FizzBuzzTest {
	FizzBuzz fizzBuzz = new FizzBuzz();

	@Test
	public void fizzBuzz_should_say_1_for_3의배수도아니고_5의배수도_아닌경우() {
		assertEquals("1",fizzBuzz.say(1));
		assertEquals("2",fizzBuzz.say(2));
	}
	
	@Test
	public void fizzBuzz_should_say_Fizz_for_multiples_of_3() {
		assertEquals("Fizz",fizzBuzz.say(3));
		assertEquals("Fizz",fizzBuzz.say(6));
	}

	@Test
	public void fizzBuzz_should_say_Buzz_for_multiples_of_5() {
		assertEquals("Buzz",fizzBuzz.say(5));
		assertEquals("Buzz",fizzBuzz.say(10));
	}
	
	@Test
	public void fizzBuzz_should_say_FizzBuzz_for_multiples_of_15() {
		assertEquals("FizzBuzz",fizzBuzz.say(15));
		assertEquals("FizzBuzz",fizzBuzz.say(30));
	}

}

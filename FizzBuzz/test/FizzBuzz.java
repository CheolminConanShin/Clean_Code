public class FizzBuzz {

	public String say(int number) {
		if ( number % 15 == 0 ) 
			return "Fizz" + "Buzz";
		if (number % 5 == 0)
			return "Buzz";
		if (number % 3 == 0)
			return "Fizz";
		return String.valueOf(number);
	}

}

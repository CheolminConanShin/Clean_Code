import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactor {

	public List<Integer> of(int number) {
		List<Integer> result = new ArrayList<Integer>();

		for (int divisor = 2; number != 1; divisor++) {
			while (number % divisor == 0) {
				result.add(divisor);
				number /= divisor;
			}
		}

		return result;
	}

}

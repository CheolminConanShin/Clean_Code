import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;


public class PrimeFactorTest {
	PrimeFactor primeFactor = new PrimeFactor();

	@Test
	public void primeFactorsForPrimeNumbers() {
		assertEquals(Arrays.asList(2),primeFactor.of(2));
		assertEquals(Arrays.asList(3),primeFactor.of(3));
	}
	
	@Test
	public void primeFactorsForCompositeNumbers() {
		assertEquals(Arrays.asList(2,2),primeFactor.of(4));
		assertEquals(Arrays.asList(2,3),primeFactor.of(6));
		assertEquals(Arrays.asList(2,2,2),primeFactor.of(8));
		assertEquals(Arrays.asList(3,3),primeFactor.of(9));
	}
	
	@Test
	public void primeFactorsForBigNumber() {
		assertEquals(Arrays.asList(2,2,3,3,7,7,11,13),primeFactor.of(2*2*3*3*7*7*11*13));
	}
}

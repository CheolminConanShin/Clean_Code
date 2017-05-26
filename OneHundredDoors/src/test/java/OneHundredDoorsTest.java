import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


public class OneHundredDoorsTest {

	@Test
	public void oneDoorAndZeroPass() {
		OneHundredDoors oneHundredDoors = new OneHundredDoors(1);
		
		assertArrayEquals(new boolean[]{false},oneHundredDoors.getDoorState());
	}

	@Test
	public void oneDoorAndOnePass() {
		OneHundredDoors oneHundredDoors = new OneHundredDoors(1);
		
		oneHundredDoors.pass();
		
		assertArrayEquals(new boolean[]{true},oneHundredDoors.getDoorState());
	}
	
	@Test
	public void twoDoorAndOnePass() {
		OneHundredDoors oneHundredDoors = new OneHundredDoors(2);
		
		oneHundredDoors.pass();
		
		assertArrayEquals(new boolean[]{true,true},oneHundredDoors.getDoorState());
	}
	
	@Test
	public void twoDoorAndTwoPass() {
		OneHundredDoors oneHundredDoors = new OneHundredDoors(2);
		
		oneHundredDoors.pass();
		oneHundredDoors.pass();
		
		assertArrayEquals(new boolean[]{true,false},oneHundredDoors.getDoorState());
	}

	@Test
	public void threeDoorAndOnePass() {
		OneHundredDoors oneHundredDoors = new OneHundredDoors(3);
		
		oneHundredDoors.pass();
		
		assertArrayEquals(new boolean[]{true,true,true},oneHundredDoors.getDoorState());
	}
	
	@Test
	public void threeDoorAndTwoPass() {
		OneHundredDoors oneHundredDoors = new OneHundredDoors(3);
		
		oneHundredDoors.pass();
		oneHundredDoors.pass();
		
		assertArrayEquals(new boolean[]{true,false,true},oneHundredDoors.getDoorState());
	}	
	
	@Test
	public void threeDoorAndThreePass() {
		OneHundredDoors oneHundredDoors = new OneHundredDoors(3);
		
		oneHundredDoors.pass();
		oneHundredDoors.pass();
		oneHundredDoors.pass();
		
		assertArrayEquals(new boolean[]{true,false,false},oneHundredDoors.getDoorState());
	}
	
	@Test
	public void fourDoorAndOnePass() {
		OneHundredDoors oneHundredDoors = new OneHundredDoors(4);
		
		oneHundredDoors.pass();
		
		assertArrayEquals(new boolean[]{true,true,true,true},oneHundredDoors.getDoorState());
	}
	
	@Test
	public void fourDoorAndTwoPass() {
		OneHundredDoors oneHundredDoors = new OneHundredDoors(4);
		
		oneHundredDoors.pass();
		oneHundredDoors.pass();
		
		assertArrayEquals(new boolean[]{true,false,true,false},oneHundredDoors.getDoorState());
	}

	@Test
	public void fourDoorAndThreePass() {
		OneHundredDoors oneHundredDoors = new OneHundredDoors(4);
		
		oneHundredDoors.pass(3);
		
		assertArrayEquals(new boolean[]{true,false,false,false},oneHundredDoors.getDoorState());
	}
	
	@Test
	public void fourDoorAndFourPass() {
		OneHundredDoors oneHundredDoors = new OneHundredDoors(4);
		
		oneHundredDoors.pass(4);
		
		assertArrayEquals(new boolean[]{true,false,false,true},oneHundredDoors.getDoorState());
	}
}

public class OneHundredDoors {

	private boolean[] doorState;
	private int doorCount;
	private int pass = 0;

	public OneHundredDoors(int doorCount) {
		this.doorCount = doorCount;
		this.doorState = new boolean[doorCount];
	}

	public boolean[] getDoorState() {
		return doorState;
	}

	public void pass() {
		pass++;

		for (int doorIndex = pass - 1; doorIndex < doorCount; doorIndex += pass)
			doorState[doorIndex] = !doorState[doorIndex];
	}

	public void pass(int passCount) {
		for ( int i = 0; i < passCount ; i++ )
			pass();
	}

}

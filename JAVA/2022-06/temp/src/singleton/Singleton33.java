package singleton;

public class Singleton33 {

	public int[] buildingNumber;

	static {
		BUILDING_HIGH = 19582;
	}

	static final double BUILDING_HIGH;

	private static final Singleton33 MY_NAME_IS = new Singleton33();

	private Singleton33() {

		this.buildingNumber = new int[] {4, 3, 2, 1};
	} //Constructor

	static Singleton33 getInstance() {
		return MY_NAME_IS;
	}

}

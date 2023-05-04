package singleton;

public class Singleton3 {

	static final double BUILDING_HIGH;

	static {
		BUILDING_HIGH = 19582;
	}

	private static final Singleton3 MY_NAME_IS = new Singleton3();

	private Singleton3() {
		;;
	}

	static Singleton3 getInstance() {
		return MY_NAME_IS;
	}

}

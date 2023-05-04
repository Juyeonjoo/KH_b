package singleton;

public class Singleton1 {

	public int[] passwords;

	private static final Singleton1 MY_SELF_ADDRESS;

	static {
		System.out.println("Singleton1::static initializer invoked.");

		MY_SELF_ADDRESS = new Singleton1();
	} //static initializer

	private Singleton1() {
		System.out.println("Singleton1::Constructor invoked.");

		this.passwords = new int[] {1, 2, 3, 4, 5};
	} //Constructor

	public static Singleton1 getInstance() {
		System.out.println("Singleton1::getinstance() invoked.");

		return MY_SELF_ADDRESS;
	} //getInstance
} //end class

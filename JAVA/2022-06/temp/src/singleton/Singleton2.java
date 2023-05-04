package singleton;

public class Singleton2 {

	public int[] passwords;

	private static final Singleton2 MY_SELF_ADDRESS;

	static {
		System.out.println("Singleton::static initializer invoked.");

		MY_SELF_ADDRESS = new Singleton2();
	} //static initializer

	private Singleton2() {
		System.out.println("Singleton::constructor invoked.");

		passwords = new int[] {1, 2, 3, 4, 5};
	} //Constructor

	public static Singleton2 getInstance() {
		System.out.println("Singleton::getInstance() invoked.");

		return MY_SELF_ADDRESS;
	} //getInstance

} //end class

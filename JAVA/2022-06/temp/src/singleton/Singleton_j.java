package singleton;

import java.util.Arrays;

public class Singleton_j {

	private static final Singleton_j MINE;

	public int [] passwords;

	private Singleton_j() {
		System.out.println("Singleton_j::default constructor invoked.");
		this.passwords = new int [] {3,7,9,11,13};
	} //default constructor

	static {
		MINE = new Singleton_j();
	} // static initializer

	public static Singleton_j getInstance() {
		System.out.println("Singleton_j::getInstance() invoked.");
		return MINE;

	}//getInstance

	public static void main(String[] args) {
		Singleton_j ref = Singleton_j.getInstance();
		System.out.println(Arrays.toString(ref.passwords));
	}
}//end class
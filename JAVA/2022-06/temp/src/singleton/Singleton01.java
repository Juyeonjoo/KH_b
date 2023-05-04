package singleton;

public class Singleton01 {

	private static final Singleton01 B_T_S = new Singleton01();

	String RM;

	private Singleton01() {
		System.out.println("Singleton01::default constructor invoked.");
		this.RM = "Singer";
	}	// default constructor

	static Singleton01 getInstance() {
		System.out.println("Singleton01::getInstance() invoked.");
		return B_T_S;
	}	// getInstance

	public static void main(String[] args) {
		Singleton01 result = Singleton01.getInstance();
		System.out.println(result.RM);
	}

}	// class

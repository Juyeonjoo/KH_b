package singleton;


public class Singleton {

	private static Singleton SINGLETON;

	String game;

	static {
		SINGLETON = new Singleton();
	}	// static

	private Singleton() {
		System.out.println("Singleton::default constructor invoked.");
		this.game = "lol";
	}	// default constructor

	static Singleton getInstance() {
		System.out.println("Singleton::getInstance() invoked.");
		return SINGLETON;
	}	// getInstance

	public static void main(String[] args) {
		Singleton lisk = Singleton.getInstance();
		System.out.println(lisk.game);

	}

}	// class

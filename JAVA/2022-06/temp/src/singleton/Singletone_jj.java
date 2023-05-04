package singleton;

public class Singletone_jj {

	private static final Singletone_jj MINE;

	Singletone_jj(){
		System.out.println("Singletone_jj::default constructor invoked.");
	} // default constructor

	static {
		MINE = new Singletone_jj();
	} //static initializer

	public static Singletone_jj getInstance() {
		System.out.println("Singletone_jj::getInstance() invoked.");
		return MINE;
	} //getInstance

	public static void main(String[] args) {
		System.out.println(Singletone_jj.getInstance());
	}

} //end class

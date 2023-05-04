package singleton;


public class Singleton_LastName {
	
	private static final Singleton_LastName LAST_NAME;
	
	String lastName;

	
	static {
		System.out.println("Singleton_LastName::static constructor invoked.");
		LAST_NAME = new Singleton_LastName();
		
	} // 정적 생성자
	
	private Singleton_LastName() {
		System.out.println("Singleton_LastName::default constructor invoked.");
		lastName = "감";
	} // 기본 생성자

	static Singleton_LastName getInstance() {
		System.out.println("Singleton_LastName::getInstance() invoked.");
		return LAST_NAME;
	} // getInstance
	
	public static void main(String[] args) {
		Singleton_LastName value = Singleton_LastName.getInstance();
		System.out.println(value.lastName);		
	}
	
} // end class
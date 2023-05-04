package singleton;


public class Singleton_Country {
	
	private static final Singleton_Country COUNTRY;
	
	String country;

	
	static {
		System.out.println("Singleton_Country::static constructor invoked.");
		COUNTRY = new Singleton_Country();
		
	} // 정적 생성자
	
	private Singleton_Country() {
		System.out.println("Singleton_Country::default constructor invoked.");
		country = "대한민국";
	} // 기본 생성자

	static Singleton_Country getInstance() {
		System.out.println("Singleton_Country::getInstance() invoked.");
		return COUNTRY;
	} // getInstance
	
	public static void main(String[] args) {
		Singleton_Country value = Singleton_Country.getInstance();
		System.out.println(value.country);		
	}
	
} // end class
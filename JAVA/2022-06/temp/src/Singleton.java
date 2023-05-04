
public class Singleton {

	private static final Singleton MY_SELF_ADDRESS;

//	========================
	
//	모든 외부객체에 공유할 데이터 저장 
//	========================
	
	public int[] passwords;
	
	private Singleton() {
		System.out.println("Singleton::default constructor invoked.");
		
		this.passwords = new int[] {1,2,3,4,5};
	} //  default constructor
	
	static {//jvm에서 단 한번만 실행되도록 보장하는 블록
		
		MY_SELF_ADDRESS = new Singleton();
		
	}// static initializer 
	
	public static Singleton getInstance() {
		System.out.println("Singleton::getInstance() invoked.");
		return MY_SELF_ADDRESS;
		
	}//getInstance
	
}//end class

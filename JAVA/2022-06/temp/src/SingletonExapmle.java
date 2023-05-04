import java.util.Arrays;

public class SingletonExapmle {

	
	public static void main(String[] args) {
		
		/*
		 * Singleton obj1 = new Singleton(); //컴파일에러
		 * Singleton obj2 = new Singleton(); //컴파일에러
		 */
		
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		
		System.out.println(">>> 1. obj1" + obj1);
		System.out.println(">>> 2. obj2" + obj2);
		
	for(int i = 0; i < 100; i++) {
		
		Singleton ref = Singleton.getInstance();
		System.out.println(Arrays.toString(ref.passwords));
	}
	}//main
}//end class

/*
Singleton::default constructor invoked.
Singleton::getInstance() invoked.
Singleton::getInstance() invoked.
>>> 1. obj1Singleton@24d46ca6
>>> 2. obj2Singleton@24d46ca6
같은 Singleton 객체입니다.
*/
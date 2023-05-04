
public class Calculator2 {

	public static void main(String[] args) {
		

		plus(100,200);
	}
	

	
//	이 클래스 안에 있는 모든 멤버(필드, 메소드)는 모두 "정적(static) 이다."
//	즉, 모든 멤버가 정적멤버이다.
	
	static double pi = 3.14159;			//원주율 파이값을 가진 정적필드
	
	
	static int plus(int x, int y) {		//덧셈연산을 수행하는 정적 메소드

			
	System.out.println("TEST");
	System.out.println("******************" + System.out + "******************");
			
	return x+y;
	}//plus

	static int minus(int x, int y) {	//뺄셈연산을 수행하는 정적 메소드
		Calculator2.plus(100,200); 	//plus(100,200); 로도 가능하나.
		System.out.println(Calculator2.plus(100, 200));
		System.out.println(plus(100, 200));
		return x-y;
	} //minus
	

}//end class

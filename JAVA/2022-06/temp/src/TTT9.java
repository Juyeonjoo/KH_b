
public class TTT9 {

	String instanceField;
	static int staticField;

	public void instanceMethod() {
		System.out.println(instanceField);	//oo
		System.out.println(TTT9.staticField);    //oo  staticField 도 가능하나 static이니 클래스명.해주는 것이 더 올바름

		instanceMethod();					//oo	
		TTT9.staticMethod();						//oo
		
	} //instanceMethod
//	===================================
//	결론2
//	===================================
//* 1. 인스턴스 메소드에서는 모든 멤버(정적, 인스턴스) 사용 가능	

	public static void staticMethod() {
		;;
	}//staticMethod
	
	
	public static void main(String[] args) {
	
		System.out.println(instanceField);	//xx
		System.out.println(TTT9.staticField);    //oo  staticField 도 가능하나 static이니 클래스명.해주는 것이 더 올바름

		instanceMethod();					//xx	
		TTT9.staticMethod();						//oo
		
//		===================================
//		결론1
//		===================================		
/*		1. 정적 메소드에서는 오로지 정적필드와 메소드만 사용 가능.
 * 		2. 정적 메소드에서는 인스턴스 필드와 메소드는 사용 불가.
//		===================================

 * 
 * 
 */
	}
}

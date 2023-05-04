
public class Korean1 {

	String name;
	int age;


	//정적필드 선언	
	static String 국적 = "대한민국";		
	//국적은 다 똑같아서 공유되므로.
	
	// 정적메소드 선언
	static String 국적반환하기() {
//		return 국적;				//되긴하는데 사용하지 말 것
		
		return Korean1.국적;	
//			
	} // 국적반환하기
	
	//이 클래스에 공용으로 사용될만한 메소드인가?

	String 인스턴스메소드(){
		return 국적;
		
	}// 인스턴스메소드
	
}// end class

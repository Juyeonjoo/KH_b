
public class Television {

	//1. 필드 선언(가.고유속성, 2. 상태, 3. 부속필드
	static  String company = "Samsung";
	static  String model = "LCD";
	static  String info;
	
	//아래의 것이 바로 클래스의 4번째 멤버인
//	정적초기자(static initializer)라 불리는 것으로 선언된 필드 중 
//	정적 필드의 초기화를 담당
//	생성자(CONSTRUCTOR)은 인스턴스 필드의 초기화 담당
	static {
		System.out.println(">>>Televeision static initializer invoked.");// 1)
		Television.company = "Samsung";
		Television.model = "LCD";
		
		Television.company = "LG";
		Television.model = "OLED";
		
//		info = company + "-" + model;
		Television.info = Television.company + "-" + Television.model; //정적필드 답게 클래스명.필드
	} // static initializer
	
	//Samsung-LCD 에서 LG-OLED로 갑 바뀜.
 
	public Television() {
		
		System.out.println(">>>Televeision default constructor invoked.");
		
	} //default constructor
}// end class

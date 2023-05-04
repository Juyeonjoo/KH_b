package Nov14.pacakge1;


//같은 패키지내에 있는 외부 클래스에서는
//protected 멤버 사용 가능
public class B {

	public void method() {
		A_1 a = new A_1();				//protected 생성자 호출
		
		a.field = "value";			//protected 필드 사용
		a.method();					//protected 메소드 호출
	}//method
}//end class

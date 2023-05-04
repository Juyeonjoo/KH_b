package Nov16;

public class RemotControlExample {

	//Lvalue, Rvalue가 모두 동일한 구현클래스 타입의 구현객체 생성
	public static void main(String[] args) {
		
		SmartTelevision tv = new SmartTelevision();
		
//		다형성1: 부모타입(여기서는, "인터페이스")의 참조변수에 
//		모든 자식객체(여기서는 '구현객체' 가 대입가능하다.
		RemoteControl rc = tv;			//Lvalue(interface type) = Rvalue(구현 객체)
		Searchable searchable = tv;		//Lvalue(interface type) = Rvalue(구현 객체)
	}//main
}//end class

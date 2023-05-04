package Nov15;

public class PhoneExample {

	public static void main(String[] args) {
//		Phone phone = new Phone(); //xxx
		
		//자식객체를 생성할 때, 힙에는 먼저 부모객체부터 생성된다.
		//부모클래스의 생성자부터 호출된다.
		
		SmartPhone smartPhone = new SmartPhone("홍길동");
		
		smartPhone.turnOn();			//추상클래스에 선언된 메소드 호출
		smartPhone.internetSearch();	//실체클래스에 선언된 메소드 호출	
		smartPhone.turnOff();			//추상클래스에 선언된 메소드 호출
		
	}//main
}//end class

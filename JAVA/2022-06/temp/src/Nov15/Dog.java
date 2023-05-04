package Nov15;


public class Dog extends Animal{

//	abstract  2. 선택지 : 상속된 추상 메소드(강제규격)을 구현하기 싫으면,
//	 자식타입도 추상클래스로 만들어라.
	public Dog() {
		System.out.println("Dog::default constructor invoked.");
		this.kind = "포유류";
	}//default constructor
	
	
	@Override
	public void sound() {		//1. 선택지: 강제된 규격을 무조건 구현(재정의)해야 한다.
		System.out.println("Dog::sound() invoked.");
	}//sound()
	
}//end class

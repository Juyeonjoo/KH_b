package Nov15;

public class Cat extends Animal {

	public Cat() {
		
		System.out.println("Cat::default constructor invoked.");
		this.kind = "포유류";
	}//default constructor
	
	@Override
	public void sound() {	//상속받은 추상메소드(강제규격) 재정의(구현)
		System.out.println("Cat::sound() invoked.");
	}//sound()
}//end class

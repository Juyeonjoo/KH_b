package Nov10;

public class Animal {

	public void sound() {;;}	//소리를 내라 , 라는 의미의 메소드
	
	public static void main(String[] args) {
		Animal animal = new Person ();		//사람 객체 생성
		animal.sound();
		
		//-----------
		
		animal = new Dog();					//Dog 객체 생성
		animal.sound();
		
		//-----------
		animal = new Cat();					//Cat 객체 생성
		animal.sound();
	}
} // Animal

// ==================================================
class Person extends Animal { 
	
	@Override
	public void sound() {
		
		System.out.println("엉엉!!!!!ㅜㅜ");
		
	}//sound method

} //Person class


//==================================================

class Dog extends Animal{
	
	@Override
	public void sound() {
		
		System.out.println("멍멍!!!!!ㅜㅜ");
		
	}//sound method

	
} //Dog class

//==================================================

class Cat extends Animal {
	
	@Override
	public void sound() {
		
		System.out.println("야옹!!!!!ㅜㅜ");
		
	}//sound method

	
}//Cat class

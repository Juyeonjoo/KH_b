package Nov15;


public class AnimalExample {

	public static void main(String[] args) {
		Dog dog = new Dog();		//자식 객체 생성
		Cat cat = new Cat();		//자식 객체 생성
		
		dog.sound();				//상속받아 재정의된 메소드 호출
		cat.sound();				//상속받아 재정의된 메소드 호출
		
//		-----------
		//변수의 자동 타입 변환
		Animal animal = null;
		
		animal = new Dog();
		animal.sound();
		
		animal = new Cat();
		animal.sound();
		
		System.out.println("-----");
		
//		-----------
		
//		매개변수의 자동 타입 변환
		animalSound(new Dog());
		animalSound(new Cat());
	}//main

	public static void animalSound(Animal animal) { //다형성1
		animal.sound(); // 다형성2
	}
}


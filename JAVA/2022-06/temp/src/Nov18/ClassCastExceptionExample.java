package Nov18;


class Animal{;;}					//부모 클래스
class Dog extends Animal {;;}		//상속하는 자식 클래스 #1
class Cat extends Animal {;;}		//상속하는 자식 클래스 #2

public class ClassCastExceptionExample {

	//3번째 가장 많이 발생하는 실행 예외(runtime Exception) :"ClassCastException"
	public static void main(String[] args) {	//static method

//
//		Dog dog = new Dog();					//invoke static method
//		ClassCastExceptionExample.changeDog(dog);	//자식 객체 생성
//	
//		
		
		Cat cat = new Cat();					//invoke static method
		ClassCastExceptionExample.changeDog(cat);							//자식 객체 생성
		
		
	}//main
	
	public static void changeDog(/*다형성1*/Animal animal) {
			if(animal instanceof Cat cat ) {
			
		//다형성1에 의해, 부모품에 꽉 안겨있는 자식객체를 강제로 빼냄
//		Cat cat = (Cat) animal;				//Class Cast Exception발생
		System.out.println(cat);
		System.out.println(animal);
		}//if
	}//changeDog
		
}//end class

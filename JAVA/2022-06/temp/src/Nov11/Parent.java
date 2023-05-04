package Nov11;


public class Parent {	//상속관계에서 부모역할을 할 클래스, POJO

	//생성자
	public Parent(){
		System.out.println("Parent::default constructor invoked.");
	} //default constructor
	
	//메소드
	public void method1() {
		System.out.println("Parent::method1() invoked.");
	} //method(1)
	
	public void method2() {
		System.out.println("Parent::method2()invoked.");
	} //method(2)
	
} //end class

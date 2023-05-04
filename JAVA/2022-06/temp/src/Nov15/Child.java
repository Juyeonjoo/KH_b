package Nov15;

public class Child extends Parent {

	public String field2;		//자식만의 필드
	
	Child(){
		super();			//자동으로 compiler가 부모객체 생성자 호출
		System.out.println("Child::default constructor invoked.");
	}//default constructor
	
	public void method3() {		//자식만의 메소드
		
		System.out.println("Child::method3() invoked");
	} //method3
	
} //end class

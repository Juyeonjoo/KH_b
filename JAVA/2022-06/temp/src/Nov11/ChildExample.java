package Nov11;


public class ChildExample {

	//상속 관계인 두 클래스(Parent, Child)를 이용한 다형성 구현
	public static void main(String[] args) {
							
		Child child = new Child(); //1.자식객체 생성
			
		Parent parent= child;     //2. 다형성-1. 부모타입 참조변수에 자식객체 대입
	
		System.out.println(">>> parent: " + parent);
		parent.method1();		//	3. 다형성-2: 재정의된 메소드만 실행
		parent.method2();		//	3. 다형성-2: 재정의된 메소드만 실행
		
//		parent.method3(); //호출 불가능
		
	
	}//main
} // end class

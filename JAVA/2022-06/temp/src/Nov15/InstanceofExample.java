package Nov15;

public class InstanceofExample {

	/*지금 예제는 다형성1에 의해서 부모타입의 참조변수로부터
	 * 자식 객체를 강제로 끄집어 낼 때 이전 예제와 같이 '강제형변환'이 필요한데
	 * 이 때 먼저 해야 될 것은? 
	 * >부모타입의 참조변수에 정말 내가 알고 있는 자식 객체가 
	 * 들어가있는가? 이걸 개발자가 어떻게 알 수 있는지 
	 * 직접 부모타입의 참조변수로 출력해보지 않는한 어떻게 아는가.
	 * 프로그램적으로 부모타입의 참조변수에 어떤 자식타입의
	 * 객체가 실제 들어가있는지 (다형성1)을 알아야 한다.
	 * 
	 * 이를 위해 나온 연산자가 바로 "패턴매칭연산자"라고 불리는"instanceof"연산자 필요
	 * 
	 * (1) 어디에 사용? => 조건식에 사용
	 * (2) 연산자의 결과는 ? => boolean(true/false)
	 * (3) 용법: 왼쪽에는 <참조변수> instanceof <참조타입> 
	  	
	  정적메소드에서 다른 정적메소드를 사용하려면 static이어야 함
	  >main method를 쓰기 위해서
	 */
	public static void main(String[] args) {
	
		Parent1 parentA = new Child1();		// 다형성1 
		System.out.println("=========parentA");
		InstanceofExample.method1(parentA);	// 정적메소드 호출
		InstanceofExample.method2(parentA);	// 정적메소드 
		
		Parent1 parentB = new Parent1();		//다형성1 아님.
		System.out.println("=========parentB");
		InstanceofExample.method1(parentB);
		InstanceofExample.method2(parentB);		//예외 발생	
		
	}//main
	
	//정적메소드: 왜? 대전제: 정적 멤버는 오르지 정적 멤버만 사용 가능하다
//	main 에서 사용하기 위해서?
	public static void method1(Parent1 parent) {
//		instanceof 연산자를 통해서 부모타입의 참조변수에 어떤 타입의 자식객체가
//		대입되어 있는지를 판별 -> 필요한게, 패턴매칭연산자 "instanceof
		
//		parent 란 객체 안에 Child1  타입이 들어가 있는 것.
//			참조타입변수  패턴매칭      판별할 참조타입명
//			----------		----				------		
		if (parent instanceof Child1) {		//Child 타입의 자식 객체가 들어있다면
			Child1 child = (Child1) parent;	//강제형변환을 통해 강제로 자식객체 끄집어냄
			System.out.println("method1 - Child 로 변환 성공");	//안전한 강제형변환
 		} else {
 			System.out.println("method1 - Child 로 변환되지 않음.");
 		}
//		
		//상속관계도 아니니까
//		Child1 child = (Child1) parent;
	}//method1
	
	
	public static void method2(Parent1 parent) {
		Child1 child = (Child1) parent;
		System.out.println("method2 - Child로 변환 성공");
	} //method2
}//end class


public class Car1Example {

	//라이브러리 클래스르르 이용해서 객체를 생성해 필드의 값을 '조작'해보자
	public static void main(String[] args) {
		Car1 car1 = new Car1(); //기본생성자를 이용한 객체 초기화
		
//		System.out.println("car1: " + car1); // 참조변수 그대로 찍어보기
//		System.out.println("car1.company : " + car1.company); // 참조변수car1를 따라가면 company 필드를 출력.
//		System.out.println();
		

		
	} //main
} // end class


//=====
/*
 * 
 *  * 		//Step.1 new 연산자와 생성자를 이용한 객체 생성
		Car myCar = new Car(); //생성자나 메소드 선언시, 소괄호 블록은 "호출"할 수 있기 해준다.
		System.out.println("myCar : " + myCar); //myCar : Car@24d46ca6
		
		/* 대전제: 어떻게 클래스의 구성멤버 중 필드와 메소드를 사용할 수 있을까?
		 * 			바로 "객체멤버참조연산자"라 불리는 "dot(.)연산자"를 사용해서
		 			객체의 멤버( 필드, 메소드)를 사용할 수 있다.
		 			예: car.필드명, car.필드명 = 새로운값, car.메소드명
		 */
		
		//Step.2 생성된 객체의 필드에 저장된 값을 출력(필드의 값 read)
		//> 필드의 사용
//		System.out.println("제작회사: " + myCar.company);
//		System.out.println("모델명: " + myCar.model);
//		System.out.println("색깔: " + myCar.color);
//		System.out.println("최고속도: " + myCar.maxSpeed);
//		System.out.println("현재속도: " + myCar.speed); // int의 기본값 : 0 (초기화안해놓았기 때문에)
//		
//		//Step.3 생성된 객체의 필드의 값을 얼마든지 변경해보자 
//		myCar.speed = 60;
//		System.out.println("수정된 속도 : " + myCar.speed);

//
////===========
//
////매개변수가 1개인 생성자를 이용한 객체의 필드 촉화
//Car car2 = new Car("자가용");
////			this("자가용");
//
//
//System.out.println("car2: " + car2); 
//System.out.println("car2.company : " + car2.company);
//System.out.println("car2.comodel : " +car2.model);
//System.out.println();
//
////===========
//
//Car car3 = new Car("자가용", "빨강");	
////			this("자가용", "빨강");
//
//System.out.println("car3: " + car3);
//System.out.println("car3.company : " + car3.company);
//System.out.println("car3.model :  " + car3.model);
//System.out.println("car3.color : " + car3.color);
//System.out.println();
//
////===========
//Car car4 = new Car("택시", "검정", 200);
//
//System.out.println("car4 : " + car4);
//System.out.println("car4.company : " + car4.company);
//System.out.println("car4.model :  " + car4.model);
//System.out.println("car4.color : " + car4.color);
//System.out.println("car4.maxSpeed : " + car4.maxSpeed);
//System.out.println();
//
////===========

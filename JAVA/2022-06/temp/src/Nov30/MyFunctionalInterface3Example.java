package Nov30;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyFunctionalInterface3Example {

	
	//추상메소드 : 매개변수 o 리턴타입 o 함수적인터페이스를 어떻게 람다식으로 구현하는가?
	public static void main(String[] args) {
		
		//핵심: 매개변수도 있고 리턴타입도 있는 추상메소드의 람다식 구현
		//public abstract int method(int x, int y);
		
//		**********************************
//		생략조건1: 매개변수 선언부의 각 매개변수의 타입은 생략가능
//		생략조건2: 매개변수 선언부의 매개변수 개수가 단 1개뿐이면 소괄호도 생략 가능.
//		생략조건3: 중괄호 블록({}) 안에 실행문장 개수가 단 1개뿐이면, 중괄호기호도 생략
//		생략조건4: 실행문장이 값을 리턴하는 return 문장일 때는 "return" 키워드는 무조건 생략해야 한다.
//		**********************************
//		화살표 기호 오른쪽에 남아 있는 식이 표현식(값을 생성하는 식)이라면
//		그 앞에 return 키워드가 생략된 것 
//		표현식: (1) 리터럴 (2) 변수 (3) 연산식
		
		MyFunctionalInterface3 fi;
		
		fi = (x, y) -> 		//람다식 , 매개변수 2개 () 생략 불가능
//			int result = x + y;		//덧셈수행
//			
//			return result;			//리턴타입대로 값 반환
			 x + y; 				//ok ,연산식
		
			fi = (x,y) -> 1;
			
			int returnValue = 100;
			fi =(x,y) -> returnValue;
			
			//익명구현객체	
		
		log.info(fi.method(2,5));
		
//		===============================

		fi = (x, y) -> { return x + y; };
		log.info(fi.method(2,5));
//		===============================
		fi = (x, y) -> x + y;
		log.info(fi.method(2,5));
		
		//리턴문장이 생략되어있는 람다식은 메소드 참조로 만들 수 없다.
		//메소드 호출문장으 아니고, 연산식이고, return문장이 생략되어있다.
		//return 문장은 메소드 참조 xx 
//		===============================
		fi = (x, y) -> sum(x, y);			//정적메소드 호출(메인메소드가 정적메소드이니까)
		//값을 생성하는 것은 같지만, 메소드가 돌려주는 값을 표현식 범주에 넣지는 않는다.			
		//왜냐하면 만약 배열을 반환하면? double , 람다식은 int 반환하기로 되어있음
		

		log.info(fi.method(2,5));
//		===============================
		
	}//main
	
	public static int sum(int x, int y) {
		return(x+y);
	}//sum
} //end class

//fi = (x, y) -> log.info("x: {}, y : {}", x, y); //값 생성xxx
//{return 0;
////오류난 이유는 return 문장이 빠져있어서 .


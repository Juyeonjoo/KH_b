package Nov30;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyMethodReferencesExample {

	public static void main(String[] args) {
		
		MyFunctionalInterface2 fi;
		
		//추상메소드: 매개변수 o 리턴타입 x
		//public abstract void method(int x); 
		
//		**********************************
//		생략조건1: 매개변수 선언부의 각 매개변수의 타입은 생략가능
//		생략조건2: 매개변수 선언부의 매개변수 개수가 단 1개뿐이면 소괄호도 생략 가능.
//		생략조건3: 중괄호 블록({}) 안에 실행문장 개수가 단 1개뿐이면, 중괄호 기혿 ㅗ ㅣㄹ
//		**********************************
		
//		fi = (int x) -> {	//함수적 인터페이스에 선언된 추상메소드의 구현블록
//		fi = (x) -> {	//생략조건1, 넘겨준 인자값으로부터 타입 추론 가능
		fi = x -> {		//생략조건1 + 생략조건2
			int result = x * 5;
			log.info("result : {}", result);
		};//람다식 : 익명구현객체 생성
	
		fi.method(2);		//다형성2
		
//		==========================================
		//람다 생략문법
		//모든 매개변수의 타입은 생략 가능하다.
		
		fi = x ->{log.info("x*5 : {} ", x*5);};
		fi.method(2);
		
//		==========================================
		fi = x ->log.info(x*5);	//생략조건3
	
		fi.method(2);
		
		//메소드 참조에 대해서 점진적으로 알아보자.
		//1. 메소드 참조란, 말 그대로 메소드를 참조(=사용)하겠다라는 의미
		//이 메소드 참조는 람다식과는 다른 것이 있지만 람다식의 목표와는 동일하다.
		// => 간결한 코드
		
		//2. 메소든 참조는 어떻게 만드는가?
		// (1) 람다식에서
		// (2) 매개변수가 1개이든, 2개이든
		// (3) 람다식의 실행문장이 '하나'일 때
		// (4) 실행문장에 매개변수가 그대로 전달만되어서 사용될 때 
//			(매개변수의 가공이 전혀 없을 때)
//			=> 이때 람다식을 "메소드참조"로 바꿀 수 있다.
		// (5) 메소드 참조의 문법: <<참조변수 :: 메소드 이름>>
//			=> 메소드 참조는 람다식을 통째로 바꾸는 것
//			=> 메소드 참조 ! = 람다식
		
		//핵심은 매개변수를 어떻게 사용하는가.
		
		fi = x -> log.info(x); //람다식, log 필드, info 메소드
		fi = log::info; //메소드 참조, 람다식을 메소드참조로 바꾸기
		//메소드 참조는 매개변수가 없다.
		
		fi = x -> System.out.println(x);	//람다식
		fi = System.out::println;			//메소드 참조
		
//		========================================
		
		List<Integer> list = Arrays.<Integer>asList(1,2,3); //오토박싱 , 기본값을 Integer객체로 만들어줌
		
		//forEach 메소드의 매개변수가 바로 함수적 인터페이스이고,
		//그 안에 선언된 추상메소드 단 1개 :  void accept(T t);

		
//  1st. Method : 익명구현객체코딩기법
		Consumer<Integer> consumer = new Consumer<>() {

			@Override
			public void accept(Integer t) {
				log.trace("accept({}) invoked", t);
			} //accept
			
		}; //익명구현객체
//		list.forEach(consumer);
		//11:26:38.733 TRACE --- [      main] N.MyMethodReferencesExample.accept:0084: accept(1)
//		11:26:38.734 TRACE --- [      main] N.MyMethodReferencesExample.accept:0084: accept(2)
//		11:26:38.734 TRACE --- [      main] N.MyMethodReferencesExample.accept:0084: accept(3)
		//2nd. method: 람다식 
		// void accept(T t);
		Consumer<Integer> consumer2 =(Integer t) -> {
			log.trace("lamda({}) invoked.", t );
		}; //람다식 익명구현객체 생성
//		============================
		list.forEach(consumer2);
//		11:31:40.402 TRACE --- [      main] N.MyMethodReferencesExample.lambda$7:0095: lamda(1) invoked.
//		11:31:40.402 TRACE --- [      main] N.MyMethodReferencesExample.lambda$7:0095: lamda(2) invoked.
//		11:31:40.403 TRACE --- [      main] N.MyMethodReferencesExample.lambda$7:0095: lamda(3) invoked.
	
		//3rd. method : 메소드 참조(Method Reference)
		//조건: 람다식 전체, 실행문이 오직1개 매개변수가 몇개이든 그냥 실행문장의 메소드에 그대로 전달되어 사용될 때
		//매개변수만 사용해서 메소드를 만든다는 것. fi = x -> System.out.println(x);
		
		Consumer<Integer> consumer3 = log::trace;
		//log.trace(t); 이 의미, 위에 lamda({}) invoked.는 안됨.
		//매개변수를 받아서 가공한것은 안된다.
		list.forEach(consumer3);
//		11:38:32.819 TRACE --- [      main] N.MyMethodReferencesExample.forEach:4204: 1
//		11:38:32.820 TRACE --- [      main] N.MyMethodReferencesExample.forEach:4204: 2
//		11:38:32.820 TRACE --- [      main] N.MyMethodReferencesExample.forEach:4204: 3
	}//main
	//		fi.method(5);
} //end class

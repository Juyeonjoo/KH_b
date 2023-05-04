package Nov23;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoxExample extends Object {
//제네릭 타입의 클래스를 "사용" 할 때, 정말 제네릭 이전의 각종 형변환이
	//사라졌는지 확인해보기 > 이것이 제네릭의 목적
	
		public static void main(String[] args) {
//			GenericBox<String> box1 = new GenericBox<String>();	//@till java7
			
			//새로운 연산자라, 제네렉 위해 출현 
			//<> 연산자 (타입추론연산자) < - 내부적으론 여전히 <> 에도 값이 필요하다
			GenericBox<String> box1 = new GenericBox<>();			//@since java8
			log.info("1. box1: {}", box1); // GenericBox(t=null) :필드 이름 = 값, set 호출하기 전
			
			box1.setT("hello");
			log.info("set(hello) 1. box1: {}", box1); 
		String str = box1.getT();
//	===================
		
	GenericBox<Integer> box2 = new GenericBox<Integer>();
	log.info("2. box2: {}", box2);
	box2.setT(6);
	int value = box2.getT();
		
		} //main
}	//end class 

/*
//Generic 사용하기 전에는 코드가 많은 형변환(Promotion, Casting)을 발생시킨다.

public static void main(String[] args) {
	
	Box box = new Box();				//1. 상자 생성
	box.setObject("홍길동");					//2. 상자에 "문자열 객체" 넣기 

	log.info("1. box: {}", box);
	String name = (String)box.getObject();	//3. 상자에서 "문자열객체" 꺼내기
	
//	====================
	
	box.setObject(new Apple());				//4. 상자에 새로이 "사과객체" 넣기
	log.info("2. box: {}", box);
	Apple apple = (Apple) box.getObject();	//5. 상자에서 "사과객체" 꺼내기
} //main
*/

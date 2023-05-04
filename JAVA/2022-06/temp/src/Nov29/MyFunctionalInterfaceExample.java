package Nov29;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyFunctionalInterfaceExample {

	//타겟타입인 함수적 인터페이스를 람다식을 이용해서,
//	단 하나뿐인 추상메소드를 재정의한 익명구현객체를 생성(람다식의 최종목표)하는 예제
	
	public static void main(String[] args) {

		//1st.Method - 인터페이스마다 직접 구현클래스를 선언하고 객체도 직접 생성한다.
//		---Lvalue(Initerface)부모---	---Rvalue(Implementation Class)자식---
//		MyFunctionalInterface fi = new MyFunctionalInterfaceImpl(); //다형성1
		//자식클래스로부터 자식 객체 만들어내서 부모타입 참조변수에 넣어준다. 다형성1

//		fi.method();			//다형성2
		//N.MyFunctionalInterfaceImpl.method:0015: method() invoked.
		
		//2nd. Method - 익명구현객체코딩기법을 이용한, "익명구현객체생성"
//		MyFunctionalInterface fi = new MyFunctionalInterface() {//인터페이스는 생성자가없지만, 마치 있는듯이.

			//여기는 클래스 블록. 필드, 메소드 사용 가능.
			//but 생성자는 불가능, 왜냐? 우린 이름을 모르잖아.
			
//			@Override
//			public void method() {
//			log.trace("methd() invoked.");
//			}//method()
//		}; //다형성1 : 익명구현객체 생성
//		
//		fi.method();	//다형성2
//		log.info(fi);
		
		//3rd. Method 람다식을 이용한 익명구현객체 생성
//		Step1. Target Type인 Functional Interface에 선언되어있는
//		 	오직 단 한개의 추상메소드 시그니처를 그대로 복사
		
//		public abstract void method(); <- () 소괄호가 매개변수 선언부
		
//		Step2.Step.1 에서 복사해온 추상 메소드에서 오직 '매개변수 선언부'만 떼어오라
//		(); <- 추상메소드의 매개변수 선언부만 떼어온 것
		
//		Step3. Step2. 에서 떼어온 매개변수 선언부를 Target Type의 참조변수에 대입
//		MyFunctionalInterface fi = ();
		
//		Step4. Step3. 에서 Rvalue의 매개변수 선언부 뒤에 "->" 기호를 넣어달라.
//		MyFunctionalInterface fi = ()->;
		
//		Step5. Step4.에서 "->" 기호 오른쪽에 중괄호 블록을 생성하라{}
//		MyFunctionalInterface fi = ()-> {};
		
//		Step6. Step5. 가 정말 추상 Target Type의 추상메소드를 재정의하는게 맞는지
//		검증하는 단계
		MyFunctionalInterface fi = ()-> {
			log.info("*************");
//			log.info("\t+ this: {}", this);	//Cannot use this in a static context
		};
		
		fi.method(); // 다형성 1에 의해서 다형성2에 재정의된 함수 호출
		log.info("람다: \t+ fi: {}", fi);
		
		//N.MyFunctionalInterfaceExample.lambda$0:0057: *************
		//자바 컴파일러가 만든 우리가 이름을 알 수 없는.
		//클래쯔객체를 얻으면 정확히 알 수 있다.
		
		log.info("Real Type: {}", fi.getClass().getName());
		//Real Type: Nov29.MyFunctionalInterfaceExample$$Lambda$99/0x0000000800d45478
	
	
		MyFunctionalInterface fi2 = new MyFunctionalInterface(){

			@Override
			public void method() {
				log.trace("method() invoked");
				log.info("\t+ this: {}", this);
				
			}//method
			
			}; //익명 구현객체 다형성1
		
			fi2.method(); //다형성2
			log.info("\t+ fi2: {}", fi2);
			
			MyFunctionalInterfaceExample obj = new  MyFunctionalInterfaceExample();
			
					obj.instanceMethod();
					
				log.info("\t + 1. obj: {}", obj);
				//1. obj: Nov29.MyFunctionalInterfaceExample@2df9b86

	}//main 
	
	public void instanceMethod() {
		log.trace("instanceMethod() invoked.");
		MyFunctionalInterface fi = ()-> {
			log.info("*************");
			log.info("2. 람다 this: \t+ this: {}", this);
			//2. 람다 this: 	+ this: Nov29.MyFunctionalInterfaceExample@2df9b86
		};
		
		fi.method();
		log.info("3. 람다 fi: \t+ fi: {}", fi);
		//3. 람다 fi: 	+ fi: Nov29.MyFunctionalInterfaceExample$$Lambda$105/0x0000000800d48d90@37654521
	}//instanceMethod
}//end class


/*
		
//		[람다식 만들기]
//		구현객체 만든 후, fi에 집어넣을 것.
		
//		Step1. 람다식으로 구현할 타겟타입인 함수적 인터페이스에 선언된
//				아래와 같이 단 하나의 추상 메소드 시그니쳐를 그대로 복사해 오기
//		public abstract void method(); <- 이것을 람다로 구현하겠다.

//		Step2. Step1에서 복사해온 추상메소드에서 오로지 매개변수 선언부만
//		떼어와서, Rvalue를 구성한다.

//2. 참조변수 초기화 by 람다식
//그래서 람다식의 Target Type은 우리가 만든 MyFunctionalInterface이고
//Overriding 대상 메소드는 public abstract void method() 입니다.
//이 메소드의 구현 메소드 만든다.

//public abstract void method() 이걸 구현하는 것이 람다
//다형성1 
fi = () ->{
	String str = "method call1";
	log.info("1. str: {}", str);
}; //람다식으로 만든 '익명구현객체'

fi.method(); //다형성2 //람다식에서 만든 FQCN

Class clazz = fi.getClass();
log.info("2. FQCN: {} ", clazz.getName());


//========= 익명구현객체 
//fi = new MyFunctionalInterface() {
//
//	@Override
//	public void method() {
//		log.trace("method() invoked.");
//	} //method()
//	
//}; //익명 구현객체 생성
//
//fi.method(); //익명구현객체에서 만든 FQCN
//
//clazz = fi.getClass();
//log.info("3. FQCN: {} ", clazz.getName());

//====================================

fi = () -> {log.info("method call2");};		//다형성1

fi.method();
//====================================

fi = () -> log.info("method call3");		//다형성1
fi.method();		//다형성2
*/
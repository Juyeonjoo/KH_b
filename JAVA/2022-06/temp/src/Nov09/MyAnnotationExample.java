package Nov09;

import java.lang.reflect.Method;

public class MyAnnotationExample {

	//자바 리플렉션 API(Java Reflection API)을 이용하여
//	어노테이션의 메타데이터를 이용하여 실행시 특수한 기능을 구현해보자
	
	public static void main(String[] args) {
	
		//=============================================
		//Step.1 Service 클래스의 "Clazz" 객체로부터,
		//		클래스 안에 선언된 모든 메소드 정보를 배열로 얻음
		//=============================================
		
		Class clazz = Service.class;
		Method[] declaredMethods = clazz.getDeclaredMethods();
		
		//=============================================
		//Step.2 배열을 순회하면서, Service 클래스에 선언된 
		//		각 Method에 MyAnnotation이 적용되어 있는지 확인
		//		(참고: 배열 순회를 위해 Enhanced for문 이용)
		//=============================================
		
		for(Method method : declaredMethods) {
			
			//=============================================
			//Step.3 MyAnnotation이 현재 메소드에 적용되어 있는지 확인
			//=============================================			
			
			if(method.isAnnotationPresent(MyAnnotation.class)) {
				
				//=============================================
				//Step.4 현재 메소드에 MyAnnotation 이 적용되어 있다면,
				//		해당 어노테이션을 얻어오기
				//=============================================
				MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
				//=============================================
				//Step.5 현재 메소드의 이름을 콘솔에 출력
				//=============================================
				System.out.println("[" + method.getName()+ "]");
			
			//=============================================
			//Step.6 현재 메소드에 적용된 MyAnnotation의 속성으로
			//		제공되는 메타데이터를 이용하여, 메소드 호출로그
			//		를 자동으로 만들어 출력하자!!
			//		(이것이 바로 MyAnnotation의 메타데이터 이용목적임)
			//=============================================
			
			//-----------------------
			//Step. 6-1 구분선 출력
			//-----------------------
			
			for(int i =0; i < myAnnotation.number(); i++) {
				System.out.print(myAnnotation.value());
			} //for
			
			System.out.println();	//하나의 빈행 출력
			
			//-----------------------
			//Step. 6-2 현재 순회하는 메소드를 직접 호출
			//-----------------------			
			try { 				
				method.invoke(new Service());
			} catch(Exception e) {;;}
			System.out.println();
			}	//if
		}// enhanced for
	}	//main
} // end class

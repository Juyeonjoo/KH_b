package Nov09;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//새로이 선언한 어노테이션을 자바타입의 어느 부분에 적용(즉, 붙일 수 있는지 결정)
@Target({
	ElementType.METHOD, 					//클래스의 메소드에 적용
	ElementType.CONSTRUCTOR,				//클래스의 생성자에 적용
	ElementType.FIELD,						//클래스의 필드에 적용
	ElementType.PARAMETER,					//클래스의 메소드 매개변수에 적용	
	ElementType.LOCAL_VARIABLE,				//클래스의 지역변수에 적용
	ElementType.ANNOTATION_TYPE,			//어노테이션 타입 선언부에 적용
	ElementType.TYPE,						//참조타입 선언부에 적용
	ElementType.PACKAGE,					
	
}) //우리의 어노테이션 타입의 어디에 적용(붙일 수 )할 수 있을지를 결정

//자바표준어노테이션, 적용된 어노테이션 정보가 언제까지 유지될 것인가를 결정.
//(1) RetentionPolicy.SOURCE
//	- 어노테이션이 적용된 자바소스파일에는 유지되지만,
//	- 자바 컴파일이 종료되고, *.class 파일이 생성되면,
// 	- 이 .class 파일 안에는 어노테이션 정보가 모두 사라짐

//	(2) RetentionPolicy.CLASS
//	- 컴파일이 끝나고 난 후 생성되는, 바이트코드가 들어있는 *.class 파일 안에도
//	- 그대로 어노테이션 적용 정보가 남아있게 하겠다라는 의미
//	-(***중요***) *.class 파일 안에는 어노테이션 정보가 있긴하지만, 
//	- 한마디로 "사용불가"


//	(3) RetentionPolicy.RUNTIME
//- 컴파일이 끝나고 난 후 생성되는, 바이트코드가 들어있는 *.class 파일 안에도
//- 그대로 어노테이션 적용 정보가 남아있게 하겠다라는 의미
//-(***중요***) *.class 파일 안에는 어노테이션 정보가 있고, 
//	자바프로그램이 JVM에 의해 실행중일때에도 저굥된 어노테이션 정보를 그대로 사용가능하다
//	(CLASS와 다른 점, 따라서 CLASS는 잘 사용하지 않는다.)

@Retention(RetentionPolicy.RUNTIME)


//@MyAnnotation
@MyAnnotation public @interface MyAnnotation { //어노테이션 선언
	

	//이 어노테이션이 적용된 곳에 제공하는 "메타데이터"
 String value() default "-";		
 int number() default 15;

} // end @interface(annotation)

//Elementype java 패키지 밑에 있는 열거타입이 import된 것.

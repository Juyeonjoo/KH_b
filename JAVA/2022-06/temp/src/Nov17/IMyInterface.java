package Nov17;


//인터페이스 이름은 일반적으로,
//(1) 클래스명의 규칙을 따라가지만 (소스 파일명도 포함해서)
//(2) 하지만, 인터페이스의 이름은 통상 대문자 'I'를 붙인다.
//	 이름만 보고도 이 이름이 인터페이스의 이름인 것을 알려준다.)
public interface IMyInterface {
	//4개의 멤버가 올 수 있다.
	//(1) public static final 상수		- since JAVA 1
	//(2) public abstract 추상 메소드	- since JAVA 1	
	//(3) public default 기본 메소드	- since JAVA 8
	//(4) public static 정적 메소드		- since JAVA 8
//	==================================================
//	(1) public static final 상수	
	
	public static final double PI = 3.14159; 	//정적 멤버 
	
//	(2) public abstract 추상 메소드
//	가. 인터페이스는 절대 객체를 직접 생성할 수 없다.
//	나. 추상클래스와 다르다(추상클래스도 직접 객체는 생성할 수 없지만
//		자식객체를 통해서 자동으로 추상 클래스의 객체가 부모객체로서 
//		생성은 되지만 인터페이스는 아니다.
//	다. 추상클래스에 선언된 추상메소드 == 인터페이스에 선언된 추상메소드 (똑같다)
//	라. 자식타입에서 반드시 구현(=재정의) 해야만 하는 대상
	
//	모델링 대상 객체의 규격(기능)
//	: 즉, 대상 객체에는 아래와 같은 기능이 반드시 있어야 한다는 의미
//	때문에, 이 인터페이스의 '구현 클래스에서' 반드시 재정의 해야함
//	자식타입인 구현 클래스에 상속된다.
	
	public abstract void abstractMethod();	
	
//	(4) public static 정적 메소드
	public static void staticMethod() {
		System.out.println("IMyInterface::staticMethod() invoked.");
	}//staticMethod // 롬복 사용 불가
	
//	public default 기본 메소드
//	가. 디폴트 메소드는 완전한 "인스턴스 메소드" 이다.
//	> 객체 없이는 호출 불가
	
//	나. 그런데, 인터페이스는 객체를 생성할 수 없는 타입인 것이 문제
//		어디선가 객체를 수해야 한다.
//		=> 인터페이스의 구현 클래스, 즉 자식으로부터 생성된 구현객체가 있어 이 객체 이용
//	다. 이 default method는 자식타입인 구현클래스에 상속된다.
//	 	정말 구현클래스(자식타입)에 "상속"된다면, "재정의"도 가능하다.
 	
	public default void defaultMethod() {
		System.out.println("abstractMethod::defaultMethod() invoked.");
	}//defaultMethod
	
} // end interface

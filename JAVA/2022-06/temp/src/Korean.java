
public class Korean { // 라이브러리클래스 : main 메소드 없음.

	//(1) 필드 (모델링 대상 객체의 속성)
	String nation = "대한민국"; 		//국적
	String name;						//이름
	String ssn;							//사회보장번호(social security number,주민번호)
	
	//(2) 생성자
/*  public Korean(String n, String s){
	
	name= n;
	ssn = s;
	
*/
	/*
	 * 생성자 대전제4 : 생성자의 매개변수의 이름은 이 매개변수의 값으로 초기화할
	 * 					필드의 이름과 동일하게 명명하는 것이 관례 = > 이름 충돌이 필히 발생
	 * 
	 * 					=> 따라서 this 키워드로 이름 충돌을 원천적으로 예방하라.
	 * 
	 * 
	 * 
	 * 
	 */
	
	//(2) 생성자
	
	//			|----매개변수(Parameters) 선언부 ----|
	public Korean(String name, String ssn) { // 생성자 호출시, 외부에서 "이름", "사회보장번호"를 받아서 

		
//		Lvalue(필드) = Rvalue(매개변수)
		// 자바 키워드로 this 가 나오게 됨 클래스블록 안에서만 사용하는?
		
		//이름 충돌 해결하는 방법
//		//1st: 매개변수 이름 바꾸는 것도 안좋고. 필드이름은 바꾸면 안됨)
//		name = name1;
//		ssn = ssn1;
//	
		// 2nd : 필드의 이름과 같은 이름의 지역변수 선언과 초기화가 가능한 것도 문제이다.
//주의 사항: 생성자 블록안에서는 클래스필드와 같은 이름의 지역변수를 선언하지 않도록주의
		
		//- 록안에서는 클래스필드와 같은 이름의 지역변수를 선언하지 않도록 주의
		//- 비록 오류는 아니지만, 버그의 개연설발생
//		String ssn = null; //매개변수 ssn1 x  지역변수 정의!!!!! 컴파일 오류 안남.
	
		System.out.println("******** this :" + this);
		
		//this 키워드를 이용한 필드 초기화(매개변수)
		this.name = name;					// "이름" 필드를 초기화
		this.ssn = ssn;						// "사회보장번호" 필드 초기화 수행

//		method(); // 메소드 호출 > method이름의 지역변수가 있을 수 있으니.
		this.method(); // 아래와 같이 사용하라

  // Constructor #2
	
	}

	
	// (3) 메소드(모델링 대상 객체의 행위/동작/기능) 
	void method() {
		String ssn = null; 		//지역변수의 이름과 filed이름 충돌이기 때문에 xx
		
		System.out.println(ssn);		//내가 쓰는게 field라면 this 붙이라.
		
		//메소드 블록이든, 새엇ㅇ자 블록이든, 클래스에 선언된 필드/메소드를 사용하고자 한다면
		//명시적으로 앞에 this 키워드를 붙여서 사용하라
		// 우발적으로 이름 충돌을 예방하고, 
		//명시적으로 지역변수이름/매개변수이름 과 필드의 이름 충돌을 원천적으로 예방가능
		System.out.println(this.ssn);
	}

} //end class
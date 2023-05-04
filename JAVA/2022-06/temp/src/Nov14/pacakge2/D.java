package Nov14.pacakge2;

import Nov14.pacakge1.A;

public class D extends A { 	//A클래스의 자식 클래스인 D
	
	public D() {				//자식 클래스 생성자 내에서
		super();				//부모클래스의 생성자를 호출 가능하다는 개념
		this.field = "value";	// 부모인 A가 물려준 필드를 사용 가능
		this.method();			//부모인 A가 물려준 메소드 호출 가능
	} //default constructor

	public void instanceMethod() {
		this.field = "Other value";
		this.method();
	}//instanceMethod
}//end class

//자식만이 호출할수 이는 A_1 생성자.(protected 되어있음)

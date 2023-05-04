package Nov14.pacakge2;

import Nov14.pacakge1.A;

import Nov14.pacakge1.A;

public class C extends A{				//A의 자식클래스가 아니기 때문에 A의 protected에 접근 불가

	public void method() {
		A a = new A();				//xx A클래스의 생성자 접근 불가
		
		a.field = "value";			//xx A클래스의 필드 접근 불가
		a.method();					//xx A클래스의 메소드 접근 불가
		
	} // method
} // end class

//C가 A_1의 자식이라도, A의 생성자는 자식으로서 자식 객체를만들때
//부모객체의 생성자를 호출하라고 내려준거지
//new A()가 안된다는 것. 
//>> 왜냐하면 부모가 먼저 생성되어야 하기 때문에 super();
// 또한, 참조변수명.field 가 안된다. protected는 안된다.
//자식 클래스 선언된 내부안에서 물려받은 것 처럼 사용하라..
//this.field, this method 처럼

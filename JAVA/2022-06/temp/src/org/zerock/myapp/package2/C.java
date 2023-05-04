package org.zerock.myapp.package2;

import org.zerock.myapp.package1.A;

public 			// 외부에서 어떤 클래스에서건 사용가능한 클래스
class C {

	public C() {
		
		A a = new A();
		a.field1 = 1;
//		a.field2 = 1; // default라 다른 패키지 안됨
//		a.field3 = 1; /e
		
		a.method1();
//		a.method2()
//		a.method3();
	}//default constructor
	
} // end class

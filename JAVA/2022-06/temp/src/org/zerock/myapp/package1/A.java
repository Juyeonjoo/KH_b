package org.zerock.myapp.package1;


/*class 선언부 앞에 붙일 수 있는 접근 제한자는 2개밖에 없음 
	(1) public
	(2) default
 * 
 */
public class A { // public 이 없기 때문에 default 제한자 
	//필드
	public int field1;
	int field2;
	private int field3;
	
	//생성자
	public A() {
		field1 = 1;
		field2 = 1;
		field3 = 1;
		
		method1();
		method2();
		method3();
	} //default constructor
	

	public void method1(){;;}		//method1
	void method2(){;;}				//method2
	private void method3(){;;}		//method3
	
}//end class

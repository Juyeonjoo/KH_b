package Nov17;


public class Example {

	public static void main(String[] args) {
		
		ImplementationC impl = new ImplementationC();//구현객체 생성
		
		InterfaceA ia = impl;		//인터페이스A 참조타입(부모)에 다형성1 대입
		ia.methodA();				//다형성 2
		System.out.println();
		
		InterfaceB ib = impl;		//인터페이스B 참조타입(부모)에 다형성1 대입
		ib.methodB();				//다형성 2
		System.out.println();
		
		InterfaceC ic = impl;		//인터페이스C 참조타입(부모)에 다형성1 대입
		ic.methodA();				//다형성 2
		ic.methodB();				//다형성 2
		ic.methodC();				//다형성 2
	}//main
}//end class

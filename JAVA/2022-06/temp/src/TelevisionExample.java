
public class TelevisionExample {

	public static void main(String[] args) {
		
		
		//대전제: 
		//가. 정적초기자(static initializer)는 무조건 생성자보다 먼저 수행된다.
		//나. 정적초기자는 오로지 단 한번만 수행
//			- 정적멤버는 그 소속이 객체가 아니라, 메소드 영역의 Clazz객체 소속
//			- Clazz 객체를 생성하는 주체가 개발자가 아니라 virtual machine이기 때문
//			(정확히는 JVM의 ClassLoader가 생성주체이다.)
//			-Clazz 객체를 메소드 영역에 꽂아 넣기 직전에 단 한번 호출하는 것이
//		static initializer이라 단 한번만 호출됨
		Television television = new Television();
		System.out.println(Television.info); //2)
		//클래쯔 객체, static 붙여야한다. 
		

	}//main
}//end class

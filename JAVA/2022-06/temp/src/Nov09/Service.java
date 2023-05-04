package Nov09;


@MyAnnotation
public class Service {
	
	//========================
	//필드
	//========================
	
//	@MyAnnotation					//ok
//	private @MyAnnotation	

	@MyAnnotation private String name;
	private int age;
	
	//========================
	//생성자
	//========================
	@MyAnnotation 
	Service(){
		System.out.println("Service::default constructor invoked.");
	} //default constructor
	
	Service(String name, int age){
		System.out.println("Service::Service(String, int) invoked.");
	} //constructor2
	
	//========================
	//메소드
	//========================
	
//	@MyAnnotation			//선언된 annotation 사용
//	@MyAnnotation public 
//	public @MyAnnotation 
	public
//	void @MyAnnotation	
	
	void method1() {
		System.out.println("Service::method1() invoked");
		
//		@MyAnnotation			//ok
//		@MyAnnotation String name ="Yoseph"; //ok, 지역변수는 반드시 초기화
		
		@MyAnnotation
		String name = "Yoseph";
		
		int age =23;
		
	} //method1
	
	@MyAnnotation	
	public void method2(
//			@MyAnnotation				//ok
//			@MyAnnotation String name, //ok
			@MyAnnotation String  name, 	
			int age) {
		System.out.println("Service::method2(String, int) invoked");
		
	} //method2
	
	@MyAnnotation	
	public void method3() {
		System.out.println("Service::method3() invoked");
		
	} //method3
}

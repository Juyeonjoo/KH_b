
public class Calculator2Example {


	public static void main(String[] args) throws ClassNotFoundException {
		
		double result1= 10*10*Calculator2.pi;	//정적필드(pi)사용
		int result2 = Calculator2.plus(10, 5);	//정적메소드(plus)호출
		int result3 = Calculator2.minus(10, 5);	//정적메소드(minus)호출
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
//		======================================		
		
		Calculator2 calc = new Calculator2();
//		calc.pi;
//		calc.minus(100,200);
//		calc.plus(100,200);
		
		System.out.println(Calculator2.pi);
		Calculator2.minus(100,200);
		Calculator2.plus(100,200);
		
//		======================================
		
//		우리가 만든 "Calculator2"클래스의 "Clazz"를 직접얻어서 출력해보자.
//		특정 클래스에 대한 "Clazz"객체를 얻는(즉, 주소를 얻는)
//		3가지 방법 소개.
		
		Class clazz;
		
//		(1) 클래스명.class			//클래스이름만 안다면,
		clazz = Calculator2.class;
		System.out.println(">>>>>>>> 1. "+ clazz);
		
//		(2)참조변수명.getClass() 메소드 호출 반환값
		
		Calculator2 calc2 = new Calculator2();
		clazz = calc2.getClass(); //참조변수로부터 객체의 주소를 갖고있는, 참조변수로부터 해당객체에 대응되는 clazz객체ㅡㄹ 바로 얻어올 수 있는 getClass 메소드를 만들어 집어 넣은 것.
		System.out.println(">>>>>>>> 2. "+ clazz);
		
//	(3) Class.forName(FQCN) 메소드 호출 반환값
		
		String FQCN = "Calculator2";
		
		clazz = Class.forName(FQCN);
		

		System.out.println(">>>>>>>> 3. "+ clazz);
		
//		calculator클래스의 clazz 객체
		//forname이라는 정적 메소드가 들억아ㅣㅆ음. 


	} //main
}// end class

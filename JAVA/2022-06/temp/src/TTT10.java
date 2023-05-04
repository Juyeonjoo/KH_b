
public class TTT10 {

	static {
		System.out.println(">>> static initializer #1");
	}		// static initializer #1
	
	{
		System.out.println("&&& User - defined bl                                                                                                                                                                                                                                                                                                                                                                   ock #1");
	} //User-defined block #1
	
	public static void main(String...args) {
		
		double earthArea;
		
		
//		주의사항 : 사용자-정의 블록은 어느 블록에서건 선언 가능
		{
			//지구의 면적을 계산하여 earthArea 변수에 대입
//			earthArea = 지구의 면적계산(지구면적 =  4 * 원주율 * 지구 반지름의 제곱) 
					
			int age = 23;
			
			System.out.println("&&& User - defined block #4");
		} //User-defined block #4
		
		//주의사항: static initializer는 메소드 블록 안에서는 선언 불가!!!
//		static { 		//Syntax error on token "static", delete this token
//			System.out.println(">>> static initializer #4");
//		}		// static initializer #4
//		
//		
	}//main
	
	static {
		System.out.println(">>> static initializer #2");
	}		// static initializer #2
	
	{
		System.out.println("&&& User - defined block #2");
	}//User-defined block #2
	
	
	static {
		System.out.println(">>> static initializer #3");
		
		{
			System.out.println("&&& User - defined block #5");
		} //User-defined block #5
		
	}		// static initializer #3
	
	{
		System.out.println("&&& User - defined block #3");
	} //User-defined block #3
	
	
} //end class

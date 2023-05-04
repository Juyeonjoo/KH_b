
public class VariableScopeExample {

	public static void main(String[] args) {
		
		int var1; // main 메소드에 소속
		
		if(true) {
			int var2; // if 부문에 소속
			
			var1 = 10; // 정의됨
			var2 = 20;	
		} // if블록, var2는 if문에서 만들어졌기 때문에 여기서 파괴. 

		System.out.println("1. var1: " + var1); // '+' =>문자열 연결 연산자(산술연산자x) 
//		System.out.println("2. var2: " + var2); // 변수는 변수안에 있는 값 연결해라(그릇 안에 있는 값이 사용되는 것)
		
	} //main var 1 은 이때 파괴
}

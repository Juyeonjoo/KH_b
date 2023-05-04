
public class ContinueExample {

	
	public static void main(String[] args) {
		
		label:
		for(int j = 0; j < 3; j++) {
				System.out.println("j = " + j);
				
			
			for(int i = 1; i <= 10; i++) {
				
				//산술연산자가 비교연산자보다 우선순위가 높다.
				if(i % 2 != 0) { // 2의 배수가 아니라면
					continue label;    // 바깥쪽 for문, 증감식으로 돌아가서 계속 수행	
				} //if
				System.out.println(i);
			} // 안쪽 for

		}//안쪽 for
	} // main
}//end class

/*
j = 0
j = 1
j = 2

*/
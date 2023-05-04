
public class ForPrintFrom1to10Example {

	public static void main(String[] args) {
		
		int sum = 0; // 총 합을 구하기 위한 변수, counter변수의 값 누적시키기 위해 만든. 총합과는 다르다.
		int i = 0;	//main 안에서 선언된 변수, for문 안에서x, 더 큰 유효범위의 counter 변수
		
		
		for(i = 1 ; i <= 100 ; i++) { //counter변수가 for문 안 초기식에서만 만들어질 필요는 없다.
			
			sum += i;     // sum = sum+i // sum 의 값은 변한다.
//			int newSum = sum +i; // newSum의 값은 변하지 않는다. i 값만 변한다.


		}//for문
		System.out.println("1~" +(i-1) + " 합 : " + sum );
		
	} //main
} // end class 

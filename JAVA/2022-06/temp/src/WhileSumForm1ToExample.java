
public class WhileSumForm1ToExample {

	public static void main(String[] args) {
		int sum = 0; // 중간/최종단계의 누적합을 보관할 변수
		int i =1;   // 카운터 변수 :반복횟수 제어
		
		while(i <= 10) { //조건식
			
			sum +=i; //카운터 변수의 값을 sum에 누적시킴
			
			i++;	//(30증감식
		} // while
		System.out.println("1~"+ (i-1) + " 합 : " +sum);
	} //main
	
} // end class

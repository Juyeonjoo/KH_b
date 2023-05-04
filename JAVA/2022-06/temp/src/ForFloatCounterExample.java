
public class ForFloatCounterExample {

	//카운터 변수의 타입으로는 실수타입(float, double)은 절대 사용x
	public static void main(String[] args) {
		
		//(1) 초기식 		조건식			증감식
		for(float x = 0.1f ; x <= 1.0f ; x += 0.1f) {
			
			System.out.println(x); //반복할 실행문장
		} //for
		System.out.println();
	}//main
}//end class

//0.1
//0.2
//0.3
//0.4
//0.5
//0.6
//0.70000005
//0.8000001
//0.9000001

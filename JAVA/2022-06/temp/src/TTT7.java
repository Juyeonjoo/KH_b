
public class TTT7 {

	//자바 언어가 얼마나 빨라?
	public static void main(String[] args) {
		
		//for 반복문 20만번 수행시키고 소요 시간 측정.
		
		//System.이란, 자바표준라이브러리에 이미 있는 클래스에는
		//currentTimeMillis() 이란 실행가능한 "메소드"가 있다. 매개변수는 없음
		//대신, 이 메소드는 현재시간을long(정수)타입으로 반환
		
		//long time 값 리턴
		long start = System.currentTimeMillis(); // 시작전 시간측정: 밀리초(1/1000초)
		
			//아래와 같이 성능측정대상 코드는 한번더 "들여쓰기"해주거나,
			//사용자 정의 블록({}) 을 이용
			for(int i = 1; i <= 2000000000; i++); //반복시킬 실행문장x
			
			/*
			{
				for(int i = 1; i <= 200000; i++); 
			} // 사용자 정의 블록(User-Defined Block)
			*/
			
		long end = System.currentTimeMillis(); //종료후 시간측정: 밀리초(1/1000초)
		
		System.out.println("*Eclipsed time: " + (end - start) + " ms.");
		System.out.println("*Eclipsed time: " + ((end - start)/1000) + " seconds");
	}
}


public class Car {

	// 필드
	int gas;
	
	//2. 생성자
	
	//3.메소드
	
	void setGas(int gas) {
		
		this.gas= gas;
	} // setGas
	
	boolean isLeftGas() {
		
		if(gas ==0) {
			System.out.println("gas가 없습니다.");
		
			return false;
		} // if
		
		System.out.println("gas가 있습니다.");
		
		return true;
	} // isLeftGas
	
	void run() {
		while (true) { 
			if(gas > 0 ) {
				System.out.println("달립니다. (gas잔량: " + gas + ")");
				gas -= 1;	//한번 반복할 때마다 연료의 양을 1씩 줄인다.			
			} else {
				System.out.println("멈춥니다.(gas잔량: " + gas + ")");

				break;			//그 즉시 메소드 실행종료시킴
			}//if - else: 탈출 조건
			
		} //while
		System.out.println("break");
	}//run
}//end class


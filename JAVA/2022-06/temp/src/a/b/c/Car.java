package a.b.c;

public class Car {

	//1. 필드 < 데이터가 저장되는 곳이 필드라서 private인 경우가 많음
	private int speed;
	private boolean stop;
	
	
public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public boolean isStop() {
		return stop;
	}


	public void setStop(boolean stop) {
		this.stop = stop;
	}


	//	===========================================
//			
	//2. 생성자
	public Car() {;;} //default constructor
	
	
//	===========================================
	//3. 메소드
	/*
	public int getSpeed() {
		return this.speed;		
	} //getSpeed
	
	public void setSpeed(int speed) {
		if(speed < 0) {	//0보다 작은건 말이 안되니까 0으로 초기화
			this.speed = 0;
			
			return; //return은 띄어주기, 그 즉시 종료. return문장 필요 없는데 왜 넣었을까
					//
		} else {
			this.speed = speed;
		} //if-else
	} // setSpeed


	public boolean isStop(){
	
		return stop;
	
	}//isStop, getter

	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
		
*/		
	} //setStop
}//end Class
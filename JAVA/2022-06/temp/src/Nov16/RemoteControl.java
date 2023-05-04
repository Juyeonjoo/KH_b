package Nov16;

public interface RemoteControl {
	
	//인터페이스 구성 멤버 #1 - static final 상수
	//모든 곳에서 RemoteControl.하면사용 가능한
	public static final int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;
	
	
	// 인터페이스 구성멤버 #2 -
	//추상 메소드
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract void setVolume(int volume);

//	==========java untill 7 ==========
	
	
//	==========java untill 8 ==========
	//default method
	//17버전 전까지는 모든 멤버는 public 이다.
	//17버전부터는 아니다.
	//3. 인터페이스 구성멤버 #3 - 디폴트 메소드(default methods)
	//기존 타객객체기능의 확장을 위해서 인스턴스 메소드가 나오옴
	public default void setMute(boolean mute) {		//인스턴스 메소드
	if(mute) {
		System.out.println("무음 처리하니다.");
	} else {
		System.out.println("무음 해제 합니다.");
	}//if-else
	}// 디폴트 메소드
	
//	인터페이스 구성 멤버 #4  정적 메소드(static methods)
//	이유: 기존 타겟객체의 기능 확장 위해 
	public static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}//changeBatterry
	
	
} //end interface

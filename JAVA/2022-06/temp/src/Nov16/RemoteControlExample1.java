package Nov16;

import java.util.Arrays;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Log4j2

public class RemoteControlExample1 {

	public static void main(String[] args) {
		log.trace("main({}) invoked.", Arrays.toString(args));
		
		// ***익명구현객체*** 코딩기법을 통해, 실제 구현 클래스를 만들지 않고
		// 바로 구현객체를 생성하여 Lvalue 인터페이스 타입의 참조 변수에 대입한다.
		
		RemoteControl rc = new RemoteControl() {	//다형성1: 익명구현객체 생성
	
			@Override
			public void turnOn() {
				log.trace("turnOn() invoked.");
			}//turnOn
			
			@Override
			public void turnOff() {
				log.trace("turnOff() invoked.");
			}//turnOff
			
			@Override
			public void setVolume(int volume) {
				log.trace("setVolume({}) invoked.", volume);
			}//setVolume
			
		}; //익명구현객체(Anonymous Implementation Object)코딩 기법
		
		log.info(">>>>>>rc: " +rc);
		
		//인터페이스에 선언된 추상 메소드만 보고 사용(다형성2)
		
		rc.turnOn();
		rc.setVolume(RemoteControl.MIN_VOLUME);
		rc.turnOff();
		
	}//main
}//end class

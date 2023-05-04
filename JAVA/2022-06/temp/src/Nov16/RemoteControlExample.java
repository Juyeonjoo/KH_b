package Nov16;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class RemoteControlExample {

	public static void main(String[] args) {
		
		RemoteControl rc;			//부모타입(인터페이스)의 참조변수 선언
		
		rc = new Television();		//다형성1
		log.info("1. rc: {} " , rc);
		
		rc.turnOn();
		rc.setVolume(RemoteControl.MAX_VOLUME);
		rc.turnOff();
		
		rc = new Audio();			//다형성1
		log.info("2. rc: {} " , rc);
	} //main
}//end class

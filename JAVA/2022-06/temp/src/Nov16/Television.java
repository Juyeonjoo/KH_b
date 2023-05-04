package Nov16;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2						//Apache Log 4j2 Logger 생성
@NoArgsConstructor			//기본 생성자 생성
public class Television implements RemoteControl {

	private int volume;
	
	@Override
	public void turnOn() {
		log.trace("turnOn() invoked.");	//trace () => Log Level: TRACE
	}//turnOn
		
	@Override
	public void turnOff() {
		log.trace("turnOff() invoked");
	}//turnOff

	@Override
	public void setVolume(int volume) { //setVolume() 추상메소드의 실체 메소드
		log.trace("set(Volume({}) invoked.", volume);
		if(volume > RemoteControl.MAX_VOLUME) {// 인터페이스의 static final 상수 사용
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}//multiple if
			
		log.info("현재 tv 볼륨 : " + volume); 	//일반로그 => INFO LEVEL
	}//setVolume


}

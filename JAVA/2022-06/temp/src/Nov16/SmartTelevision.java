package Nov16;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
public class SmartTelevision implements RemoteControl, Searchable {

	private int volume;
	
	//생성자 없으므로 NoArgsConstructor
	
	@Override
	public void turnOn() {
		log.trace("turnOn() invoked.");
	} //turnOn

	@Override
	public void turnOff() {
		log.trace("turnOff() invoked.");
	}//turnOff

	@Override
	public void setVolume(int volume) {
		log.trace("setVolume({}) invoked.", volume);
//		if(volume > RemoteControl.MAX_VOLUME) {
//			this.volume = RemoteControl.MAX_VOLUME;
//		} else if(volume < RemoteControl.MIN_VOLUME) {
//			this.volume = RemoteControl.MIN_VOLUME;
//		} else {
//			this.volume = volume;
//	}//다중 if
//		
//		log.info("현재 TV 볼륨: " +volume);
	}//setVolume
	
//-----Searchable 인터페이스의 추상메소드=강제규격)재정의
	@Override
	public void search(String url) {
		log.trace("search({}) invoked.", url);
	} //search


} //end class

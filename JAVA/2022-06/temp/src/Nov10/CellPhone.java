package Nov10;

public class CellPhone {

	//필드
	String model;		//타입별 기본값. null;
	String color;		//타입별 기본값. null;
	
	//생성자
	
	public CellPhone(){
		System.out.println("Cellphone::default constructor invoked");
	}//default constructor
	
	public CellPhone(String model, String color){
		System.out.println("Cellphone::CellPhone(model, color) invoked");
		this.model = model; 
		this.color = model;
	}// constructor
	
	
	
	//메소드, 모든 메소드 default
	void powerOn() {
		System.out.println("Cellphone::powerOn() invoked");
	} //powerOn
	
	void powerOff() {
		System.out.println("Cellphone::powerOff() invoked");
	} //powerOff
	
	void bell() {
		System.out.println("Cellphone::bell() invoked");
	}//bell
	
	void sendVoice(String message) {
		System.out.println("Cellphone::sendVoice(message) invoked");
		System.out.println("자기 :" + message);
	}//sendVoice
	
	void receiveVoice(String message) {
		System.out.println("Cellphone::receiveVoice(message) invoked");
		System.out.println("상대방 :" + message);
	} //receiveVoice
	
	void hangUp() {
		System.out.println("Cellphone::hangUp() invoked");
	}//hangUp() 
	
} //end class

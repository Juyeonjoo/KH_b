package Nov10;

//자식클래스 extends 부모클래스(단일상속만 지원)
//주의 , 하지만 "인터페이스"에서는 기본이 "다중상속"이다.
public class DmbCellPhone extends CellPhone {

	//필드
	int channel;		//default
	
	//생성자
	DmbCellPhone(String model, String color, int channel) {
		//model, color는 부모 때문에, channel은 본인 거를 초기화하려고 받은 것.
	
//		super(model, color);			//부모클래스 생성자호출
		super(); //첫줄, 컴파일에게 의존하지 말라.부모클래스의 기본 생성자를 직접 넣어준다.
		
		System.out.println("DmbCellPhone::DmbCellPhone(model, color, channel) invoked.");
		
		this.model = model;
		this.color = color;
		this.channel = channel;
	} // constructor 
	
	//메소드
	
	void turnOnDmb() {
		System.out.println("DmbCellPhone::turnOnDmb() invoked");
	} //turnOnDmb() 
	
	void changeChannelDmb(int channel) {
		System.out.println("DmbCellPhone::changeChannelDmb(channel) invoked");
		
		this.channel =channel;
		System.out.println("채널 " + channel + "번으로 바꿉니다.");
	} //changeChannelDmb
	
	void turnOffDmb() { //default
		System.out.println("DmbCellPhone::turnOffDmb()  invoked");
	} //turnOffDmb() 
	
	void invokeAllMethodsOfParentDirectly() {
		System.out.println("DmbCellPphone::invokeAllMethodsOfParentDirectly() invoked");
		
//		System.out.println(">>>>>super: " + super); 	//xxxx
		System.out.println(">>>>>this: " + this); 
		
		//아래와 같이 자식 클래스의 내부에서는 "super"란 키워드(즉,생성된 부모객체의
		// 주소(참조)를 가지고 있는) 를 이용하여, 직접 부모객체의 메소드와 필드 사용 가능
		super.powerOn();
		super.powerOff();
		super.sendVoice("여보세요");
		super.receiveVoice("안녕하세요! 저는 홍길동인데요!");
		super.sendVoice("아~ 예 반갑습니다.");
		super.hangUp();
		
		System.out.println("super.model : " + super.model);
		System.out.println("super.color : " + super.color);

	} //invokeAllMethodsOfParentDirectly()

	
	void invokeAllInheritedMethods() { //default
		System.out.println("DmbCellPphone::invokeAllInheritedMethods() invoked");
		
//		System.out.println(">>>>>super: " + super); 	//xxxx
		System.out.println(">>>>>this: " + this); 
		
		this.powerOn();
		this.powerOff();
		this.sendVoice("여보세요");
		this.receiveVoice("안녕하세요! 저는 홍길동인데요!");
		this.sendVoice("아~ 예 반갑습니다.");
		this.hangUp();
		
		System.out.println("this.model : " + this.model);
		System.out.println("this.color : " + this.color);

	} //invokeAllInheritedMethods() 
	
	// 호출로그는 똑같아도 내거 호출한거랑 부모님꺼 호출한거랑은 다르다.
} //end class

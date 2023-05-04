package Nov10;

public class DmbCellPhoneExample {

	/*
	(1) extends 키워드를 이용한 두 클래스 간에 "상속관계"가 형성되었을 때에
	자식 객체를 생성한다면, 부모없는 자식 없듯이 힙에는 먼저 '부모'객체가 생성
	되고 이어서 '자식' 객체 생성 
	
	
	(2) 부모객체가 물려준 필드와 메소드를 내것처럼 사용해보기
	
	*/
	public static void main(String[] args) {
		
		//Step1. DmbCellPhone 자식 객체 생성
//				(주의사항) 부모객체부터 "완전하게"먼저 생성되고
		//		이후에 "자식객체"가 완전하게 생성됨 
		//DmbCellPhone 객체 생성
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
		
		
//		Step2.  CellPhone으로부터 상속 받은 필드를 사용해보자
//			상속받은 필드는 부모것이 아니라 "내" 것입니다.
		//CellPhone으로부터 상속 받은 필드
		System.out.println("모델 : " + dmbCellPhone.model);
		System.out.println("색상 : " + dmbCellPhone.color);
		System.out.println("채널: " + dmbCellPhone.channel);
		
		//Step3. CellPhone으로부터 상속 받은 메소드 호출
//				상속받은 메소드는 부모것이 아니라 '내' 것이다.
		
//		Step3-1. 아래의 호출된 메소드는 모두 상속받은 메소드를 호출하여 사용
		System.out.println(">>>>>아래의 호출된 메소드는 모두 상속받은 메소드를 호출");
		dmbCellPhone.powerOn();
		dmbCellPhone.powerOff();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receiveVoice("안녕하세요 저는 홍길동인데요");
		dmbCellPhone.sendVoice("아~ 예 반갑습니다.");
		dmbCellPhone.hangUp();
		
		//Step3-2. 아래의 호출메소드는 모두 원래 자식객체가 가지고 있던 메소드 호출
		System.out.println(">>>>>아래의 호출된 메소드는 모두 원래 자식객체가 가지고 있던 메소드 호출");
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnOffDmb();
		
		//Step.3-3 super키워드를 이용한 부모 멤버의 직접 사용
		System.out.println(">>>>>super키워드를 이용한 부모 멤버의 직접 사용");
		dmbCellPhone.invokeAllMethodsOfParentDirectly();
		
		//Step.3-4 this키워드를 이용한
		System.out.println(">>>>>this키워드를 이용");
		dmbCellPhone.invokeAllInheritedMethods();
		
	} //main
} //end class


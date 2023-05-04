package Nov29;

import java.util.LinkedList;
import java.util.Queue;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class QueueExample {
	public static void main(String[] args) {
		
	
	//1. Q interface의 구현 객체 생성/대입
	Queue<Message> messageQueue = new LinkedList<>();		//다형성1
	
	//2.Q 객체 메시지 객체 넣기(offer)
	messageQueue.offer(new Message("sendMail", "홍길동"));		//다형성2
	messageQueue.offer(new Message("sendSMS", "신용권"));		//다형성2
	messageQueue.offer(new Message("sendKakaotalk", "홍두께"));	//다형성2
	
	log.info("1. messageQ: {}", messageQueue);
	
//	3. Q에 있는 요소를 하나씩 빼내면서 (poll), Q가 비워질때까지(until empty)
	while(!messageQueue.isEmpty()) {
		Message message = messageQueue.poll();
		switch(message.command) {
		case "sendMail" ->log.info("{} 님에게 메일을 보냅니다.", message.to);
		case "sendSMS" -> log.info("{} 님에게 SMS을 보냅니다 ", message.to);
		case "sendKAkaotalk "->log.info("{} 님에게 카카오톡을 보냅니다.", message.to);
		}//switch Expression
	}//while
	}//main
} //end class


//인터페이스의 구성멤버(java 8기준)
//(1) static final 상수
//(2) abstract methods
//(3) default instance methods
//(4)static methods
//위에는 무조건 public 
//(5) private instance methods *** since java9
//(6) private static methods	***since java9

interface IMyInterface {
	
	public default void defaultMethod() {
//		if, 너무 많은 실행문장구성으로 구성되어있다,
//		private instance메소드들로 쪼개서 구현하라
	}//defulatMethod
	
	public static void lengthSSaticMethod() {
//		if, 너무 많은 실행문장구성으로 구성되어있다,
//		private instance메소드들로 쪼개서 구현하라
	}//lengthSSaticMethod
	
	//lengthy default method를 쪼개서 구현하라 라는 의미
	private void instanceMethod() {
		;;
	}//instanceMethod
	
	private static void staticMEthod() {
		staticMEthod();
	}//staticMethod
}//end interface
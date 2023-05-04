package Nov17;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class TTT1 {

	public static void main(String[] args) {
		
		//InterfaceA 인터페이스에 대한 "익명구현객체"의 생성
		InterfaceA ia = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA() invoked.");
			} //methodA()
			
		}; //익명구현객체 생성
		
		ia.methodA();			//재정의된 자식 익명구현객체의 메소드		
		log.info(ia);
	}// main
	
} // end class

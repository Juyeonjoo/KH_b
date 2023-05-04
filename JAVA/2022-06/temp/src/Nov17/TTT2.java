package Nov17;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TTT2 {

	public static void main(String[] args) {
		
		InterfaceA ia2 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA() invoked.");
			} //methodA
			
		};// 익명구현객체 생성
		ia2.methodA();
		log.info(ia2);
	} // main
}//end class

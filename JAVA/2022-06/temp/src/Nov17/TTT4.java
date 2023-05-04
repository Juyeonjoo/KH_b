package Nov17;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TTT4 {

	public static void main(String[] args) {
		
		InterfaceA ia4 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA() invoked");
			} //methodA
	
		}; // 익명구현객체
		ia4.methodA();
		log.info(ia4);
	}//main
} //end class

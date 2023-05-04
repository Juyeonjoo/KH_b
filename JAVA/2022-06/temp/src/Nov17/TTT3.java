package Nov17;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TTT3 {	
	
	public static void main(String[] args) {
		
		InterfaceA ia3 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA() invoked.");
			}//mehtodA()
			
		}; //인터페이스객체생성
		ia3.methodA();
		log.info(ia3);
		
	}//main
}//end class

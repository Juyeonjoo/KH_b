package Nov17;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TTT5 {

	public static void main(String[] args) {
		InterfaceA ia5 = new InterfaceA () {

			@Override
			public void methodA() {
				log.trace("methodA() invoked.");
			} // method A
			
		};//익명구현객체
		ia5.methodA();
		log.info(ia5);
	}//main
}//end class

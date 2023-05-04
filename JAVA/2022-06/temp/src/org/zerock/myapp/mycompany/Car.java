package org.zerock.myapp.mycompany;

import org.zerock.myapp.hankook.SnowTire;
import org.zerock.myapp.hyundai.Engine;
import org.zerock.myapp.kumho.BigWidthTire;

public class Car {
	
	//필드
	Engine engine = new Engine();
	
	SnowTire tire1 = new SnowTire();
	BigWidthTire tire2 = new BigWidthTire();
	

	org.zerock.myapp.hankook.Tire tire3 = new org.zerock.myapp.hankook.Tire (); // import부문을 쓰지 않고,FQCN으로 
	org.zerock.myapp.kumho.Tire tire4 = new org.zerock.myapp.kumho.Tire();
//	
}//end class


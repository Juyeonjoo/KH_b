package Nov17;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TTT6 {

	public static void main(String[] args) {
		InterfaceA ia6 = new InterfaceA() {
			
			String name = "Ju";
			int age = 23;
			
			@Override
			public void methodA() {
				log.trace("methodA() invoked");
				log.info("\t+ name: {}", this.name, this.age); //필드사용 가능
				
				this.instanceMethod();		//인스턴스 메소드 호출 가능
				this.staticMethod();		//정적 메소드 호출 가능
			}//methodA
			
			public void instanceMethod() {
				log.trace("instanceMethod() invoked.");
			
			}// instanceMethod
			
			
			public static void staticMethod() {
				log.trace("staticMethod() invoked.");
			}//staticMethod()
		
		}; //익명구현객체생성


		ia6.methodA();
		log.info(ia6);
		
		
		InterfaceA ia7 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA() invoked.");
			}//methodA() 
	
		}; //ia7
		ia7.methodA();
		log.info(ia7);
		
		InterfaceA i8 = new InterfaceA() {
			
			public void methodA() {
				log.trace("methodA() invoked.");
			}// methodA()
		
		}; // 
		i8.methodA();
		log.info(i8);
		
		InterfaceA ia9 = new InterfaceA() {
			
			public void methodA() {
				log.trace("methodA() invoked.");
			}//methodA()
		};// 익명구현
		ia9.methodA();
		log.info(ia9);
		
		InterfaceA ia10 = new InterfaceA() {
			
			public void methodA() {
				log.trace("methodA() invoked.");
			}
		};
		ia10.methodA();
		log.info(ia10);
		
		InterfaceA ia11= new InterfaceA() {
			public void methodA() {
				log.trace("methodA() invoked.");
			} //methodA
		};// 구현
		ia11.methodA();
		log.info(ia11);
		
		InterfaceA ia12 = new InterfaceA() {
			
			public void methodA() {
				log.trace("methodA() invoked.");
			}//methodA
		};//
		log.info(ia12);
		ia12.methodA();
		
		InterfaceA ia13 = new InterfaceA() {
			
			public void methodA() {
				log.trace("methodA() invoked.");
			}
		};
		ia13.methodA();
		log.info(ia13);

		InterfaceA ia14 = new InterfaceA() {
			
			public void methodA() {
				log.trace("methodA() invoked.");
			}//
		};
		ia14.methodA();
		log.info(ia14);
		
		InterfaceA ia15 = new InterfaceA() {
			public void methodA() {
				log.trace("methodA() invoked.");
			}
		};
		ia15.methodA();
		log.info(ia15);
		
		InterfaceA ia16 = new InterfaceA() {
			public void methodA() {
				log.trace("methodA() invoked.");
			} //methodA
		};
		ia16.methodA();
		log.info(ia16);
		
		InterfaceA ia17 = new InterfaceA() {
			public void methodA() {
				log.trace("methodA() invoked.");
			}
		};
		log.info(ia17);
		ia17.methodA();
		
		InterfaceA ia18 = new InterfaceA() {
			public void methodA() {
				log.trace("methodA() invoked.");
			}
		};
		log.info(ia18);
		ia18.methodA();
		
		InterfaceA ia19 = new InterfaceA() {
			public void methodA() {
				log.trace("methodA() invoked.");
			}
		};
		ia19.methodA();
		log.info(ia19);
		
		InterfaceA i20 = new InterfaceA() {
			public void methodA() {
				log.trace("methodA() invoked.");
			}
		};
		log.info(i20);
		i20.methodA();
	}//main
}//end class

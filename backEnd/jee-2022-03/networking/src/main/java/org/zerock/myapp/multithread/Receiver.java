package org.zerock.myapp.multithread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;


//HandShake Protocol 대로, 클라이언트에서 보내는 객체(메시지) 수신
@Log4j2
public class Receiver extends Thread{
	private Socket sock;
	
	public Receiver(Socket sock, String name) {
		log.trace("Constructor({}, {}) invoked", sock, name);
		
		this.sock=sock;
		super.setName(name);
		
	}//Constructor
	
	//thread를 만드는 방법, thread클래스를 상속받은 클래스에서 run method overriding하기
	@Override
	public void run() {//run method는 throw절을 붙일 수 없다. functional.. >우리가 안에서 처리해야 함
		log.trace("run() invoked.");
		
		try {
//			객체기반으로 주고받기 위해서
			@Cleanup InputStream is = sock.getInputStream();
			@Cleanup ObjectInputStream ois = new ObjectInputStream(is);
		
		
			while(true) { //무한루프, 클라이언트에서 보내는 메시지(객체) 수신 
				//while 문에서 클라이언트가 보낸 객체를 계속 읽는다.
				Object obj = ois.readObject();
				log.info("recv:{}", obj);
			}//while	
			
			}catch(Exception e) {
				;;
			}finally{
				if(this.sock!=null&&!this.sock.isClosed()) {
					try {
						this.sock.close(); 
					}catch(IOException e) {
						;;
						}
					//try-catch
				}//if
			}//try-catch-finally
	}//run
	
}//end class

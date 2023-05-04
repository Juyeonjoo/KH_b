package org.zerock.myapp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Objects;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class UDPServer {

	//DatagramPacket을 수신할 임무 
	// 지금 예제는 UDP서버가 UDP Client로 부터 오는 패킷들을 계속 수신만 하는 경우
	//수신한 패킷으로부터 얻어낸 데이터(문자열)을 콘솔에 계속 출력
	public static void main(String[] args) throws IOException {
		
		//IP주소 뭘로들어와도 되고,이 Port번호에서 기다리겠다.
		
		int listenPort= 5001;
		DatagramSocket sock = new DatagramSocket(listenPort);
		log.info("1. socket: {}", sock);
		
		try {
			log.info("2. Waiting message from port : {}", listenPort);
			while(true) {//무한루프- 언제올지 모르고 ,몇 번이나 패킷이 올지 모르니
				//만일에 패킷이 송신자(sender)로부터 들어온다면, 이 패킷을 받을 준비를 해야 된다.
				DatagramPacket packet = new DatagramPacket(new byte[100], 100);
				sock.receive(packet);//우리가 생성한 패킷 안에 데이터가 들어오게된다. 
				
				//decoding > 문자열 만든다.
				String recvMessage = new String(packet.getData(), 0, packet.getLength(), "utf8");//getData 바이트를 거꾸로주는?
				log.info("\t+ recvMessage:{}", recvMessage);
				
	//			single thread이므로 현재는 무한루프 빠져나오는것은 예외발생일때만
				
			}//while
		}catch(IOException e) { //IOException 만 잡아서 위로 던지면 됨.
			log.info("\t+3. Finished receiving...");
			throw e;
		}finally {
			Objects.requireNonNull(sock);
			if(!sock.isClosed()) {
				sock.close(); //finally는 반드시 수행되는
				log.info("4. Socket Closed.");
			}
			//socket이 닫혔는가 yes, 닫히지 않았다면 close해라 
		}//try-catch-finally
	}//main
}//end class

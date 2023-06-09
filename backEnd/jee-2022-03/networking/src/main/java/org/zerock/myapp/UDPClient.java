package org.zerock.myapp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Objects;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UDPClient {

//	client는 sender 송신자 역할을 한다
//	UDP Networking 에서 메시지 송신자의 역할, 송신하기만 한다(수신은 반대로 없다)
	public static void main(String[] args) throws IOException {
		
		//UDP에서 클라이언트는 매개변수 없는 생성자를 이용한다.
		//왜냐하면, UDP는 TCP와 같이 연결지향이 아니기 때문
		//송신자 입장에서 아래의 DatagramSocket은 단지 생성된 DatagramPacket을
		//인터넷에 그냥 던지는 역할 밖에는 안한다.
		@Cleanup DatagramSocket sock = new DatagramSocket();
		
		try {
			for(int i=1; i<=10; i++) { //10번 패킷 생성 및 전송(이 패킷이 편지봉투의 역할)
				//때문에 이 DatagramPacket에 "보내는 사람 주소/포트, 받는 사람 주소/포트" 기재해야 함.
				String message = "MESSAGE_" + i;
				
				//모리스부호로 바꾸는 것 encoding.
				//모든 통신은 바이트 열이기 때문에 메시지를 byte열로 바꿔줘야 한다.
				byte[] bytes = message.getBytes("utf8"); //utf8에 정의된 것으로 쪼개라 
				
				//생성자 안에 보내는 메시지 넣기
				DatagramPacket packet = new DatagramPacket(
						bytes, bytes.length,
						//받는 사람(수신자) 주소(IP주소+port번호) 기재>inetsocketaddress
						new InetSocketAddress("localhost", 5001)
						//보내는 사람(송신자)의 주소는 자동으로 결정/기재(운영체제가 결정하므로)
						);
				//인터넷으로 패킷을 던져버림(어떻게 갈지, 언제 도착할지 모름)
				sock.send(packet);
			}//for
		} finally {
			Objects.requireNonNull(sock);
			if(!sock.isClosed()) {
				sock.close();
			}//if
		}//try-finally
	}//main

}//end class

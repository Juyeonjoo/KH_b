package org.zerock.myapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Objects;

import org.zerock.myapp.domain.Member;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class OIOSocketServer {

	//소켓(Socket객체) 통해, 주고받는 메시지에 대한 규격도 설계해야 하는데,
	//이를 바이트 기반으로 설계하는게 아니라, 객체기반으로 설계한다면
	//매우 단순해질수가 있다. 
	//이를 위해서, 우리가 배웠던 자바 입/출력 보조스트림 중에
	//객체의 직렬화/역직렬화에서 소개되었었던
	//ObjectInput/OutputStream 을 이용하면 객체를 네트워크로 주고 받을 수 있다.
	//이번 예제는 이것이 핵심
	public static void main(String[] args) throws IOException {
		
		log.trace("main({})", Arrays.toString(args));
		
		//ServerSocket 생성 및 accept 수행
		int listenPort = 5555;
		int backlog = 100; //default size: 50
		
//		ServerSocket serverSocket = new ServerSocket(listenPort, backlog);
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("0.0.0.0", listenPort), backlog);//socketaddress >ip와 port 가지고 있음
//		----------------------------------------------
		
	try(serverSocket){
			
		while(true) {
				
			log.info("start Listening...");
			Socket socket = serverSocket.accept();
			
			SocketAddress remoteSocket = socket.getRemoteSocketAddress(); //연결된 클라이언트의 주소/포트 정보 획득
			log.info("remoteSocket:{} ", remoteSocket);
			
			try(socket){
				
				@Cleanup InputStream  is = socket.getInputStream();
				@Cleanup ObjectInputStream ois = new ObjectInputStream(is);
				
				//객체의 역직렬화, byte[]->Java Object로 변환 
				Object obj = ois.readObject(); 
				
				
				Objects.requireNonNull(obj);
				Member member = (Member) obj;
				
				log.info("\t+member:{}", member);
				
//				------------------------------------------
//				송신
				member.setId(2);
				member.setName("Trinity");
				member.setAge(21);
				
				@Cleanup OutputStream os = socket.getOutputStream();
				@Cleanup ObjectOutputStream oos = new ObjectOutputStream(os);
				
				//객체의 직렬화 : java Object => byte[]로 변환
				oos.writeObject(member); oos.flush();
				log.info("Sent member:{}", member);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}//try-catch
		}//while
		}//try-with-resources 단독 사용 가능, @Cleanup 과 유사한 기능
		
	}//main

}//end class

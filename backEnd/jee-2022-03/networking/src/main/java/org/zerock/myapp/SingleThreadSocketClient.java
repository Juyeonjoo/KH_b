package org.zerock.myapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SingleThreadSocketClient {

	public static void main(String[] args) throws IOException {
		log.info("* Client started...");
		
		//서버의 지정된 Listen Port로 새로운 연결 요청 생성/전송=>연결생성
		//=>데이터를 주고받을 수 있는 Socket을 완성한다.
		
		//Step.1 클라이언트용 Socket 객체 생성
		@Cleanup
		Socket socket = new Socket();
		log.info("1. socket:{}", socket);//연결할 서버의 주소정보 없음
		
		//Step.2 연결을 요청할 서버의 IP 주소+ Listen Port번호를 가지는 InetSocketAddress객체를 생성
		
		String serverIPAddress ="localhost";		//loopback Address
//		String serverIPAddress ="192.168.10.3";		//IPv4 Address
		int serverListenPort = 7777;
		int timeout= 1000*1;
		
		
		//Step.3 지정된 IP 주소와 포트번호로 Listen하고 있는 
		//		서버로 연결 요청
		InetSocketAddress serverSocketAddress 
				= new InetSocketAddress(serverIPAddress, serverListenPort);
		
//		socket.connect(serverSocketAddress);
		socket.connect(serverSocketAddress, timeout);		//blocking I/O
//		log.info("2. serverSocketAddress:{}", serverSocketAddress);
		log.info("2. serverSocketAddress:{}, timeout:{} ", serverSocketAddress, timeout);
		
		log.info("3. socket after connected to the server:{}", socket);
		
		//Step.4 통신규약을 아래와 같이 정했다.
		//(1) 클라이언트가 문자열 메시지 송신(Send)
		//(2) 서버가 문자열 메시지 수신(Recv) 하고 콘솔에 출력
		//(3) 서버는 받은 문자열을 다시 클라이언트로 송신(Send)
		//(4) 클라이언트는 받은 문자열을 콘솔에 출력
		
		String message = "Hello From Client.";
		byte[] bytes = message.getBytes("utf8");
		
//		==============================
		@Cleanup OutputStream os = socket.getOutputStream();
		//socket은 무조건 바이트 기반
		os.write(bytes); os.flush();//출력스트림으로 강제 방출
		log.info(">>> Sent to Server");
//		==============================
		@Cleanup InputStream is = socket.getInputStream();
		bytes = new byte[100];
		int readBytes = is.read(bytes);
		
		message = new String(bytes,0, readBytes, "utf8");
		message = new String(bytes, "utf8");//문자열로 반환
		log.info("<<< Recv from Server : {}", message);

//		os.close();		
//		is.close();
	}//main
}//end class
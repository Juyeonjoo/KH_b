package org.zerock.myapp.io.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class MultiChatServer {
	
	private static final int port=7777;
	private static final Charset charset = Charset.forName("UTF-8");
	private static Map<String, Socket> clients;
	
	
	
	public MultiChatServer() {
		log.trace("Default constructor invoked.");
		
		clients = new HashMap<>();
		clients = Collections.<String, Socket> synchronizedMap(clients);
	} // Default Constructor
	
	
	private void start () {		
		try (ServerSocket serverSock = new ServerSocket(port)) {
			
			while(true) {				
				log.debug("Listening on {} .....", serverSock);
				Socket sock = serverSock.accept();
				log.debug("Client Connected From {}", sock);
				
				ServerReceiver receiver = new ServerReceiver(sock);
				receiver.start();
			} // while
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			log.info("Server finished.");
		} // try-with-resources
	} // start

	
	@Log4j2
	static class ServerReceiver extends Thread {
		final Socket sock;
		final String clientKey;
		
		
		ServerReceiver(Socket sock) {			
			this.sock = sock;
			this.clientKey = sock.getRemoteSocketAddress().toString();
			
			clients.put(this.clientKey, sock);
			log.debug("clients: {}", clients);
			
			try {
				String WELCOME = String.format("<<< Client Key: %s Entered. Welcome !!!", this.clientKey);
				
				publish("SERVER", WELCOME, true);
			} catch (IOException e) {
				clients.remove(this.clientKey);
				log.debug("clients: {}", clients);
				
				try {
					String BYE = String.format(">>> Client Key: %s Exited. Bye !!!", this.clientKey);
					
					publish("SERVER", BYE, true);
				} catch (IOException e1) {;;}
			} // try-finally
		} // Constructor
		
		
		public void run() {			
			try (this.sock) {
				
				InputStream is = this.sock.getInputStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				
				try (is; baos;) {
					
//					----------------------------
//					1. RECEIVE MESSAGES FROM ALL CLIENTS
//					----------------------------
					
					int CR=13, LF=10;
					
					int ch;
					String RECV = null;
					
					while((ch = is.read()) != -1) {
						if(ch != CR && ch != LF) {
							baos.write(ch);
						} else {
							if(ch == LF) {								
								RECV = baos.toString(charset);
								log.info("RECV from {}: {}", this.clientKey, RECV);
								
								baos.reset();
								
//								----------------------------
//								2. PUBLISH MESSAGES TO ALL CLIENTS
//								----------------------------
								publish(this.sock.getRemoteSocketAddress().toString(), RECV, false);								
							} // if
							
						} // if-else
						
					} // while : is.read() != 1
					
				} // try-with-resources : is, baos
				
			} catch(IOException e) {
				;;
			} finally {
				log.info("Client {} Disconnected", this.sock);
				
				clients.remove(this.clientKey, this.sock);
				log.debug("clients: {}", clients);
				
				try {
					String BYE = String.format(">>> Client Key: %s Exited. Bye !!!", this.clientKey);
					
					publish("SERVER", BYE, true);
				} catch (IOException e1) {;;}
			} // try-with-resources : this.sock
			
		} // run
		
	} // end class
	
	
	private static void publish(String fromKey, String message, boolean toSelf) throws IOException {
		log.trace("publish({}, {}) invoked.", fromKey, message);
		
		Set<String> keys = clients.keySet();
		
		for(String key : keys) {			
			log.debug("publish to the client key: {}", key);
			
			if(!key.equals(fromKey) || toSelf) {
					
				int CR=13, LF=10;

				Socket sock = clients.get(key);
				OutputStream os = sock.getOutputStream();
				
				os.write((fromKey+": "+message).getBytes(charset));
				os.write(CR);
				os.write(LF);
				
				os.flush();
				
				log.info("SENT from {}: {}", fromKey, message);
			} else {
				log.debug("Excluding client itself key: {} to publish.", fromKey);
			} // if-else
			
		} // enhanced for
		
	} // publish
	

	public static void main(String[] args) {
		log.trace("main({}) invoked", Arrays.toString(args));
		
		new MultiChatServer().start();
	} // main

} // end class

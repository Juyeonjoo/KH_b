package org.zerock.myapp.io.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class MultiChatClient {
	private static final String host = "localhost";
	private static final int port = 7777;

	
	public static void main(String[] args) throws IOException, InterruptedException {
		log.trace("main({}) invoked.", Arrays.toString(args));
		
		try (Socket sock = new Socket(host, port)) {
			log.info("Connected to the server addr: {}, port: {}", host, port);

			Thread R = new Receiver(sock.getInputStream());
			R.start();
			
			Thread S = new Sender(sock.getOutputStream());
			S.start();
			
			R.join();
			S.join();
		} finally {
			log.info("Disconnected.");
		} // try-with-resources
		
	} // main

	
	
	static class Sender extends Thread {
		private final OutputStream os;

		
		Sender(OutputStream os) {
			log.trace("constructor({}) invoked.", os);

			this.os = os;
		} // constructor
		
		@Override
		public void run() {
			Scanner scanner = new Scanner(System.in);
			
			try (this.os; scanner;) {
				int CR=13, LF=10;
				
				String line = null;
				while((line=scanner.nextLine()) != null) {
					String message = line.trim();
					os.write(message.getBytes("UTF-8"));
					
					// Sent CRLF (***)
					os.write(CR);
					os.write(LF);
					
					os.flush();
					
					log.info(message);
				} // while
				
			} catch(IOException | IllegalStateException | NoSuchElementException e) {
				e.printStackTrace();
			} finally {
				log.debug("Sender stopped.");
			} // try-with-resources

		} // run

	} // end class : Sender
	
//	--------------------------
	
	static class Receiver extends Thread {
		private final InputStream is;

		
		Receiver(InputStream is) {
			log.trace("constructor({}) invoked.", is);
			
			this.is = is;
		} // constructor
		
		@Override
		public void run() {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			try (this.is; baos;) {
				log.debug("Receiver started.");
				
				int ch;
				int CR=13, LF=10;
				
				while((ch=is.read()) != -1) {
					if(ch != CR && ch != LF) {
						baos.write(ch);
					} else {
						if(ch == LF) {
							String recv = baos.toString("UTF-8");
							log.info(recv);
							
							baos.reset();
						} // if
					} // if-else
				} // while
				
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				log.debug("Receiver stopped.");
			} // try-with-resources
		} // run

	} // end class : Receiver

} // end class

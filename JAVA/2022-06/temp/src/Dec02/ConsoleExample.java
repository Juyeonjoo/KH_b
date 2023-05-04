package Dec02;

import java.io.Console;

//import lombok.extern.log4j.Log4j2;

//@Log4j2
public class ConsoleExample {

	public static void main(String[] args) {
		
		Console console = System.console();		
		
		System.out.println(console);
		
		System.out.print("1. id: ");
		String id = console.readLine();		
		
		System.out.println("2. password: ");

		char[] charPass = console.readPassword();
		String strPassword = new String(charPass);
		
		System.out.println("==================");
		System.out.println("1. id :" + id);
		System.out.println("2. strPassword:" + strPassword);
		
	}//main
} //end class

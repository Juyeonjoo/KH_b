package Dec02;

import java.io.IOException;
import java.io.OutputStream;

public class WriteFiles {

	public static void main(String[] args) throws IOException {
		
		OutputStream os = System.out;
		
		os.write(100);
		os.write(101);
//		os.flush();
		
	}//main
} //end class

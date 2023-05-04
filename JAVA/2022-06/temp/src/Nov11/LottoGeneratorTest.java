package Nov11;

import java.util.Arrays;

class LottoGenerator {    
    public int[] generate() { return null; } 
} // end class


public class LottoGeneratorTest {

	public static void main(String[] args) {

		LottoGenerator2 generator2 = new LottoGenerator2();
		LottoGenerator generator = generator2;
		
		generator2.generate();
		
		long start = System.nanoTime();
		
			int[] lottoNumbers = generator.generate();
		
		long end = System.nanoTime();
		
		System.out.println(">> Elapsed time: " + (end-start) + "ns.");
		System.out.println(">> Lotto Numbers: " + Arrays.toString(lottoNumbers));
	} // main

} // end class
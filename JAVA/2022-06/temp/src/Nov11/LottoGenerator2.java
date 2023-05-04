package Nov11;

import java.util.Arrays;

public class LottoGenerator2 extends LottoGenerator {


	int[] arr = new int[6];
	int extractedNumber;
	
	@Override
	public int[] generate() {
	
		int i = 0;
	while(true) {
	
//		 i < generateArr.length
//		abstract boolean isAlreadyExtractedNumber(int[] arr, int extractedNumber); //규격
		 
		for(int extractedNumber : arr) {
			extractedNumber = (int)(Math.random()*45) + 1;
		}
	
			i++;
			return arr;
	}
	
		} //while
	
	abstract boolean isAlreadyExtractedNumber(int[] arr, int extractedNumber) {
		for(int a : arr) {
			if(!a == extractedNumber)
		}
	}
	
	

//	
//	public static void main(String[] args) {
//		
//		LottoGenerator2 two = new LottoGenerator2();
//		two.generate();
//		System.out.println(two.extractedNumber);
//		
//	}
	
} // end class
	
			

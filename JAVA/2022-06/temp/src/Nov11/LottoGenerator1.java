package org.zerock.myapp;


public class LottoGenerator1 extends LottoGenerator {

	
	// 생성자------------------------------------------------------------------
	public LottoGenerator1() {
//		System.out.println("LottoGenerator1::default constructor invoked.");
	} // default constructor

	
	// 메소드------------------------------------------------------------------
	@Override
	public int[] generate() {
//		System.out.println("LottoGenerator1::generate() invoked.");
		
		int[] lotto = new int[6];
		int idx = 0;

		while (idx != lotto.length) {
			
			int num = (int) (Math.random() * 45) + 1;
			
			if (!isAlreadyExtractedNumber(lotto, num)) {
				lotto[idx++] = num;
			} // if
		} // while
		
		return lotto;
	} // generate

	@Override
	public boolean isAlreadyExtractedNumber(int[] arr, int extractedNumber) {
//		System.out.println("LottoGenerator1::isAlreadyExtractedNumber(arr, extractedNumber) invoked.");
		
		for (int i : arr) {
			
			if (i == extractedNumber) {
				
				return true;
			} // if
		} // for each
		
		return false;
	} // isAlreadyExtractedNumber

	@Override
	public void printArray(int[] arr) {
//		System.out.println("LottoGenerator1::printArray(arr) invoked.");
		
		for(int i : arr) {
			
			System.out.print(i + "  ");
		} // for
	} // printArray

} // end class
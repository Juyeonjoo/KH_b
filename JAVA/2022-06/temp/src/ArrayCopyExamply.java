import java.util.Arrays;

public class ArrayCopyExamply {
	public static void main(String[] args) {
	
		//System.arraycopy() 메소드를 이용한 배열의 복제
		String[] oldStrArray = {"java", "array", "copy"};
		String[] newStrArray = new String[5];
		
		
		/*System.arraycopy(
			복제할 배열 객체,
			int offset(복제를 시작할 인덱스 번호),
			Object 복제대상객체,
			int offset2 (복제대상 객체의 시작 인덱스 번호),
			int length(offset2 인덱스를 포함하여, 총 몇개의 원소를 복제할까)

		*/
		System.arraycopy( oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		
		System.out.println("1. oldStrArray: " +  Arrays.toString(oldStrArray));
		System.out.println("2. newStrArray: " +  Arrays.toString(newStrArray));
//	}
//		for(int i = 0; i < newStrArray.length; i++) {
//			
//			System.out.println(newStrArray[i] + ", ");
		
}//main
}//end

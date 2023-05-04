package Nov22;



public class TryWithResourceExample {

	//try- with -resources 구문
	public static void main(String[] args) {
		
		//fileInputStream타입의 객체 > 자원객체(왜? AutoCloseable 하니까)
		
		//Syntax: try(AutoCloseable한 ㅈ원개ㅔ체ㅐㅇㅅㅇ
		try(FileInputStream fis = new FileInputStream("file.txt")){
			fis.read();
			
			throw new Exception();		//강제를 예외로 발생시킴
		} catch(Exception e) {
			e.printStackTrace();
		}//try-catch
	} //main
} //end class

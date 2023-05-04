package Dec02;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FileExample {
//	핵심포인트: 파일시스템의 폴더와 파일을 모델링해서 만든 클래스가 바로
	//File 클래스, 파일시스템에 대한 조작에 필요한 대부분의 API가 File객체를
//	매개변수로 요구하는 경우가 많다.
	public static void main(String[] args) throws Exception {
//		1. File 객체 생성 - 이때, 생성자에 지정한 경로가 실제 존재하지 않아도 상관없음.
	File dir = new File("C:/Temp/Dir");		//폴더 경로 지정
	File file1 = new File("C:/Temp/TTT3.txt");	//파일 경로 지정
	File file2 = new File("C:/Temp/TTT4.txt");		//파일 경로 지정
	
	//URI객체와 URI 표현방식으로 경로 지정해도된다.
	//즉 생성자의 매개변수 타입으로 URI인 생성자도 있지만,
	//잘 안쓴다. 위와같이 간단한게 있기 때문에, 일부러 아래처럼 어렵게 경로를 지정할 필요가 없다.
	File file3 = new File(new URI("file:///C:/Temp/TTT5.txt"));
	
	log.info("1.dir: {}", dir);
	log.info("2. file1: {}", file1);
	log.info("3. file3: {}", file2);
	
//	============================================
	
	//File.exsit() File클래스의 메소드: File객체가 가리키고 있는 경로가 존재하는지 여부를 
//	boolean 값으로 반환
	//
	if(dir.exists() == false) { 
		//dir의 참조변수의 경로는 C:/Temp/Dir, 이 경로가 없으면 만들어라.
		//mkdir과 mkdirs 이 있는데, mkdirs는 전체 경로에 없는걸 다 만들어라
		//ex) Dir없으면 만들고, Temp없으면 이것도 만들어라.
		dir.mkdirs();		//파일객체의 경로대로 모든 폴더를 만들어주는 메소드
		}
	
	//C:/Temp/TTT3.txt 이 경로가 존재하지 않으면 새로운 파일 만들어라.
	if(file1.exists() == false) {file1.createNewFile();}
	if(file2.exists() == false) {file2.createNewFile();}
	if(file3.exists() == false) {file3.createNewFile();}
//	============================================
	
	File temp = new File("C:/Temp");
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd    a    HH:mm");
	
	//File.listFiles() : 지정된 경로 밑에 존재하는 모든 파일목록을 획득
	File[] contents = temp.listFiles();
	
	System.out.println("-------------------------------------");
	System.out.println("날짜	시간	형태	크기	이름");
	System.out.println("-------------------------------------");
	
	for(File file : contents) {
		//File.lastModified(): 지정된 경로의 파일의 최종수정시간 획득
		//Date 클래스: 날짜와 시간정보를 관리하는 클래스
		//SimpleDateFormat 클래스: 개발자가 원하는 형식(포맷)으로
		//							날짜와 시간 정보를 문자열로 만들어내는 클래스
		//long java.io.File.lastModified() > long 타입
		
		//SimpleDateFormat 포맷팅한 형식대로 
		System.out.println(sdf.format(new Date(file.lastModified())));
		
		//File.isDirectory() : 지정된 경로가 디렉토리or파일인지 알려줌
		if(file.isDirectory()) {
			System.out.println("\t<DIR>\t\t\t" + file.getName());
		}else{
			//File.length() : 지정된 경로의 크기(길이)획득
			System.out.println("\t\t\t"+ file.length() + "\t"+file.getName());
		}//if-else
		System.out.println();
	}//for
	}//main 
} //end class

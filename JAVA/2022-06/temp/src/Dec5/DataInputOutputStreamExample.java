package Dec5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
//핵심포인트: 기본 타입 변수에 있는 데이터로, 입/출력을 수행할 수 있도록 해주는 보조스트림
public class DataInputOutputStreamExample {

	public static void main(String[] args) throws IOException {
		

//	// base 출력스트림
//	@Cleanup
//	FileOutputStream fos = new FileOutputStream("C:/Temp/TTT2.txt");
//	//기본 데이터 타입 보조스트림 생성
//	@Cleanup
//	DataOutputStream dos = new DataOutputStream(fos);
//	
//	//기본 타입의 데이터로 출력 수행
//	dos.writeUTF("홍길동");					//String(UTF-8)
//	dos.writeDouble(95.5);					//double
//	dos.writeInt(1);						//int
//	
////	===========================
//	dos.writeUTF("감자바");		//String (UTF-8)
//	dos.writeDouble(90.3);		//double
//	dos.writeInt(2);			//int
//	
//	dos.flush();				//강제 flush
//	
	//자원해제
//	dos.close();
//	fos.close();
	
//	===========================
	
	//base 스트림 생성(바이트 기반)
	FileInputStream fis = new FileInputStream("C:/Temp/TTT2.txt");
	
	//기본타입 보조스트림 생성
	DataInputStream dis = new DataInputStream(fis);
	
	//파일에 기로갛ㄴ 순서대로 읽으면 원래정보가 그대로 복구
	for(int i= 0; i<2; i++){
		String name = dis.readUTF();
		double score = dis.readDouble();	
		int order = dis.readInt();
		
//	log.info(name + " : " + score + " : " + order);
		
		log.info("name: %s, score: %s, order: %s".formatted(name, score, order));
	}//for
	
	//자원해제
//	dis.close();
//	fis.close();
	}// main
} //end class

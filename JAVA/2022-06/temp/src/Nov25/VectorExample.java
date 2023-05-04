package Nov25;

import java.util.List;
import java.util.Vector;

import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@ToString
@Log4j2

public class VectorExample {

	public static void main(String[] args) {
		//Thread-safe 한 ArrayList가 바로 vector
		//공식 : Vector == ArrayList + alpha(Thread-safe 성질)
		
		List<Board> list = new Vector<>();		//다형성1
		log.info("1. list: {}", list);		
		
		//다형성2
		//2. 새로운 게시글 추가
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		log.info("2. list: {}", list);
		
		//3. 게시글 삭제
		list.remove(2);
		list.remove(3);
		log.info("3. list: {}", list);
		
		//4. 리스트의 순회 및 출력
		list.forEach(log::info);

	}//main
}//end class

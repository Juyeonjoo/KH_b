package Nov25;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor		//모든 필드의 생성자 
public class Board { //게시판 게시글 하나를 모델링해서 만든 클래스

	String subject; 	//제목
	String content;		//내용
	String writer;		//작성자
	
} //end class

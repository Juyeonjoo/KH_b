package org.zerock.myapp.domain;

import lombok.Data;

//이 DTO는 페이징처리와 관련된 전송파라미터만 
//수집하는 용도

@Data
public class Criteria {

	private Integer currPage = 1;		//현재 페이지 번호
	private Integer amount = 10;		//한페이지당 보여줄 게시물 개수(크기)

} // Criteria

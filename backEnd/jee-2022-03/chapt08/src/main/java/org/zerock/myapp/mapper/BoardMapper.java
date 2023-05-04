package org.zerock.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;

public interface BoardMapper {
	
	@Select("SELECT /*+ index_desc(tbl_board) */ * FROM tbl_board")
	public abstract List<BoardVO> selectAll(); //1. 전체목록 조회 전체 게시판 목록, 영속성 개체니까 selectAll?
	
	//XML Mapper 방식으로 SQL 처리
	public abstract BoardVO select(Integer bno); 	//2. 게시물상세 조회
	
	public abstract Integer delete(Integer bno); 	//3. 게시물삭제
	
	public abstract Integer insert(BoardDTO dto);	//4. 신규게시물등록
	public abstract Integer update(BoardDTO dto);	//5. 기존게시물수정

}//end interface

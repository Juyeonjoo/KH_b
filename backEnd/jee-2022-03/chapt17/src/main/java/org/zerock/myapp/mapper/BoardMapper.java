package org.zerock.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;

public interface BoardMapper {
	
	//페이징 처리하기 전
//	@Select("SELECT /*+ index_desc(tbl_board pk_board) */ * FROM tbl_board ORDER BY bno DESC")
	
	//페이징처리적용
	@Select("""
			SELECT *
			FROM tbl_board
			ORDER BY bno DESC
			OFFSET (#{currPage}-1) * #{amount} ROWS
			FETCH NEXT #{amount} ROWS ONLY
			""")
	public abstract List<BoardVO> selectAll(
//			@Param("currPage") Integer currPage, 
//			@Param("amount")Integer amount

			Criteria criteria
			); 
	//1. 전체목록 조회 전체 게시판 목록, 영속성 개체니까 selectAll?
	
	//XML Mapper 방식으로 SQL 처리
	public abstract BoardVO select(Integer bno); 	//2. 게시물상세 조회
	
	public abstract Integer delete(Integer bno); 	//3. 게시물삭제
	
	public abstract Integer insert(BoardDTO dto);	//4. 신규게시물등록
	public abstract Integer update(BoardDTO dto);	//5. 기존게시물수정
	
	@Select("SELECT count(bno) FROM tbl_board WHERE bno > 0") //항상똑같이 구하는거고 길지 않기 때문에 @어노테이션방식
	public abstract Integer selectTotalCount();		//6. 총 게시물건수 반환
	
}//end interface

package org.zerock.myapp.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/**/root-*.xml")
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardMapperTests {

	@Setter(onMethod_= {@Autowired})
	private BoardMapper mapper;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked" );
		
		Objects.nonNull(this.mapper);
//		assertNotNull(this.mapper);
//		assert this.mapper !=null;
		
		log.info("this.mapper:{}, {}",this.mapper,this.mapper.getClass().getName());
	}//beforeAlll/();
	
	/*
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("페이징처리전(deprecated):testSelectAll")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testSelectAll() {
		
		log.trace("testSelectAll() invoked" );
		
		List<BoardVO> list = this.mapper.selectAll();
		assertNotNull(list);
		
		list.forEach(log::info);
	}//contextLoads
	*/
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("페이징처리후: testSelectAll")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testSelectAll() {
		
		log.trace("testSelectAll() invoked" );
		
//		int currPage = 2; //현재 페이지
//		int amount = 20; //한 페이지 당 보여줄 게시물의 개수

//		======================
//		Criteria적용
//		======================
		Criteria cri = new Criteria();
		cri.setCurrPage(2);
		cri.setAmount(20);
		
		List<BoardVO> list = this.mapper.selectAll(cri);
		assertNotNull(list);
		list.forEach(log::info);
	}//contextLoads
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("testSelect()")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testSelect() {
		
		log.trace("testSelect() invoked" );
		
		Integer bno = 33;
		BoardVO vo = this.mapper.select(bno);
		assertNotNull(vo);
		
		Objects.requireNonNull(vo);
		log.info("vo:{}", vo);
	}//contextLoads
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("testDelete()")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testDelete() {
		
		log.trace("testDelete() invoked" );
		
		Integer bno = 300;
		Integer affectedLines = this.mapper.delete(bno);
		assertNotNull(affectedLines);
		
		Objects.requireNonNull(affectedLines);
		log.info("afftedLines:{}", affectedLines);
	}//contextLoads
	
//	@Disabled
	@Test
	@Order(4)
	@DisplayName("testInsert()")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testInsert() {
		
		log.trace("testInsert() invoked" );
		
		BoardDTO dto = new BoardDTO();
		
		dto.setTitle("TITLE_NEW");
		dto.setContent("CONTENT_NEW");
		dto.setWriter("WRITER_NEW");
		
		Integer affectedLines = this.mapper.insert(dto);
		assertNotNull(affectedLines);
		
		Objects.requireNonNull(affectedLines);
		log.info("***********afftedLines:{}", affectedLines);
	}//testInsert
	
	
//	@Disabled
	@Test
	@Order(5)
	@DisplayName("testUpdate()")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testUpdate() {
		
		log.trace("testUpdate() invoked" );
		
//		BoardDTO dto = new BoardDTO();		
//		dto.setBno(301);
//		dto.setTitle("TITLE_301");
//		dto.setContent("CONTENT_301");
//		dto.setWriter("WRITER_301");

		// 모든 컬럼을 수정하지 않는 경우
		
		BoardVO vo = this.mapper.select(301);
		BoardDTO dto = new BoardDTO();
		
		dto.setBno(vo.getBno());
		dto.setTitle(vo.getTitle());
		dto.setContent("CONTENT_NEW");
		dto.setWriter(vo.getWriter());
		
		Integer affectedLines = this.mapper.update(dto);
		assertNotNull(affectedLines);
		
		Objects.requireNonNull(affectedLines);
		log.info("***********afftedLines:{}", affectedLines);
	}//testInsert
	
//	@Disabled
	@Test
	@Order(6)
	@DisplayName("testSelectTotalCount()")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testSelectTotalCount() {
		
		log.trace("testSelectTotalCount() invoked" );
		

		Integer totalCount = this.mapper.selectTotalCount();
		//DML문장이아니라서 affectedLines이 아님
		Objects.requireNonNull(totalCount);
		log.info("totalCount:{}", totalCount);
	}//testSelectTotalCount
	
	
}//end class

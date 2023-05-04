package org.zerock.myapp.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.BoardMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@ToString
@Log4j2
@NoArgsConstructor

@Service("boardService")
public class BoardServiceImpl implements BoardService, InitializingBean{ //POJO
	
	@Setter(onMethod_= {@Autowired})
	private BoardMapper mapper;
	
	//빈, 주입잘 받았는지 체크 필요함.
	@Override
	public void afterPropertiesSet() throws Exception {//1회성 전처리
		log.trace("afterPropertiesSet() invoked");
		
		try {
			Objects.requireNonNull(this.mapper); //serviceException으로 매핑해서 던지게
			log.info("\t+this.dao:{}", this.mapper);
		}catch(Exception e) {
			throw new ServiceException(e);
		}//try-catch
	}//afterPropertiesSet()
	
	@Override
	public List<BoardVO> getList(Criteria cri) throws ServiceException {
		log.trace("getList() invoked");
		try {
			
			return this.mapper.selectAll(cri);
		}catch(Exception e) {
			throw new ServiceException(e);
		}//try-catch
	}

	public BoardVO get(Integer bno) throws ServiceException{
		
		log.trace("get() invoked");
		
		try {
			return this.mapper.select(bno);
		}catch(Exception e){
			throw new ServiceException(e);
		}//try-catch
	}

	@Override
	public boolean remove(Integer bno) throws ServiceException {
		log.trace("remove() invoked");
		
		try {
			return this.mapper.delete(bno)==1; //삭제되면 1(delete==1이니 총 true), affectedLines=1
		}catch(Exception e) {
			throw new ServiceException(e);
		}//try-catch
	}

	@Override
	public boolean register(BoardDTO dto) throws ServiceException {
		log.trace("register() invoked");
		
		try {
			return this.mapper.insert(dto)==1;
		}catch(Exception e){
			throw new ServiceException(e);
		}

	}

	@Override
	public boolean modify(BoardDTO dto) throws ServiceException {
		try {
			return this.mapper.update(dto)==1;
		}catch(Exception e){
			throw new ServiceException(e);
		}
	}//get
	
}//end class

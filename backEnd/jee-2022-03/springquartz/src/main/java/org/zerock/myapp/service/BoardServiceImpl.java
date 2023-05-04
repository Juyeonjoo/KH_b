package org.zerock.myapp.service;

import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Override
	public void testCronJob() { //얘를 execute 메소드 대신에 실행시킨다.
		log.trace("testCronJob() invoked.");
	}//testCronJob() 

}//end class

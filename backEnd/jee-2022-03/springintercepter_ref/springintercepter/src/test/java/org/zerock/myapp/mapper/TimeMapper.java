package org.zerock.myapp.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT current_date FROM dual") // 간단한 SQL
	public abstract Date getNow();
	
	// xml 방식으로 처리 (TimeMapper.xml에 SQL 문장 입력) 
	public abstract Date getNow2();
} // end interface

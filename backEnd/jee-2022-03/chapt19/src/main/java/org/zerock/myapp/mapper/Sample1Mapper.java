package org.zerock.myapp.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface Sample1Mapper {

	@Insert("INSERT INTO tbl_sample1(col) VALUES (#{col})")
	public abstract int insert(@Param("col") String data);//mapper proxy가 알아서해서 throws 절 xx
	
}//end interface

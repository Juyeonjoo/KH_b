package org.zerock.myapp.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface Sample1Mapper {
	
	@Insert("Insert INTO tbl_sample1 (col) VALUES ( #{col} )")
	public abstract int insert(@Param("col") String data);
} // end interface

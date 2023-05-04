package org.zerock.myapp.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface Sample2Mapper {

	@Insert("Insert INTO tbl_sample2 (col) VALUES ( #{col} )")
	public abstract int insert(@Param("col") String data);
	
} // end interface

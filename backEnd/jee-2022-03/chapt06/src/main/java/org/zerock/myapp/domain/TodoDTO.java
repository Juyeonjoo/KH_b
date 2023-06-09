package org.zerock.myapp.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class TodoDTO {
	
	private String title;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
//	@DateTimeFormat(iso=ISO.DATE) //"YYYY-MM-DD"
	private Date dueDate;
	
}//end TodoDTO

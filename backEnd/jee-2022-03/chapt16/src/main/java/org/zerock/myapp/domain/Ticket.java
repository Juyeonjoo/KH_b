package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class Ticket {

	private Integer tno;
	private String owner; //SampleDTO가 회원정보를 가지고 있으니
	private String grade;
}//end class

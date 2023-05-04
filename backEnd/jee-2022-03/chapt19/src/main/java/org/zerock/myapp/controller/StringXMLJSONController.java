package org.zerock.myapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.SampleDTO;
import org.zerock.myapp.domain.Ticket;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@AllArgsConstructor

@RequestMapping("/sample") //base URI
@RestController("sampleController")//빈즈이름등록(생략가능)
public class StringXMLJSONController {
	
	//HikariDataSource주입받자
//	@Setter(onMethod_=@Autowired)
	//주입받을 필드가 하나이고 이 필드를 매개변수로 받는 생성자가있으면
	//>AllArgsConstructro로 하면 자동주입
	private DataSource dataSource;
	
	//순수한 문자열을 받는 메소드
	@GetMapping(path="/getString", produces={

			//이 핸들러 메소드가 반환하는 데이터의 Content Type지정하는 속성
			
//			MediaType.TEXT_PLAIN_VALUE    //한글깨짐
//			MediaType.TEXT_PLAIN_VALUE + "; charset=UTF-8"	//한글 안깨짐
			"text/plain; charset=utf8"						//우리가직접, 한글 안깨짐
	})
	public String getString() {
		log.trace("getString) invoked");
		
		
		return "안녕하세요";
	}//getString
	
	/*
	
//	@GetMapping("/getSample")
	@GetMapping(
			//produces 속성으로 Content Type기재 안하면 =>XML로 반환
			
			path="/getSample", 
			produces= { 
			
			//XML, JSON타입을 모두 지정하면 순서와 상관없이 무조건 XML로 변환(***)
			MediaType.APPLICATION_XML_VALUE, // xml로 변환요청(한글 안깨짐)		
			MediaType.APPLICATION_JSON_VALUE, //JASON으로 변환요청(한글안깨짐)
//			MediaType.APPLICATION_JSON_UTF8_VALUE //JASON으로 변환요청(한글안깨짐)
			
			})
	public SampleDTO sample() {
		

		log.trace("getSample() invoked");
		
		SampleDTO dto = new SampleDTO();
		
		dto.setMno(100);
		dto.setFirstName("쥬");
		dto.setLastName("조");
		
		log.info("\t+dto:{}", dto);
		return dto;
	}//getSample
	
*/

	@GetMapping(
			path="/getSampleByJSON", 
			produces="application/json" //우리가 직접 지정
			)
	public SampleDTO getSampleByJson() {
		log.trace("getSampleByJason() invoked");
		
		SampleDTO dto = new SampleDTO();
		
		dto.setMno(100);
		dto.setFirstName("쥬");
		dto.setLastName("조");
		
		log.info("\t+dto:{}", dto);
		return dto;
	}//getSampleByJson
	
	@GetMapping(
			path="/getSampleByXML", 
			produces="application/xml" //우리가 직접 지정
			)
	public SampleDTO getSampleByXML() {
		log.trace("getSampleByXML() invoked");
		
		SampleDTO dto = new SampleDTO();
		
		dto.setMno(100);
		dto.setFirstName("쥬");
		dto.setLastName("조");
		
		log.info("\t+dto:{}", dto);
		return dto;
	}//getSampleByXML
	
	@GetMapping(
			path="/getSamplelist",
			produces="application/json"
			)
	public List<SampleDTO> getSampleList(){
		log.trace("getSampleList() invoked");
		
		List<SampleDTO> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			SampleDTO dto = new SampleDTO();
			
			dto.setMno(i);
			dto.setFirstName("FIRST_NAME_"+i);
			dto.setLastName("LAST_NAME_"+i);
			
			list.add(dto);
		}//for
		
		log.info("\t+list:{}", list);
		
		return list;
	}//getSampleList
	
	
	@GetMapping(
			path="/getSampleMap",
			produces="application/json"
			)
	public Map<String, SampleDTO> getSampleMap(){
		log.trace("getSampleMap() invoked");
		
		Map<String, SampleDTO> map = new Hashtable<>();
		
		for(int i=0; i<10; i++) {
			SampleDTO dto = new SampleDTO();
			dto.setMno(i);
			dto.setFirstName("FIRST_NAME_"+i);
			dto.setLastName("LAST_NAME_"+i);
			
			map.put("SAMPLE_"+i, dto);
		}//for
		
		log.info("\t+list:{}", map);
		
		return map;
	}//getSampleMap
	
	@GetMapping(
			path="/getSampleSet",
			produces="application/json"
			)
	public Set<SampleDTO> getSampleSet(){
		log.trace("getSampleSet() invoked");
		
		Set<SampleDTO> set = new HashSet<>();
		
		for(int i=0; i<10; i++) {
			SampleDTO dto = new SampleDTO();
			
			dto.setMno(i);
			dto.setFirstName("FIRST_NAME_"+i);
			dto.setLastName("LAST_NAME_"+i);
			
			set.add(dto);
		}//for
		
		log.info("\t+list:{}", set);
		
		return set;
	}//getSampleSet
	
	@GetMapping(
			path="/getSampleArray",
			produces="application/json"
			)
	public SampleDTO[] getSampleArray(){
		log.trace("getSampleArray() invoked");
		
		SampleDTO[] arr = {null,null,null,null,null};
		
		for(int i=0; i<5; i++) {
			SampleDTO dto = new SampleDTO();
			
			dto.setMno(i);
			dto.setFirstName("FIRST_NAME_"+i);
			dto.setLastName("LAST_NAME_"+i);
			
			arr[i]=dto;
		}//for
		
		log.info("\t+arr:{}", Arrays.toString(arr));
		
		return arr;
	}//getSampleArray
	
	@GetMapping(
			path="/getSampleTicket",
			produces="application/json"
			)
	public Ticket getSampleTicket(){
		log.trace("getSampleTicket() invoked");
		
		Ticket ticket = new Ticket();
		ticket.setTno(1000);
		ticket.setGrade("A");
		
		SampleDTO dto = new SampleDTO();
		dto.setMno(3);
		dto.setLastName("Cho");
		dto.setFirstName("Ju");

		ticket.setOwner(dto);

		return ticket;
	}//getSampleTicket
	
}//end class

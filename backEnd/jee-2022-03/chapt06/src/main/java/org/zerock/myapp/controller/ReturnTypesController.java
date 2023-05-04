package org.zerock.myapp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.domain.SampleDTO;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/return")	//Base URI
@Controller
public class ReturnTypesController {

	//1. No return type, No parameters
	@GetMapping("/void")
	void returnVoidNoParameters(
			//전송파라미터 필요없고, 모델상자도 rttrs도 필요없음
			) {
		log.trace("returnVoidNoParameters invoked");
		//No return type 더이상 뷰의 이름을 전달하지 않는다.
		//대신 Request URI(==BaseURI+상세 URI)가 자동으로 view의 이름으로 결정된다.
	}//returnVoidNoParameters
	
	
//	2. Return type, No Parameters = > 단순화면 전환용이되, 전환될 화면을 명시적으로 직접 지정
	@GetMapping("ViewName")
	//접근제한자는 default이어도(즉, public 생략해도 괜찮다)
	private String returnString() {
		log.trace("returnString invoked");
		
		//반환하는 문자열이 바로 view의 이름을 사용된다.
		return "return/void";
	}//returnString
	
//	--------------------------------------------
//	2-1. String return type: "redirect:"keyword
//	--------------------------------------------
	@PostMapping("/redirect")
	public String returnRedirect() {
		log.trace("returnRedirect() invoked");
		
//		내게 보낸 요청은 잘못됐으니, 다시 지정한대로 보내라.
//		in servlet: response.sendRedirect(target);
//		(주의)redirect:target사이에는 공백이 있어선 안됨
//		return "redirect:void"; //ok: /return/void, GET
		return "redirect:/return/void";  //ok 난 안됨
//		return "redirect:https://www.naver.com"; //ok:URL
	}//returnRedirect
	
//	2-2.  String return type:"forward:" keyword
	@GetMapping("/forward")
	public String returnForward() {
		log.trace("forward invoked");
		
//		In servlet:
//		RequestDispatcher dispatcher = request.getReqeustDispatcher("/return/void");
//		dispatcher.forward(request, response);
//		return "forward:void";			//ok basEuri가 있다면 자동으로붙음
//		return "forward:/return/void";	//OK: BASEURI를 직접 붙여도 됨
//		return "forward:http://naver.com"; //XX: URL로 지정하면 오류
		return "forward:/WEB-INF/views/return/void.jsp"; //OK, 그러나 spring MVC 패턴을 깨고 직접 view 호출, 그럼 framework 쓸 이유 없음
	}//returnForward
	
//	3. Object return type using @ResponseBody
//		To return JSON format document
	
	@PostMapping("/ResponseBody")
	public @ResponseBody SampleDTO returnResponseBody(
		@NonNull @RequestParam("name") String NAME,
		@NonNull @RequestParam("age") Integer AGE
		) {
		log.trace("returnResponseBody({},{}) invoked",NAME, AGE );
		
		SampleDTO dto = new SampleDTO();
		dto.setName(NAME);
		dto.setAge(AGE);
		
		log.info("dto:{}", dto);
		return dto;
	}
	
//	4. Object return type using ResponseEntity<T>
//	To return JSON format document 
//	including User-defined HEADERS and BODY, HTTP status
	
	@PostMapping("/ResponseEntity")
	public ResponseEntity<String> returnResponseEntity(){
		log.trace("returnResponseEntity() invoked");
		
		//HTTP response body(payload)에 넣을 JSON문서
		String json = "{'name':'한글', 'age':23}";
		
		//HTTP response의 헤더 추가
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/json; charset=utf8");
		
		//HTTP response의 (1) Body (2) Header (3) HTTP status code
		return new ResponseEntity<>(json, headers, HttpStatus.OK);
		
	}//returnResponseEntity
	
}//end class

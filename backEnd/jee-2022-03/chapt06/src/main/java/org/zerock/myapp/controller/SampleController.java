package org.zerock.myapp.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.SampleDTO;
import org.zerock.myapp.domain.TodoDTO;
import org.zerock.myapp.exception.AException;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/sample/*") //Base URI 
@Controller 
public class SampleController { //POJO&JavaBeans

//	--------------------------------------------------
//	1. @RequestMapping or @RequestMapping("")
//	--------------------------------------------------
	
	//http://localhost:8080/sample/
//	@RequestMapping("")				//OK: /sample/with GET & POST ---> WEB-INF/views/sample.jsp
//	@RequestMapping(method=RequestMethod.POST)
//	@RequestMapping("basic")
	@RequestMapping("/TTT")
	public String basic()  throws AException {
		log.trace("basic() invoked.");
		
		
		boolean isTrue = true;
		if(isTrue) throw new AException("TEST");
		
		return "sample";
	}//basic
	
	
//	--------------------------------------------------
//	2. @RequestMapping(path,method) -지정된 상세 URI+전송방식으로 들어온 요청을 처리
//	--------------------------------------------------

	@RequestMapping(
//		path={"/basicGet"},		//배열로 지정하는 경우
//		method= {RequestMethod.GET}
			
		path="/basicGet",			//단일값으로 지정하는 경우
		method= RequestMethod.GET
			)
	public String basicGet() {
		log.trace("basicGet() invoked");
		
		return "sample";		//view 이름을 반환 
								//WEB-INF/views/sample.jsp
	}
	
//	--------------------------------------------------
//	3. @RequestMapping(path,method) - 한개 이상의 전송방식을 동시에 지정하는 경우
//	--------------------------------------------------
	@RequestMapping(
			path={"/basicGetPost"},		
			method= {
				RequestMethod.GET,
				RequestMethod.POST	
			})
	public String basicGetPost() {
		log.trace("basicGetPost() invoked");

		return "sample";
	}

//	--------------------------------------------------
//	4. GetMapping(path) - @RequestMapping 의 단축형(get방식일때만 사용)
//	--------------------------------------------------
	@GetMapping("/basicOnlyGet")
	public String basicOnlyGet() {
		log.trace("basicOnlyGet() invoked");
		return "sample";
	}
	
//	--------------------------------------------------
//	5. PostMapping(path) - @RequestMapping 의 단축형(Post방식일때만 사용)
//	--------------------------------------------------
	@PostMapping("/basicOnlyPost")
	public String basicOnlyPost() {
		log.trace("basicOnlyPost() invoked");
		return "sample";
	}
	
//	--------------------------------------------------
//	6. @GetMapping(path) with DTO parameter - DTO 매개변수로 가지는 매핑
//	--------------------------------------------------

	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) { //Spring에서는 "Command Object" 이라 함
		//Spring Command Object 는 전송파라미터를 수집하는 용도의 빈 객체를 의미함
		log.trace("ex01({}) invoked.", dto);
		
		return "sample";		//뷰이름 
	}//ex01

	/*
	@GetMapping("/ex01")
	public String ex01(String name, int age) { //Spring에서는 "Command Object" 이라 함
		//Spring Command Object 는 전송파라미터를 수집하는 용도의 빈 객체를 의미함
		log.trace("ex01({}, {}) invoked.", name, age);
		
		return "sample";		//뷰이름 
	}//ex01
	*/
	
//	--------------------------------------------------
//	7.@GetMapping(path) with some primitive types's parameters
//	--------------------------------------------------
	@GetMapping("/ex02")
	public String ex02(
			@RequestParam("name")
			String recvName, 
			
			@RequestParam("age")
			Integer currentAge) {
		log.trace("ex02({},{}) invoked", recvName,currentAge );
		return "sample";
		
	}//ex02
	
	
	/*
	public String ex02(String name, Integer age) {
		log.trace("ex02({}, {}) invoked", name, age);
		
		return "sample";
	}
	*/

//	--------------------------------------------------
//	8.@GetMapping(path) with some List types's parameters
//	--------------------------------------------------
	
	@GetMapping("/ex02List")
	public String ex02List(
//			String[] ids								//OK : Good
			
//			@RequestParam("ids")ArrayList<String> ids 	//OK: Good
//			@RequestParam("ids") List<String> ids		//OK: Good
			@RequestParam("ids") Set<String> ids		////OK : Good
			
//			ArrayList<String> ids						//OK: EmptyArray([])
//			List<String> ids							//XX : 예외 발생	
//			Set<String> ids								//XX : 예외 발생

			) {
		log.trace("ids: ({}) invoked", ids);
		
		return "sample";
	}//ex02List
	
//	--------------------------------------------------
//	9. @GetMapping(path) with @DateTimeFormat
//	--------------------------------------------------
	@GetMapping("/ex03")
	public String ex03(TodoDTO dto) {
		log.trace("ex03({}) invoked.", dto);
		
		return "sample";
	}//ex03
	
//	--------------------------------------------------
//	10. Predefined Model parameter 
//	--------------------------------------------------
	@GetMapping("/ex05")
	public String ex05(String name, Integer age, Integer page, Model model) {
		log.trace("ex05: ({}, {}, {}) invoked", name, age, page);
		
//		과연 Model타입의 매개변수의 진짜 타입은 무엇일까? Clazz객체 이용해보자
		log.info("model:{}", model);
		log.info("modelType:{}", model.getClass().getName());
		
		
//		Model 이란 상자에 넣을 sample 객체를 생성한다. 여기서는 DTO객체 이용
//		그렇다고 실전에서 진짜 Model 상자안에 DT패턴 객체를 넣는건 절대 아니다.
//		왜? DTO객체를 자동으로 View까지 전달되기 때문이다. 
//		단, DTO객체로 전송파라미터를 수집한 경우 즉, Spring Command Object인 경우를 의미
		SampleDTO dto = new SampleDTO();
		dto.setName(name);
		dto.setAge(age);
		
//		Model이란 상자안에, 비즈니스 데이터 추가(2개)
		model.addAttribute("sampleDTO",dto);
		model.addAttribute("page", page);
		
//		View 이름 반환
		return "commandObject";
	
	}//ex05
	
//	--------------------------------------------------
//	11. @ModelAttribute(key) to transfer data into the View.
//	--------------------------------------------------
	@PostMapping("/ex06")
	public String ex06(SampleDTO dto, @ModelAttribute("page") Integer page) {
		log.trace("ex05: ({}, {}) invoked", dto, page);
		
		return "commandObject";
	}///ex06
	
//	--------------------------------------------------
//	15. Pre-defined RedirectAttributes to redirect requeset into the other url.
//	--------------------------------------------------
	
	@GetMapping("/ex07")
	public String ex07(@RequestParam("name") String name, int age, RedirectAttributes rttrs) {
		log.trace("ex07: ({}, {}, {}) invoked", name, age, rttrs);
		
		log.info("rttrs:{}", rttrs.getClass().getName());
		
		rttrs.addAttribute("name", name);
		rttrs.addAttribute("age", age);
		
		//지금 버전의 스프링에서는 더이상 작동안하니 사용하지 못한다.
//		rttrs.addFlashAttribute("name", "Trinity");//xx
//		rttrs.addFlashAttribute("age", "20");		//xx
		
//		리다이렉션 수행(특수문자열: "redirect:<Other URL>")
//		return "redirect:http://127.0.0.1:8008/";
		return "redirect:/sample/basicGet";

	}//ex07
}//end class

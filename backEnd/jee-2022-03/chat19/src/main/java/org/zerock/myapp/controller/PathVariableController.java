package org.zerock.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RestController 
public class PathVariableController {

	@GetMapping(
			path="/product/{category}/{productionId}",
			produces="application/json"
	)
	@PostMapping(
			path="/product/{category}/{productionId}",
			produces="application/json"
	)
	public String[] getPathVariables(
			@PathVariable("category") String category, 
			@PathVariable("productionId") Integer productionId 
			){
			log.trace("getPathVariables({}, {}) invoked", category,productionId);
			
			//두 개의 String을 담아서 보내려면 어떤게좋을까?
			
			return new String[] {"Category: "+category, "Production ID:" + productionId}; //빈문자열이라도붙여주면 참조타입인 String이 더 크니까 오류없어짐
	}//getPathVariables()

	
}//end class

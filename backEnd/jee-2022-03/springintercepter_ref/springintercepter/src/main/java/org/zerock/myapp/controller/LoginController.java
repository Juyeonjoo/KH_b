package org.zerock.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.myapp.domain.LoginDTO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor


@RequestMapping("/user")
@Controller
public class LoginController { // POJO

	@PostMapping("/loginPost")
	public String loginPost(LoginDTO dto) {
		log.info("loginPost({}) invoked", dto);
		
		
		
		return null;
	} // loginPost
	
} // end class

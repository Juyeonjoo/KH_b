package org.zerock.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@AllArgsConstructor

// 아래의 어노테이션은, "반드시" "Model 상자에 넣은 KEY"를 지정하면,
// 이 Key 이름으로 Session Scope에 공통속성으로 넣어줍니다.
@SessionAttributes({ "__AUTH__" })
@RequestMapping("/user")
@Controller
public class LoginController {		// POJO	
	private UserService service;
	
	
	@PostMapping("/loginPost")
	public String loginPost(LoginDTO dto, RedirectAttributes rttrs, Model model) 
			throws ControllerException {
		log.trace("loginPost({}, {}, {}) invoked.", dto, rttrs, model);
		
		try {
			UserVO vo = this.service.login(dto);
			log.info("\t+ vo: {}", vo);
		
			if(vo != null) {		// if 인증성공
				model.addAttribute("__AUTH__", vo);				
				return "redirect:/board/list";					// 메인화면
			} else {				// if 인증실패				
				rttrs.addAttribute("result", "Login Failed");
				return "redirect:/user/login";					// 인증실패결과와 함께, 로그인화면으로 다시 밀어버림
			} // if-else
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // loginPost

} // end class

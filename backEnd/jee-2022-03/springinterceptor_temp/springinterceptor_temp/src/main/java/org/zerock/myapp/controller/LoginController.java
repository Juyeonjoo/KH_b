package org.zerock.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor


//@SessionAttributes({"__USER__"}) //세션스콥의 공통속성이 된다. >인터셉터에서 한다.
@RequestMapping("/user")
@Controller
public class LoginController {
	private UserService service;
	
	@PostMapping("/loginPost")
	public String loginPost(LoginDTO dto, RedirectAttributes rttrs, Model model) throws ControllerException{
		log.trace("loginPost({},{},{}) invoked",dto,rttrs, model);
		
		try{
			UserVO vo = this.service.login(dto);
				log.info("\t+vo:{}", vo);
				
				if(vo !=null) { //if 인증성공
					//인증성공하면 model 상자안에 넣어서 보내야한다.
					//얘를 인증정보로 올려야한다. 
					
					model.addAttribute("__AUTH__", vo);//AuthinterCEptor의 __AUTH__와 동일하게
					
					return null;	//메인화면
				} else{			//if 인증실패
					rttrs.addAttribute("result", "Login Failed");//결과를 임시상자에 넣기
					//result라는 query string에 들어갈 전송파라미터(공유속성..은아님) 이름으로 
					return "redirect:/user/login";//인증실패결과와 함께 로그인화면으로 다시 밀어버림
					
				}//if-else
				
		}catch(Exception e) {
			throw new ControllerException(e);
		}//try-catch
	}//loginPost
	
	
	//LogoutInterceptor 가 로우아웃요청(/user/logout)을 가로채서(preHandle),
	//인터셉터에서 로그아웃처리완료(세션객체 파괴), 요청을 이 핸들러 메소드로
//	보내지않는다.
	//로그아웃처리하고나면 home으로 가든 or 다시 로그인처리로 가든
//	>>따라서 logout.jsp는 필요없는 것.
	@GetMapping("/logout")
	public void dummylogout(SessionStatus sessionStatus) {
		log.trace("dummylogout() invoked" );
		
		/*
				log.trace("sessionStatus:{} ", sessionStatus);
		sessionStatus.setComplete(); //현재의 웹브라우저에 대응되는 세션객체(금고상자) 파괴
		 * */
	}//dummylogout
}//LoginControlle

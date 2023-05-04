package org.zerock.myapp.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@Component

// 게시판도 list 는 인증 필요없 볼수 있지만 CRUD를 진행할 경우 인증이 필요하다..
// 인증(Authentication) 을 전반적으로 수행하는 역활
public class AuthIntercepter implements HandlerInterceptor {

	
	// 가로챈 모든 게시판CRUD, List Request URI에 대해서 요청을 보낸 웹브라우저가 현재 싯점에 인증된 상태인지 
	// 아닌지를 체크해서 인증된 회원만이 접근 할 수 있는 화면과 그렇지 않은 비회원도 접근 가능한 화면
	// 요청에 대한 접근제어(Access Control) 수행한다.
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		log.info("preHandle(req, res, {}) invoked", handler);
		
		
		HttpSession session = req.getSession(false); // 
		if(session == null) { // 인증되지 않았다면(값이 null 이라면)
			res.sendRedirect("/user/login");
			
			return false; // 뒤로 넘기지 않는다.
		} // if
		
		// 세션(Session Scope 공유영역)에 미리 약속된 인증공통 속성이 있는지 확인하다.
		Object auth = session.getAttribute("__AUTH__");
		if(auth == null) { // 인증공통속성이 없다면 => 로그인 하지 않았다면
			res.sendRedirect("/user/login");  // // 미인증 상태임 => 로그인 창으로 밀어버린다.
			
			return false;  // 요청을 뒤로(Controller)로 넘기지 않는다
		} // if 
		
		// 인증된 웹 브라우저인 경우(=로그인 하고 왔다... 이미 로그인이 되어 있는 상태이다)
		return true; // 요청을 뒤로(Controller)로 보낸다. 
	} // preHandle


	
} // end class

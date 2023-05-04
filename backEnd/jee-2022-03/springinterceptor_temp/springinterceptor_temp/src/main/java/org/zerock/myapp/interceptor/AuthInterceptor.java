package org.zerock.myapp.interceptor;

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
//게시판도 list는 인증 필요없이 볼 수 있지만 CRUD를 진행할 경우 인증이 필요하다. 
//인증(Authentication)을 전반적으로 수행하는 역할 
public class AuthInterceptor implements HandlerInterceptor {

	//가로챈 모든 게시판CRUD, LIST request uri 에 대해서 요청을 보낸 웹브라우저가 현재 시점에 
	//인증된 상태인지 아닌지를체크해서 인증된 회원만이 접근할 수 있는 화면과
	//그렇지 않은 비회원도 접근가능한 화면 요청에 대한 접근제어(access control) 수행 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.trace("preHandle(request,response,{}) invoekd", handler);
		
		HttpSession session = request.getSession(false);
		if(session==null) { //인증되지 않았다면 ( 값이 null 이라면 ) 
			response.sendRedirect("/user/login");
			return false;
		}//if
		
		//세션 공유 영역(Session Scope 공유 영역)에 미리 약속된 인증공통속성이 있는지를 확인한다.
		
		Object auth = session.getAttribute("__AUTH__"); //USerVO가 있느냐 없느냐
		
		if(auth==null) {// 인증공통속성이 없다면 > 로그인하지 않았다면
			response.sendRedirect("/user/login"); //미인증상태 = > 로그인 창으로 밀어버린다. 
			
			return false;			//요청을 뒤로 (Controller)로 넘기지 않는다. 
		}//if 
		
		//인증된 웹 브라우저인 경우(=로그인 하고 옴,이미 로그인 되어 있는 상태) 사용자, 인된 웹브라우저인 경우(=로그인 되어있는 상태 )
		return true; //요청을 뒤로 (Controller)로 보낸다. 
	}//preHandle

}//end class

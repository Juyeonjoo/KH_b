package org.zerock.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.myapp.domain.UserVO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Component
public class LogoutInterceptor implements HandlerInterceptor{
	
	////로그인 시도하는, LogoutInterceptor가 무엇을 가로챌것이냐
	//Target of LoginInterceptor: /user/loginPost(로그아웃 처리)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	//전처리
		
		log.trace("============================================");
		log.trace("preHandle(request, response, handler" );
		log.trace("============================================");
		
		//Step.1 현재 요청을 보낸 웹브라우저에 대한 세션 획득
		HttpSession session = request.getSession(false);
		//로그아웃요청을보냈다는 것은 이미 세션이있다는 것이잖아
//		그래서 기존 session 만 획득하는것. 
//		(새로운 세션만들면 안되기 때문에 false)
		
		//Step.2 세션객체(금고상자) 자체를 파괴시킴
//				파괴시키면, 세션객체(금고상자)안에 있었던 모든 공유속성은
//		삭제 발생

		session.invalidate();
		log.info("\t+ 세션객체 파괴완료");
		
		//Step.3 세션파괴 후, 홈 또는 로그인 화면으로 강제 이동시킴
		response.sendRedirect("/user/login");
		//뒤로보내지 않지만 home으로 가든, login창으로 우리에겐 home이 없으니 login창으로
		
		//Step.4 이미 Step3에서 웹 브라우저를 로그인창으로 강제 이동시켰으니
		//			원래의 요청은 컨트롤러로 보내지 않음(보낼 필요 없음)
		//로그아웃처리기때문에 요청을 컨트롤러 핸들러로 보내지 않음
		return false; //뒤로보내지않음 그래서 post controller도 필요없음.
	}


	
}//end class

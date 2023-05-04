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
public class LoginInterceptor implements HandlerInterceptor{
	
	////로그인 시도하는, login interceptor가 무엇을 가로챌것이냐
	//Target of LoginInterceptor: /user/loginPost(로그인 처리)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	//전처리
		
		log.trace("============================================");
		log.trace("preHandle(request, response, handler" );
		log.trace("============================================");
		
		//Step.1 현재 요청을 보낸 웹브라우저에 대한 세션 획득
		HttpSession session = request.getSession();
		
		//Step.2 획득한 세션 영역(Session Scope, 금고상자)에 "__AUTH__"이름으로
//		UserVO객체가 있으면 삭제시켜라
		//삭제시키지 않으면 다시 로그인해도 바뀌질 않아서 interceptor로 사전처리
		
		Object auth = session.getAttribute("__AUTH__");
		
		log.info("\t+auth:{}", auth);
		if(auth !=null) {
			session.removeAttribute("__AUTH__");		//금고상자에서 미리약속된인증객체삭제
			log.info("\t+ 세션영역에서, 인증객체 (__AUTH_) 삭제 완료");
		}//if
		
		return true;
	}

	//아직 응답이 생성 및 전송되기 직전에 수행
	//단, 컨트롤러의 핸들러메소드에서 예외가 발생하면 수행안됨
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		log.trace("============================================");
		log.trace("postHandle(request, response, handler, modelAndView" );
		log.trace("============================================");
		
		log.info("modelAndView", modelAndView);
		
		//Step.1 모델에서 얻은 새로운 __AUTH__란 이름으로 저장된 UserVO객체 획득
		ModelMap modelMap = modelAndView.getModelMap();
		UserVO userVO = (UserVO)modelMap.get("__AUTH__");
		
		log.info("\t+userVO:{}", userVO);
		//Step.2 새로이 획득한 __AUTH__(UserVO)인증객체를 현재웹브라우저의 세션영역(금고상자)에 넣는다.
		if(userVO !=null) { //인증에 성공한 현재의 웹브라우저의 새로운 인증객체를 세션영역에 저장
			HttpSession session = request.getSession();//없으면 만들고 있으면 재사용
		
			//Step2-1. 인증에 성공한 현재의 웹브라우저의 새로운 인증객체를 세션영역에 저장
			session.setAttribute("__AUTH__", userVO);//인증객체저장성공
			log.info("\t+3. 세션영역에 새로운 인증객체 저장 성공");
		}//if
	}//preHandle
	
	
	
}//end class

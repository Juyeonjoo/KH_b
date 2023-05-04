package org.zerock.myapp.intercepter;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.Inet4Address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor


@Component
public class SampleIntercepter implements  HandlerInterceptor  { // intercepter는 POJO로 만들수 없다(반드시  HandlerInterceptor를 implements를 받는다)

	// HTTP Request가 해당 Controller의 Handler 메소드에게 위임(전달) 되기 직전에 자동으로 Callback 된다.
	@Override  // 전처리(Controller Handler 요청전 가로채서 처리한다, 무조건 성공한다.)
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		log.trace("==========================================================================");
		log.trace("preHandle(req, res,{}) invoked", handler );
		log.trace("==========================================================================");
		
		HandlerMethod controllHandler = (HandlerMethod) handler;
		Object controller = controllHandler.getBean();
		Method method = controllHandler.getMethod();
		
		log.trace("\t controller : {}, type : {}", controller,  controller.getClass().getName());
		log.trace("\t method : {}, type : {}", method,  method.getClass().getName());
		
		
//		// 인증체크
//		HttpSession session = req.getSession(false);
//		if(session == null) { // 세션 자체가 없으니 인증정보도 없다 => 로그인 창으로 밀어버린다.
//			res.sendRedirect("/login");
//			
//			return false;  // 요청을 뒤로 넘겨셔는 안된다..(****)
//		} else { //세션은 있는데 세션스쿱 공유영역에 미리 약속된 인증데이터가 없을 때
//			String authKey = "__AUTH__";
//			Object auth = session.getAttribute(authKey);
//			
//			if (auth== null) {
//				res.sendRedirect("/login");  // 미인증 상태임 => 로그인 창으로 밀어버린다.
//				return false;
//			}
//		}
		
		//현재 호스트의 IP 주소를 나타내는 Inet4Address 객체를 반환
		String hostAddr =  Inet4Address.getLocalHost().getHostAddress();
		log.info("\t hostAddr : {}", hostAddr);
		
		//return 값에 의해서 interceptor chain 또는 컨트롤러의 핸들러에게 
//		가로챈 요청을 넘기게 된다.
		
//		return true; // 그 다음으로 넘김
//		return false; //그 다음으로 넘기지 않고 여기서 응답으로 처리 
		
		// 1. 접근제한을 해보자!!!
		String requstURL = req.getRequestURL().toString();
		
		HttpSession session = req.getSession(false);
		String sessionId =  (session != null)? session.getId() : "NO null";
		String remoteAddr = req.getRemoteAddr();
		
		if("192.168.110.16".equals(hostAddr)) { // 블랙리스트 IP주소에 해당한다면...
			res.setCharacterEncoding("utf8");
			res.setContentType("text/xml; charset=utf8");
			
			PrintWriter out = res.getWriter();
			out.print("<h2>Access Denied.</h2>");
			out.print("<h3>1. requstURL :" + requstURL + "</h3>");
			out.print("<h3>2. sessionId :" + sessionId + "</h3>");
			out.print("<h3>3. remoteAddr :" + remoteAddr + "</h3>");
		
			
			out.flush();
			
			return false;
		} // if
		
		
		
		//Controller Handler에서 예외가 발생하면 호출이 되지 않는다
		// return 값에 의해서 intercepter chain 또는 컨트롤러의 핸들러에게 가로챈 요청을 넘기게 된다.
		return true;  // 그 다음으로 넘긴다(위임, 전달).
//		return false; // 그 다음으로 넘기지 않고, 여기서 응답으로 보내서 끝낸다.
	} // preHandle

	
	// Controller Handler 메소드가 위임받은 HTTP request를 처리 완료하여 Model과 View 이름을 반환한 
	// 직후에 (그리고 아직까지 View는 호출되기 전이다..
	// 자동으로 Callback (*** 주의 *** : View 는 아직 호출되지 않았다.)
	// Controller Handler에서 예외가 발생하면 Callback 되지 않는다.
	@Override  // 후처리 (Controller Handler에서 예외가 발생하면 호출이 되지 않는다.)
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.trace("==========================================================================");
		log.trace("postHandle(req, res, {}, {}) invoked", handler, modelAndView);
		log.trace("==========================================================================");
		
		log.info("\t handler type : {}", handler.getClass().getName());;
	} // postHandle

	
	// View(JSP) 까지 호출완료되어 HTTP response가 전송완료된 직후에 Callback
	// *** 주의 *** : Controller Handler 메소드에서 예외가 발생하든 아니든 무조건 호출된다.
	@Override // 응답이 나간 이후에 처리가 할 것이 있다면 하라는 것, Controller handler에서 예외가 발생하든 아니든 무조건 호출한다.
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception e)
			throws Exception {
		log.trace("==========================================================================");
		log.trace("afterCompletion(req, res, {}, e) invoked", handler, e);  
		log.trace("==========================================================================");
		//==========================================================================
		
	} // afterCompletion

} // end class

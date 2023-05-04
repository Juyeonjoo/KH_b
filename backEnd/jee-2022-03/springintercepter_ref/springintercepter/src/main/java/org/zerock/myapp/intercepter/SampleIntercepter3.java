package org.zerock.myapp.intercepter;

import java.io.PrintWriter;
import java.lang.reflect.Method;

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
public class SampleIntercepter3 implements  HandlerInterceptor  { 

	
	@Override 
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
		

		String remoteAddr = req.getRemoteAddr();
		log.info("\t remoteAddr : {}", remoteAddr);
		

		return true; 

	} // preHandle

	@Override  
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.trace("==========================================================================");
		log.trace("postHandle(req, res, {}, {}) invoked", handler, modelAndView);
		log.trace("==========================================================================");
		
		log.info("\t handler type : {}", handler.getClass().getName());;
	} // postHandle


	@Override 
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception e)
			throws Exception {
		log.trace("==========================================================================");
		log.trace("afterCompletion(req, res, {}, e) invoked", handler, e);  
		log.trace("==========================================================================");
		//==========================================================================
		
	} // afterCompletion

} // end class

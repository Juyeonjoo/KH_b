package org.zerock.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor


public class SampleInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		log.trace("preHandle(req, res, handler:{}) invoked.", handler);
		return false;
	}//preHandle

	@Override
	public void postHandle(
			HttpServletRequest req, HttpServletResponse res, 
			Object handler, ModelAndView modelAndView) throws Exception {
		log.trace("preHandle(req, res, handler:{}, modelAndView:{}) invoked.", handler, modelAndView );
	
	}//postHandle

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception e)
			throws Exception {
		log.trace("preHandle(req, res, handler:{}, {}) invoked.", handler, e);
	}//afterCompletion

}//end class

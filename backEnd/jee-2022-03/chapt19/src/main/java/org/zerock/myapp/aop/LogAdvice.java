package org.zerock.myapp.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor


@Aspect
//모든 Advice 구현객체도 Beans Contatiner에 Bean을 등록되어야 한다.
@Component
public class LogAdvice {

//	@Before("execution(* org.zerock.myapp.service.*Service.plus(String, String))&&args(num1, num2)")
//	public void logBefore(String num1, String num2) {//ok
	
	//Target객체 JoinPoint수행 직전에 적용되는 Advice
	@Before("execution(* org.zerock.myapp.service.*Service.*(..))") 	//ok
	public void beforeAdvice() {
		log.trace("************************************");
		log.trace("1. beforeAdvice() invoked: @Before");
		log.trace("************************************");
	}//beforeAdvice()
	
	
	//Target객체의 JoinPoint 수행이 성공적으로 끝난 직후에 적용되는 Advice
	@AfterReturning(
			pointcut="execution( * org.zerock.myapp.service.*Service.*(..))",
			returning="result"
			)  //joinpoint가 정상수행되고 return된 후에 적용되는 advice
	public void afterReturningAdvice(Object result) {
		log.trace("************************************");
		log.trace("2. afterReturningAdvice({}) invoked: @AfterReturning ", result);
		log.trace("************************************");
	}//afterReturningAdvice()
	
	
	//3. Target객체의 JoinPoint 수행 중, 오류 (예외)발생 직후 적용되는 Advice
	@AfterThrowing(
			pointcut="execution( * org.zerock.myapp.service.*Service.*(..))",
			throwing="e"
			)
	public void afterThrowingAdvice(Exception e) {
		log.trace("************************************");
		log.trace("3. afterThrowingAdvice({}) invoked: @AfterThrowing ", e);
		log.trace("************************************");
	}//afterThrowingAdvice
	
	
	//4. Target 객체의 JoinPoint에서 예외가 발생하든/안하든 상관없이 무조건 적용되는 Advice
	@After("execution( * org.zerock.myapp.service.*Service.*(..))")
	public void afterAdvice() {
		log.trace("************************************");
		log.trace("4. afterAdvice({}) invoked: @After ");
		log.trace("************************************");
	}//afterAdvice() 
	
	//5. Target객체의 JoinPoint 수행직전 그리고 수행직후 모두에 적용되는 Advice
	//이렇게 Advice 를 적용하려면 한 가지 조건이 필요하다.
//	즉, Target객체의 해당 JoinPoint를 직접 제어(=직접 실행과 동일한 말)
	@Around("execution( * org.zerock.myapp.service.*Service.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable  {
		log.trace("************************************");
		log.trace("5. aroundAdvice({}) invoked: @Around ", pjp);
		log.trace("************************************");
		
		
		Object target = pjp.getTarget();
		Signature signature = pjp.getSignature();
		Object[] args = pjp.getArgs();
		SourceLocation sourceLocation = pjp.getSourceLocation();
		StaticPart staticPart =pjp.getStaticPart();
		Object thisObj = pjp.getThis();
		
		log.info("\t+1. target:{}", target);
		log.info("\t+2. signature:{}", signature);
		log.info("\t+3. args:{}", Arrays.deepToString(args));
		log.info("\t+4. sourceLocation:{}", sourceLocation);
		log.info("\t+5. staticPart:{}", staticPart);
		log.info("\t+6. thisObj:{}", thisObj);
		
		long start = System.nanoTime();		//JoinPoint 실행전 시간 측정
		
		Object result = pjp.proceed();		//Target객체의 JoinPoint를 실행시키는 메소드
	
		long end = System.nanoTime();		//JoinPoint 실행 직후 시간 측정
		
		
		log.info("\t>>>>>>>>>>>>>>>>>>Elapsed time(ns): {}", (end- start), "ns. "); //nano second 10억분의1
		log.info("\t>>>>>>>>>>>>>>>>>>Elapsed time(secs): {}", (end- start)/Math.pow(10.0, 9.0), "secs. ");//초당, nano sec의 10억분의 9승?
		
		return result;
	}//aroundAdvice
}//end class

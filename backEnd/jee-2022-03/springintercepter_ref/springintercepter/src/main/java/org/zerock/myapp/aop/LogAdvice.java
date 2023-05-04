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
@Component  // Bean으로 등록
public class LogAdvice {

	// Target의 JoinPoint(메소드의 실행 시점, *(..) )를 호출하기 전에 실행되는 코드입니다. 코드의 실행 자체에는 관여할 수 없습니다.
//	@Before("execution(* org.zerock.myapp.service.*Service.*(..))")
//	public void beforeAdvice() {
	@Before("execution(* org.zerock.myapp.service.*Service.plus(String,String) ) && args(num1, num2)")
	public void beforeAdvice(String num1, String num2) {
		log.info("******************************************************");
		log.info("1. beforeAdvice_({}, {}) invoked", num1, num2);
		log.info("******************************************************");
		
	} // beforeAdvice
		

	// 모든 실행이 정상적으로 이루어진 후에 동작하는 코드입니다. (Target 객체의 joinpoint 수행이 끝난 직후에 적용되는 Advice)
	// After Returning Advice        
//	접근제한자		package			  ~Service클래스.확장자.메소드(파라미터)	
//		* 		org.zerock.myapp.service.*Service.*(..)					
//	returning = "result" => 반환하고자 하는 파라미터 변수명 입력
//	@AfterReturning(value = "execution(* org.zerock.myapp.service.*Service.*(..))", returning = "result")
	@AfterReturning(pointcut = "execution(* org.zerock.myapp.service.*Service.*(..))", returning = "result")
	public void afterReturning(Object result) { //
		log.info("******************************************************");
		log.info("2. afterReturning_({}) invoked", result);
		log.info("******************************************************");
	} // afterReturning
	
	
	//예외가 발생한 뒤에 동작하는 코드입니다. (Target 객체의 joinPoint 수행 중 오류(예외) 발생 직후에 적용되는 Advice
	//After Throwing Advice
//	throwing = "e" => 오류발생 후 Exception 변수명을 입력
//	@AfterThrowing("execution(* org.zerock.myapp.service.*Service.*(..))")
	@AfterThrowing(pointcut ="execution(* org.zerock.myapp.service.*Service.*(..))", throwing="e")
	public void afterThrowing(Exception e) {
		log.info("=======================================================");
		log.info("3. afterThrowing_({}) invoked", e);
		log.info("=======================================================");
	} // afterThrowing
	
	
	
	// 정상적으로 실행되거나 예외가 발생했을 때 구분 없이 실행되는 코드입니다.(Target 객체의 joinpoint에서 예외가 발생 상관없이 무조건 적용되는 Advice
	// After Advice
	@After(value ="execution(* org.zerock.myapp.service.*Service.*(..))")
	public void after() {
		log.info("******************************************************");
		log.info("4. after_() invoked");
		log.info("******************************************************");
	} // after
	
	
	
	// Target 객체의 joinpoint에서 수행직전 그리고 수행직후 모두 적용되는 Advice
	// 이렇게 Advice를 적용하려면 한가지 조건이 필요하다.. 즉, Target 객체의 해당 JoinPoint를 직접 젝어(=직접실행과 동일한 말) 
	// Around Advice : try-catch(개발자가 직접 오류 처리) 하지 말고 throws Throwable 처리하도록 한다.(그래야 호출자가 오류난것을 알 수 있기 때문이다)
	@Around(value ="execution(* org.zerock.myapp.service.*Service.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable  {
		log.info("******************************************************");
		log.info("5. aroundAdvice({}) invoked", pjp);
		log.info("******************************************************");
		
		Object target = pjp.getTarget();
		Signature signature = pjp.getSignature();
		Object[] args = pjp.getArgs();
		SourceLocation sourceLocation = pjp.getSourceLocation();
		StaticPart staticPart = pjp.getStaticPart();
		Object objthis = pjp.getThis();
		
		log.info("\t 1. target : {}", target);			// org.zerock.myapp.service.SampleServiceImpl@614aeccc
		log.info("\t 2. signature : {}", signature);	// Integer org.zerock.myapp.service.SampleService.plus(String,String)
		log.info("\t 3. args : {}", Arrays.toString(args));		// [600, 300]
		log.info("\t 4. sourceLocation : {}", sourceLocation);  // org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint$SourceLocationImpl@79ab34c1
		log.info("\t 5. staticPart : {}", staticPart);	//  execution(Integer org.zerock.myapp.service.SampleService.plus(String,String))
		log.info("\t 6. objthis : {}", objthis);  // org.zerock.myapp.service.SampleServiceImpl@614aeccc
		
		long start = System.nanoTime();   // JoinPoint 실행전 시간측정
		
		// Target 객체의 JoinPoint 실행시킴
		Object result = pjp.proceed();
		log.info("\t == result : {}", result);
		
		long end = System.nanoTime(); // JoinPoint 실행 후 시간 측정
		
		log.info("\t >>> Elapsed time(ns): {}", (end - start), "ns.");
		log.info("\t >>> Elapsed time(secs): {}", (end-start) / Math.pow(10.0, 9.0), "secs");
		
		return result;
	} // aroundAdvice
	
	
} // end class

package org.zerock.myapp.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.myapp.domain.BoardVO;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {
		//file:src/main/webapp/spring/**/*.xml"
		"file:src/main/webapp/**/spring/root-*.xml",
		"file:src/main/webapp/**/spring/**/servlet-*.xml"
		}
		)


//Spring MVC 까지 작동(=>결과적으로 Spring core인, 
//Spring Beans Container까지 생성함) 시키는 어노테이션으로,
//표현계층의 컨트롤러 핸들러메소드 테스트 할때에
//반드시넣어주여야 하는 어노테이션******
@WebAppConfiguration //spring MVC가 작동한다.

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardControllerTests {
	
	//다른 계층처럼 빈 주입하기 위해서 아래와 같이 하면 안됨
//	@Setter(onMethod_= {@Autowired})// controller에서는 이거안씀
//	private BoardController controller;

	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;//Spring beans container 의 구현객체*******
	
	//가상의 Spring MVC를 테스트해주는 POSTMAN과 비슷한 역할을 수행
//	이 타입의 객체를 통해서 실질적으로 컨트롤러의 핸들러 메소드 테스트를 수행
//	private MockMvc mockMvc; //MVC 환경을 mockup한다. 진짜처럼 꾸며놓고 얘를 통해서 테스트해보자
	
	//전처리작업
	@BeforeAll
	void beforeAll() { //1회성 전처리 수행
		log.trace("beforeAll() invoked.");
		
		//의존성 주입(DI) 확인
		assertNotNull(this.ctx);
		log.info("\t+this.ctx:{}", this.ctx);
	}//beforeAll()
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("testList")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testList() throws Exception {
		log.trace("testList() invoked.");
		
		//MockMvc를 지어줄 "건설사(Builder)"부터 획득
		DefaultMockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();
		
		//BoardController의 /board/list, GET핸들러 테스트
		//상위타입인 requestBuilder를 타입으로 가짐
		MockHttpServletRequestBuilder reqeustBuilder = MockMvcRequestBuilders.get("/board/list");
		reqeustBuilder.param("currPage", "2");
		reqeustBuilder.param("amount", "20");
		
		//이제 가상의 MVC 환경에서, BoardController에 요청생성 및 전송
		@Cleanup("clear")
//		ModelMap modelMap = mockMvc.perform(reqeustBuilder).andReturn().getModelAndView().getModelMap(); //요청이 날라간다.
		//날라가는 두 가지 뷰이름과 model 중에 modelMap만 얻기
		ModelAndView modelAndView = mockMvc.perform(reqeustBuilder).andReturn().getModelAndView();
		log.info("\t+modelAndView:{}, type:{}", modelAndView.getViewName(),modelAndView.getClass().getName());
		
		//테스트 대상 컨트롤러 핸들러(메소드) 가 반환한 (1)모델 (2)뷰이름 중에
//		모델(ModelMap)을 얻었으니, 순회하여 그 안의 모든 모델 속성(즉, 비즈니스데이터인
//		모델 객체들) 출력

//		log.info("\t+modelMap:{}", modelMap);
		
	}//testList()

//	@Disabled
	@Test
	@Order(2)
	@DisplayName("testGet")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testGet() throws Exception {
		log.trace("testGet() invoked.");

		DefaultMockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();

//		RequestBuilder reqeustBuilder = MockMvcRequestBuilders.get("/board/get").param("bno", "200");
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/board/get");
		requestBuilder.param("bno","33"); //전송파라미터를 가지고 있는 reqeust 를 perform에 넣어주면
		
//		@Cleanup("clear") //Map 컬렉션이 아니라 필요없다?
		ModelAndView modelAndView = mockMvc.perform(requestBuilder).andReturn().getModelAndView();
		log.info("\t+viewName:{}, type:{}", modelAndView.getViewName(),modelAndView.getClass().getName());

	}//testGet()
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("testRemove")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testRemove() throws Exception {
		log.trace("testRemove() invoked.");

		DefaultMockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();

//		RequestBuilder reqeustBuilder = MockMvcRequestBuilders.post("/board/remove").param("bno", "200");
		MockHttpServletRequestBuilder reqeustBuilder = MockMvcRequestBuilders.post("/board/remove");
		reqeustBuilder.param("bno","300");
		
		@Cleanup("clear")
		ModelAndView modelAndView = mockMvc.perform(reqeustBuilder).andReturn().getModelAndView();
		log.info("\t+modelAndView:{}, type:{}", modelAndView.getViewName(),modelAndView.getClass().getName());

	}//testRemove()


//	@Disabled
	@Test
	@Order(4)
	@DisplayName("testModify")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testModify() throws Exception {
		log.trace("testModify() invoked.");

		DefaultMockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();

		//Step1. bno 304게시글을 상세히 조회
		MockHttpServletRequestBuilder reqeustBuilder = MockMvcRequestBuilders.get("/board/get");
		reqeustBuilder.param("bno", "304");
		
		//이제 가상의 MVC 환경에서 BoardController에 요청생성 및 전송
		@Cleanup("clear")
		ModelAndView modelAndView = 
				mockMvc.
					perform(reqeustBuilder).
					andReturn().
					getModelAndView();
		log.info("\t+modelAndView:{}, type:{}", modelAndView.getViewName(),modelAndView.getClass().getName());

		ModelMap model = modelAndView.getModelMap();
		log.info("\t+model:{}, type:{}", model, model.getClass().getName());
	
		BoardVO vo = (BoardVO) model.getAttribute("board");
		
		assertNotNull(vo);
		log.info("\t+vo:{}", vo);
		
		//step2. 304 bno 게시글 수정
		Integer bno = vo.getBno();
//		String title = vo.getTitle();
//		String content = vo.getContent();
		String writer = vo.getWriter();
		
		reqeustBuilder = MockMvcRequestBuilders.post("/board/modify");
		reqeustBuilder.param("bno", bno.toString());
		reqeustBuilder.param("title", "NEW_TITLE"); //수정항목1
		reqeustBuilder.param("content", "NEW_CONTENT"); //수정항목2
		reqeustBuilder.param("writer", writer);
		
		//가상의 MVC 환경에서, BoardController에 요청생성 및 전송
//		@Cleanup("clear")
		modelAndView = 
				mockMvc.
					perform(reqeustBuilder).
					andReturn().
					getModelAndView();
		
	}//testModify()
	

//	@Disabled
	@Test
	@Order(5)
	@DisplayName("testRegister")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testRegister() throws Exception {
		log.trace("testRegister() invoked.");

		DefaultMockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();

		MockHttpServletRequestBuilder reqeustBuilder = MockMvcRequestBuilders.post("/board/register");
		reqeustBuilder.param("title","200");
		reqeustBuilder.param("content","200");
		reqeustBuilder.param("writer","200");

		@Cleanup("clear")
		ModelAndView modelAndView = mockMvc.perform(reqeustBuilder).andReturn().getModelAndView();
		log.info("\t+modelAndView:{}, type:{}", modelAndView.getViewName(),modelAndView.getClass().getName());

	}//testRegister()
	

//	@Disabled
	@Test
	@Order(6)
	@DisplayName("testRegisterByget") 
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testRegisterByget() throws Exception {
		//단순 화면띄우는 view Controller>model만들지 못한다.
		
		log.trace("testRegisterByget() invoked.");

		DefaultMockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();

		MockHttpServletRequestBuilder reqeustBuilder = MockMvcRequestBuilders.get("/board/register");

		ModelAndView modelAndView = 
				mockMvc.
				perform(reqeustBuilder).
				andReturn().
				getModelAndView();
		
		log.info("\t+modelAndView:{}", modelAndView);

	}//testRegisterByget()
	
//	@Disabled
	@Test
	@Order(7)
	@DisplayName("testModifyByget") 
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testModifyByget() throws Exception {
		//단순 화면띄우는 view Controller>model만들지 못한다.
		
		log.trace("testModifyByget() invoked.");

		DefaultMockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();

		//MockHttpServletRequestBuilder로 받아야지 Param메소드를 쓸 수 있다.
		MockHttpServletRequestBuilder reqeustBuilder = MockMvcRequestBuilders.get("/board/modify");
		reqeustBuilder.param("bno", "33");
		
		ModelAndView modelAndView = 
				mockMvc.
				perform(reqeustBuilder).
				andReturn().
				getModelAndView();
		
		log.info("\t+modelAndView:{}", modelAndView);

	}//testModifyByget()
	
}//end class

package org.zerock.myapp.service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.DAOException;
import org.zerock.myapp.exception.ServiceException;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2

//Junit test class는 무조건 반드시 매개변수없는 기본생성자가 있어야 한다(대전제)
//@AllArgsConstructor //xxx. Junit에서는 용납되지 않음
@NoArgsConstructor

//To run spring framework for Junit v4
//@RunWith(SpringRunner.class)			// option1
//@RunWith(SpringJUnit4ClassRunner.class)// option2(option1을 쓰지 않는다면)

// To run spring framework for Junit v5
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTests {
	
	@Inject
	private UserService userService;
	
	@BeforeAll
	void beforeAll() {//1회성 전처리
		log.trace("beforeAll() invoked.");
		
		assert this.userService !=null;
		log.info("\t+this.userService:{}", this.userService);
		
	}//beforeAll
	
	@Test
	@Order(1)
	@DisplayName("login")
	@Timeout(value=2,unit=TimeUnit.SECONDS)
	void login() throws DAOException, ServiceException {
		log.trace("login() invoked.");
		
		LoginDTO dto = new LoginDTO();
		dto.setUserid("USER_1");
		dto.setUserpw("PASS_1");
		dto.setRememberMe(false);

		UserVO vo = this.userService.login(dto);
		
		Objects.requireNonNull(vo);
		log.info("\t+vo :{}", vo);
		
	}//login()
}//end class

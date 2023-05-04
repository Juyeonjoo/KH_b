package org.zerock.myapp.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Objects;
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
import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.DAOException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

//To run spring framework for Junit v4
//@RunWith(SpringRunner.class)			// option1
//@RunWith(SpringJUnit4ClassRunner.class)// option2(option1을 쓰지 않는다면)

// To run spring framework for Junit v5
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTests {
	
	@Setter(onMethod_= {@Autowired})
	private UserDAO dao;
	
	@BeforeAll
	void beforeAll() {//1회성 전처리
		log.trace("beforeAll() invoked.");
		
		assertNotNull(dao);
		log.info("\t+dao:{}, try:{}", dao, dao.getClass().getName());
		
	}//beforeAll
	
	@Test
	@Order(1)
	@DisplayName("selectUser")
	@Timeout(value=1,unit=TimeUnit.SECONDS)
	void selectUser() throws DAOException {
		log.trace("selectUser() invoked.");
		
		LoginDTO dto = new LoginDTO();
		dto.setUserid("USER_1");
		dto.setUserpw("PASS_1");
		dto.setRememberMe(false);
		
		UserVO vo = this.dao.selectUser(dto);
		
		Objects.requireNonNull(vo);
		log.info("\t+vo :{}", vo);
		
	}//selectUser()
}//end class

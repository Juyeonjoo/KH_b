package org.zerock.myapp.di;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;


@Data
@Log4j2
@AllArgsConstructor


@Component("Restaurant")
public class Restaurant implements InitializingBean, DisposableBean { //POJO
	
	
	
	// 빈 객체가 생성/파괴되는 모습을 모니터링하고싶다면 POJO를 포기하면 된다.
//	@Resource(type=Chef.class)
//	@Resource
//	@Inject
	
	//테스트 3: Setter 메소드를 통한 묵시적 의존성 주입 테스트 #2
//	@Setter(onMethod_= { @Autowired })
//	@Setter(onMethod_= { @Inject })
//	@Setter(onMethod_= { @Resource })
//	@Setter(onMethod_= { @Resource(type=Chef.class) })
	
//	@Autowired				//주입시그널 보내는 어노테이션 
	private Chef chef;
	
	/*
	//테스트 1: 생성자를 통한 명시적 의존성 주입 테스트
	public Restaurant(@Autowired Chef chef) {
		log.trace("**************Restaurant({})invoked", chef);
		
		this.chef = chef;
	}//constructor
	*/
	

	//테스트 2: Setter 메소드를 통한 명시적 의존성 주입 테스트
//	@Autowired
//	public void setChef(Chef chef) {
//		log.trace("**************setChef({})invoked", chef);
//		this.chef = chef;

//	} // setChef
	
//	========================= InitializingBean, DisposableBean================
	
	@Override
	public void destroy() throws Exception {
		log.trace("destroy() invoked.");
		
	}//destroy

	@Override
	public void afterPropertiesSet() throws Exception {
	
		log.trace("afterPropertiesSet() invoked.");
		
	}//afterPropertiesSet
	
}//end class
	


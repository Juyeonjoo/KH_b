package org.zerock.myapp.di;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@ToString

@Component("Chef")
public class Chef  implements InitializingBean, DisposableBean { //POJO
	
	@Override
	public void destroy() throws Exception {
		log.trace("destroy() invoked.");
		
	}//destroy

	@Override
	public void afterPropertiesSet() throws Exception {
	
		log.trace("afterPropertiesSet() invoked.");
		
	}//afterPropertiesSet
	
	
}//end class

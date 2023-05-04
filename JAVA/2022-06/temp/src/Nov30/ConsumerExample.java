package Nov30;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConsumerExample {

	
	public static void main(String[] args) {
		
		Consumer<String> consumer = t -> log.info(t + "8");
		consumer.accept("java");
		
		BiConsumer<String, String> bigConsumer = (t,u) -> log.info(t + u);
		bigConsumer.accept("java", "8");
		
		DoubleConsumer doubleConsumer = d -> log.info("Java"+ d);
		doubleConsumer.accept(8.0);
		
		ObjIntConsumer<String> objIntConsumer = (t, i)->log.info(t+i);
		objIntConsumer.accept("java", 8);
		
	}//main
}//end class

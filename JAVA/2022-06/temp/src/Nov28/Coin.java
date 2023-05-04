package Nov28;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@ToString
@Log4j2
@AllArgsConstructor
public class Coin {

	@Getter(lombok.AccessLevel.PUBLIC)
	private int value;

}//end class

package bicycle;

public class PedalExample {
	public static void main(String[] args) {
		Pedal pedal = new Pedal(true, "뒤");	//전달인자 값: isStep, direction

		pedal.step();
		pedal.run(60);							//전달인자 값: cadence

	} //main
} //end class

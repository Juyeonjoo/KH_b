package Bicycle02;


public class KumhoHandleBar extends HandleBar{

	private Bicycle bicycle;

	public KumhoHandleBar() {
		;;
	}//default constructor

	@Override
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
		
		System.out.println("KumhoHandleBar::setBicycle(bicycle) invoked.");
	} //setBicycle

	@Override
	public void turnLeft(Bicycle bicycle) {
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.LEFT);
		
		System.out.println("KumhoHandleBar::turnLeft() invoked.");
	} 	//turnLeft()

	@Override
	public void turnRight(Bicycle bicycle){
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.RIGHT);
		
		System.out.println("KumhoHandleBar::turnRight() invoked.");
	} // turnRight()

	@Override
	public void go(Bicycle bicycle) {
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.GO);
		
		System.out.println("KumhoHandleBar::Go() invoked.");
	} 	//goAhead()



} // end class



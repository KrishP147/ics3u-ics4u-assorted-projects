public class Polymorphism {

	public static void main(String[] args) {
		
		// polymorphism = 	greek word for poly-"many", morph-"form"
		//					The ability of an object to identify as more than one type
		
		Car4 car = new Car4();
		Bicycle bicycle = new Bicycle();
		Boat boat = new Boat();
		
		Vehicle[] racers = {car,bicycle,boat};
		
		for(Vehicle x : racers) {
			x.go();
		}
		
	}
}

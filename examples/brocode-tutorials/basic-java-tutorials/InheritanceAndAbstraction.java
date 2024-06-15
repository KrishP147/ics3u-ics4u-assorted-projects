public class InheritanceAndAbstraction {

	public static void main(String[] args) {
		
		// inheritance = 	the process where one class acquires,
		//					the attributes and methods of another.
		
		Car4 car = new Car4();
		
		car.go();
		
		Bicycle bike = new Bicycle();
		
		bike.go();
		bike.stop();
		
		System.out.println(car.doors);
		System.out.println(bike.pedals);
				
	}
}
//*************************************

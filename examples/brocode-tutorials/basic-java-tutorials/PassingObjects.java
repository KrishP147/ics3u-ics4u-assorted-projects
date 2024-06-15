public class PassingObjects {

	public static void main(String[] args) {
			
		Garage garage = new Garage();
		
		Car3 car1 = new Car3("BMW");
		Car3 car2 = new Car3("Tesla");
		Bike bike = new Bike("BMX");
		garage.park(car1);
		garage.park(car2);
		garage.park(bike);
		
	}
}
//********************************************
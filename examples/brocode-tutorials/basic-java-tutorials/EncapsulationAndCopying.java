public class EncapsulationAndCopying {

	public static void main(String[] args) {
		
		
		Car5 car1 = new Car5("Chevrolet","Camaro",2021);
		//Car car2 = new Car("Ford","Mustang",2022);
		//car2.copy(car1);
		Car5 car2 = new Car5(car1);
		
		System.out.println(car1);
		System.out.println(car2);
		System.out.println();
		System.out.println(car1.getMake());
		System.out.println(car1.getModel());
		System.out.println(car1.getYear());
		System.out.println();
		System.out.println(car2.getMake());
		System.out.println(car2.getModel());
		System.out.println(car2.getYear());		
	
	}
}
//*********************************************
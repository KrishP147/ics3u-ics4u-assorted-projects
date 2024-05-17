public class StudentIsimbi {
	
	//These are the fields or variables of the class. Each DogSimple object will have these variables
	String studentName;
	int grade;
	
	//class constructor, invoked with the new operator; instantiate & initializes an object of class DogSimple, with parameters
	public StudentIsimbi () {
			
		this.studentName = "New StudentIsimbi";
		this.grade = 0;
	}
	
	//class constructor, invoked with the new operator; instantiate & initializes an object of class DogSimple, with parameters
	public StudentIsimbi (String studentName, int grade) {
		
		this.studentName = studentName;
		this.grade = grade;
	}

	public String getStudentIsimbiName() {
		return studentName;
	}

	public int getGrade() {
		return grade;
	}

	public void setStudentIsimbiName(String studentName) {
		this.studentName = studentName;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void submitAssignment() {
		//submit
	}
	
	public void presentAssignment() {
		//teacher teach all students
		//all students must be present
	}
	
	public void accessComputer() {
		//literally just this
		//Desktop studentDesktop = new Desktop();
	}
	
	public void goToBathroom() {
		//toilet flush effect
	}
	
	public void eatPancakes() {
		//mahmood bro
	}

	public static void main(String[] args) {
		StudentIsimbi student = new StudentIsimbi();
		
	}

}

public class TeacherIsimbi {
	
	//These are the fields or variables of the class. Each DogSimple object will have these variables
	String teacherName;
	String emailAddress;
	
	//class constructor, invoked with the new operator; instantiate & initializes an object of class DogSimple, with parameters
	public TeacherIsimbi () {
			
		this.teacherName = "TeacherIsimbi";
		this.emailAddress = "teacher@ocsb.ca";
	}
	
	//class constructor, invoked with the new operator; instantiate & initializes an object of class DogSimple, with parameters
	public TeacherIsimbi (String teacherName, String emailAddress) {
		
		this.teacherName = teacherName;
		this.emailAddress = emailAddress;
	}
	
		//special constructor, used if only name is provided, creates email using lowercase firstname.lastname format
		public TeacherIsimbi (String teacherName) {
			
			this.teacherName = teacherName;
			this.emailAddress = teacherName.toLowerCase().replaceFirst(" ", ".") + "@ocsb.ca";
		}

	public String getTeacherIsimbiName() {
		return teacherName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setTeacherIsimbiName(String teacherName) {
		this.teacherName = teacherName;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void viewStudentInfo() {
		//method to look at cool list + grades
		//all students need to be here
	}
	
	public void teachStudents() {
		//teacher teach all students
		//all students must be present
	}
	
	public void tellStory() {
		//teacher yap
		//no student link/paying attention
	}
	
	public static void main(String args) {
		TeacherIsimbi teacher = new TeacherIsimbi(args);
		//alternatively, TeacherIsimbi teacher = new TeacherIsimbi("name");
	} 
}
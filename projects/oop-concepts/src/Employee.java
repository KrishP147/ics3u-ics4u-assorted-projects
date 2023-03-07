/* This is an OOP class that shows the user various employees with various attributes 
 * Author Krish Punjabi
 * Date April 16 2024
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Employee {
	
	//These are the fields or variables of the class. Each Employee object will have these variables.
	int employeeId;
	String firstName;
	String lastName;
	String gender;
	String position;
	int salary;
	ImageIcon photo; 
	
	//class constructor: invoked with the new operator; instantiate & initializes an object of class Employee
	public Employee (String[] eData) { 
		// Initializes Employee object from string array
		this.employeeId = Integer.valueOf(eData[0]);
		this.firstName = eData[1];
		this.lastName = eData[2];
		this.gender = eData[3];
		this.position = eData[4];
		this.salary = Integer.valueOf(eData[5]);
		this.photo = new ImageIcon(eData[6]);
	}
	
	//class constructor, this time with parameters
	public Employee (int employeeId, String firstName, String lastName, String gender, String position, int salary, ImageIcon photo) { 
		// Initializes Employee object with specified parameters
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.position = position;
		this.salary = salary;
		this.photo = photo;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public ImageIcon getPhoto() {
		return photo;
	}

	public void setPhoto(ImageIcon photo) {
		this.photo = photo;
	}
	
	public void raiseSalary(JLabel salaryLabel) {
		final int MONEY = 20000;
		String raise = this.getFirstName() + " got a raise of $" + MONEY + " to their salary!";
		setSalary(getSalary() + MONEY); //sets salary by getting it then increasing it by set amount
		salaryLabel.setText("Salary: $" + salary); //label is updated
		JOptionPane.showMessageDialog(null, raise, "++$$", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void lowerSalary(JLabel salaryLabel) {
		final int MONEY = 20000;
		String raise = this.getFirstName() + " lost $" + MONEY + " from their salary!";
		setSalary(getSalary() - MONEY); //sets salary by getting it then reducing it by set amount
		salaryLabel.setText("Salary: $" + salary); //label is updated
		JOptionPane.showMessageDialog(null, raise, "--$$", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String sleep() { //this method plays two audio tracks together and displays a sleeping message, same logic as bark
		String sleep = this.getFirstName() + " is sleeping on the job!";
		try {
	        int playbackTime = 0;
	        File file = new File("Lullaby.wav");
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioStream);
	        clip.setMicrosecondPosition(playbackTime);
	        clip.start();
	        
	        File file2 = new File("Snore.wav");
	        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
	        Clip clip2 = AudioSystem.getClip();
	        clip2.open(audioStream2);
	        clip2.setMicrosecondPosition(playbackTime);
	        clip2.start();
	        
	        // Pause for 3 seconds, let both clips play together
	        Thread.sleep(3000);

	        // Stop both clips
	        clip.stop();
	        clip2.stop();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        sleep = "Error: Sleep action failed";
	    }
		return sleep;
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	
	public void displayInfo() {
	    // Displays employee information in a JFrame
	    JFrame frame = new JFrame("Employee Information");
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(935, 580);
	    
	    // Labels for displaying employee information
	    JLabel nameLabel = new JLabel("Name: " + firstName + " " + lastName);
	    nameLabel.setBounds(646, 45, 240, 54);
	    
	    // Gender, position, and salary labels
	    JLabel genderLabel = new JLabel("Gender: " + gender);
	    genderLabel.setBounds(646, 210, 240, 54);
	    JLabel positionLabel = new JLabel("Position: " + position);
	    positionLabel.setBounds(646, 295, 240, 54);
	    JLabel salaryLabel = new JLabel("Salary: $" + salary);
	    salaryLabel.setBounds(646, 373, 240, 54);
	    JLabel idLabel = new JLabel("Employee ID: " + employeeId);
	    idLabel.setBounds(646, 130, 240, 54);
	    
	    // Label for displaying employee photo
	    JLabel photoLabel = new JLabel(photo);
	    photoLabel.setBounds(21, 27, 600, 400);
	    
	    JPanel buttonPanel = new JPanel(); // a button panel is created to store buttons with specific methods for the employee objects
	    buttonPanel.setBounds(10, 446, 909, 95);
	    
	    
	    JButton raiseSalaryButton = new JButton("Raise Salary");
	    raiseSalaryButton.setBounds(50, 20, 200, 55);
	    raiseSalaryButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) { //message is displayed, and raise salary method is executed (if this button is pressed)
	            raiseSalary(salaryLabel);
	        }
	    });

	    JButton sleepButton = new JButton("Sleep");
	    sleepButton.setBounds(450, 20, 200, 55);
	    sleepButton.addActionListener(new ActionListener() { 
	        @Override
	        public void actionPerformed(ActionEvent e) { //message is displayed, and sleep method is executed (if this button is pressed)
	            JOptionPane.showMessageDialog(frame, sleep(), "Sleep", JOptionPane.INFORMATION_MESSAGE);
	        }
	    });

	    JButton lowerSalaryButton = new JButton("Lower Salary");
	    lowerSalaryButton.setBounds(250, 20, 200, 55);
	    lowerSalaryButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) { //message is displayed, and lower salary method is executed (if this button is pressed)	
	        	lowerSalary(salaryLabel);
	        }
	    });
	    
	    JButton backButton = new JButton("Back");
	    backButton.setBounds(650, 20, 200, 55);
	    backButton.addActionListener(new ActionListener() { 
	        @Override
	        public void actionPerformed(ActionEvent e) {// if this button is pressed, the frame just disposes - loop in main continues
                frame.dispose(); // Close the frame
	        }
	    });
	    
	    buttonPanel.setLayout(null);
	    buttonPanel.add(raiseSalaryButton);
	    buttonPanel.add(lowerSalaryButton);
	    buttonPanel.add(sleepButton);
	    buttonPanel.add(backButton);
	    frame.getContentPane().setLayout(null);
	    frame.getContentPane().add(nameLabel);
	    frame.getContentPane().add(genderLabel);
	    frame.getContentPane().add(positionLabel);
	    frame.getContentPane().add(salaryLabel);
	    frame.getContentPane().add(idLabel);
	    frame.getContentPane().add(photoLabel);
	    frame.getContentPane().add(buttonPanel);
	    
	    // Making the frame visible
	    frame.setVisible(true);
	    
	    // Ensuring the program doesn't proceed until the frame is closed
	    while (frame.isVisible()) {
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	public static void programDescription() {
        // Displays a program description message
        JOptionPane.showMessageDialog(null, "This program introduces three lovely employees to the user.\n","EMPLOYEES", JOptionPane.INFORMATION_MESSAGE);
    }
	
	public static void goodBye() { // this method displays a goodbye message to the user
        // Displays a goodbye message
        JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
        System.exit(0);// closes the program
    }
	
	public static int chooseEmployee(Employee e1, Employee e2, Employee e3) {// This method chooses which employee to display
		// Method to choose which employee to display
		int intInput;
		
		// Options for user to choose from
		String []options = {e1.getFirstName() + " " + e1.getLastName(), e2.getFirstName() + " " + e2.getLastName(), e3.getFirstName() + " " + e3.getLastName(), "Cancel"}; // can either choose one of the employees, or to cancel
		intInput = JOptionPane.showOptionDialog(null, "Which employee would you like to meet first?", "How would you like to proceed?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (intInput == (options.length - 1) || intInput == ((options.length - 1) - (options.length))) {// if index is final or -1, will terminate (cancel button or null)
			goodBye();
		}
		return intInput; // communicating procedure type
	}
	
	public static void main(String[] args) {
		
		int employeeType; // Variable to hold procedure/employee type
		final int BACK = -1; // Constants for switch case table, possible employee types
		final int EMPLOYEE_ONE = 0;
		final int EMPLOYEE_TWO = 1;
		final int EMPLOYEE_THREE = 2;
		
		// Instantiating Employee objects
		Employee e1 = new Employee(1001, "Mark", "Zuckerburg", "male", "Custodian", 70000, new ImageIcon("Mark.png")); 
    	Employee e2 = new Employee(1002, "Emma", "Watson", "female", "Sales Manager", 80000, new ImageIcon ("Emma.png"));
		
    	// Another class constructor - method overload: same name, different parameter list 
    	String[] eData = {"1003", "John", "Cena", "male", "CEO", "1000000", "John.png"}; 
    	Employee e3 = new Employee(eData); // another Employee constructor with parameter list as String[]
    	
    	// Display program description
    	programDescription();
    	
    	// Choose employee to display
    	employeeType = chooseEmployee(e1, e2, e3); // choosing employee based on input, storing it
	    while (true) {// while cancel button is not pressed
	        switch (employeeType) {
		        case BACK: // in this case, will ask again for input
		        	employeeType = chooseEmployee(e1, e2, e3);
		        	continue;
		        case EMPLOYEE_ONE:
	                // call the method displayInfo for each Employee object - case dependent on selection
	                e1.displayInfo();
	                break;
	            case EMPLOYEE_TWO:
	                e2.displayInfo();    
	                break;
	            case EMPLOYEE_THREE:
	                e3.displayInfo();
	                break;
	            default: // mandatory break here
	            	break;
	        }
	            employeeType = BACK; // user wants to go back, will reach here if back button (getting out of displayInfo due to buffer) or x is pressed
	            continue; // returns to home page, start of loop, choosing procedure again
	    }
	}    
} // Employee

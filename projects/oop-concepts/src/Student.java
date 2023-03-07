/* This is an OOP class that uses the attributes of students to determine if they can "party".
 * Author: Krish Punjabi
 * Date: April 17 2024
 */

import javax.swing.JOptionPane;

public class Student {
	
	//These are the fields or variables of the class. Each DogSimple object will have these variables.
	
	String name;
	int grade;
	
	//class constructor, this time with parameters
	public Student (String name, int grade) { 
		
		this.name = name;
		this.grade = grade;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		
	public String returnInfo() { //determines if student can party or not (if grade <75, can't party)
		
		String message;
		final int PASSING_GRADE = 75;
		
		if (this.getGrade() < PASSING_GRADE) {
			message = "Sorry " + this.getName() + ", your test score of " + this.getGrade() + "% is too low. You cannot go to the party.\nYou have to study more, and you must get a score of atleast " + PASSING_GRADE + "% next time!";
		}
		else
			message = "Congratulations " + this.getName() + ", your test score of " + this.getGrade() + "% is great. You can go to the party.\nHAVE FUN! A score of more than " + (PASSING_GRADE - 1) + "% is awesome, keep it up!";	
		return message;
	}
	
	public static void printStudentInfo(Student[] students) {// static since this method displays the info for all the students
		//Create a String to be printed out
		////use a get method to display some variables
		String message = "";
		for (int i = 0; (i < students.length-1); i++) {
			if (students[i] == null) //since array length is preset, so won't always be full
            	break;
			message = message + students[i].returnInfo() + "\n\n";
        }
		JOptionPane.showMessageDialog(null, message, "STUDENT INFO", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static void programDescription() {
        JOptionPane.showMessageDialog(null, "This program lets the user know if they can party, depending on their test grade.\n","Student", JOptionPane.INFORMATION_MESSAGE);
    }
	
	public static void goodBye(Student[] students) { // this method displays a goodbye message to the user
        JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
        System.exit(0);// closes the program
    }
	
	public static String validateInput(String message, Student[] students){ //this method simply receives input from the user and validates it
		// this version validates for Strings (only exception is if input is null)
        boolean validInput = false; //will become true after passing try and catch
        String userInput = ""; //declaring String input variable
        while (!validInput) { //will run while input is not valid, will try and catch value  
            try { 
                userInput = JOptionPane.showInputDialog
                		(null, message);
                if (userInput == null) {//if cancel button is pressed, program terminates
                	goodBye(students);
                }
                validInput = true; //since this line is executed
            }
            catch(NumberFormatException e) {//shows error message and repeats loop until input is valid (an integer) or program is exited
                JOptionPane.showMessageDialog(null,"You entered invalid input. Please enter a String" + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
            }   
        }
        return userInput;
    }
	
    public static int validateInput(int maxValue, String message, Student[] students){ //this method simply receives input from the user and validates it
    	//overridden method, for integers
    	final int MIN_VALUE = 0; //min score
        int input = 0; 

        boolean validInput = false; //will become true after passing try and catch
        String userInput = ""; //declaring String input variable
        while (!validInput) { //will run while input is not valid, will try and catch value  
            try { //tries to convert string to integer, if fails, catch block is executed
                userInput = JOptionPane.showInputDialog
                		(null, message);
                if (userInput == null) {//if cancel button is pressed, program terminates
                	goodBye(students);
                }
                input = Integer.parseInt(userInput);
                if ((input < MIN_VALUE || input > maxValue)) {
					throw new IllegalArgumentException(); // in the case that the answer is not within the specific range of acceptable answers, an exception will be thrown.
                }
                validInput = true; //since this line is executed
            }
            catch(NumberFormatException e) {//shows error message and repeats loop until input is valid (an integer) or program is exited
                JOptionPane.showMessageDialog(null,"You entered invalid input. Please enter a integer" + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
            }
            catch (IllegalArgumentException f) {// in the case the input isn't within specified range, this message will show up
				JOptionPane.showMessageDialog(null, "You entered invalid input. " + "\nPlease enter a value between " + MIN_VALUE + " and " + maxValue, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return input;
    }
	
	public static void main(String[] args) {
		
		final int MAX_STUDENTS = 5; //max number of students info that will show at once
		final int MAX_GRADE = 100; //max grade, not possible to have more than 100
		int i = 0;
		String name;
		int grade;
		
		programDescription();//Instantiates objects of class Employee - calling a class constructor 
		Student[] students = new Student [MAX_STUDENTS]; //new array is created with predetermined length
		
		while (true) {
			name = validateInput("Please enter your name:", students); //validates name
			grade = validateInput(MAX_GRADE, "Please enter your grade:", students); //validates score
	        students[i] = new Student(name, grade); //new student is created and stored in an array
	        printStudentInfo(students); //info is printed for all students (max 5, min 1)
	        i++; //incremented for new student (if added)
	        if (i == MAX_STUDENTS) { //if i > max students, array is erased and i is set to 0, effectively resetting array
	        	students = new Student[MAX_STUDENTS];
	        	i = 0;
	        }
		}
        
	}    
} //Student

/* This is an OOP calculator class that performs basic arithmetic operations.
 * Author: Krish Punjabi
 * Date: April 19 2024
 */

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Calculator {
	
	//These are the fields or variables of the class. Each Calculator object will have these variables.
	
	double number1;
    double number2;
    double sum;
    double difference;
    double product;
    double quotient;

    //class constructor: invoked with the new operator; instantiate & initializes an object of class Calculator
    //going to use methods to validate and assign values to attributes manually later on
  	public Calculator () { 
  		
  		this.number1 = 0;
		this.number2 = 0;
		this.sum = 0;
		this.difference = 0;
		this.product = 0;
		this.quotient = 0;
  	}
	
	//class constructor, this time with parameters
  	//offers alternative solution, instead of manually setting values for number 1 and two, could instantiate object after collecting input and use input as parameters for constructor
	public Calculator (double number1, double number2) { 
		
		this.number1 = number1;
		this.number2 = number2;
		this.sum = 0;
		this.difference = 0;
		this.product = 0;
		this.quotient = 0;
	}
	
	//Getter methods, will get the value for each variable
	public double getNumber1() {
		return number1;
	}

	public double getNumber2() {
		return number2;
	}

	public double getSum() {
		return sum;
	}

	public double getDifference() {
		return difference;
	}

	public double getProduct() {
		return product;
	}

	public double getQuotient() {
		return quotient;
	}

	//Setter methods, will set/update the value for each variable
	public void setNumber1(double number1) {
		this.number1 = number1;
	}

	public void setNumber2(double number2) {
		this.number2 = number2;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public void setDifference(double difference) {
		this.difference = difference;
	}

	public void setProduct(double product) {
		this.product = product;
	}

	public void setQuotient(double quotient) {
		this.quotient = quotient;
	}
	
	//Methods to calculate the sum, difference, product and quotient for each pair of inputed numbers
	public double calculateSum() {
		double sum = (this.getNumber1()) + (this.getNumber2()); //sum is num 1 + num 2
		return sum;
	}
	
	public double calculateDifference() {
		double difference = (this.getNumber1()) - (this.getNumber2()); //difference is num 1 - num 2
		return difference;
	}
	
	public double calculateProduct() {
		double product = (this.getNumber1()) * (this.getNumber2()); //product is num 1 * num 2
		return product;
	}
	
	public double calculateQuotient() {
		double quotient = (this.getNumber1()) / (this.getNumber2()); //quotient is num 1 / num 2
		return quotient;
	}
	
	public void printCalculatorInfo() {
		//Create a String to be printed out
		//use get methods to display some variables
		
		DecimalFormat df = new DecimalFormat("0.00"); //to format doubles to two decimal places
		
		String formattedNumber1 = df.format(this.getNumber1()); //formatting number 1 and storing it ni a variable to use in multiple places efficiently
		String formattedNumber2 = df.format(this.getNumber2()); //same idea for number 2
		String quotient;
		
		if (this.getNumber2() == 0 && this.getNumber1() == 0) //if numerator and denominator are zero, result is indeterminate
			quotient = "indeterminate";
		else if (this.getNumber2() == 0) //if only denominator is zero, then result should be undefined
			quotient = "undefined";
		else
			quotient = df.format(this.getQuotient()); //otherwise the string quotient is just the value of the quotient
		
		String message = formattedNumber1 + " + " + formattedNumber2 + " = " + df.format(this.getSum()); //prints sum
		message += "\n" + formattedNumber1 + " - " + formattedNumber2 + " = " + df.format(this.getDifference()); //prints difference
		message += "\n" + formattedNumber1 + " * " + formattedNumber2 + " = " + df.format(this.getProduct()); //prints product
		message += "\n" + formattedNumber1 + " / " + formattedNumber2 + " = " + quotient; //prints quotient
		
		//if second number is 0, result for quotient will be + or - infinity
		JOptionPane.showMessageDialog(null, message, "CALCULATIONS", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static void programDescription() {
        JOptionPane.showMessageDialog(null, "This program  prompts the user to enter two numbers, then displays their sum, difference, product & quotient.\n","CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
    }
	
	public static void goodBye() { // this method displays a goodbye message to the user
        JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
        System.exit(0);// closes the program
    }
	
    public static double validateInput(double MAX_VALUE, double MIN_VALUE, String message){ //this method simply receives input from the user and validates it

        double input = 0; 

        boolean validInput = false; //will become true after passing try and catch
        String userInput = ""; //declaring String input variable
        while (!validInput) { //will run while input is not valid, will try and catch value  
            try { //tries to convert string to integer, if fails, catch block is executed
                userInput = JOptionPane.showInputDialog
                		(null, message);
                if (userInput == null) {//if cancel button is pressed, program terminates
                	goodBye();
                }
                input = Double.parseDouble(userInput);
                if ((input < MIN_VALUE || input > MAX_VALUE)) {
					throw new IllegalArgumentException(); // in the case that the answer is not within the specific range of acceptable answers, an exception will be thrown.
                }
                validInput = true; //since this line is executed
            }
            catch(NumberFormatException e) {//shows error message and repeats loop until input is valid (an integer) or program is exited
                JOptionPane.showMessageDialog(null,"You entered invalid input. Please enter a double (real number)" + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
            }
            catch (IllegalArgumentException f) {// in the case the input isn't within specified range, this message will show up
				JOptionPane.showMessageDialog(null, "You entered invalid input. " + "\nPlease enter a value between " + MIN_VALUE + " and " + MAX_VALUE, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return input;
    }
	
	public static void main(String[] args) {
		
		final double MAX_VALUE = Double.POSITIVE_INFINITY; //max value of input, can be adjusted according to employer's needs.
    	final double MIN_VALUE = Double.NEGATIVE_INFINITY; //min value of input, can be adjusted according to employer's needs.
		double num1 = 0;
		double num2 = 0;
		Calculator calculation; //initializing object outside of loop
		programDescription(); //program description 			
		while (true) {
			calculation = new Calculator(); //Create object of class Calculator - calling a class constructor
			num1 = validateInput(MAX_VALUE, MIN_VALUE, "Please enter your first double:"); //validates first number
			num2 = validateInput(MAX_VALUE, MIN_VALUE, "Please enter your second double:"); //validates second number
			
			calculation.setNumber1(num1); //sets value of number 1 to inputed number
			calculation.setNumber2(num2); //sets value of number 2 to inputed number
			
			//calculation = new Calculator(num1, num2); //alternatively, could have used constructor with parameters instead of manually setting values
			
			calculation.setSum(calculation.calculateSum()); //sets the sum based on its calculation, based on the input
			calculation.setDifference(calculation.calculateDifference()); //sets the difference based on its calculation, based on the input
			calculation.setProduct(calculation.calculateProduct()); //sets the product based on its calculation, based on the input
			calculation.setQuotient(calculation.calculateQuotient()); //sets the quotient based on its calculation, based on the input
			
			calculation.printCalculatorInfo(); //results are printed for this calculation of type calculator
	        
		}
        
	}    
} //Calculator

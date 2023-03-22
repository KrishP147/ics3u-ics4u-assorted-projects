
/* This is an OOP calculator class that performs basic arithmetic operations.
 * Author: Krish Punjabi
 * Date: April 19 2024
 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class CalculatorKrish {
	
	//These are the fields or variables of the class. Each Calculator object will have these variables.
	
	double number1;
    double number2;
    double sum;
    double difference;
    double product;
    double quotient;

    //class constructor: invoked with the new operator; instantiate & initializes an object of class Calculator
    //going to use methods to validate and assign values to attributes manually later on
  	public CalculatorKrish () { 
  		
  		this.number1 = 0;
		this.number2 = 0;
		this.sum = 0;
		this.difference = 0;
		this.product = 0;
		this.quotient = 0;
  	}
	
	//class constructor, this time with parameters
  	//offers alternative solution, instead of manually setting values for number 1 and two, could instantiate object after collecting input and use input as parameters for constructor
	public CalculatorKrish (double number1, double number2) { 
		
		this.number1 = number1;
		this.number2 = number2;
		this.sum = number1 + number2;
		this.difference = number1 - number2;;
		this.product = number1 * number2;;
		this.quotient = number1 / number2;;
	}
	
	//Getter methods, will get the value for each variable
	public double getNumber1() {
		return number1;
	}

	public double getNumber2() {
		return number2;
	}

	//Setter methods, will set/update the value for each variable
	public void setNumber1(double number1) {
		this.number1 = number1;
	}

	public void setNumber2(double number2) {
		this.number2 = number2;
	}

	//Methods to calculate the sum, difference, product and quotient for each pair of inputed numbers
	public void setSum() {
		 sum = number1+number2; //sum is num 1 + num 2
	}
	
	public void setDifference() {
		 difference = number1-number2; //difference is num 1 - num 2
	}
	
	public void setProduct() {
		 product = number1*number2; //product is num 1 * num 2
	}
	
	public void setQuotient() {
		 quotient = number1/number2; //quotient is num 1 / num 2
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
	
	public String formatNum(double num) {
		DecimalFormat df = new DecimalFormat("0.00"); //to format doubles to two decimal places
		return df.format(num);
	}
	
	public String formatQuotient() {
		if (number1 == 0 && number2 == 0) //if numerator and denominator are zero, result is indeterminate
			return "indeterminate";
		else if (number2 == 0) //if only denominator is zero, then result should be undefined
			return "undefined";
		else
			return formatNum(getQuotient()); //otherwise the string quotient is just the value of the quotient
	}
	
	public void printCalculatorInfo() {
		//Create a String to be printed out
		//use get methods to display some variables
		
		String message = formatNum(number1) + " + " + formatNum(number2) + " = " + formatNum(getSum()); //prints sum
		message += "\n" + formatNum(number1) + " - " + formatNum(number2) + " = " + formatNum(getDifference()); //prints difference
		message += "\n" + formatNum(number1) + " * " + formatNum(number2) + " = " + formatNum(getProduct()); //prints product
		message += "\n" + formatNum(number1) + " + " + formatNum(number2) + " = " + formatQuotient(); //prints quotient
		
		//if second number is 0, result for quotient will be + or - infinity
		JOptionPane.showMessageDialog(null, message, "CALCULATION RESULTS", JOptionPane.INFORMATION_MESSAGE);
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
		CalculatorKrish calculator; //initializing object outside of loop
		programDescription(); //program description 			
		while (true) {
			calculator = new CalculatorKrish(); //Create object of class Calculator - calling a class constructor
			
			num1 = validateInput(MAX_VALUE, MIN_VALUE, "Please enter your first double:"); //validates first number
			num2 = validateInput(MAX_VALUE, MIN_VALUE, "Please enter your second double:"); //validates second number
			calculator.setNumber1(num1); //sets value of number 1 to inputed number
			calculator.setNumber2(num2); //sets value of number 2 to inputed number
			
			//calculator = new CalculatorKrish(num1, num2); //alternatively, could have used constructor with parameters instead of manually setting values
			
			calculator.setSum(); //sets the sum based on its calculation, based on the input
			calculator.setDifference(); //sets the difference based on its calculation, based on the input
			calculator.setProduct(); //sets the product based on its calculation, based on the input
			calculator.setQuotient(); //sets the quotient based on its calculation, based on the input
			
			calculator.printCalculatorInfo(); //results are printed for this calculation of type calculator
		}
        
	}    
} //Calculator
/* This is an abstract account class that is intended to act as a blueprint for specific account classes
 * Author: Krish Punjabi
 * Date: May 7 2024
 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public abstract class Account { //abstract keyword here to indicate that this class is only a blueprint to compiler - no main
	//all accounts must have a name (of the user), a type and a balance.
	private String name;
	private String accountType;
	protected double balance; //must be protected so that sub classes can access it
	
	public Account() {//default contructor
		this.name = "Natasha Rakocevic";
		this.accountType = "normal";
		this.balance = 3000;
	}
	
	public Account(String name, String accountType, double balance) {
		this.name = name;
		this.accountType = accountType;
		this.balance = balance;
	}
	
	//getters
	public String getName() {
		return name;
	}

	public String getAccountType() {
		return accountType;
	}

	public double getBalance() {
		return balance;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//program description for generic account, with type included
	public void programDescription() {
        JOptionPane.showMessageDialog(null, "Welcome to your " + getAccountType() + " account.","WELCOME", JOptionPane.INFORMATION_MESSAGE);
    }
	
	public void goodBye() { // this method displays a goodbye message to the user
        JOptionPane.showMessageDialog(null, "Thank you for banking with KP Banks!");
        System.exit(0);// closes the program
    }
	
    public double validateInput(final double MAX_VALUE, String message){ //this method simply receives input from the user and validates it
    	//this method deals exclusively with monetary values (doubles)
    	final double MIN_VALUE = 0;
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
                JOptionPane.showMessageDialog(null,"You entered invalid input. Please enter a valid numerical value" + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
            }
            catch (IllegalArgumentException f) {// in the case the input isn't within specified range, this message will show up
				JOptionPane.showMessageDialog(null, "You entered invalid input. " + "\nPlease enter a value between $" + MIN_VALUE + " and $" + MAX_VALUE, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return input;
    }
	
    public String formatNum(double num) {
		DecimalFormat df = new DecimalFormat("0.00"); //to format doubles to two decimal places
		return df.format(num);
	}
    
	public void deposit() { //generic method to deposit money into account; updating balance
		double deposit = validateInput(Double.POSITIVE_INFINITY, "Hey " + getName() + ", how much money would you like to deposit?");
		setBalance(getBalance() + deposit); //balance is updated with input
		JOptionPane.showMessageDialog(null, "You deposited $"  + formatNum(deposit) + ".\nYour new account balance is $" + formatNum(getBalance()) + ".", "DEPOSIT!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void withdraw() { //method to withdraw money from account; once again, simply updating balance
		double withdrawal = validateInput(getBalance(), "Hey " + getName() + ", how much money would you like to withdraw?");
		setBalance(getBalance() - withdrawal);
		JOptionPane.showMessageDialog(null, "You withdrew $"  + formatNum(withdrawal) + ".\nYour new account balance is $" + formatNum(getBalance()) + ".", "WITHDRAWAL!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String showOptions() { //Using show option dialogue to show user operations at bank - this includes the very basic ones only
	    Object[] options = {"Deposit", "Withdraw", "Account Summary"};
	    int choiceInt = JOptionPane.showOptionDialog(null, "What do you want to do today, " + getName() + "?", "PLEASE PROCEED", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	    if (choiceInt == JOptionPane.CLOSED_OPTION) { //if x button is pressed
	        goodBye(); // terminates program
	    }
	    return (String) options[choiceInt];
	}
	
	public void getChoice () { //performs specified operation depending on choice
		String choice = showOptions(); //get user choice
		if (choice.equals("Deposit")) {
			deposit(); //runs deposit method
		} 
		else if (choice.equals("Withdraw")) {
			withdraw(); //runs withdraw method
		}
		else if (choice.equals("Account Summary")) {
			displayAccount(); //account info is simply displayed
		}
	}
	
	public void displayAccount() { //displays name, account type and balance
		JOptionPane.showMessageDialog(null, "Dear " + getName() + ", your " + getAccountType() + " account has a balance of $" + formatNum(getBalance()) + ".");
	}
	
/*	public static void main(String[] args) // a possible main for this class (will not work unless abstrct keyword is removed for class
		
		Account account = new Account("Anna Brown", "regular", 3000);
		programDescription
		while (true) {	
			account.getChoice();
		}
	} */
}

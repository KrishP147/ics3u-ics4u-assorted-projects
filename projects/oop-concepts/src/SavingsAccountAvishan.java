/*
 * Saving Account extends from the Account class, to create the object sa, which is Anna Brown and her bank account
 * Avishan Jegathasan
 * April 24th, 2023
 */

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class SavingsAccountAvishan extends AccountAvishan {

	double interestRate; // new instance variables
	String choice = "";


	//class constructor
	public SavingsAccountAvishan(String name, String accountType, double balance, double interests) {
		super(name, accountType, balance); //from Account class
		this.interestRate = interests;
	}

	public String showOptions() { //Show options of what you can do with at the bank. Not a drop down menu but now custom buttons that direct you to a certain method
	    Object[] options = {"Deposit", "Withdraw", "Book An Appointment", "E-Transfer", "Financial Advisor(Loan)", "Account Summary"};
	    int choiceInt = JOptionPane.showOptionDialog(null, "What do you want to do today, " + getName() + "?", 
	        "Welcome!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	    if (choiceInt == JOptionPane.CLOSED_OPTION) { // cancel button, same thing as null but when you have an object array
	        super.goodBye(); // calls the goodbye class from the super class
	    }
	    String choice = (String) options[choiceInt];
	    return choice;
	}

	
	
	public void bookAppointment () { // Book an appointment to talk with somebody at a bank
		
		final int NUMBER_OF_DAYS = 31; //Constant variables
		
		String [] month = {"January", "Febuary", "March", "April" , "May", "June", "July" , "August", "September", "October", "November", "December"}; // String of months
		String stringDate = (String) JOptionPane.showInputDialog(null, "Please select when you would like to book an appointment", "Account", JOptionPane.QUESTION_MESSAGE, null, month, month [0]); // Drop down menu
		
		    Object[] date = new Object[NUMBER_OF_DAYS]; // Object array created to use integers in drop down menu. Objects allow for different data types
	        for (int i = 0; i < date.length; i++) {
	           date[i] = i+1;
	        }
		
		int stringDay = (int) JOptionPane.showInputDialog(null, "What date?", "Account", JOptionPane.QUESTION_MESSAGE, null, date, date[0]); // Drop down menu with dates
		
		JOptionPane.showMessageDialog(null, "Your appointment for " + stringDate + " " + stringDay + " has been booked");
		

	}
	
	public void financialAdvisor() { // Asks for a loan similar to deposit but, asks for years and determine final amount after the years with interest rate
		boolean validInput = false;
		boolean validYear = false;
		double amount = 0;
		double year = 0;
		
		while (!validInput) {
		try {
		String stringAmount = JOptionPane.showInputDialog(null, "Hey " + getName() + ", how much of a loan are you interested in?");
		if (stringAmount == null) {
       		goodBye();
       	}
    	amount = Double.parseDouble(stringAmount);
    	validInput = true;
    	if (amount < 1) {
    		JOptionPane.showMessageDialog(null, "Error occured, please enter a number above 0", "ACCOUNT", JOptionPane.ERROR_MESSAGE);
    		validInput = false;
    	}
    	}
    	catch (Exception e ) {
    		JOptionPane.showMessageDialog(null, "Error occured, please enter a number not a String", "ACCOUNT", JOptionPane.ERROR_MESSAGE);
    	}
		}

		while (!validYear) {
		try {
		String stringYear = JOptionPane.showInputDialog(null, "How long do you want this loan to last for, remember there is an interest rate of 1.5%");
		if (stringYear == null) {
       		goodBye();
       	}
    	year = Double.parseDouble(stringYear);
    	validYear = true;
    	if (year < 1) {
    		JOptionPane.showMessageDialog(null, "Error occured, please enter a number above 0", "ACCOUNT", JOptionPane.ERROR_MESSAGE);
    		validYear = false;
    	}
    	}
    	catch (Exception e ) {
    		JOptionPane.showMessageDialog(null, "Error occured, please enter a number not a String", "ACCOUNT", JOptionPane.ERROR_MESSAGE);
    	}
		}

		double newAmount = (amount*year*(interestRate/100)) + amount; // Calculate Interested amount
		
		JOptionPane.showMessageDialog(null, "After " + year + " years of getting this loan of $" + amount + " you would need to pay back $" + newAmount + " due to the interest");
		
	}
	

	public void displayAccount() {  //method override, added interest
	    DecimalFormat df = new DecimalFormat("0.00");	// formats the money
		JOptionPane.showMessageDialog(null, getName() + ", your " + getAccountType() + " has a balance of $" + df.format(getBalance()) + "\n\n***Please note if you take a loan from our bank, there is an interest rate of " + interestRate + "%***");
	}

	public void getChoice () {
		String choice = showOptions(); // get user choice
		if (choice.equals("Deposit")) {
			deposit(); // gets a deposit from the user, adds to balance
		} else if (choice.equals("Withdraw")) {
			withdraw(); // get withdraw, remove from balance
		} else if (choice.equals("Book An Appointment")) {
			bookAppointment();
		}
		else  if (choice.equals("E-Transfer")) {
			eTransfer();
	}
		else  if (choice.equals("Financial Advisor(Loan)")) {
			financialAdvisor();
	}
		else if (choice.equals("Account Summary")) {
			displayAccount();
		}
	}

	public static void main(String[] args) {
		SavingsAccountAvishan sa = new SavingsAccountAvishan("Anna Brown", "savings", 3000, 1.5); // Initial values
		while (true) {
			sa.getChoice(); // Options at the bank
		}
	}
}
/* This is a subclass of the abstract account class:
 * a class built on the basic account, with specified attributes that make it a savings account. 
 * Author: Krish Punjabi
 * Date: May 7 2024
 */

import javax.swing.JOptionPane;

public class SavingsAccount extends Account { //extends keyword here, inherits all attributes and methods of the account class.
	private double interestRate; //new fields for new functions
	private int withdrawalsRemaining;
	private int year;
	private int yearDifference;
	
	//class constructor
	public SavingsAccount() {
		super(); //superclass constructor used to handle these fields
		this.interestRate = 5; //interest rate is decided based on input
		this.withdrawalsRemaining = 6; //number of withdrawals for a savings account must be 6
		this.year = 2024; //year must always start at 2024
		this.yearDifference = 0; //doesn't need a starting value
	}
	
	public SavingsAccount(String name, String accountType, double balance, double interests) {
		super(name, accountType, balance); //superclass constructor used to handle these fields
		this.interestRate = interests; //interest rate is decided based on input
		this.withdrawalsRemaining = 6; //number of withdrawals for a savings account must be 6
		this.year = 2024; //year must always start at 2024
		this.yearDifference = 0; //doesn't need a starting value
	}
	
	//getters
	public double getInterestRate() {
		return interestRate;
	}
	
	public int getWithdrawalsRemaining() {
		return withdrawalsRemaining;
	}

	public int getYear() {
		return year;
	}
	
	public int getYearDifference() {
		return yearDifference;
	}
	
	//setters
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void setWithdrawalsRemaining(int withdrawalsRemaining) {
		this.withdrawalsRemaining = withdrawalsRemaining;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setYearDifference(int yearDifference) {
		this.yearDifference = yearDifference;
	}

	@Override
	public void setBalance(double balance) { //this is a method to override the setting of tha balance field - everytime the balance is set, it will account for time and interest rates
		this.balance = (balance*getYearDifference()*(interestRate/100)) + balance;
	}
	
	//Polymorphism, another validate input method with a different signature - return type is int. useful to validate input in the form of years.
	public int validateInput(final int MAX_VALUE, String message){ //this method simply receives input from the user and validates it
    	final int MIN_VALUE = getYear();
        int input = 0; 
        boolean validInput = false; //will become true after passing try and catch
        String userInput = ""; //declaring String input variable
        while (!validInput) { //will run while input is not valid, will try and catch value  
            try { //tries to convert string to integer, if fails, catch block is executed
                userInput = JOptionPane.showInputDialog
                		(null, message);
                if (userInput == null) {//if cancel button is pressed, program terminates
                	goodBye();
                }
                input = Integer.parseInt(userInput);
                if ((input <= MIN_VALUE || input > MAX_VALUE)) {
					throw new IllegalArgumentException(); // in the case that the answer is not within the specific range of acceptable answers, an exception will be thrown.
                }
                validInput = true; //since this line is executed
            }
            catch(NumberFormatException e) {//shows error message and repeats loop until input is valid (an integer) or program is exited
                JOptionPane.showMessageDialog(null,"You entered invalid input. Please enter a valid numerical value, representing a year." + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
            }
            catch (IllegalArgumentException f) {// in the case the input isn't within specified range, this message will show up
				JOptionPane.showMessageDialog(null, "You entered invalid input. " + "\nPlease enter a year between " + MIN_VALUE + " and " + MAX_VALUE, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return input;
    }
	
	public void timeTravel() {//method to change the year and set the difference between the previous year and current year.
		//can only move forward in time - otherwise complicates interest rates
		int newYear = (int) validateInput(Integer.MAX_VALUE, "What year would you like to travel to?");
			if (newYear != getYear()) //if the new year is not equal to the old year, number of withdrawals (per year) is reset to 6
			setWithdrawalsRemaining(6);
		setYearDifference(newYear-getYear()); //difference is found, important for calculating new balance
		setYear(newYear);//year is updated with new value
		//since not storing preceding year value, important to create a field to store the difference
		JOptionPane.showMessageDialog(null, "You travelled " + getYearDifference() + " years in time.\nThe year is now "+ getYear() + ".", "TIME TRAVEL!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public void withdraw() { //overridden method, to account for limited number of withdrawals in a savings account.
		if (getWithdrawalsRemaining() > 0) {
			double withdrawal = validateInput(getBalance(), "How much money would you like to withdraw?\nYou have " + getWithdrawalsRemaining() + " withdrawals remaining this year.");
			setBalance(getBalance() - withdrawal);
			setWithdrawalsRemaining(getWithdrawalsRemaining() - 1);
			JOptionPane.showMessageDialog(null, "You withdrew $"  + formatNum(withdrawal) + ".\nYour new account balance is $" + formatNum(getBalance()) + ".\nYou have " + getWithdrawalsRemaining() + " withdrawals remaining.", "WITHDRAWAL!", JOptionPane.INFORMATION_MESSAGE);
		}
		else 
			JOptionPane.showMessageDialog(null, "Sorry, you are out of withdrawals for this year. Please try again at a later date.", "WITHDRAWAL!", JOptionPane.ERROR_MESSAGE);
	}
	
	@Override
	public String showOptions() { //ovveridden method, adds o[ption to travel to the future to view impact of interest rate
	    Object[] options = {"Deposit", "Withdraw", "Account Summary", "Travel to the Future"};
	    int choiceInt = JOptionPane.showOptionDialog(null, "What do you want to do today, " + getName() + "?", "PLEASE PROCEED", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	    if (choiceInt == JOptionPane.CLOSED_OPTION)  //if x button is pressed
	        goodBye(); // terminates program
	    return (String) options[choiceInt];
	}
	
	@Override
	public void getChoice () { //overriden to add extra case of travelling in time
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
		else if (choice.equals("Travel to the Future")) {
			timeTravel(); //year is updated
			setBalance(getBalance()); //balance is updated with interest rates - overriden method is used to add interest when getting the balance, setting the balance to this value
		}
		else
			goodBye();
	}
	
	@Override
	public void displayAccount() { //override to add interest rate
		JOptionPane.showMessageDialog(null, "Dear " + getName() + ", your " + getAccountType() + " account has a balance of $" + formatNum(getBalance()) + "\nThe annual interest rate is " + getInterestRate() + "%.");
	}
	
	public static void main(String[] args) {
		
		SavingsAccount sa = new SavingsAccount("Natasha Rakocevic", "savings", 3000, 5);
		sa.programDescription();
		while (true) {	
			sa.getChoice(); //asks user which operation they would like to proceed with
		}
	} 


}

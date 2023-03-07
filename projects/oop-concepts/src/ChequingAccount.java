/* This is a subclass of the abstract account class:
 * a class built on the basic account, with specified attributes that make it a chequing account. 
 * Author: Krish Punjabi
 * Date: May 7 2024
 */

import javax.swing.JOptionPane;

public class ChequingAccount extends Account{
	
	public ChequingAccount() {
		super(); //default constructor
	}
	
	public ChequingAccount(String name, String accountType, double balance) {
		super(name, accountType, balance); //no additional fields, constructed with super class
	}
	
	public void sendMoney () { // similar to withdrawing, but instead, "sending" money to specific person
		double amount = validateInput(getBalance(), "Please enter the amount of money you would like to send:");
		String [] names = {"Jacob Zheng", "Isimbi Karama", "Saad Waqas", "Emanuel Villa-Galego"};	// Select few names, as exception handling with Strings are complicated
	    String recipient = (String) JOptionPane.showInputDialog(null, getName() + ", who would you like to send money to?" , "SEND MONEY", JOptionPane.QUESTION_MESSAGE, null, names, names[0]);
	    JOptionPane.showMessageDialog(null, recipient + " successfully received $" + amount);
	    setBalance(getBalance() - amount);
	}
	
	@Override
	public String showOptions() { //overidden method, adds option to send money with chequing account
	    Object[] options = {"Deposit", "Withdraw", "Account Summary", "Send Money"};
	    int choiceInt = JOptionPane.showOptionDialog(null, "What do you want to do today, " + getName() + "?", "PLEASE PROCEED", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	    if (choiceInt == JOptionPane.CLOSED_OPTION)  //if x button is pressed
	        goodBye(); // terminates program
	    return (String) options[choiceInt];
	}
	
	@Override
	public void getChoice () { //overridden to add extra case of sending money
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
		else if (choice.equals("Send Money")) {
			sendMoney(); //money is sent
		}
		else
			goodBye();
	}
		
	public static void main(String[] args) {
		
		ChequingAccount ca = new ChequingAccount("Natasha Rakocevic", "chequing", 3000);
		ca.programDescription();
		while (true) {
			ca.getChoice(); //asks user which operation they would like to proceed with
		}
	}
}

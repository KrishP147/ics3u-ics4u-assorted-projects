// imports JOptionPane class 
import javax.swing.JOptionPane;

public class JOption {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "This is a plain message", "Plain", JOptionPane.PLAIN_MESSAGE);
		// creates plain message
		JOptionPane.showMessageDialog(null, "This is an information message", "Information", JOptionPane.INFORMATION_MESSAGE);
		// creates information message
		JOptionPane.showMessageDialog(null, "This is a warning message", "Warning", JOptionPane.WARNING_MESSAGE);
		// creates warning message
		JOptionPane.showMessageDialog(null, "This is an error message", "Error", JOptionPane.ERROR_MESSAGE);
		// creates error message
		String stringInput = JOptionPane.showInputDialog(null, "Input a number!", "");
		// creates pop-up where the user can enter a string, saving it in stringInput
		int userInput = Integer.parseInt(stringInput);
		// changes String to integer
		JOptionPane.showMessageDialog(null, "You entered number " + userInput, "Your Input", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "GOODBYE!", "Program Terminating", JOptionPane.INFORMATION_MESSAGE);
	}
}
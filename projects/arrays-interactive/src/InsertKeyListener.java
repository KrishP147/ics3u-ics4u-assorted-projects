import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class InsertKeyListener implements ActionListener {
	int index;
	InsertKeyListener(int index) {
		this.index = index;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] options = {"Insert", "Delete", "Back"};
    	int response = JOptionPane.showOptionDialog(null, "You clicked the insert element button: "
    			+ "/nWould you like to insert an element?", "Insert?", 0, 0, null, options, null);
    	if (response == 0)
    		Replace
    	if (response == 1)
    		Delete
    	if (response == 2)
    		Close
    	else 
    		ArrayCreate.goodBye();
    }
}

}

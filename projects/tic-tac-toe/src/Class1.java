/* This program provides the user with an interactive array in the form of a GUI. 
 * The user can perform a wide variety of operations with the array, and 
 * this program provides visual feedback to these operations. 
 * Author: Krish Punjabi
 * Date: March 24, 2024
 */

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Class1 extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JButton[][] buttons;  
    public int size = 3;
    public int clickedIndex;
    public int state;

    public Class1() {
        super("Tic Tac Toe");
        // Add window listener to handle frame closing event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ArrayOperations.goodBye(); // Call the goodBye method when the window is closing
            }
        });

        // Initialize the array and buttons
        buttons = new JButton[size][size]; // Array for buttons
        // Set layout for the frame
        getContentPane().setLayout(new BorderLayout()); //Border

        // Create a panel for the array of buttons with a linear layout
        JPanel buttonPanel = new JPanel();

        // Populate the buttons
        for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
            buttons[i][j] = new JButton(); // Create a button with the array value
            buttons[i][j].addActionListener(new ButtonArrayClickListener(i), new ButtonArrayClickListener(j)); // Add ActionListener to handle button click
            buttons[i][j].setPreferredSize(new Dimension (100, 100)); // Set preferred size for the button
            buttons[i][j].setFont(new Font("Consolas", Font.PLAIN, 20)); // Set the font for the button text
            buttons[i][j].setBackground(Color.DARK_GRAY);
            buttons[i][j].setForeground(Color.WHITE);
            buttonPanel.add(buttons[i][j]); // Add the button to the panel
        	}
        }
        // Add the panel with the array of buttons to the top of the frame
        //getContentPane().add(buttonPanel, GridLayout.class);
        buttonPanel.setLayout(new GridLayout(3, 4, 0, 0));
        buttonPanel.setSize(500, 500);
        getContentPane().add(buttonPanel, GridLayout.class); // Button panel to the center

        // Set frame size and visibility
        pack();
        //setSize(1216,529);
        setResizable(true);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    // ActionListener implementation to handle array button click
    class ButtonArrayClickListener extends ArrayOperations implements ActionListener {
        int row;
        int column;

        public ButtonArrayClickListener(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (state == 0) {
            	buttons[row][column].setBackground(Color.YELLOW);
            	clickedIndex = row;
            	state = 1;
            } else if (state == 1) {
            	buttons[row][column].setBackground(Color.BLACK);
            	clickedIndex = row;
            	state = 0;
            }

        }
    }

    class ArrayOperations {
        public static void programDescription() {
            JOptionPane.showMessageDialog(null, "This program provides the user with an interactive array to work with.\n","Key Insertion", JOptionPane.INFORMATION_MESSAGE);
        }

        public static void goodBye() { // this method displays a goodbye message to the user
            JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
            System.exit(0);// closes the program
        }

    }
    public static void main(String[] args) {
        ArrayOperations.programDescription();
    	new Class1();
    }
}

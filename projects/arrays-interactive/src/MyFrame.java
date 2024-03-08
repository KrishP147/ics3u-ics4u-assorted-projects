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
import java.util.ArrayList;
import java.util.Arrays;

public class MyFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] array;
    private static boolean reverseOrder = false; // Flag to indicate whether to reverse the array
    JPanel controlPanel;
    JPanel topPanel;
    private JButton[] buttons;
    private JButton addButton;
    private JButton deleteButton;
    private JButton replaceButton;
    private JButton resetButton;
    private JButton shuffleButton;
    private JButton reverseButton;
    private JButton lSearchButton;
    private JButton bSearchButton;
    private JButton sumButton;
    private JButton sizeButton;
    private JButton boundsButton;
    private JButton infoButton;
    private static int maxValue = 100;
    private static int minValue = 1;
    private static int state = -1;
    private boolean infoButtonPressedOnce = true;
    public int size = 12;
    public int clickedIndex;

    public MyFrame() {
        super("INTERRAY");
        // Add window listener to handle frame closing event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ArrayOperations.goodBye(); // Call the goodBye method when the window is closing
            }
        });

        // Initialize the array and buttons
        array = ArrayOperations.initializeArray(size);
        buttons = new JButton[size]; // Array for buttons
        // Set layout for the frame
        getContentPane().setLayout(new BorderLayout()); //Border
        
        // Create the main outer panel with BorderLayout
        JPanel mainPanel = new JPanel(new GridLayout());
        ImageIcon logo = new ImageIcon ("logo.png");
        // Create the top panel for the welcome message
        topPanel = new JPanel(new BorderLayout());
        
        JLabel welcomeLabel = new JLabel("<html><font color='green'>Welcome to </font> <font color='orange'>INT</font><font color='aqua'>ERRAY</font><font color='green'>. Please click on a button.</font></html>");
        //welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Consolas", Font.BOLD, 35));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10)); // Add padding here

        
        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(logo);
        iconLabel.setForeground(Color.WHITE);
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10)); // Add padding here

        
        topPanel.add(welcomeLabel, BorderLayout.NORTH);
        topPanel.add(iconLabel, BorderLayout.SOUTH);
        topPanel.setBackground(Color.BLACK);
        

        // Add the top panel to the main panel at the top
        getContentPane().add(topPanel, BorderLayout.NORTH);

        // Create a panel for the array of buttons with a linear layout
        JPanel buttonPanel = new JPanel();

        // Populate the buttons
        for (int i = 0; i < size; i++) {
            buttons[i] = new JButton(Integer.toString(array[i])); // Create a button with the array value
            buttons[i].addActionListener(new ButtonArrayClickListener(i)); // Add ActionListener to handle button click
            buttons[i].setPreferredSize(new Dimension (100, 100)); // Set preferred size for the button
            buttons[i].setFont(new Font("Consolas", Font.PLAIN, 20)); // Set the font for the button text
            buttons[i].setBackground(Color.DARK_GRAY);
            buttons[i].setForeground(Color.WHITE);
            buttonPanel.add(buttons[i]); // Add the button to the panel
        }
        // Add the panel with the array of buttons to the top of the frame
        //getContentPane().add(buttonPanel, GridLayout.class);
        buttonPanel.setLayout(new GridLayout(3, 4, 0, 0));
        buttonPanel.setSize(500, 500);
        JScrollPane scrollPane = new JScrollPane(buttonPanel);    
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //getContentPane().add(scrollPane);
        // Add the button panel and the control panel to the content pane
        mainPanel.add(scrollPane, GridLayout.class); // Button panel to the center

        // Create a panel for additional buttons
        controlPanel = new JPanel();

        // Additional button for inserting a new element
        addButton = new JButton("Insert");
        addButton.addActionListener(new ButtonClickListener("Insert"));
        controlPanel.setLayout(new GridLayout(4, 3, 0, 0));
        addButton.setPreferredSize(new Dimension (200, 100)); // Set preferred size for the button
        addButton.setFont(new Font("Consolas", Font.BOLD, 25)); // Set the font for the button text
        addButton.setBackground(Color.GREEN);
        controlPanel.add(addButton);

        // Additional button for deleting an element
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ButtonClickListener("Delete"));
        deleteButton.setPreferredSize(new Dimension (200, 100)); // Set preferred size for the button
        deleteButton.setFont(new Font("Consolas", Font.BOLD, 25)); // Set the font for the button text
        deleteButton.setBackground(Color.RED);
        controlPanel.add(deleteButton);

        // Additional button for replacing an element
        replaceButton = new JButton("Replace");
        replaceButton.addActionListener(new ButtonClickListener("Replace"));
        replaceButton.setPreferredSize(new Dimension (200, 100)); // Set preferred size for the button
        replaceButton.setFont(new Font("Consolas", Font.PLAIN, 25)); // Set the font for the button text
        replaceButton.setBackground(new Color(255, 140, 0));
        controlPanel.add(replaceButton);

        // Additional button for resetting the array
        resetButton = new JButton("Reset");
        resetButton.setForeground(new Color(255, 255, 255));
        resetButton.addActionListener(new ButtonClickListener("Reset"));
        resetButton.setPreferredSize(new Dimension (200, 100)); // Set preferred size for the button
        resetButton.setFont(new Font("Consolas", Font.PLAIN, 25)); // Set the font for the button text
        resetButton.setBackground(new Color(0, 0, 139));
        controlPanel.add(resetButton);

        // Additional button for shuffling the array
        shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(new ButtonClickListener("Shuffle"));
        shuffleButton.setPreferredSize(new Dimension (200, 100)); // Set preferred size for the button
        shuffleButton.setFont(new Font("Consolas", Font.PLAIN, 25)); // Set the font for the button text
        shuffleButton.setBackground(Color.YELLOW);
        controlPanel.add(shuffleButton);

        // Additional button for reversing the array
        reverseButton = new JButton("Descending Order");
        reverseButton.addActionListener(new ButtonClickListener("Reverse"));
        reverseButton.setPreferredSize(new Dimension (200, 100)); // Set preferred size for the button
        reverseButton.setFont(new Font("Consolas", Font.PLAIN, 19)); // Set the font for the button text
        reverseButton.setBackground(Color.MAGENTA);
        controlPanel.add(reverseButton);
        
        // Additional button for searching the array
        bSearchButton = new JButton("Binary Search");
        bSearchButton.addActionListener(new ButtonClickListener("Binary Search"));
        bSearchButton.setPreferredSize(new Dimension (200, 100)); // Set preferred size for the button
        bSearchButton.setFont(new Font("Consolas", Font.PLAIN, 20)); // Set the font for the button text
        bSearchButton.setBackground(Color.CYAN);
        controlPanel.add(bSearchButton);
        
        // Additional button for searching the array
        lSearchButton = new JButton("Linear Search");
        lSearchButton.setForeground(Color.WHITE);
        lSearchButton.addActionListener(new ButtonClickListener("Linear Search"));
        lSearchButton.setPreferredSize(new Dimension (200, 100)); // Set preferred size for the button
        lSearchButton.setFont(new Font("Consolas", Font.PLAIN, 20)); // Set the font for the button text
        lSearchButton.setBackground(new Color(0, 100, 0));
        controlPanel.add(lSearchButton);
        
        // Additional button for calculating the sum of the array
        sumButton = new JButton("Sum");
        sumButton.setForeground(Color.WHITE);
        sumButton.addActionListener(new ButtonClickListener("Sum"));
        sumButton.setPreferredSize(new Dimension (200, 100)); // Set preferred size for the button
        sumButton.setFont(new Font("Consolas", Font.PLAIN, 25)); // Set the font for the button text
        sumButton.setBackground(new Color(128, 0, 0));
        controlPanel.add(sumButton);
        
        sizeButton = new JButton("Size");
        sizeButton.setForeground(new Color(255, 255, 255));
        sizeButton.addActionListener(new ButtonClickListener("Size"));
        sizeButton.setPreferredSize(new Dimension (200, 100)); // Set preferred size for the button
        sizeButton.setFont(new Font("Consolas", Font.PLAIN, 25)); // Set the font for the button text
        sizeButton.setBackground(new Color(51, 0, 153));
        controlPanel.add(sizeButton);
        
        boundsButton = new JButton("Bounds");
        boundsButton.setForeground(Color.WHITE);
        boundsButton.addActionListener(new ButtonClickListener("Bounds"));
        boundsButton.setPreferredSize(new Dimension (200, 100)); // Set preferred size for the button
        boundsButton.setFont(new Font("Consolas", Font.PLAIN, 25)); // Set the font for the button text
        boundsButton.setBackground(Color.GRAY);
        controlPanel.add(boundsButton);
        
        infoButton = new JButton("Info");
        infoButton.addActionListener(new ButtonClickListener("Info"));
        infoButton.setPreferredSize(new Dimension (200, 100)); // Set preferred size for the button
        infoButton.setFont(new Font("Consolas", Font.PLAIN, 25)); // Set the font for the button text
        infoButton.setBackground(Color.WHITE);
        infoButton.setEnabled(false);
        controlPanel.add(infoButton);

        // Add the control panel to the frame
        mainPanel.add(controlPanel, GridLayout.class);
        getContentPane().add(mainPanel, BorderLayout.CENTER); // main panel to the right
        
        // Set frame size and visibility
        pack();
        //setSize(1216,529);
        setResizable(true);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    // ActionListener implementation to handle button click
    class ButtonClickListener implements ActionListener {
        String type;

        public ButtonClickListener(String type) {
            this.type = type;
        }   
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (type) {
                case "Insert":
                	state = -1;
                    int key = ArrayOperations.validateInput("Enter an element to insert: ", minValue, maxValue);
                    if (key == -1)
                		return;
                    Arrays.sort(array);
                    int index = ArrayOperations.keyIndexSearch(array, key);
                    array = ArrayOperations.modifyArray(array, key, index, false); // Insert the element at the specified index
                    refreshButtons();
                    buttons[index].setBackground(Color.GREEN);
                    buttons[index].setForeground(Color.BLACK);
                    break;
                case "Delete":
                    state = 1;
                    setTitle("Click on the element you to delete");
                    break;
                case "Replace":
                	state = 2;
                    setTitle("Click on the element you to replace");
                    break;
                case "Reset":
                	state = -1;
                    size = 12;
                	array = ArrayOperations.initializeArray(size);
                    maxValue = 100;
                    minValue = 1;
                    refreshButtons();
                    setTitle("Array reset");
                    break;
                case "Shuffle":
                	state = -1;
                    array = ArrayOperations.shuffleArray(array);
                    refreshButtons();
                    setTitle("Array shuffled");
                    break;
                case "Reverse":
                	state = -1;
                    if (reverseOrder) {
                        Arrays.sort(array); // Sort array in ascending order
                        refreshButtons();
                        reverseOrder = false;
                        reverseButton.setBackground(Color.MAGENTA);
                        reverseButton.setText("Descending Order");
                        reverseButton.setForeground(Color.BLACK);
                    } else {
                    	Arrays.sort(array); // Sort array in ascending order
                    	array = ArrayOperations.reverseArrayOrder(array); // Reverse array
                        refreshButtons();
                        reverseOrder = true;
                        reverseButton.setBackground(Color.BLUE);
                        reverseButton.setText("Ascending Order");
                        reverseButton.setForeground(Color.WHITE);
                    }
                    setTitle("Array sorted");
                    break;
                case "Binary Search":
                	state = -1;
                    Arrays.sort(array);
                    key = ArrayOperations.validateInput("Enter an element to search for: ", minValue, maxValue);
                    if (key == -1)
                        return;
                    int[] indices = ArrayOperations.binarySearch(array, key);
                    if (indices.length == 0) {
                        ArrayOperations.notFound(key, array);
                        break;
                    }
                    setTitle("Array searched");
                    refreshButtons();
                    for (int i = 0; i < indices.length; i++) {
                        buttons[indices[i]].setBackground(Color.CYAN); // Set the background color of found elements
                        buttons[indices[i]].setForeground(Color.BLACK); // Set the background color of found elements
                    }
                    break;
                case "Linear Search":
                	state = -1;
                    key = ArrayOperations.validateInput("Enter an element to search for: ", minValue, maxValue);
                    if (key == -1)
                        return;
                    indices = ArrayOperations.linearSearch(array, key);
                    if (indices.length == 0) {
                        ArrayOperations.notFound(key, array);
                        break;
                    }
                    setTitle("Array searched");
                    refreshButtons();
                    for (int i = 0; i < indices.length; i++) {
                        buttons[indices[i]].setBackground(new Color(0, 100, 0)); // Set the background color of found elements
                    }
                    break; 
                case "Sum":	
                    int sum = ArrayOperations.arraySum(array); // Reverse array
                    sumButton.setText("Array sum: " + sum);
                    refreshButtons();
                    break;
                case "Size":
                	state = -1;
                	size = ArrayOperations.validateInput("Please enter a size to quickly generate an array:\n(Currently at a size of " + size + " elements)");
                	if (size == -1)
                		return;
                	if (size > 5000)
                		size = 5000;
                	array = ArrayOperations.initializeArray(size);
                    refreshButtons();
                    setTitle("Array length updated");
                    sumButton.setBackground(new Color(128, 0, 0));
                    break;
                case "Bounds":
                	state = -1;
                	maxValue = ArrayOperations.validateInput("Please enter a maximum value for the randomly generated elements:");
                	if (maxValue == -1){
                		maxValue = 100;
                		return;
                	}
                	minValue = ArrayOperations.validateInput("Please enter a minimum value for the randomly generated elements:");
                	if (minValue == -1) {
                		minValue = 1;
                		maxValue = 100;
                		return;
                	}
                	if (minValue > maxValue) {
                    	int temp = minValue;
                    	minValue = maxValue;
                    	maxValue = temp;
                    }
                	array = ArrayOperations.initializeArray(size);
                	refreshButtons();
                    setTitle("Array bounds updated");
                    sumButton.setBackground(Color.WHITE);
                    break;
                case "Info":
                	if (infoButtonPressedOnce) {
                		// First press: Change button appearance to show index
                        infoButton.setBackground(Color.BLACK);
                        infoButton.setForeground(Color.WHITE);
                        infoButton.setText("Index: " + Integer.toString(clickedIndex));
                        infoButtonPressedOnce = false;
                    } else {
                        // Second press or not pressed at all: Change button appearance to show element number
                        infoButton.setBackground(Color.WHITE);
                        infoButton.setForeground(Color.BLACK);
                        infoButton.setText("Element: " + Integer.toString(array[clickedIndex]));
                        infoButtonPressedOnce = true;
                        }

                    break;
                default:
                    break;
            }
            if (!type.equals("Sum")) {
                sumButton.setText("Sum");
                sumButton.setBackground(new Color(128, 0, 0));
            }
        }
    }

    // ActionListener implementation to handle array button click
    class ButtonArrayClickListener extends ArrayOperations implements ActionListener {
        int index;

        public ButtonArrayClickListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (state == -1 || state == 0) {
            	refreshButtons();
            	buttons[index].setBackground(Color.YELLOW);
               buttons[index].setForeground(Color.BLACK);
            	clickedIndex = index;
            	state = 0;
            } else if (state == 1) {
                array = ArrayOperations.modifyArray(array, array[index], index, true); // Delete the element at the specified index
                refreshButtons();
                state = -1;
                setTitle("INTERRAY");
            } else if (state == 2) {
            	int key = array[index];
            	int replacement = ArrayOperations.validateInput("Enter a replacement for element " + key + ": ", minValue, maxValue);
            	if (replacement == -1)
            		return;
            	array = ArrayOperations.modifyArray(array, key, index, true); // Delete the element at the specified index
            	int newIndex = ArrayOperations.keyIndexSearch(array, replacement);
            	array = ArrayOperations.modifyArray(array, replacement, newIndex, false); // Insert the element at the specified index
            	refreshButtons();
            	buttons[newIndex].setBackground(new Color(255, 140, 0));
                buttons[newIndex].setForeground(Color.BLACK);
            	state = -1;
                setTitle("INTERRAY");
            }
            if (state == 0) {
            	infoButton.setEnabled(true);
                infoButton.setBackground(Color.WHITE);
                infoButton.setForeground(Color.BLACK);
                infoButton.setText("Element: " + (Integer.toString(array[clickedIndex])));
            }
        }
    }

    public void refreshButtons() {
        // Remove all components from the content pane
        getContentPane().removeAll();
        // Create a new button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 4)); // Use GridLayout to display buttons side by side
        
        // Create the main outer panel with BorderLayout
        JPanel mainPanel = new JPanel(new GridLayout());
        // Create a new array of buttons with the updated size
        buttons = new JButton[array.length];

        // Populate the button panel with the new buttons
        for (int i = 0; i < array.length; i++) {
            buttons[i] = new JButton(Integer.toString(array[i]));
            buttons[i].addActionListener(new ButtonArrayClickListener(i));
            buttons[i].setPreferredSize(new Dimension(100, 100));
            buttons[i].setFont(new Font("Consolas", Font.PLAIN, 20));
            buttons[i].setBackground(Color.DARK_GRAY);
            buttons[i].setForeground(Color.WHITE);
            buttonPanel.add(buttons[i]);
        }

        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the button panel and the control panel to the content pane
        mainPanel.add(scrollPane, GridLayout.class);
        mainPanel.add(controlPanel, GridLayout.class);
        
        // Add the top panel to the top
        getContentPane().add(topPanel, BorderLayout.NORTH);
     // Add the top panel to the top
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        if (state != 0) {
        	infoButton.setText("Info");
        	infoButton.setEnabled(false);
        }
    
        // Refresh the frame
        revalidate();
        repaint();
        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    class ArrayOperations {
        public static void programDescription() {
            JOptionPane.showMessageDialog(null, "This program provides the user with an interactive array to work with.\n","Key Insertion", JOptionPane.INFORMATION_MESSAGE);
        }

        public static void goodBye() { // this method displays a goodbye message to the user
            JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
            System.exit(0);// closes the program
        }

        public static int validateInput(String message, int minValue, int maxValue){ //this method simply receives input from the user and validates it
            int input = 0;
            boolean validInput = false; //will become true after passing try and catch
            String userInput = ""; //declaring String input variable
            while (!validInput) { //will run while input is not valid,
            	// will try and catch value  
                try { //tries to convert string to integer, if fails, catch block is executed
                    userInput = JOptionPane.showInputDialog
                            (null, message);
                    if (userInput == null) {//if cancel button is pressed, program terminates
                    	return -1; 
                    }
                    input = Integer.parseInt(userInput);
                    if ((input < minValue || input > maxValue)) {
    					throw new IllegalArgumentException(); // in the case that the answer is not within the specific range of acceptable answers, an exception will be thrown.
                    }
                    validInput = true; //since this line is executed
                }
                catch(NumberFormatException e) {//shows error message and repeats loop until input is valid (an integer) or program is exited
                    JOptionPane.showMessageDialog(null,"You entered invalid input. Please enter a integer" + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
                }
                catch (IllegalArgumentException f) {// in the case the input isn't within specified range, this message will show up
    				JOptionPane.showMessageDialog(null, "You entered invalid input. " + "\nPlease enter a value between " + minValue + " and " + maxValue, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
    			}
            }
            return input;
        }
        
        public static int validateInput(String message){ //this method simply receives input from the user and validates it
            int input = 0;
            boolean validInput = false; //will become true after passing try and catch
            String userInput = ""; //declaring String input variable
            while (!validInput) { //will run while input is not valid,
            	// will try and catch value  
                try { //tries to convert string to integer, if fails, catch block is executed
                    userInput = JOptionPane.showInputDialog
                            (null, message);
                    if (userInput == null) {//if cancel button is pressed, program terminates
                    	return -1; 
                    }
                    input = Integer.parseInt(userInput);
                    if (input >= 0)
                    	validInput = true; //since this line is executed
                    else
                    	throw new NumberFormatException();
                }
                catch(NumberFormatException e) {//shows error message and repeats loop until input is valid (an integer) or program is exited
                    JOptionPane.showMessageDialog(null,"You entered invalid input. Please enter a positive integer" + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
                }
            }
            return input;
        }

        public static int[] initializeArray(int size) {
            int[] arr = new int [size];  //array is sorted through initialization - length is 1024
            for (int i = 0; i <= arr.length - 1; i++) { // for each index of the array, the number that is 1 + that index is stored - ex: at 0, 1 is stored, etc, to have an array of consecutive integers from 1 - 1024
                arr[i] = (int) ((Math.random()*(maxValue-minValue+1)) + minValue); 
            } // for
            Arrays.sort(arr);
            return arr;
        }

        public static int[] shuffleArray(int[] array) {
            int[] shuffledArray = Arrays.copyOf(array, array.length);

            for (int i = shuffledArray.length - 1; i > 0; i--) {
                int j = (int) (Math.random() * (i + 1)); // Generate a random index between 0 and i (inclusive)
                // Swap elements at indices i and j
                int temp = shuffledArray[i];
                shuffledArray[i] = shuffledArray[j];
                shuffledArray[j] = temp;
            }

            return shuffledArray;
        }
        public static int[] modifyArray(int []arr, int key, int index, boolean deleteTrue) {
            int insert = 1;
            int delete = 0;
            if (deleteTrue) {
                insert = 0;
                delete = -1;
            }
            
            int [] newArr = new int [arr.length + insert + delete];
            System.arraycopy(arr, 0, newArr, 0, index);
            System.arraycopy(arr, index - delete, newArr, index+insert, arr.length+delete-index);
            
            if(!deleteTrue)
                newArr[index] = key;
            Arrays.sort(newArr);
            return newArr;
        }

        public static int keyIndexSearch(int arr[], int key){ 
             for (int i = 0; i < arr.length; i++) {
                    if (!reverseOrder && key <= arr[i]) {
                        return i; // Return the index if the key is less than or equal to the current element
                    }
                    if (reverseOrder && key >= arr[i]) {
                        return i; // Return the index if the key is less than or equal to the current element
                    }
                }
                return arr.length; // Return the index after the loop if the key is greater than all elements
            }

        public static int[] reverseArrayOrder(int []array) {//this method calculates and returns the reverse of an array
            int[] reversed = new int[array.length]; //new array with same length as initial one is initialized
            for (int j = 0, i = array.length - 1; j <= array.length - 1 && i >= 0; j++, i--) //while one integer increments, the other decrements (one starts at the min length, and one starts at the max for both arrays)
                reversed[j] = array[i]; //the position of the smaller number getting bigger on the new array becomes equal to the position of the big number getting smaller on the initial array; the array is reversed.
            return reversed;
        }
	public static void notFound(int input, int[]arr) {
	    String message = "The key " + input + " is NOT found in the array " + Arrays.toString(arr) + ".";
		JOptionPane.showMessageDialog(null, message, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
	}
	
	public static int[] binarySearch(int[] array, int key) {
	    ArrayList<Integer> indicesList = new ArrayList<>();
	    int index = Arrays.binarySearch(array, key);
	    if (index >= 0) {
	        indicesList.add(index);
	        // Check left
	        for (int i = index - 1; i >= 0 && array[i] == key; i--) {
	            indicesList.add(i);
	        }
	        // Check right
	        for (int i = index + 1; i < array.length && array[i] == key; i++) {
	            indicesList.add(i);
	        }
	    }
	    // Convert ArrayList to int array
	    int[] indices = new int[indicesList.size()];
	    for (int i = 0; i < indicesList.size(); i++) {
	        indices[i] = indicesList.get(i);
	    }
	    return indices;
	}
	public static int[] linearSearch(int[] array, int key) { 
	    int[] indices = new int[array.length];
	    int count = 0; // Counter for the number of occurrences of the key
	    for (int i = 0; i < array.length; i++) {
	        if (key == array[i]) {
	            indices[count++] = i; // Store the index of the key
	        }
	    }
	    // Resize the indices array to remove unused elements
	    return Arrays.copyOf(indices, count);
	}
	public static int arraySum(int []array) {//this method calculates and returns the sum of an array
		int sum = 0; //sum variable is declared
		
		for (int i = 0; i <= array.length - 1; i++) //repeated to calculate sum1
			sum = sum + array[i];
		return sum;
	}
}
    public static void main(String[] args) {
        ArrayOperations.programDescription();
    	new MyFrame();
    }
}

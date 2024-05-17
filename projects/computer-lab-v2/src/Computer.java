/* This is an abstract class for computer objects - like desktop and chromebook.
 * This class provides the basic, repetitive blueprint for both these classes
 * Date: May 17 2024
 * Authors: Krish Punjabi and Isimbi Karama
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import javax.swing.JTextArea;

public class Computer {
	

	//These are the fields or variables of the class. Each DogSimple object will have these variables.
	String ipAddress;
	int modelNumber;
	String operatingSystem;
	String brand;
	int manufacturingDate;
	String memorySize;
	String compatibleIDE;

	//default constructor
	public Computer () {
			
		this.ipAddress = "1.1.1.1";
		this.modelNumber = 0000;
		this.operatingSystem = "chromeOS";
		this.brand = "Unknown";
		this.manufacturingDate = 2024;
		this.memorySize = "0GB";
		this.compatibleIDE = "Replit";
	}
	
	//class constructor, invoked with the new operator; instantiate & initializes an object of class Computer, with parameters
	public Computer (String ipAddress, int modelNumber, String operatingSystem, String brand, int manufacturingDate, String memorySize, String compatibleIDE) {
		
		this.ipAddress = ipAddress;
		this.modelNumber = modelNumber;
		this.operatingSystem = operatingSystem;
		this.brand = brand;
		this.manufacturingDate = manufacturingDate;
		this.memorySize = memorySize;
		this.compatibleIDE = compatibleIDE;
	}
	
	//Getters
	public String getIpAddress() {
		return "This computer's IP address is: " + ipAddress + ".";
	}

	public String getModelNumber() {
		return "This computer's model number is: " + modelNumber + ".";
	}

	public String getOperatingSystem() {
		return "This computer's operating system is: " + operatingSystem + ".";
	}

	public String getBrand() {
		return "This computer's brand is: " + brand + ".";
	}

	public String getManufacturingDate() {
		return "This computer's manufacturing date is: " + manufacturingDate + ".";
	}

	public String getMemorySize() {
		return "This computer's memory size is: " + memorySize + ".";
	}

	public String getCompatibleIDE() {
		return compatibleIDE;
	}

	//Setters
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setManufacturingDate(int manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public void setMemorySize(String memorySize) {
		this.memorySize = memorySize;
	}
	
	public void setCompatibleIDE(String compatibleIDE) {
		this.compatibleIDE = compatibleIDE;
	}

	//method to make the frame
	public void makeFrame(JFrame frame, JPanel panel, JPanel keyboard) { 
	    
        keyboard.setBackground(new Color(0, 0, 128)); //keyboard panel is made
        //brought in as an argument to move positioning of keyboard for subclasses
        keyboard.setBounds(167, 355, 542, 214);
        keyboard.setLayout(null);
        
        makeKeys(keyboard); //manually adding keys to keyboard
	    
	    panel.setBounds(251, 190, 470, 243); //this panel is modified later on - therefore is brought in as an argument
	    panel.setBackground(Color.BLACK);
	    panel.setLayout(null); 
	    panel.setLocation(35, 30);
	
	    JPanel desktop = new JPanel(); //surrounding desktop panel is made
	    desktop.setBackground(Color.GRAY);
	    desktop.setBounds(167, 22, 540, 298);
	    desktop.setLayout(null);
	    desktop.add(panel);
	    
	    frame.getContentPane().add(desktop); //frame is set - passed in since it is modified later on
	    frame.getContentPane().add(keyboard);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //will dispose frame if x is pressed, going back to computer lab homepage
	    frame.setSize(935, 680); 
	    frame.getContentPane().setLayout(null);
	    
		JButton googleButton = new JButton("Google"); //button to run browseWeb method
		googleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    googleButton.setBounds(98, 96, 89, 68);
	    panel.add(googleButton);
	    
	    JButton IDEButton = new JButton(getCompatibleIDE()); //button to run runIDE method
	    IDEButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    IDEButton.setBounds(284, 96, 89, 68);
	    panel.add(IDEButton);
	    
	    googleButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) { //if clicked, will set up frame and two option buttons
	           browseWeb(frame, panel);
	           panel.remove(googleButton);
	           panel.remove(IDEButton);
	        }
	    });
	    
	    IDEButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {// same as above, will set up frame for coding and remove option buttons
	            runIDE(frame, panel);
	            panel.remove(googleButton);
	            panel.remove(IDEButton);
	        }
	    });
	    
        JButton detailButton = new JButton("View Details"); //button to display info (attributes) of computer
        detailButton.setBounds(745, 258, 113, 39);
        frame.getContentPane().add(detailButton);
        detailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	displayComputerInfo(); // runs the display method
            }
        });
	    
        frame.setVisible(true); // Make the frame visible after all components are added
	}
	
	public void makeKeys(JPanel keyboard) { //manually adding all keys, alligned on keyboard
		// First row
        JButton button1 = new JButton("1");
        button1.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(button1).setBounds(8, 20, 42, 42);

        JButton button2 = new JButton("2");
        button2.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(button2).setBounds(52, 20, 42, 42);

        JButton button3 = new JButton("3");
        button3.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(button3).setBounds(96, 20, 42, 42);

        JButton button4 = new JButton("4");
        button4.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(button4).setBounds(140, 20, 42, 42);

        JButton button5 = new JButton("5");
        button5.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(button5).setBounds(184, 20, 42, 42);

        JButton button6 = new JButton("6");
        button6.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(button6).setBounds(228, 20, 42, 42);

        JButton button7 = new JButton("7");
        button7.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(button7).setBounds(272, 20, 42, 42);

        JButton button8 = new JButton("8");
        button8.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(button8).setBounds(316, 20, 42, 42);

        JButton button9 = new JButton("9");
        button9.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(button9).setBounds(360, 20, 42, 42);

        JButton button0 = new JButton("0");
        button0.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(button0).setBounds(404, 20, 42, 42);

        JButton buttonMinus = new JButton("-");
        buttonMinus.setFont(new Font("Arial", Font.PLAIN, 16));
        keyboard.add(buttonMinus).setBounds(448, 20, 42, 42);

        JButton buttonPlus = new JButton("+");
        buttonPlus.setFont(new Font("Arial", Font.PLAIN, 14));
        keyboard.add(buttonPlus).setBounds(492, 20, 42, 42);

        // Second row
        JButton buttonBackspace = new JButton("Backspace");
        buttonBackspace.setFont(new Font("Arial", Font.PLAIN, 10));
        keyboard.add(buttonBackspace).setBounds(8, 64, 86, 42);

        JButton buttonQ = new JButton("Q");
        buttonQ.setFont(new Font("Arial", Font.PLAIN, 11));
        keyboard.add(buttonQ).setBounds(96, 64, 42, 42);

        JButton buttonW = new JButton("W");
        buttonW.setFont(new Font("Arial", Font.PLAIN, 8));
        keyboard.add(buttonW).setBounds(140, 64, 42, 42);

        JButton buttonE = new JButton("E");
        buttonE.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(buttonE).setBounds(184, 64, 42, 42);

        JButton buttonR = new JButton("R");
        buttonR.setFont(new Font("Arial", Font.PLAIN, 11));
        keyboard.add(buttonR).setBounds(228, 64, 42, 42);

        JButton buttonT = new JButton("T");
        buttonT.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(buttonT).setBounds(272, 64, 42, 42);

        JButton buttonY = new JButton("Y");
        buttonY.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(buttonY).setBounds(316, 64, 42, 42);

        JButton buttonU = new JButton("U");
        buttonU.setFont(new Font("Arial", Font.PLAIN, 11));
        keyboard.add(buttonU).setBounds(360, 64, 42, 42);

        JButton buttonI = new JButton("I");
        buttonI.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(buttonI).setBounds(404, 64, 42, 42);

        JButton buttonO = new JButton("O");
        buttonO.setFont(new Font("Arial", Font.PLAIN, 11));
        keyboard.add(buttonO).setBounds(448, 64, 42, 42);

        JButton buttonP = new JButton("P");
        buttonP.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(buttonP).setBounds(492, 64, 42, 42);

        // Third row
        JButton buttonA = new JButton("A");
        buttonA.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(buttonA).setBounds(8, 108, 42, 42);

        JButton buttonS = new JButton("S");
        buttonS.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(buttonS).setBounds(52, 108, 42, 42);

        JButton buttonD = new JButton("D");
        buttonD.setFont(new Font("Arial", Font.PLAIN, 11));
        keyboard.add(buttonD).setBounds(96, 108, 42, 42);

        JButton buttonF = new JButton("F");
        buttonF.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(buttonF).setBounds(140, 108, 42, 42);

        JButton buttonG = new JButton("G");
        buttonG.setFont(new Font("Arial", Font.PLAIN, 11));
        keyboard.add(buttonG).setBounds(184, 108, 42, 42);

        JButton buttonH = new JButton("H");
        buttonH.setFont(new Font("Arial", Font.PLAIN, 11));
        keyboard.add(buttonH).setBounds(228, 108, 42, 42);

        JButton buttonJ = new JButton("J");
        buttonJ.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(buttonJ).setBounds(272, 108, 42, 42);

        JButton buttonK = new JButton("K");
        buttonK.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(buttonK).setBounds(316, 108, 42, 42);

        JButton buttonL = new JButton("L");
        buttonL.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(buttonL).setBounds(360, 108, 42, 42);

        JButton buttonUnderline = new JButton("_");
        buttonUnderline.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(buttonUnderline).setBounds(404, 108, 42, 42);

        JButton buttonLeftBracket = new JButton("(");
        buttonLeftBracket.setFont(new Font("Arial", Font.PLAIN, 12));
        keyboard.add(buttonLeftBracket).setBounds(448, 108, 42, 42);

		JButton buttonRightBracket = new JButton(")");
		buttonRightBracket.setFont(new Font("Arial", Font.PLAIN, 12));
		keyboard.add(buttonRightBracket).setBounds(492, 108, 42, 42);
		
		// Fourth row
		JButton buttonSemicolon = new JButton(";");
		buttonSemicolon.setFont(new Font("Arial", Font.PLAIN, 16));
		keyboard.add(buttonSemicolon).setBounds(8, 152, 42, 42);
		
		JButton buttonColon = new JButton(":");
		buttonColon.setFont(new Font("Arial", Font.PLAIN, 16));
		keyboard.add(buttonColon).setBounds(52, 152, 42, 42);
		
		JButton buttonZ = new JButton("Z");
		buttonZ.setFont(new Font("Arial", Font.PLAIN, 12));
		keyboard.add(buttonZ).setBounds(96, 152, 42, 42);
		
		JButton buttonX = new JButton("X");
		buttonX.setFont(new Font("Arial", Font.PLAIN, 12));
		keyboard.add(buttonX).setBounds(140, 152, 42, 42);
		
		JButton buttonC = new JButton("C");
		buttonC.setFont(new Font("Arial", Font.PLAIN, 11));
		keyboard.add(buttonC).setBounds(316, 152, 42, 42);
		
		JButton buttonV = new JButton("V");
		buttonV.setFont(new Font("Arial", Font.PLAIN, 12));
		keyboard.add(buttonV).setBounds(360, 152, 42, 42);
		
		JButton buttonB = new JButton("B");
		buttonB.setFont(new Font("Arial", Font.PLAIN, 12));
		keyboard.add(buttonB).setBounds(404, 152, 42, 42);
		
		JButton buttonN = new JButton("N");
		buttonN.setFont(new Font("Arial", Font.PLAIN, 11));
		keyboard.add(buttonN).setBounds(448, 152, 42, 42);
		
		JButton buttonM = new JButton("M");
		buttonM.setFont(new Font("Arial", Font.PLAIN, 8));
		keyboard.add(buttonM).setBounds(492, 152, 42, 42);
		
		JButton buttonSpace = new JButton("SPACE");
		buttonSpace.setFont(new Font("Arial", Font.PLAIN, 12));
		keyboard.add(buttonSpace).setBounds(184, 152, 130, 42);
	}

	public void performSearch(JTextField textField, JFrame frame) { //method to actually do the search in a new tab on google
		String query = textField.getText().trim(); //query is trimmed and stored - no leading or trailing spaces
        if (!query.isEmpty()) {
            try {
            	//encoding the query to handle spaces and other special characters, using standard encoding imports
                query = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
            	String googleSearchUrl = "https://www.google.com/search?q=" + query;//a link is made with the query
                Desktop.getDesktop().browse(new URI(googleSearchUrl)); //new tab is opened with query, using external desktop class's browse function
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error occurred while searching.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace(); //report of errors
            }
        } else { //if nothing is inputted
            JOptionPane.showMessageDialog(frame, "Please enter a search query.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
	}

    public void browseWeb(JFrame frame, JPanel panel) { //method to browse web

        panel.setBackground(Color.WHITE); //panel is updated - display on "computer"

        JTextField textField = new JTextField(); //textfield to get query input
        textField.setBounds(75, 130, 311, 20);
        panel.add(textField);
        textField.setColumns(10);

        JButton searchButton = new JButton("Search"); //button to perform search - entering query
        searchButton.setBounds(180, 173, 95, 28);
        panel.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	performSearch(textField, frame); //will actually run perform search method
            }
        });
        //key listener for the text field
        textField.addKeyListener(new KeyListener() { //will check for searching if enter key is pressed as well
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performSearch(textField, frame); //will perform search
                }
            }

            @Override //necessary to provide implementations for all the methods here, since KeyListener inherits form an abstract class - must include.
            public void keyTyped(KeyEvent e) {} //corresponds to when a key is typed - processing key input - empty, don't need this function.

            @Override
            public void keyReleased(KeyEvent e) {} //corresponds to when a key is released - empty, don't need this function.
        });
        
        JLabel nameLabel = new JLabel("GOOGLE"); //name label to imitate google search engine
        nameLabel.setBounds(108, 65, 240, 54);
        nameLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(nameLabel);
        
        JButton backButton = new JButton("Back"); //button to return back to choosing between searching or coding
        backButton.setBounds(405, 0, 65, 32);
        panel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); //will dispose of the frame
            	makeFrame(new JFrame(), new JPanel(), new JPanel()); //literally making a new frame from scratch - corresponding to make frame method
            }
        });

        frame.setVisible(true); // Make the frame visible after all components are added
    }
	
	public void runIDE(JFrame frame, JPanel panel) { //method to run the coding functionality
        
		panel.setBackground(Color.CYAN); //panel is modified
		
        JLabel nameLabel = new JLabel(getCompatibleIDE()); //label for header, either eclipse or replit depending on ide attribute
        nameLabel.setForeground(new Color(255, 128, 0));
        nameLabel.setBounds(157, 11, 162, 43);
        nameLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(nameLabel);
        
        JPanel consolePanel = new JPanel(); //a panel meant to show text output, the "console"
        consolePanel.setBackground(new Color(0, 64, 128));
        consolePanel.setBounds(19, 205, 433, 27);
        panel.add(consolePanel);
        consolePanel.setLayout(null);
        
        JLabel console = new JLabel(""); //the jlabel for the console
        console.setBackground(Color.WHITE);
        console.setFont(new Font("Monospaced", Font.PLAIN, 12));
        console.setForeground(new Color(0, 255, 0));
        console.setBounds(10, 8, 400, 14);
        consolePanel.add(console);
        
        JPanel IDEPanel = new JPanel(); //ide editing part
        IDEPanel.setBounds(19, 53, 433, 149);
        panel.add(IDEPanel);
        IDEPanel.setLayout(null);
        
        JTextArea providedCodeTop = new JTextArea(); //panel for top part of code, above input section
        providedCodeTop.setFont(new Font("Monospaced", Font.PLAIN, 11));
        providedCodeTop.setText("public class Hello_World {\r\n\tpublic static void main(String[] args) {\r\n\t\t//Displays greetings on the console\r\n\t\tSystem.out.println(\"\r");
        providedCodeTop.setEditable(false);
        providedCodeTop.setBounds(10, 11, 413, 68);
        IDEPanel.add(providedCodeTop);
        
        JTextField codeField = new JTextField(); // text field to receive user input
        codeField.setFont(new Font("Monospaced", Font.PLAIN, 10));
        codeField.setEditable(true);
        codeField.setBounds(10, 80, 413, 15);
        IDEPanel.add(codeField);
        codeField.setColumns(10);
        
        JButton runButton = new JButton("Run"); // will "run code" simply printing the users input as output to the "console"
        runButton.setBackground(new Color(0, 255, 0));
        runButton.setBounds(100, 133, 79, 14);
        IDEPanel.add(runButton);
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	console.setText((codeField.getText()));
            }
        });
        
        JTextArea providedCodeBottom = new JTextArea(); //bottom part of displayed code, underneath textfield
        providedCodeBottom.setText("\r\");\r\n}");
        providedCodeBottom.setFont(new Font("Monospaced", Font.PLAIN, 11));
        providedCodeBottom.setEditable(false);
        providedCodeBottom.setBounds(10, 95, 413, 32);
        IDEPanel.add(providedCodeBottom);
        
        JButton endButton = new JButton("End"); //similar to back button for browseWeb, will close frame and will make new frames and panels
        endButton.setBackground(new Color(255, 0, 0));
        endButton.setBounds(200, 133, 79, 14);
        IDEPanel.add(endButton);
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	makeFrame(new JFrame(), new JPanel(), new JPanel());
            }
        });

        frame.setVisible(true); // Make the frame visible after all components are added
	}
	
	public void displayComputerInfo() { //method to display info about computers attributes
		String info = getIpAddress() + "\n" + getModelNumber() + "\n" + getOperatingSystem() + "\n" + getBrand() + "\n" + getManufacturingDate() + "\n" + getMemorySize() + "\nThis computer is compatible with " + getCompatibleIDE() + "'s IDE.";
		JOptionPane.showMessageDialog(null, info,"SHOWING INFO", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void main(String[] args) {
	    
		JFrame frame = new JFrame();
	    JPanel panel = new JPanel();
	    JPanel keyboard = new JPanel();
	    
		Computer comp = new Computer("192.158.1.38", 1546, "macOS", "LENOVO", 2020, "64GB", "Replit"); //using class constructor for specifications
        comp.makeFrame(frame, panel, keyboard); //frame is made - action is taken depending on button clicks
    }

}
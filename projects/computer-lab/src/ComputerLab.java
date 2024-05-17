/* This is an OOP oriented project that creates a simulates the creation of objects in a computer lab.
 * This class is the shell for the computer lab, like a home-page.
 * Users can navigate to internal, independent objects through the use of a Window BUilder GUI equipped with buttons.
 * Author Krish Punjabi and Isimbi Karama
 * Date May 17 2024
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class ComputerLab {
	
	//These are the fields or variables of the class. Each ComputerLab object will have these variables.
	int roomNumber;
	int floorNumber;
	boolean openStatus;
	String owner;
	
	//default class constructor
	public ComputerLab () {
			
		this.roomNumber = 100;
		this.floorNumber = 1;
		this.openStatus = true;
		this.owner = "Teacher";
	}
	
	//class constructor, invoked with the new operator; instantiate & initializes an object of class ComputerLab with parameters
	public ComputerLab (int roomNumber, int floorNumber, boolean openStatus, String owner) {
		
		this.roomNumber = roomNumber;
		this.floorNumber = floorNumber;
		this.openStatus = openStatus;
		this.owner = owner;
	}
	
	//Getters
	
	public String getRoomNumber() {
		return "This lab is in room " + roomNumber + ". ";
	}
	
	public String getFloorNumber() {
		return "This lab is on floor " + floorNumber + ". ";
	}

	public String isStatus() {
		String statusString;
		if (openStatus)
			statusString = "This lab is currently open.";
		else
			statusString = "This lab is currently closed.";
		return statusString;
	}

	public String getOwner() {
		return owner;
	}

	//Setters
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public void setStatus(boolean status) {
		this.openStatus = status;
	}	
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void programDescription() {//welcome to computer lab message
        JOptionPane.showMessageDialog(null, "Welcome to " + getOwner() + "'s computer lab!","WELCOME", JOptionPane.INFORMATION_MESSAGE);
    }

    public void goodBye() { // this method displays a goodbye message to the user
        JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
        System.exit(0);// closes the program
    }
    
	public void chooseProcedure(JFrame homepage, JFrame mainFrame, JPanel mainPanel, JPanel keyboard) {// This method shows the user buttons for each object and runs the main of that class if it is clicked

		homepage.getContentPane().setBackground(new Color(255, 128, 192));
		homepage.addWindowListener(new WindowAdapter() {//listening for event regarding x button inbuilt to window
            @Override
            public void windowClosing(WindowEvent e) {
                homepage.dispose();
            	goodBye(); //goodbye method, set as close operation
            }
        });
		
	    homepage.setSize(935, 680); //setting homepage size
	    homepage.getContentPane().setLayout(null); //using absolute layout, nothing specific
	    
		JButton desktopButton = new JButton("Desktops"); //desktop button
		desktopButton.setBackground(new Color(0, 0, 255));
		desktopButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		desktopButton.setBounds(163, 160, 282, 156);
		homepage.getContentPane().add(desktopButton);
		
		JButton teacherButton = new JButton("Teacher"); //teacher button
		teacherButton.setBackground(new Color(255, 255, 0));
		teacherButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		teacherButton.setBounds(476, 160, 292, 156);
		homepage.getContentPane().add(teacherButton);
		
		JButton chromebookButton = new JButton("Chromebooks"); //chromebook button
		chromebookButton.setBackground(new Color(255, 128, 0));
		chromebookButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		chromebookButton.setBounds(163, 357, 282, 156);
		homepage.getContentPane().add(chromebookButton);
		
		JButton studentButton = new JButton("Students"); //student button
		studentButton.setBackground(new Color(255, 0, 0));
		studentButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		studentButton.setBounds(476, 357, 292, 156);
		homepage.getContentPane().add(studentButton);
		
		JButton infoButton = new JButton("Lab Info"); //info button
		infoButton.setBackground(new Color(0, 255, 128));
		infoButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		infoButton.setBounds(340, 50, 251, 68);
		homepage.getContentPane().add(infoButton);
		
		JLabel chooseLabel = new JLabel("What would you like to explore?"); //general message
		chooseLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		chooseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chooseLabel.setBounds(150, 547, 618, 62);
		homepage.getContentPane().add(chooseLabel);
		
		teacherButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        Teacher t = new Teacher();
		        t.makeFrame(t.getTeacherName(), t.getEmailAddress(), mainFrame, mainPanel, ClassList.getStudentList());
		    }
		});
	    
		studentButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Student s = new Student();
				s.makeFrame(s.getStudentName(),s.getGrade(), mainFrame, mainPanel);
		    }
		});
		
		desktopButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	DesktopComputer desktop = new DesktopComputer("192.158.1.38", 2153, "macOS", "LENOVO", 2007, "64GB", "Eclipse"); //DesktopComputer is made with its specifications
	            desktop.makeFrame(mainFrame, mainPanel, keyboard); // frame is made
	        }
	    });
		
	    chromebookButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) { 
	        	Chromebook chromebook = new Chromebook("205.128.7.36", 56346, "chromeOS", "ACER", 2023, "32GB", "Replit", false); //Chromebook is created with specifications
	    		chromebook.makeFrame(mainFrame, mainPanel, keyboard); //homepage is made
	        }
	    });
	    
	    infoButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	labInfo(); //will run the lab info method if clicked
	        }
	    });
	    
	    while (homepage.isVisible()) { //this acts as a buffer, ensuring that the program doesn't keep going on while the user is interacting with the homepage - like a wait block
	        try { //necessary to ensure collaboration between JFrames and JOption Panes - when displaying goodbye message, info message, etc.
	            Thread.sleep(10000); //instead of instantly instantiating many copies of thre homepage, if a jhomepage is open, it will take 10 seconds for this to reappear
	        } catch (InterruptedException ex) {
	            ex.printStackTrace();
	        }
	    }
	    
        homepage.setVisible(true); // Make the homepage visible after all components are added
	}
	
	public void labInfo() { // this method displays info about the lab to the user
        String info = getRoomNumber() + "\n" + getFloorNumber() + "\n" + isStatus() + "\nThe owner of this lab is " + getOwner() + ".";
		JOptionPane.showMessageDialog(null, info);
    }
	
	public static void main(String[] args) {
		
		JFrame homepage = new JFrame();
		JFrame mainFrame = new JFrame();
	    JPanel mainPanel = new JPanel();
	    JPanel keyboard = new JPanel();
	    
		ComputerLab computerLab = new ComputerLab(225, 2, true, "Natasha Rakocevic"); //computerLab is instantiated
		
		computerLab.programDescription(); //program description
		while (true) { //on frame disposal, will go back here - ensures the creation of only one computerLb object, until is closed. This frame wil continuaslly run in the background
				computerLab.chooseProcedure(homepage, mainFrame, mainPanel, keyboard); //Frame with buttons is created, waiting on users to choose something
		}
	} 
}
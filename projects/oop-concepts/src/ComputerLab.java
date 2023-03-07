/* This is an OOP class that shows the user various dogs with various attributes 
 * Author Krish Punjabi
 * Date April 16 2024
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ComputerLab {
	
	//These are the fields or variables of the class. Each DogSimple object will have these variables.
	int roomNumber;
	int floorNumber;
	boolean status; 
	boolean availibility;
	
	//class constructor, invoked with the new operator; instantiate & initializes an object of class DogSimple, with parameters
	public ComputerLab (int roomNumber, int floorNumber, boolean status, boolean availibility) { 
		
		this.roomNumber = roomNumber;
		this.floorNumber = floorNumber;
		this.status = status;
		this.availibility = availibility;
	}
		
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public int getFloorNumber() {
		return floorNumber;
	}

	public boolean isStatus() {
		return status;
	}
	
	public boolean isAvailibility() {
		return availibility;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setAvailibility(boolean availibility) {
		this.availibility = availibility;
	}

	/*public String bark() { //this method makes the dog bark
	    String bark = this.getName() + " barks"; 
		try {
	        int playbackTime = 0; //clip starts from beginning
	        File file = new File(this.getBreed() + " Bark.wav"); //each dog has a unique bark, clip chosen according to name
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file); //file to audio
	        Clip clip = AudioSystem.getClip(); //audio to clip
	        clip.open(audioStream); //clip is opened
	        clip.setMicrosecondPosition(playbackTime); //starting point is set
	        clip.start(); //these lines above make the clip play
 
	    } catch (Exception e) {
	        e.printStackTrace();
	        bark =  "Error: Bark action failed"; //in case file is not found
	    }
		return bark;
	}
	
	public void eat() {
		String eat = this.getName() + " is excited to eat!";
		ImageIcon treat = new ImageIcon("Treat.png"); //special image file
		JOptionPane.showMessageDialog(null, eat, "Eat", JOptionPane.INFORMATION_MESSAGE, treat);
	}
	
	public String sleep() { //this method plays two audio tracks together and displays a sleeping message, same logic as bark
		String sleep = this.getName() + " is sleeping";
		try {
	        int playbackTime = 0;
	        File file = new File("Lullaby.wav");
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioStream);
	        clip.setMicrosecondPosition(playbackTime);
	        clip.start();
	        
	        File file2 = new File("Snore.wav");
	        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
	        Clip clip2 = AudioSystem.getClip();
	        clip2.open(audioStream2);
	        clip2.setMicrosecondPosition(playbackTime);
	        clip2.start();
	        
	        // Pause for 3 seconds, let both clips play together
	        Thread.sleep(3000);

	        // Stop both clips
	        clip.stop();
	        clip2.stop();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        sleep = "Error: Sleep action failed";
	    }
		return sleep;
	}
	
	//Other class methods
	public String getDescriptiveAge() {

		String ageDescription = " He is very old and sleeps a lot.";
		if (getAge() <= 2) ageDescription = " He is still a puppy.";
		else if (getAge() <= 7) ageDescription = " He is in his best years.";
		else if (getAge() <= 10) ageDescription = " He is an old boy, but still likes to play.";
		return ageDescription;
	}*/
		
	public void displayInfo() { //this method takes all the info and creates a jframe to display it
		JFrame frame = new JFrame("Dog Information");
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(935, 580);
	    JLabel nameLabel = new JLabel("Name: " + getName());
	    nameLabel.setBounds(646, 42, 240, 54);
	    JLabel breedLabel = new JLabel("Breed: " + getBreed());
	    breedLabel.setBounds(646, 132, 240, 54);
	    JLabel colorLabel = new JLabel("Color: " + getColour());
	    colorLabel.setBounds(646, 235, 240, 54);
	    JLabel ageLabel = new JLabel("Age: " + getAge() + ", " + getDescriptiveAge());
	    ageLabel.setBounds(646, 338, 240, 54);
	    JLabel photoLabel = new JLabel(getPhoto());
	    photoLabel.setBounds(22, 22, 600, 400); //all attributes are accessed with getter methods, stored in JLabels
	    
	    JPanel buttonPanel = new JPanel(); // a button panel is created to store buttons with specific methods for the dogsimple objects
	    buttonPanel.setBounds(10, 446, 909, 95);
	    JButton barkButton = new JButton("Bark");
	    barkButton.setBounds(50, 20, 200, 55);
	    barkButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) { //message is displayed, and bark method is executed (if this button is pressed)
	            JOptionPane.showMessageDialog(frame, bark(), "Bark", JOptionPane.INFORMATION_MESSAGE);
	        }
	    });

	    JButton sleepButton = new JButton("Sleep");
	    sleepButton.setBounds(250, 20, 200, 55);
	    sleepButton.addActionListener(new ActionListener() { 
	        @Override
	        public void actionPerformed(ActionEvent e) { //message is displayed, and sleep method is executed (if this button is pressed)
	            JOptionPane.showMessageDialog(frame, sleep(), "Sleep", JOptionPane.INFORMATION_MESSAGE);
	        }
	    });

	    JButton eatButton = new JButton("Eat");
	    eatButton.setBounds(450, 20, 200, 55);
	    eatButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) { //message is displayed, and eat method is executed (if this button is pressed)
	        	eat();
	        }
	    });
	    
	    JButton backButton = new JButton("Back");
	    backButton.setBounds(650, 20, 200, 55);
	    backButton.addActionListener(new ActionListener() { 
	        @Override
	        public void actionPerformed(ActionEvent e) {// if this button is pressed, the frame just disposes - loop in main continues
                frame.dispose(); // Close the frame
	        }
	    });
	    
	    buttonPanel.setLayout(null);

	    buttonPanel.add(barkButton);
	    buttonPanel.add(sleepButton);
	    buttonPanel.add(eatButton);
	    buttonPanel.add(backButton);
	    
	    frame.getContentPane().setLayout(null);

	    frame.getContentPane().add(nameLabel);
	    frame.getContentPane().add(breedLabel);
	    frame.getContentPane().add(colorLabel);
	    frame.getContentPane().add(ageLabel);
	    frame.getContentPane().add(photoLabel);
	    
	    frame.getContentPane().add(buttonPanel); //all labels with info are added to buttons, which are added to the frame

	    frame.setVisible(true);
	    
	    while (frame.isVisible()) { //this acts as a buffer, ensuring that the program doesn't keep going on while the user is interacting with the frame - like a wait block
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	public static void programDescription() {
        JOptionPane.showMessageDialog(null, "This program introduces three lovely doggies to the user.\n","DOGGIES", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void goodBye() { // this method displays a goodbye message to the user
        JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
        System.exit(0);// closes the program
    }
    
	public static void printDogInfo(ComputerLab d1, ComputerLab d2, ComputerLab d3) {
		//Create a String to be printed out
		//use a get method to display some variables
		String message = "Dog number 1 - name: " + d1.getName() + 
				       "\nDog number 2 - name: " + d1.getName() +
				       "\nDog number 3 - name: " + d3.getName();
		JOptionPane.showMessageDialog(null, message, "DOGGY INFO", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static int chooseDoggy(ComputerLab d1, ComputerLab d2, ComputerLab d3) {// This method chooses which procedure to go through, using option buttons
		int intInput;
		
		String []options = {d1.getName(), d2.getName(), d3.getName(), "Cancel"}; // can either choose one of the doggies, or to cancel
		intInput = JOptionPane.showOptionDialog(null, "Which doggy would you like to meet first?", "How would you like to proceed?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (intInput == (options.length - 1) || intInput == ((options.length - 1) - (options.length))) {// if index is final or -1, will terminate (cancel button or null)
			goodBye();
		}
		return intInput; // communicating procedure type
	}
	
	public static void main(String[] args) {
		
		
		int doggyType; //declaring variable to hold procedure/doggy type
		final int BACK = -1; //constants for switch case table, possible doggytypes
		final int DOGGY_ONE = 0;
		final int DOGGY_TWO = 1;
		final int DOGGY_THREE = 2;

		//instantiate 3 DogSimple objects. Notice the operator new & the argument list 
		ComputerLab d1 = new ComputerLab("Simba", "Pug", "Fawn", 6, new ImageIcon ("Pug.png"));
		ComputerLab d2 = new ComputerLab("Cookie", "Poodle", "Black", 1, new ImageIcon ("Poodle.png"));
		ComputerLab d3 = new ComputerLab("Becky", "German Shepherd", "Black and Fawn", 13, new ImageIcon ("German Shepherd.png"));
		
		programDescription();
		doggyType = chooseDoggy(d1, d2, d3); //choosing procedure based on input, storing it
	    while (true) {// while cancel button is not pressed
	        switch (doggyType) {
		        case BACK: //in this case, will ask again for input
		        	doggyType = chooseDoggy(d1, d2, d3);
		        	continue;
		        case DOGGY_ONE:
	                //call the method displayInfo for each Dog object - case dependent on selection
	                d1.displayInfo();
	                break;
	            case DOGGY_TWO:
	                d2.displayInfo();    
	                break;
	            case DOGGY_THREE:
	                d3.displayInfo();
	                break;
	            default: // mandatory break here
	            	break;
	        }
	            doggyType = BACK; //user wants to go back, will reach here if back button (getting out of displayInfo due to buffer) or x is pressed
	            continue; // returns to home page, start of loop, choosing procedure again
	    }
	} 
}
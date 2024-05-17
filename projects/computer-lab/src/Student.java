import java.awt.*;
import java.awt.event.*;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class Student {

	// Fields or variables of the class
	String studentName;
	int grade;

	// Class constructor
	public Student () {
		this.studentName = "Jacob";
		this.grade = 0;
	}

	// Class constructor with parameters
	public Student (String studentName, int grade) {
		this.studentName = studentName;
		this.grade = grade;
	}

	// Getter methods
	public String getStudentName() {
		return studentName;
	}

	public int getGrade() {
		return grade;
	}

	// Setter methods
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}


    // Method to present an assignment
    public void presentAssignment() {
        // Display presentation panel
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout());

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setBackground(new Color(0, 7, 100));

        JLabel chargedLabel = new JLabel("NOW PRESENTING CODE", SwingConstants.CENTER);
        chargedLabel.setForeground(Color.PINK);
        chargedLabel.setFont(new Font("Calibri", Font.PLAIN, 20));

        // Create and add the image icon label
        ImageIcon imageIcon = new ImageIcon("present.png");
        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);

        panel.add(chargedLabel, BorderLayout.NORTH);
        panel.add(imageLabel, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.setSize(600, 600); // Set frame size
        frame.setVisible(true);
    }

    // Method to simulate going to the bathroom
    public void goToBathroom() {
        // Display bathroom panel and play sound effect
        String audioFilePath = "toiletSoundEffect.wav";
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout());

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setBackground(new Color(0, 7, 100));

        JLabel chargedLabel = new JLabel("Welcome to the bathroom!", SwingConstants.CENTER);
        chargedLabel.setForeground(Color.PINK);
        chargedLabel.setFont(new Font("Calibri", Font.PLAIN, 20));

        // Create and add the image icon label
        ImageIcon imageIcon = new ImageIcon("bathroom.png");
        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);

        panel.add(chargedLabel, BorderLayout.NORTH);
        panel.add(imageLabel, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.setSize(600, 600); // Set frame size
        frame.setVisible(false);
        // Play the sound after the panel is added
        playSound(audioFilePath);
        frame.setVisible(true);
    }

    // Method to simulate eating pancakes
    public void eatPancakes() {
        // Display eating pancakes panel and play chewing sound effect
        String audioFilePath = "ChewingSoundEffect.wav";
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout());

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setBackground(new Color(5, 11, 100));

        JLabel chargedLabel = new JLabel("LET'S EAT PANCAKES WITH MAHMOOD!", SwingConstants.CENTER);
        chargedLabel.setForeground(Color.RED);
        chargedLabel.setFont(new Font("Calibri", Font.PLAIN, 20));

        // Create and add the image icon label
        ImageIcon imageIcon = new ImageIcon("pancakes.png");
        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);

        panel.add(chargedLabel, BorderLayout.NORTH);
        panel.add(imageLabel, BorderLayout.CENTER);

        frame.getContentPane().add(panel);

        frame.setSize(600, 600); // Set frame size
        frame.setVisible(false);
        playSound(audioFilePath);
        frame.setVisible(true);
    }
	
	// Method to play a sound
	public void playSound(String audioFilePath) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File(audioFilePath)));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000); // Wait for the clip to finish
			clip.close();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
			JOptionPane.showMessageDialog(null,"Error playing audio: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public JFrame makeFrame(String teacherName, int Grade, JFrame frame, JPanel panel) { 

		frame.getContentPane().setBackground(new Color(128, 128, 0));
		
		// Create desktop panel
		JPanel desktop = new JPanel();
		desktop.setBackground(Color.RED);
		desktop.setBounds(167, 22, 600, 500);
		desktop.setLayout(null);
		
		 // Create and add the "STUDENT HANDBOOK" label
        JLabel titleLabel = new JLabel("STUDENT");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
        titleLabel.setBounds(50, 20, 400, 50);
        panel.add(titleLabel);

		// Configure panel
		panel.setBounds(251, 190, 510, 400);
		panel.setBackground(new Color(0, 255, 255));
		panel.setLayout(null); 
		panel.setLocation(35, 30);
		
		// Add an image to the control panel
        ImageIcon imageIcon = new ImageIcon("student.png");
		
        // Setup another panel below the desktop panel to hold an image icon
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(0, 200, 510, 200);
		panel.add(imagePanel);
		
		// Add the image icon to the image panel
		JLabel imageIconLabel = new JLabel(imageIcon);
		imageIconLabel.setBounds(25, 50, imageIcon.getIconWidth(), imageIcon.getIconHeight());
		imagePanel.add(imageIconLabel);
		
		// Add panel to desktop
		desktop.add(panel);
		panel.setLayout(null);
		frame.getContentPane().add(desktop);    

		// Set frame properties
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(935, 680); 
		frame.getContentPane().setLayout(null);

		// Create buttons
		JButton eatPancakesButton = new JButton("Pancakes");
		eatPancakesButton.setBackground(new Color(255, 128, 128));
		eatPancakesButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		eatPancakesButton.setBounds(22, 88, 130, 68);
		panel.add(eatPancakesButton);

		JButton goBathroomButton = new JButton("Bathroom");
		goBathroomButton.setBackground(new Color(128, 255, 128));
		goBathroomButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		goBathroomButton.setBounds(187, 88, 137, 68);
		panel.add(goBathroomButton);

		JButton presentButton = new JButton("Present");
		presentButton.setBackground(new Color(255, 255, 128));
		presentButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		presentButton.setBounds(359, 88, 117, 68);
		panel.add(presentButton);

		//since this is the class that will be used in the computer lab, need a button to navigate back to the homepage - essentially just dispose the frame. 
        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(255, 0, 0));
        backButton.setBounds(413, 11, 74, 23);
        panel.add(backButton); 
        
		// Action listeners for buttons
		eatPancakesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eatPancakes(); 
			}
		});

		goBathroomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goToBathroom();
			}
		});

		presentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				presentAssignment();
			}
		});
		
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); //disposes frame, as homepage lies underneath
            }
        });
		
		// Make the frame visible after all components are added
		frame.setVisible(true);

		// Return the frame
		return frame;
	}

	public static void main(String[] args) { //for use if running independently
		// Create a new frame and panel
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		// Create a new Student object
		Student s = new Student();
		// Call the makeFrame method to display the frame
		s.makeFrame(s.getStudentName(),s.getGrade(),frame, panel);
		
	}
}
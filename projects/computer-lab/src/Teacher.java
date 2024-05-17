import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

// Teacher class definition
public class Teacher {
    private String teacherName; // Teacher's name
    private String emailAddress; // Teacher's email address

    // Default constructor
    public Teacher () {
		this.teacherName = "Teacher";
		this.emailAddress = "teacher@ocsb.ca";
	}

    // Parameterized constructor
    public Teacher(String teacherName, String emailAddress) {
        this.teacherName = teacherName;
        this.emailAddress = emailAddress;
    }
    
    //special constructor, used if only name is provided, creates email using lowercase firstname.lastname format
    public Teacher (String teacherName) {
		this.teacherName = teacherName;
		this.emailAddress = teacherName.toLowerCase().replaceFirst(" ", ".") + "@ocsb.ca";
	}

    // Getter for teacher's name
    public String getTeacherName() {
        return teacherName;
    }

    // Getter for teacher's email address
    public String getEmailAddress() {
        return emailAddress;
    }

    // Method to set teacher's name with validation
    public void setTeacherName(String teacherName, JFrame frame, JPanel panel) {
        boolean invalid = true;
        while (invalid) {
            try {
                String input = JOptionPane.showInputDialog(null, "What is your full Name?", "ARRAY INSERT", JOptionPane.INFORMATION_MESSAGE);
                if (input == null) {
                    frame.dispose();
                }
                if (!input.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$")) {
                    throw new Exception("Only letters or words");
                }
                teacherName = input.trim().toUpperCase();
                this.teacherName = teacherName;
                invalid = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "INVALID INPUT. Please enter a name", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to set teacher's email address with validation
    public void setEmailAddress(String emailAddress, JFrame frame, JPanel panel) {
        boolean invalid = true;
        while (invalid) {
            try {
                String input = JOptionPane.showInputDialog(null, "What is your email address?", "ARRAY INSERT", JOptionPane.INFORMATION_MESSAGE);
                if (input == null) {
                    frame.dispose();
                }
                this.emailAddress = input;
                invalid = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "INVALID INPUT. Please enter a valid email address", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public JFrame makeFrame(String teacherName, String emailAddress, JFrame frame, JPanel panel, List<Student> studentList) {
        
    	frame.getContentPane().setBackground(new Color(192, 192, 192));
        // Setup the main desktop panel with a green background
        JPanel desktop = new JPanel();
        desktop.setBackground(Color.BLUE);
        desktop.setBounds(167, 22, 540, 298);
        desktop.setLayout(null);

        // Setup the control panel with a gray background and add it to the desktop panel
        panel.setBounds(251, 190, 470, 243);
        panel.setBackground(new Color(128, 0, 128));
        panel.setLayout(null);
        panel.setLocation(35, 30);
        desktop.add(panel);
        frame.getContentPane().add(desktop);
        

        // Configure the frame's default close operation and size
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(935, 680);
        frame.getContentPane().setLayout(null);

        // Add an image to the control panel
        ImageIcon imageIcon = new ImageIcon("desk-removebg-preview.png");
        
        // Setup another panel below the desktop panel to hold an image icon
        JPanel imagePanel = new JPanel();  
        imagePanel.setBounds(194, 331, 500,300);
        frame.getContentPane().add(imagePanel);

        // Add the image icon to the image panel
        JLabel imageIconLabel = new JLabel(imageIcon);
        imageIconLabel.setBounds(25, 50, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        imagePanel.add(imageIconLabel);

        // Add buttons to the control panel
        addButtonsToPanel(panel, teacherName, emailAddress, frame, studentList);

        // Add a button to view teacher details
        JButton detailButton = new JButton("View Teacher Details");
        detailButton.setBackground(new Color(128, 0, 255));
        detailButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        detailButton.setBounds(745, 258, 134, 39);
        frame.getContentPane().add(detailButton);
        detailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTeacherInfo();
            }
        });

        // Make the frame visible after all components are added
        frame.setVisible(true);

        return frame;
    }


    public void addButtonsToPanel(JPanel panel, String teacherName, String emailAddress, JFrame frame, List<Student> studentList) {
        // Button to set the teacher profile
        JButton setProfileButton = new JButton("Set Teacher Profile");
        setProfileButton.setBackground(new Color(128, 255, 0));
        setProfileButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        setProfileButton.setBounds(25, 11, 160, 55);
        setProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTeacherName(teacherName, frame, panel);
                setEmailAddress(emailAddress, frame, panel);
            }
        });
        panel.add(setProfileButton);

        // Button to view the class list
        JButton setStudentsButton = new JButton("View Class List");
        setStudentsButton.setBackground(new Color(255, 255, 0));
        setStudentsButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        setStudentsButton.setBounds(274, 185, 170, 47);
        setStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewStudentInfo(studentList);
            }
        });
        panel.add(setStudentsButton);

        // Button to add a student to the class list
        JButton addStudentButton = new JButton("Add Student to Class List");
        addStudentButton.setBackground(new Color(0, 255, 255));
        addStudentButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        addStudentButton.setBounds(274, 11, 170, 55);
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter student name:");
                String gradeStr = JOptionPane.showInputDialog("Enter student grade:");
                try {
                    int grade = Integer.parseInt(gradeStr);
                    ClassList.addStudent(name, grade);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid grade. Please enter a number.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(addStudentButton);

        // Button to start teaching students
        JButton teachClassButton = new JButton("Teach Students");
        teachClassButton.setBackground(new Color(255, 128, 0));
        teachClassButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        teachClassButton.setBounds(148, 94, 160, 68);
        teachClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teachStudents("OOP");
            }
        });
        panel.add(teachClassButton);

        // Button to tell a story
        JButton storyButton = new JButton("Tell Story");
        storyButton.setBackground(new Color(255, 128, 128));
        storyButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        storyButton.setBounds(25, 185, 160, 47);
        storyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tellStory();
            }
        });
        panel.add(storyButton);
        
        //since this is the class that will be used in the computer lab, need a button to navigate back to the homepage - essentially just dispose the frame. 
        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(255, 0, 0));
        backButton.setBounds(25, 111, 76, 36);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); //disposes frame, as homepage lies underneath
            }
        });
        panel.add(backButton);
    }

    // Method to display teacher information
    public void viewTeacherInfo() {
        JOptionPane.showMessageDialog(null, "LOGIN DETAILS:\nName: " + getTeacherName() + "\nEmail: " + getEmailAddress());
    }

    // Method to display student information
    public void viewStudentInfo(List<Student> studentList) {
        JFrame frame = new JFrame("Class List");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));

        JLabel titleLabel = new JLabel("CLASS LIST", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);

        String[] columnNames = {"No", "NAME", "GRADE"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            model.addRow(new Object[]{i + 1, student.getStudentName(), student.getGrade()});
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 200));
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Method to teach students a lesson
    public void teachStudents(String lesson) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setBackground(new Color(5, 11, 100));
        panel.setBounds(600, 200, 470, 243);
        panel.setLocation(35, 30);
        panel.setLayout(null);

        JLabel chargedLabel = new JLabel("Today's lesson is on..." + lesson);
        chargedLabel.setForeground(Color.RED);
        chargedLabel.setBounds(56, 47, 475, 81);
        chargedLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        chargedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chargedLabel.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(chargedLabel);
        frame.getContentPane().add(panel);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    // Method to tell a story
    public void tellStory() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setBackground(new Color(5, 11, 100));
        panel.setBounds(600, 200, 470, 243);
        panel.setLocation(35, 30);
        panel.setLayout(null);

        JLabel chargedLabel = new JLabel("Once upon a time in Croatia...!");
        chargedLabel.setForeground(Color.RED);
        chargedLabel.setBounds(56, 47, 475, 81);
        chargedLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        chargedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chargedLabel.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(chargedLabel);
        frame.getContentPane().add(panel);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    // Main method to start the application
    public static void main(String[] args) { //for use if running independently
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        Teacher t = new Teacher();

        // Use the student list from ClassList
        t.makeFrame(t.getTeacherName(), t.getEmailAddress(), frame, panel, ClassList.getStudentList());
    }
}



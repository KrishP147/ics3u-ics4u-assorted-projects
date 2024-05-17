import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClassList {
    // List to hold student information
    private static List<Student> studentList = new ArrayList<>();
    private static final String FILE_NAME = "student.txt"; // File name to read/write student data
    private static final int MAX_NEW_STUDENTS = 35; // Maximum number of new students allowed
    private static int newStudentCount = 0; // Counter for new students added

    // Static block to initialize student list from file
    static {
        readStudentsFromFile(FILE_NAME);
    }

    // Method to get the list of students
    public static List<Student> getStudentList() {
        return studentList;
    }

    // Method to set the list of students
    public static void setStudentList(List<Student> studentList) {
        ClassList.studentList = studentList;
    }

    // Method to read students from a file and populate the student list
    public static void readStudentsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int grade = Integer.parseInt(parts[1].trim());
                    studentList.add(new Student(name, grade));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error reading from file: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to append a new student record to the file
    public static void addStudentToFile(String fileName, String name, int grade) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(name + "," + grade);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to add a student to the list and save to the file
    public static void addStudent(String name, int grade) {
        // Check if the maximum number of new students has been reached
        if (newStudentCount >= MAX_NEW_STUDENTS) {
            JOptionPane.showMessageDialog(null, "Error: Class is full. The teacher currently Cannot add more than " + MAX_NEW_STUDENTS + " new students.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check for duplicate student name
        for (Student student : studentList) {
            if (student.getStudentName().equals(name)) {
                JOptionPane.showMessageDialog(null, "Error: Student " + name + " already exists.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Add new student to the list and save to file
        studentList.add(new Student(name, grade));
        addStudentToFile(FILE_NAME, name, grade);
        newStudentCount++; // Increment the new student counter
    }
}





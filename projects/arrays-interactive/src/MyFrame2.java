import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame2 extends JFrame {
    private int size = 12;
    private JPanel buttonPanel;
    private JButton[] buttons;
    private JScrollPane scrollPane;

    public MyFrame2() {
        super("Interactive Array GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel for the array of buttons with a linear layout
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(size, 1));

        // Populate the buttons
        buttons = new JButton[size];
        for (int i = 0; i < size; i++) {
            buttons[i] = new JButton("Button " + (i + 1)); // Sample button text
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 20)); // Set the font for the button text
            buttonPanel.add(buttons[i]); // Add the button to the panel
        }

        // Create a JScrollPane and add the button panel to it
        scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the frame
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Create additional buttons for demonstration
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        controlPanel.add(addButton);
        controlPanel.add(removeButton);

        // Add the control panel to the frame
        getContentPane().add(controlPanel, BorderLayout.SOUTH);

        // Set frame size and visibility
        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyFrame());
    }
}
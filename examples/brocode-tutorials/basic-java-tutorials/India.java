import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class India {

    public static void main(String[] args) {
    	ImageIcon icon = new ImageIcon("Ashoka_Chakra.svg.png");
    	 int newWidth = 100; // New width in pixels
         int newHeight = 100; // New height in pixels
         ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH));
		JLabel label = new JLabel();
		label.setIcon(resizedIcon);
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.LEFT);
		
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 350); //acts up w 300
        frame.setResizable(true); // prevent frame from being resized 

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setBackground(new Color(0xFF671F));
        panel2.setBackground(new Color(0x046A38));
        panel3.setBackground(Color.white);

        panel1.setPreferredSize(new Dimension(600, 100));
        panel2.setPreferredSize(new Dimension(600, 100)); 
        panel3.setPreferredSize(new Dimension(600, 100));

        frame.setLayout(new BorderLayout());

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.add(panel3, BorderLayout.CENTER);
        // Create a panel for the label and add it to the NORTH region of the frame
        JPanel labelPanel = new JPanel();
        labelPanel.add(label); // Add the label to the labelPanel
        frame.add(labelPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.pack();
        
    }
}
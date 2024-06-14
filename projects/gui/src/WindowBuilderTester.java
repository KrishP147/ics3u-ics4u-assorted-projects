import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class WindowBuilderTester extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton addButton;
	private JButton multiplyButton;
	private JRadioButton yesButton;
	private JRadioButton noButton;
	private JTextField tField1;
	private JTextField tField2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public WindowBuilderTester() {
		// JFrame settings
		getContentPane().setLayout(null);
		setSize(900, 850);
		setTitle("RECURSION PRACTICE");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Adding JPanel
		panel = new JPanel();
		panel.setBounds(0, 0, 884, 811);
		panel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel);
		panel.setLayout(null);

		// Adding JScrollPane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 480, 884, 333);
		scrollPane.setBackground(Color.LIGHT_GRAY);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		// // Disable vertical scrollbar
		panel.add(scrollPane);

		// Adding JPanel for buttons
		JPanel judgePanel = new JPanel();
		judgePanel.setLayout(null);
		judgePanel.setPreferredSize(new Dimension(2200, 333)); // Set preferred size to enable scrolling
		scrollPane.setViewportView(judgePanel); // Add judgePanel to scrollPane

		JLabel lblEnterANumber_1_1 = new JLabel("CLICK ON THE JUDGE SCROLLPANE TO CHECK THEIR IMPRESSIONS!");
		lblEnterANumber_1_1.setForeground(Color.BLUE);
		lblEnterANumber_1_1.setBounds(275, 0, 397, 30);
		judgePanel.add(lblEnterANumber_1_1);

		// Adding JButtons for judges
		JButton tiger = new JButton("JUDGE TIGER");
		tiger.setBackground(Color.BLUE);
		tiger.setForeground(Color.MAGENTA);
		tiger.setIcon(new ImageIcon("tiger.jpg"));
		tiger.setVerticalTextPosition(SwingConstants.BOTTOM);
		tiger.setHorizontalTextPosition(SwingConstants.CENTER);
		tiger.setIconTextGap(6);
		tiger.setBounds(57, 38, 202, 267);
		tiger.addActionListener(e -> System.out.println("Tiger clicked"));
		judgePanel.add(tiger);

		JButton lion = new JButton("JUDGE LION");
		lion.setBackground(Color.BLUE);
		lion.setForeground(Color.MAGENTA);
		lion.setIcon(new ImageIcon("lion.jpg"));
		lion.setVerticalTextPosition(SwingConstants.BOTTOM);
		lion.setHorizontalTextPosition(SwingConstants.CENTER);
		lion.setIconTextGap(5);
		lion.setBounds(337, 38, 202, 267);
		lion.addActionListener(e -> System.out.println("Lion clicked"));
		judgePanel.add(lion);

		JButton horse = new JButton("JUDGE HORSE");
		horse.setBackground(Color.BLUE);
		horse.setForeground(Color.MAGENTA);
		horse.setIcon(new ImageIcon("horse.jpg"));
		horse.setVerticalTextPosition(SwingConstants.BOTTOM);
		horse.setHorizontalTextPosition(SwingConstants.CENTER);
		horse.setIconTextGap(10);
		horse.setBounds(617, 38, 202, 267);
		horse.addActionListener(e -> System.out.println("Horse clicked"));
		judgePanel.add(horse);

		// Adding JButtons for judges
		JButton bear = new JButton("JUDGE BEAR");
		bear.setBackground(Color.BLUE);
		bear.setForeground(Color.MAGENTA);
		bear.setIcon(new ImageIcon("bear.jpg"));
		bear.setVerticalTextPosition(SwingConstants.BOTTOM);
		bear.setHorizontalTextPosition(SwingConstants.CENTER);
		bear.setIconTextGap(6);
		bear.setBounds(897, 38, 202, 267);
		bear.addActionListener(e -> System.out.println("Bear clicked"));
		judgePanel.add(bear);

		JButton turtle = new JButton("JUDGE TURTLE");
		turtle.setBackground(Color.BLUE);
		turtle.setForeground(Color.MAGENTA);
		turtle.setIcon(new ImageIcon("turtle.jpg"));
		turtle.setVerticalTextPosition(SwingConstants.BOTTOM);
		turtle.setHorizontalTextPosition(SwingConstants.CENTER);
		turtle.setIconTextGap(5);
		turtle.setBounds(1177, 38, 202, 267);
		turtle.addActionListener(e -> System.out.println("Turtle clicked"));
		judgePanel.add(turtle);

		JButton elephant = new JButton("JUDGE ELEPHANT");
		elephant.setBackground(Color.BLUE);
		elephant.setForeground(Color.MAGENTA);
		elephant.setIcon(new ImageIcon("elephant.jpg"));
		elephant.setVerticalTextPosition(SwingConstants.BOTTOM);
		elephant.setHorizontalTextPosition(SwingConstants.CENTER);
		elephant.setIconTextGap(10);
		elephant.setBounds(1457, 38, 202, 267);
		elephant.addActionListener(e -> System.out.println("Elephant clicked"));
		judgePanel.add(elephant);

		// Adding JButtons for judges
		JButton dolphin = new JButton("JUDGE DOLPHIN");
		dolphin.setBackground(Color.BLUE);
		dolphin.setForeground(Color.MAGENTA);
		dolphin.setIcon(new ImageIcon("dolphin.jpg"));
		dolphin.setVerticalTextPosition(SwingConstants.BOTTOM);
		dolphin.setHorizontalTextPosition(SwingConstants.CENTER);
		dolphin.setIconTextGap(6);
		dolphin.setBounds(1737, 38, 202, 267);
		dolphin.addActionListener(e -> System.out.println("Dolphin clicked"));
		judgePanel.add(dolphin);

		JButton otter = new JButton("JUDGE OTTER");
		otter.setBackground(Color.BLUE);
		otter.setForeground(Color.MAGENTA);
		otter.setIcon(new ImageIcon("otter.jpg"));
		otter.setVerticalTextPosition(SwingConstants.BOTTOM);
		otter.setHorizontalTextPosition(SwingConstants.CENTER);
		otter.setIconTextGap(5);
		otter.setBounds(2017, 38, 202, 267);
		otter.addActionListener(e -> System.out.println("Otter clicked"));
		judgePanel.add(otter);

		// Adding JLabels
		JLabel label1 = new JLabel("WELCOME TO THE RECURSION ASSESSMENT!");
		label1.setBounds(301, 11, 329, 40);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label1.setForeground(Color.BLUE);
		panel.add(label1);

		JLabel label2 = new JLabel("Enter a number and click the button to find the factorial:");
		label2.setBounds(10, 50, 345, 30);
		label2.setForeground(Color.BLUE);
		panel.add(label2);

		JLabel label3 = new JLabel("Enter a number and click the button to determine if it is a prime number:");
		label3.setBounds(10, 126, 428, 30);
		label3.setForeground(Color.BLUE);
		panel.add(label3);

		JLabel label4 = new JLabel("CONTINUE?");
		label4.setBounds(742, 167, 77, 30);
		label4.setForeground(Color.BLUE);
		panel.add(label4);

		// Adding JTextFields
		tField1 = new JTextField("");
		tField1.setBounds(20, 79, 128, 30);
		tField1.setBackground(Color.MAGENTA);
		panel.add(tField1);

		tField2 = new JTextField("");
		tField2.setBounds(20, 155, 128, 30);
		tField2.setBackground(Color.MAGENTA);
		panel.add(tField2);

		// Adding JButtons
		addButton = new JButton("FACTORIAL");
		addButton.setBounds(180, 79, 461, 30);
		addButton.addActionListener(e -> System.out.println("Factorial clicked"));
		panel.add(addButton);

		multiplyButton = new JButton("PRIME NUMBER?");
		multiplyButton.setBounds(180, 155, 461, 30);
		multiplyButton.addActionListener(e -> System.out.println("Prime clicked"));
		panel.add(multiplyButton);

		// Adding JRadioButtons
		yesButton = new JRadioButton("YES");
		yesButton.setBounds(697, 197, 70, 30);
		yesButton.setBackground(Color.GREEN);
		yesButton.addActionListener(e -> System.out.println("Yes clicked"));
		panel.add(yesButton);

		noButton = new JRadioButton("NO");
		noButton.setBounds(777, 197, 70, 30);
		noButton.setBackground(Color.GREEN);
		noButton.addActionListener(e -> System.out.println("No clicked"));
		panel.add(noButton);

		JButton btnFibonacci = new JButton("FIBONACCI");
		btnFibonacci.setBounds(180, 226, 461, 30);
		panel.add(btnFibonacci);

		textField = new JTextField("");
		textField.setBounds(20, 226, 128, 30);
		textField.setBackground(Color.MAGENTA);
		panel.add(textField);

		JLabel lblEnterANumber = new JLabel("Enter a number and click the button for the Fibonacci sequence:");
		lblEnterANumber.setBounds(10, 197, 397, 30);
		lblEnterANumber.setForeground(Color.BLUE);
		panel.add(lblEnterANumber);

		JLabel lblEnterANumber_1 = new JLabel("Enter a number and click the button for a countdown:");
		lblEnterANumber_1.setBounds(10, 267, 397, 30);
		lblEnterANumber_1.setForeground(Color.BLUE);
		panel.add(lblEnterANumber_1);

		textField_1 = new JTextField("");
		textField_1.setBounds(20, 296, 128, 30);
		textField_1.setBackground(Color.MAGENTA);
		panel.add(textField_1);

		JButton btnFibonacci_1 = new JButton("COUNTDOWN");
		btnFibonacci_1.setBounds(180, 296, 461, 30);
		panel.add(btnFibonacci_1);

		JLabel lblEnterANumber_2 = new JLabel(
				"Enter a number as the base,  and as the exponent, then click the button for their result:");
		lblEnterANumber_2.setBounds(10, 337, 507, 30);
		lblEnterANumber_2.setForeground(Color.BLUE);
		panel.add(lblEnterANumber_2);

		textField_2 = new JTextField("");
		textField_2.setBounds(20, 366, 62, 30);
		textField_2.setBackground(Color.MAGENTA);
		panel.add(textField_2);

		JButton btnFibonacci_2 = new JButton("EXPONENT");
		btnFibonacci_2.setBounds(180, 366, 461, 30);
		panel.add(btnFibonacci_2);

		textField_3 = new JTextField("");
		textField_3.setBounds(86, 366, 62, 30);
		textField_3.setBackground(Color.MAGENTA);
		panel.add(textField_3);

		JLabel lblEnterANumber_2_1 = new JLabel("Enter 2 numbers and click the button for their product:");
		lblEnterANumber_2_1.setBounds(10, 407, 507, 30);
		lblEnterANumber_2_1.setForeground(Color.BLUE);
		panel.add(lblEnterANumber_2_1);

		textField_4 = new JTextField("");
		textField_4.setBounds(20, 436, 62, 30);
		textField_4.setBackground(Color.MAGENTA);
		panel.add(textField_4);

		textField_5 = new JTextField("");
		textField_5.setBounds(86, 436, 62, 30);
		textField_5.setBackground(Color.MAGENTA);
		panel.add(textField_5);

		JButton btnFibonacci_2_1 = new JButton("MULTIPLY");
		btnFibonacci_2_1.setBounds(180, 436, 461, 30);
		panel.add(btnFibonacci_2_1);

		JButton btnNewButton = new JButton("RANDOM");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(722, 67, 97, 23);
		panel.add(btnNewButton);

		JLabel lblGenerateRandomInput = new JLabel("GENERATE RANDOM INPUT?");
		lblGenerateRandomInput.setForeground(Color.BLUE);
		lblGenerateRandomInput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGenerateRandomInput.setBounds(702, 23, 215, 40);
		panel.add(lblGenerateRandomInput);

		JButton btnNewButton_1 = new JButton("INFO");
		btnNewButton_1.setBounds(722, 370, 97, 23);
		panel.add(btnNewButton_1);

		JLabel lblProgramDescription = new JLabel("PROGRAM DESCRIPTION?");
		lblProgramDescription.setForeground(Color.BLUE);
		lblProgramDescription.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProgramDescription.setBounds(702, 332, 215, 40);
		panel.add(lblProgramDescription);

		// Display GUI
		setVisible(true);
	}

	public static void main(String[] args) {
		new WindowBuilderTester();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}

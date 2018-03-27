package blow_fish;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;




/**
 * Class which is create user interface and read 
 * data from user.
 * @author ondrejvane
 *
 */
public class UserInterface {

	private JFrame frame;
	private JTextArea txtrInput;
	private JTextArea txtrKey;
	private JTextArea txtrOutput;
	public JProgressBar progressBar;
	private String inputText;
	public String outputText;
	public String inputKey;
	private String temp;
	public int progressCounter = 78;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 658, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("BlowFish");
		
		JLabel lblInput = new JLabel("Input:");
		lblInput.setBounds(43, 8, 61, 23);
		frame.getContentPane().add(lblInput);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setBounds(43, 144, 61, 16);
		frame.getContentPane().add(lblKey);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(43, 234, 61, 16);
		frame.getContentPane().add(lblOutput);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 27, 572, 105);
		frame.getContentPane().add(scrollPane);
		
		txtrInput = new JTextArea();
		scrollPane.setViewportView(txtrInput);
		txtrInput.setLineWrap(true);
		txtrInput.setText("Input your text.");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(43, 161, 572, 23);
		frame.getContentPane().add(scrollPane_2);

		txtrKey = new JTextArea();
		scrollPane_2.setViewportView(txtrKey);
		txtrKey.setLineWrap(true);
		txtrKey.setText("Enter your key.");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(43, 252, 572, 105);
		frame.getContentPane().add(scrollPane_1);
		
		txtrOutput = new JTextArea();
		txtrOutput.setEnabled(false);
		txtrOutput.setEditable(false);
		scrollPane_1.setViewportView(txtrOutput);
		txtrOutput.setLineWrap(true);
		
		JButton btnDecipher = new JButton("Decipher");
		btnDecipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean controlChar = true;
				boolean controlEmpty = true;
						
				try {
					inputText = txtrInput.getText();
					CharException.validateChar(inputText);
					InputException.validateInput(inputText);
					
					
				}catch(InvalidCharException m) {
					controlChar = false;
					JOptionPane.showMessageDialog(null, "Input text only chars from 8-bit table!");
					
				}catch(InvalidInputException n) {
					controlEmpty = false;
					JOptionPane.showMessageDialog(null, "Input field is empty!");
				}
				
				try {
					inputKey = txtrKey.getText();
					CharException.validateChar(inputKey);
					InputException.validateInput(inputKey);
					
				}catch(InvalidCharException m) {
					controlChar = false;
					JOptionPane.showMessageDialog(null, "Key chars from 8-bit table!");
					
				}catch(InvalidInputException n) {
					controlEmpty = false;
					JOptionPane.showMessageDialog(null, "Key field is empty!");
				}
				
				if(controlChar == true && controlEmpty == true ) {
					txtrOutput.setText(BlowfishAlgorithm.decipher(temp, inputKey));
				}
			}
		});
		btnDecipher.setBounds(383, 189, 147, 29);
		frame.getContentPane().add(btnDecipher);
		
		JButton btnCipher = new JButton("Cipher");
		btnCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean controlChar = true;
				boolean controlEmpty = true;
						
				try {
					inputText = txtrInput.getText();
					CharException.validateChar(inputText);
					InputException.validateInput(inputText);
					
					
				}catch(InvalidCharException m) {
					controlChar = false;
					JOptionPane.showMessageDialog(null, "Input text only chars from 8-bit table!");
					
				}catch(InvalidInputException n) {
					controlEmpty = false;
					JOptionPane.showMessageDialog(null, "Input field is empty!");
				}
				
				try {
					inputKey = txtrKey.getText();
					CharException.validateChar(inputKey);
					InputException.validateInput(inputKey);
					
				}catch(InvalidCharException m) {
					controlChar = false;
					JOptionPane.showMessageDialog(null, "Key chars from 8-bit table!");
					
				}catch(InvalidInputException n) {
					controlEmpty = false;
					JOptionPane.showMessageDialog(null, "Key field is empty!");
				}
				
				if(controlChar == true && controlEmpty == true ) {
					
					txtrOutput.setText(BlowfishAlgorithm.encrypt(inputText, inputKey));
				}
					
				
				
			}
		});
		btnCipher.setBounds(128, 189, 159, 29);
		frame.getContentPane().add(btnCipher);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(125, 220, 411, 23);
		frame.getContentPane().add(progressBar);
		
		JButton btnCopyToInput = new JButton("Copy to input field");
		btnCopyToInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = txtrOutput.getText();
				txtrInput.setText(temp);
			}
		});
		btnCopyToInput.setBounds(259, 359, 153, 29);
		frame.getContentPane().add(btnCopyToInput);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrInput.setText(null);
				txtrOutput.setText(null);
				txtrKey.setText(null);
			}
		});
		btnClear.setBounds(92, 359, 117, 29);
		frame.getContentPane().add(btnClear);
	}
}

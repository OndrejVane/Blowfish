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
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;



public class UserInterface {

	private JFrame frame;
	private JTextArea txtrInput;
	private JTextArea txtrKey;
	private JTextArea txtrOutput;
	public JProgressBar progressBar;
	public String inputText;
	public String outputText;
	public String key;
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
		scrollPane_1.setViewportView(txtrOutput);
		txtrOutput.setLineWrap(true);
		txtrOutput.setEditable(false);
		
		JButton btnDecipher = new JButton("Decipher");
		btnDecipher.setBounds(383, 189, 147, 29);
		frame.getContentPane().add(btnDecipher);
		
		JButton btnCipher = new JButton("Cipher");
		btnCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					inputText = txtrInput.getText();
					CharException.validateChar(inputText);
					InputException.validateInput(inputText);
					txtrOutput.setText(BinOperations.stringToBinary(inputText));
					
					//TODO napsat si 
					
				}catch(InvalidCharException m) {
					JOptionPane.showMessageDialog(null, "Input text only chars from 8-bit table!");
				}catch(InvalidInputException n) {
					JOptionPane.showMessageDialog(null, "Entry field is empty!");
				}
				
				try {
					key = txtrKey.getText();
					CharException.validateChar(key);
					InputException.validateInput(key);
					
				}catch(InvalidCharException m) {
					JOptionPane.showMessageDialog(null, "Key chars from 8-bit table!");
				}catch(InvalidInputException n) {
					JOptionPane.showMessageDialog(null, "Entry field is empty!");
				}
				
				
				
				
				
			}
		});
		btnCipher.setBounds(128, 189, 159, 29);
		frame.getContentPane().add(btnCipher);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				progressBar.setValue(progressCounter);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		progressBar.setBounds(125, 220, 411, 23);
		frame.getContentPane().add(progressBar);
	}
}

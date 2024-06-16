package random_num;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;

public class RandNumGen {

	private JFrame frmRandomNumberGenerator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandNumGen window = new RandNumGen();
					window.frmRandomNumberGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RandNumGen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e) {
			System.out.println("UI Manager isn't working");
		}
		frmRandomNumberGenerator = new JFrame("Random number generator");
		frmRandomNumberGenerator.setResizable(false);
		frmRandomNumberGenerator.setBounds(0, 0, 450, 350);
		frmRandomNumberGenerator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Random Number Generator");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setBounds(0, 0, 434, 63);
		frmRandomNumberGenerator.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter min number:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 68, 171, 33);
		frmRandomNumberGenerator.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter max number:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 112, 193, 33);
		frmRandomNumberGenerator.getContentPane().add(lblNewLabel_1_1);
		
		JTextArea txtMin = new JTextArea();
		txtMin.setText("0");
		txtMin.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtMin.setBounds(191, 71, 219, 41);
		frmRandomNumberGenerator.getContentPane().add(txtMin);
		
		JTextArea txtMax = new JTextArea();
		txtMax.setText("100");
		txtMax.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtMax.setBounds(191, 115, 219, 41);
		frmRandomNumberGenerator.getContentPane().add(txtMax);
		
		JLabel lblrandom = new JLabel("[Random Number]");
		lblrandom.setHorizontalAlignment(SwingConstants.CENTER);
		lblrandom.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblrandom.setBounds(0, 167, 434, 33);
		frmRandomNumberGenerator.getContentPane().add(lblrandom);
		
		JCheckBox chDecimal = new JCheckBox("Allow Decimal Numbers");
		chDecimal.setFont(new Font("Tahoma", Font.BOLD, 18));
		chDecimal.setBounds(90, 269, 246, 23);
		frmRandomNumberGenerator.getContentPane().add(chDecimal);
		
		JButton btnNewButton = new JButton("Generate a random number");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (chDecimal.isSelected()) {
						double min = Double.parseDouble(txtMin.getText());
						double max = Double.parseDouble(txtMax.getText());
						double rand = Math.random()*max+min;
						String random = rand+"";
						lblrandom.setText(random);
					} else {
						int min = Integer.parseInt(txtMin.getText());
						int max = Integer.parseInt(txtMax.getText());
						long rand = Math.round(Math.random()*max+min);
						String random = rand+"";
						lblrandom.setText(random);
					}
				}
				catch (Exception a) {
					JOptionPane.showMessageDialog(btnNewButton, "Enter a valid number.\nIf you're trying to put decimal numbers then please check the decimal box at bottom.", "Enter a valid number", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(62, 211, 313, 39);
		btnNewButton.setFocusPainted(false);
		frmRandomNumberGenerator.getContentPane().add(btnNewButton);
	}
}

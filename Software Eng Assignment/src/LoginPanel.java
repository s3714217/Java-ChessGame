import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import java.awt.Component;
import java.awt.Container;

public class LoginPanel  {

	private JFrame frame;
	Player[] player = new Player[2];
	boolean start = false;
	int num_player = 0;
	private JTextField textField_1;
	private JPasswordField passwordField_1;

	public LoginPanel() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblChessGame = new JLabel("Chess Game");
		panel.add(lblChessGame);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(100, 100, 100, 100);
		frame.getContentPane().add(panel_2, BorderLayout.WEST);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 168, 0 };
		gbl_panel_2.rowHeights = new int[] { 151, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/thiennguyen/eclipse-workspace/SEF A!/img/icon.jpg"));
		lblNewLabel.setBounds(10, 10, 10, 10);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);

		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);

		JPasswordField passwordField;
		passwordField = new JPasswordField(10);
		passwordField.setColumns(10);
		passwordField.setBounds(80, 102, 110, 16);
		panel_3.add(passwordField);

		JTextField textField = new JTextField(10);
		textField.setColumns(10);
		textField.setBounds(80, 74, 110, 16);
		panel_3.add(textField);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(6, 74, 77, 16);
		panel_3.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(6, 102, 61, 16);
		panel_3.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setBounds(103, 138, 87, 29);
		panel_3.add(btnNewButton);
				
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBounds(327, 138, 92, 29);
		panel_3.add(btnNewButton_1);
						
		textField_1 = new JTextField(10);
		textField_1.setBounds(309, 74, 110, 16);
		panel_3.add(textField_1);
						
		passwordField_1 = new JPasswordField(10);
		passwordField_1.setBounds(309, 102, 110, 16);
		panel_3.add(passwordField_1);
						
		JLabel label = new JLabel("Password");
		label.setBounds(235, 102, 61, 16);
		panel_3.add(label);
						
		JLabel label_1 = new JLabel("Username");
		label_1.setBounds(235, 74, 77, 16);
		panel_3.add(label_1);
						
		JLabel lblLogInHere = new JLabel("PLAYER LOG IN");
		lblLogInHere.setBounds(45, 46, 110, 16);
		panel_3.add(lblLogInHere);
						
		JLabel lblRegister = new JLabel("PLAYER REGISTER");
		lblRegister.setBounds(277, 46, 123, 16);
		panel_3.add(lblRegister);
						
		btnNewButton_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		String use = textField_1.getText();
		String pass = passwordField_1.getText();
							if (use.isEmpty() == false && pass.isEmpty() == false) {
								if (player[0] != null)
								{
									if(player[1] != null)
									{
										JOptionPane.showMessageDialog(null, "Already reaching the maximum of player");
									}
									else
									{	 
									
										if(player[0].equal(use, pass) == true)
										{
										JOptionPane.showMessageDialog(null, "Player already existed");
										}
										else 
										{
											player[1] = new Player("2", use, "white", pass);
											JOptionPane.showMessageDialog(null, "Successfully registered");
										
										}
									};
								}
								else 
									{
									player[0] = new Player("1", use, "white", pass);
									JOptionPane.showMessageDialog(null, "Successfully registered");
									};
								
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Username and password cannot be blank");
								
							}}
						});
				
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String pass = passwordField.getText();
						String use = textField.getText();
						
					if(player[0] != null && player[1] != null )
					{
						if(player[0].equal(use, pass) == true | player[1].equal(use, pass) == true)
						{
							JOptionPane.showMessageDialog(null, "Sign in successfully! Enjoy the game " + use);
							num_player += 1;
							if(num_player == 2)
							{
								start = true;
							}
						}
						
						else
						{
							JOptionPane.showMessageDialog(null, "Wrong username or password");
							
						}
					}
				
					else 
					{
						JOptionPane.showMessageDialog(null, "No players were registered");
					}
					}});

	}
	public JFrame getPanel()
	{
		return frame;
	}
}

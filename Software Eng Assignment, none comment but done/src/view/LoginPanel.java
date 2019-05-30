package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JTextField;

import oo.Player;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LoginPanel  {

	private JFrame frame;
	private Map<String, String>player = new HashMap<String, String>();
	private boolean start = false;
	private int num_player = 0;
	private Player[] loggedPlayer = new Player[2];


	

	public LoginPanel() {
		initialize();
	}

	

	private void initialize() {

		//initialize the GUI
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		ImageIcon title = new ImageIcon("../Software Eng Assignment/img/Title.jpg");
		JLabel titleLabel = new JLabel("");
		titleLabel.setIcon(new ImageIcon(title.getImage().getScaledInstance(frame.getWidth(), 100, title.getImage().SCALE_SMOOTH)));
		titleLabel.setSize(frame.getWidth(), titleLabel.getHeight());
		titleLabel.setBounds(0,0, 450, 102);
		panel.add(titleLabel);

		JPanel center_panel = new JPanel();
		frame.getContentPane().add(center_panel, BorderLayout.CENTER);

		JPasswordField passwordField;
		center_panel.setLayout(null);
		passwordField = new JPasswordField(10);
		passwordField.setColumns(10);
		passwordField.setBounds(143, 81, 130, 26);
		center_panel.add(passwordField);

		JTextField textField = new JTextField(10);
		textField.setColumns(10);
		textField.setBounds(143, 52, 130, 26);
		center_panel.add(textField);

		JLabel username_label = new JLabel("Username");
		username_label.setBounds(69, 57, 62, 16);
		center_panel.add(username_label);

		JLabel pass_label = new JLabel("Password");
		pass_label.setBounds(69, 86, 59, 16);
		center_panel.add(pass_label);
		
		JButton login = new JButton("Log in");
		login.setBounds(72, 119, 83, 29);
		center_panel.add(login);
						
		JLabel main_label = new JLabel("PLAYER LOG IN");
		main_label.setBounds(109, 24, 94, 16);
		center_panel.add(main_label);
	
		JButton close = new JButton("Close");
		
		close.setBounds(158, 119, 79, 29);
		center_panel.add(close);
		
				close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
				//login function
				login.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String pass = passwordField.getText();
						String use = textField.getText();
						Properties properties = new Properties();
						
						try {
							//loading database
							properties.load(new FileInputStream("../Software Eng Assignment/player_map/data.properties"));
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
							//initializing user map
						for (String key : properties.stringPropertyNames()) {
						   player.put(key, properties.get(key).toString());
						} 
							//validating user
						if(player.get(use) != null) 
						{
							
							if (loggedPlayer[1] != null)
							{
								JOptionPane.showMessageDialog(null, "The game is full");
							}
							else
							{
								if(player.get(use).equals(pass)  == true)
								{	//player 1 logged in
									if(loggedPlayer[0] == null)
									{
										loggedPlayer[0] = new Player(use, pass);
										JOptionPane.showMessageDialog(null, "Welcome " + loggedPlayer[0].getName());
										frame.dispose();
									}
									else if (loggedPlayer[1] == null && !use.equals(loggedPlayer[0].getName()))
									{	//player 2 logged in
										loggedPlayer[1] = new Player(use, pass);
										JOptionPane.showMessageDialog(null, "Welcome " + loggedPlayer[1].getName());
	
										frame.dispose();
									}
									else
									{
										JOptionPane.showMessageDialog(null, "The user is already logged in ");
									}
									
								}
								else
								{
									JOptionPane.showMessageDialog(null, "The password does not match the username");
								}
								
							}
						}
						else{JOptionPane.showMessageDialog(null, "The username does not exist");}
						textField.setText("");
						passwordField.setText("");
					}});
				
			
					

	}
	public Player[] getLoggedPlayer()
	{
		return this.loggedPlayer;
	}
	public JFrame getPanel()
	{
		return frame;
	}
}

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterPanel  {

	private JFrame frame;
	//Player[] player = new Player[2];
	boolean start = false;
	int num_player = 0;
	File file = new File("../Software Eng Assignment/player_map/players.txt");

	public RegisterPanel(Board board) {
		initialize(board);
	}

	

	private void initialize(Board board) {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton register = new JButton("Register");
		register.setBounds(72, 119, 83, 29);
		center_panel.add(register);
						
		JLabel main_label = new JLabel("PLAYER REGISTER");
		main_label.setBounds(109, 24, 150, 16);
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
				
				register.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String pass = passwordField.getText();
						String use = textField.getText();
						
						if(pass.length() <= 3)
						{
							JOptionPane.showMessageDialog(null, "Your Password must be more than 3 characters");
						}
						else if(use.length()<= 3)
						{
							JOptionPane.showMessageDialog(null, "Your Username must be more than 3 characters");
						}
						else if(pass.length() >= 3 && use.length() >=3)
						{
						try {
							 FileWriter writer = new FileWriter(file,true); 
						      writer.append("\n"+use+"\n" +pass);
						      writer.flush();
						      writer.close();
							}
						 catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();}
						  catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						}
						
						else {JOptionPane.showMessageDialog(null, "Your Username and Password should not be blank");}
					}});
					
	}
	public JFrame getPanel()
	{
		return frame;
	}
}


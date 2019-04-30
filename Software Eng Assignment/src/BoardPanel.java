import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardPanel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	LoginPanel login = new LoginPanel();
	Player[] player = new Player[2];
	boolean start = false;
	
	//Board board = new Board(player[0], player[1]);	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardPanel window = new BoardPanel();
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
	public BoardPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		//LoginPanel login = new LoginPanel();
		LoginPanel login = new LoginPanel();
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login.getPanel().setVisible(true);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Start");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update player info");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(login.player[0] != null | login.player[1] != null)
			{
				start = login.start;
				player = login.player;
				JOptionPane.showMessageDialog(null, "Player information updated");
				JOptionPane.showMessageDialog(null, player[0].getName() + player[1].getName()+ start);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No player information to update");
			}
			}
		});
		panel.add(btnNewButton_2);
	
	}
}

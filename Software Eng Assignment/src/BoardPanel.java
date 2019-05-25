import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;

public class BoardPanel {

	private JFrame frame;

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

	public BoardPanel() {
		Board board = new Board();
		initialize(board);
	}

	private void initialize(Board board) {

		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
	
		
		
		JPanel center_panel= new JPanel();
		frame.getContentPane().add(center_panel, BorderLayout.CENTER);
		center_panel.setLayout(null);
		
		JButton register = new JButton("Register");
		register.setBounds(171, 125, 111, 37);
		center_panel.add(register);
		
		JButton login = new JButton("Log In");
		
		login.setBounds(171, 174, 107, 37);
		center_panel.add(login);
		
		JButton start = new JButton("Start Game");
		
		start.setBounds(171, 223, 107, 37);
		center_panel.add(start);
		
		ImageIcon title = new ImageIcon("../Software Eng Assignment/img/Title.jpg");
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setIcon(new ImageIcon(title.getImage().getScaledInstance(frame.getWidth(), 100, title.getImage().SCALE_SMOOTH)));
		titleLabel.setSize(frame.getWidth(), titleLabel.getHeight());
		titleLabel.setBounds(0,0, 450, 102);
		center_panel.add(titleLabel);
		
		
		LoginPanel login_panel = new LoginPanel(board);
		RegisterPanel register_panel = new RegisterPanel(board);
		ChessBoard chess_board = new ChessBoard(board);
		
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_panel.getPanel().setVisible(true);
			}
		});
		
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//chess_board.getPanel().setVisible(true);
				if (login_panel.loggedPlayer[0] != null && login_panel.loggedPlayer[1] != null)
				{	
					
					board.addPlayer(login_panel.loggedPlayer);
					JOptionPane.showMessageDialog(null, "Welcome to LATTITUDE CHESS GAME");
					chess_board.getPanel().setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Not enough player to start the game!");
				}
			}
		});
		
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				register_panel.getPanel().setVisible(true);
			}
		});

	}
	
}

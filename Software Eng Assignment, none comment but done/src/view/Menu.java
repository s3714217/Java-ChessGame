package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import oo.Board;

public class Menu
{

	private JFrame frame;

	public Menu()
	{
		Board board = new Board();
		initialize(board);
	}

	private void initialize(Board board)
	{
		//initialize the GUI
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setVisible(true);

		JPanel center_panel = new JPanel();
		frame.getContentPane().add(center_panel, BorderLayout.CENTER);
		center_panel.setLayout(null);

		JButton register = new JButton("Register");
		register.setBounds(171, 125, 111, 37);
		center_panel.add(register);

		JButton login = new JButton("Log In"); 

		login.setBounds(171, 174, 107, 37);
		center_panel.add(login);

		JButton start = new JButton("Start Game"); //Accessing ChessGUI

		start.setBounds(171, 223, 107, 37);
		center_panel.add(start);

		ImageIcon title = new ImageIcon("../Software Eng Assignment/img/Title.jpg");
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setIcon(new ImageIcon(
		title.getImage().getScaledInstance(frame.getWidth(), 100, title.getImage().SCALE_SMOOTH)));
		titleLabel.setSize(frame.getWidth(), titleLabel.getHeight());
		titleLabel.setBounds(0, 0, 450, 102);
		center_panel.add(titleLabel);

		LoginPanel login_panel = new LoginPanel();
		RegisterPanel register_panel = new RegisterPanel();

		login.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)//Accessing login window
			{
				login_panel.getPanel().setVisible(true);
			}
		});

		start.addMouseListener(new MouseAdapter()//Getting 2 logged in player and start ChessGUI
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{

				if (login_panel.getLoggedPlayer()[0] != null && login_panel.getLoggedPlayer()[1] != null)
				{
					
					board.addPlayer(login_panel.getLoggedPlayer()[0]);
					board.addPlayer(login_panel.getLoggedPlayer()[1]);

					MoveAmount moveEnter = new MoveAmount(frame, board);

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Not enough player to start the game!");
				}
			}
		});

		register.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				register_panel.getPanel().setVisible(true);//Acessing register window
			}
		});

	}

}

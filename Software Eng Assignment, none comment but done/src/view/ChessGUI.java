package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import oo.Board;
import oo.Player;

public class ChessGUI extends JFrame implements EndObserver
{
	
	// the screen size
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenXAxis = (int) screenSize.getWidth();
	
	private CenterPanel center;
	private StatusBar statusBar;
	
	public ChessGUI(Board board)
	{
		super("ChessGUI");
		
		//setting layout and size
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setSize(screenXAxis/2, screenXAxis/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		// adding tthis to end observer
		board.addEndObserver(this);
		
		// adding the status bar and center panel
		statusBar = new StatusBar(board);
		
		board.addMoveObserver(statusBar);
		center = new CenterPanel(board);
		
		add(center, BorderLayout.CENTER);
		add(statusBar, BorderLayout.SOUTH);
	}

	// if game has ended
	@Override
	public void endGame(Board board)
	{
		// TODO Auto-generated method stub
		Player p1 = board.getPlayer1();
		Player p2 = board.getPlayer2();
		
		// check who won the game
		if(p1.getScore() == p2.getScore())
		{
			JOptionPane.showMessageDialog(null, "The game ended in a draw.");
		}
		else if (p1.getScore() > p2.getScore())
		{
			JOptionPane.showMessageDialog(null, p1.getName() + " won the game.");
		}
		else if (p1.getScore() < p2.getScore())
		{
			JOptionPane.showMessageDialog(null, p2.getName() + " won the game.");
		}
		
		// close program
		System.exit(0);
	}
}

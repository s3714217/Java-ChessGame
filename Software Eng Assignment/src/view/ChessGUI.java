package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import oo.Board;
import oo.Player;

public class ChessGUI extends JFrame implements EndObserver
{

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenXAxis = (int) screenSize.getWidth();
	private int screenYAxis = (int) screenSize.getHeight();
	
	private CenterPanel center;
	private StatusBar statusBar;
	
	public ChessGUI(Board board)
	{
		super("ChessGUI");
		
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setSize(screenXAxis/2, screenXAxis/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		board.addEndObserver(this);
		
		statusBar = new StatusBar(board);
		
		board.addMoveObserver(statusBar);
		center = new CenterPanel(board);
		
		add(center, BorderLayout.CENTER);
		add(statusBar, BorderLayout.SOUTH);
	}

	@Override
	public void endGame(Board board)
	{
		// TODO Auto-generated method stub
		Player p1 = board.getPlayer1();
		Player p2 = board.getPlayer2();
		
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
		
		System.exit(0);
	}
}

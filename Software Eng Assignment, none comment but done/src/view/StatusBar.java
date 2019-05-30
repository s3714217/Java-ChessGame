package view;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import oo.Board;
import oo.Player;

// the status bar for the chessGUI
public class StatusBar extends JPanel implements MoveObserver
{
	private JLabel currentPlayerTurn;
	private JLabel player1Score;
	private JLabel player2Score;
	private JLabel turnsLeft;
	
	public StatusBar(Board board)
	{
		// TODO Auto-generated constructor stub
		
		updateBoard(board);
		
		setLayout(new GridLayout(1, 4));
		add(currentPlayerTurn);
		add(player1Score);
		add(player2Score);
		add(turnsLeft);
		
		validate();
	}

	@Override
	public void updateBoard(Board board)
	{
		// TODO Auto-generated method stub
		
		// removing past information
		if(currentPlayerTurn != null)
		{
			remove(currentPlayerTurn);
			remove(player1Score);
			remove(player2Score);
			remove(turnsLeft);
		}

		// geting the new player scores
		Player p1 = board.getPlayer1();
		Player p2 = board.getPlayer2();
		
		// getting the current players turn
		if (board.getCurrentPlayerInt() == 0)
		{
			currentPlayerTurn = new JLabel("Current Player: " + board.getCurrentPlayer().getName() + " (white)",
					SwingConstants.LEFT);
		}
		else
		{
			currentPlayerTurn = new JLabel("Current Player: " + board.getCurrentPlayer().getName()  + " (black)",
					SwingConstants.LEFT);
		}

		player1Score = new JLabel(p1.getName() + "'s Score: " + p1.getScore(), SwingConstants.CENTER);
		player2Score = new JLabel(p2.getName() + "'s Score: " + p2.getScore(), SwingConstants.CENTER);
		
		// getting the turns left
		turnsLeft = new JLabel("Moves Left: " + board.getNumMoves(),
				SwingConstants.RIGHT);
		
		Border border = BorderFactory.createRaisedBevelBorder();
		
		currentPlayerTurn.setBorder(border);
		player1Score.setBorder(border);
		player2Score.setBorder(border);
		turnsLeft.setBorder(border);
		
		// adding the info back into the status bar
		add(currentPlayerTurn);
		add(player1Score);
		add(player2Score);
		add(turnsLeft);
		
		revalidate();
		repaint();
	}

}

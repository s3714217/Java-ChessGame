package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import oo.Board;
import oo.Player;

public class StatusBar extends JPanel implements MoveObserver
{
	private JLabel currentPlayerTurn;
	private JLabel player1Score;
	private JLabel player2Score;
	private JLabel turnsLeft;
	
	public StatusBar(Board board)
	{
		// TODO Auto-generated constructor stub
			
//		board.addMoveObserver(this);
		
		updateBoard(board);
		
		setLayout(new GridLayout(1, 4));
		add(currentPlayerTurn);
		add(player1Score);
		add(player2Score);
		add(turnsLeft);
		
		validate();
	}

	public StatusBar(LayoutManager arg0)
	{
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public StatusBar(boolean arg0)
	{
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public StatusBar(LayoutManager arg0, boolean arg1)
	{
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateBoard(Board board)
	{
		// TODO Auto-generated method stub
		
		if(currentPlayerTurn != null)
		{
			remove(currentPlayerTurn);
			remove(player1Score);
			remove(player2Score);
			remove(turnsLeft);
		}

		
		Player p1 = board.getPlayer1();
		Player p2 = board.getPlayer2();
		
		currentPlayerTurn = new JLabel("Current Player: " + board.getCurrentPlayer().getName(),
				SwingConstants.LEFT);
		player1Score = new JLabel(p1.getName() + "'s Score: " + p1.getScore(), SwingConstants.CENTER);
		player2Score = new JLabel(p2.getName() + "'s Score: " + p2.getScore(), SwingConstants.CENTER);
		turnsLeft = new JLabel("Moves Left: " + board.getNumMoves(),
				SwingConstants.RIGHT);
		
		Border border = BorderFactory.createRaisedBevelBorder();
		
		currentPlayerTurn.setBorder(border);
		player1Score.setBorder(border);
		player2Score.setBorder(border);
		turnsLeft.setBorder(border);
		
		add(currentPlayerTurn);
		add(player1Score);
		add(player2Score);
		add(turnsLeft);
		
		revalidate();
		repaint();
	}

}

package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import oo.Board;
import oo.Piece;

public class SelectListener implements MouseListener
{
	
	private int xPos;
	private int yPos;
	private Board board;
	
	
	public SelectListener(int xPos, int yPos, Board board)
	{
		// TODO Auto-generated constructor stub
		this.xPos = xPos;
		this.yPos = yPos;
		this.board = board;
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		Piece gotPiece = board.getSpecPiece(xPos, yPos);
		
		// making sure that the position selected has a piece
		if (gotPiece != null)
		{
			// making sure the piece selected is from the same team
			if (board.getCurrentPlayerInt() == 0 && gotPiece.getTeam().equals("player1"))
			{
				board.pieceSelected(xPos, yPos);
			}
			else if (board.getCurrentPlayerInt() == 1 && gotPiece.getTeam().equals("player2"))
			{
				board.pieceSelected(xPos, yPos);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "This piece belongs to the enemy team");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Tile has no piece");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}

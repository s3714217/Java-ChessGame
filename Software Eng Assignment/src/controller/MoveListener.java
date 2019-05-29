package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import oo.Board;
import oo.Piece;
import oo.Square;

public class MoveListener implements MouseListener
{
	
	private int xPos;
	private int yPos;
	private int tarXPos;
	private int tarYPos;
	private Board board;
	
	
	
	public MoveListener(int xPos, int yPos, int tarXPos, int tarYPos, Board board)
	{
		// TODO Auto-generated constructor stub
		this.xPos = xPos;
		this.yPos = yPos;
		this.tarXPos = tarXPos;
		this.tarYPos = tarYPos;
		this.board = board;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		Square[] possibleMoves = board.getSpecPiece(xPos, yPos).getPossibleMoves();
		
		boolean isMove = false;
		
		for (int i = 0; i < possibleMoves.length; i++)
		{
			if (possibleMoves[i] != null)
			{
				if (possibleMoves[i].getXAxis() == tarXPos && possibleMoves[i].getYAxis() == tarYPos)
				{
					isMove = true;
				}
			}
		}
		
		if (isMove == true)
		{
			board.move(xPos, yPos, tarXPos, tarYPos);
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "This is a invalid move");
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

package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import oo.Board;

public class DeselectListener implements MouseListener
{
	private Board board;
	
	public DeselectListener(Board board)
	{
		// TODO Auto-generated constructor stub
		this.board = board;
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		board.deselected();
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

}

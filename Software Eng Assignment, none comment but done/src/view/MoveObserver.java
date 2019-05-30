package view;

import oo.Board;

public interface MoveObserver
{
	//update GUI when a move is made
	public abstract void updateBoard(Board board);
}

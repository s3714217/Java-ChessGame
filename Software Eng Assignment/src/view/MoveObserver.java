package view;

import oo.Board;

public interface MoveObserver
{
	public abstract void updateBoard(Board board);
}

package view;

import oo.Board;

public interface BoardObserver
{	
	
	public abstract void pieceSelected(Board board, int xPos, int yPos);
	
	public abstract void deselected(Board board);
	
}

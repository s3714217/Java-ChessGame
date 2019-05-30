package view;

import oo.Board;

public interface BoardObserver
{	
	// for selecting a piece
	public abstract void pieceSelected(Board board, int xPos, int yPos);
	
	// for deselecting a piece
	public abstract void deselected(Board board);
	
}

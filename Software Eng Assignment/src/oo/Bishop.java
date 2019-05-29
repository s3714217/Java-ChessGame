package oo;

public class Bishop extends Piece
{

	public Bishop(Square position, String team)
	{
		super(position, team);
		// TODO Auto-generated constructor stub
	}

	@Override
	void updatePossibleMoves(Board board)
	{
		// TODO Auto-generated method stub
		
		super.clearPossibleMoves();
		super.clearPossibleAttacks();
		
		super.checkPosition(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis() + 1, board);
		super.checkPosition(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis() - 1, board);
		super.checkPosition(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis() + 1, board);
		super.checkPosition(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis() - 1, board);
		
		checkBlockedPath(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis() + 1, board, "up-right");
		checkBlockedPath(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis() - 1, board, "down-left");
		checkBlockedPath(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis() + 1, board, "up-left");
		checkBlockedPath(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis() - 1, board, "down-right");
	}
	
	
	public void checkBlockedPath(int xPos, int yPos, Board board, String direction) {
		
		if(xPos < 6 && xPos >= 0 &&
				yPos < 6 && yPos >= 0 )
		{
			if (board.getSquare(xPos, yPos).getOccupied() == false)
			{
				if (direction.equals("up-right"))
				{
					super.checkPosition(xPos + 1, yPos + 1, board);
				}
				if (direction.equals("down-right"))
				{
					super.checkPosition(xPos + 1, yPos - 1, board);
				}
				if (direction.equals("up-left"))
				{
					super.checkPosition(xPos - 1, yPos + 1, board);
				}
				if (direction.equals("down-left"))
				{
					super.checkPosition(xPos - 1, yPos - 1, board);
				}
			}
			
		}
	}
}

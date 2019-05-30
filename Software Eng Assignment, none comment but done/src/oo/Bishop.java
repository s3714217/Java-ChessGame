package oo;

public class Bishop extends Piece
{
	
	public Bishop(Square position, String team)
	{
		super(position, team);

	}

	@Override
	void updatePossibleMoves(Board board)
	{
	
		
		super.clearPossibleMoves();
		super.clearPossibleAttacks();
		
		super.checkPosition(this.getPosition().getXAxis() + 1, this.getPosition().getYAxis() + 1, board);
		super.checkPosition(this.getPosition().getXAxis() - 1, this.getPosition().getYAxis() - 1, board);
		super.checkPosition(this.getPosition().getXAxis() - 1, this.getPosition().getYAxis() + 1, board);
		super.checkPosition(this.getPosition().getXAxis() + 1, this.getPosition().getYAxis() - 1, board);
		
		checkBlockedPath(this.getPosition().getXAxis() + 1, this.getPosition().getYAxis() + 1, board, "up-right");
		checkBlockedPath(this.getPosition().getXAxis() - 1, this.getPosition().getYAxis() - 1, board, "down-left");
		checkBlockedPath(this.getPosition().getXAxis() - 1, this.getPosition().getYAxis() + 1, board, "up-left");
		checkBlockedPath(this.getPosition().getXAxis() + 1, this.getPosition().getYAxis() - 1, board, "down-right");
	}
	
	//checking if the position entered is occupied or not, if not check for possible move at next position
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

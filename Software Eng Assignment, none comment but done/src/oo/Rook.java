package oo;

public class Rook extends Piece
{

	public Rook(Square position, String team)
	{
		super(position, team);
		
	}

	@Override
	public void updatePossibleMoves(Board board)
	{
		
		super.clearPossibleMoves();
		super.clearPossibleAttacks();
		
		super.checkPosition(this.getPosition().getXAxis() + 1, this.getPosition().getYAxis(), board);
		super.checkPosition(this.getPosition().getXAxis() - 1, this.getPosition().getYAxis(), board);
		super.checkPosition(this.getPosition().getXAxis(), this.getPosition().getYAxis() - 1, board);
		super.checkPosition(this.getPosition().getXAxis(), this.getPosition().getYAxis() + 1,board);
		
		checkBlockedPath(this.getPosition().getXAxis() + 1, this.getPosition().getYAxis(), board, "right");
		checkBlockedPath(this.getPosition().getXAxis() - 1, this.getPosition().getYAxis(), board, "left");
		checkBlockedPath(this.getPosition().getXAxis(), this.getPosition().getYAxis() - 1, board, "down");
		checkBlockedPath(this.getPosition().getXAxis(), this.getPosition().getYAxis() + 1, board, "up");
	}
	
	//checking if the position entered is occupied or not, if not check for possible move at next position
	public void checkBlockedPath(int xPos, int yPos, Board board, String direction) {
		
		if(xPos < 6 && xPos >= 0 &&
				yPos < 6 && yPos >= 0 )
		{
			if (board.getSquare(xPos, yPos).getOccupied() == false)
			{
				if (direction.equals("up"))
				{
					super.checkPosition(xPos, yPos + 1, board);
				}
				if (direction.equals("down"))
				{
					super.checkPosition(xPos, yPos - 1, board);
				}
				if (direction.equals("left"))
				{
					super.checkPosition(xPos - 1, yPos, board);
				}
				if (direction.equals("right"))
				{
					super.checkPosition(xPos + 1, yPos, board);
				}
			}
			
		}
	}

}

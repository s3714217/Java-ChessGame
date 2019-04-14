
public class Rook extends Piece
{

	public Rook(Square position, String team)
	{
		super(position, team);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updatePossibleMoves(Board board)
	{
		// TODO Auto-generated method stub
		super.clearPossibleMoves();
		super.clearPossibleAttacks();
		
		super.checkPosition(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis(), board);
		super.checkPosition(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis(), board);
		super.checkPosition(this.getSquare().getXAxis(), this.getSquare().getYAxis() - 1, board);
		super.checkPosition(this.getSquare().getXAxis(), this.getSquare().getYAxis() + 1,board);
		
		checkBlockedPath(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis(), board, "right");
		checkBlockedPath(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis(), board, "left");
		checkBlockedPath(this.getSquare().getXAxis(), this.getSquare().getYAxis() - 1, board, "down");
		checkBlockedPath(this.getSquare().getXAxis(), this.getSquare().getYAxis() + 1, board, "up");
	}
	
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

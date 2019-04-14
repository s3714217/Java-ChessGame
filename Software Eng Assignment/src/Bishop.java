
public class Bishop extends Piece
{

	public Bishop(Square position, String team)
	{
		super(position, team);
		// TODO Auto-generated constructor stub
	}

	@Override
	void updatePossibleMoves(Square[][] grid, Piece[] pieces)
	{
		// TODO Auto-generated method stub
		
		super.clearPossibleMoves();
		super.clearPossibleAttacks();
		
		super.checkPosition(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis() + 1, grid, pieces);
		super.checkPosition(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis() - 1, grid, pieces);
		super.checkPosition(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis() + 1, grid, pieces);
		super.checkPosition(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis() - 1, grid, pieces);
		
		checkBlockedPath(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis() + 1, grid, pieces, "up-right");
		checkBlockedPath(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis() - 1, grid, pieces, "down-left");
		checkBlockedPath(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis() + 1, grid, pieces, "up-left");
		checkBlockedPath(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis() - 1, grid, pieces, "down-right");
	}
	
	
	public void checkBlockedPath(int xPos, int yPos, Square[][] grid, Piece[] pieces, String direction) {
		
		if(xPos < 6 && xPos > 0 &&
				yPos < 6 && yPos > 0 )
		{
			if (grid[xPos][yPos].getOccupied() != false)
			{
				if (direction.equals("up-right"))
				{
					super.checkPosition(xPos + 1, yPos + 1, grid, pieces);
				}
				if (direction.equals("down-right"))
				{
					super.checkPosition(xPos + 1, yPos - 1, grid, pieces);
				}
				if (direction.equals("up-left"))
				{
					super.checkPosition(xPos - 1, yPos + 1, grid, pieces);
				}
				if (direction.equals("down-left"))
				{
					super.checkPosition(xPos - 1, yPos - 1, grid, pieces);
				}
			}
			
		}
	}
}

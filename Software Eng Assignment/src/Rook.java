
public class Rook extends Piece
{

	public Rook(Square position, String team)
	{
		super(position, team);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updatePossibleMoves(Square[][] grid, Piece[] pieces)
	{
		// TODO Auto-generated method stub
		super.clearPossibleMoves();
		super.clearPossibleAttacks();
		
		super.checkPosition(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis(), grid, pieces);
		super.checkPosition(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis(), grid, pieces);
		super.checkPosition(this.getSquare().getXAxis(), this.getSquare().getYAxis() - 1, grid, pieces);
		super.checkPosition(this.getSquare().getXAxis(), this.getSquare().getYAxis() + 1, grid, pieces);
		
		checkBlockedPath(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis(), grid, pieces, "right");
		checkBlockedPath(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis(), grid, pieces, "left");
		checkBlockedPath(this.getSquare().getXAxis(), this.getSquare().getYAxis() - 1, grid, pieces, "down");
		checkBlockedPath(this.getSquare().getXAxis(), this.getSquare().getYAxis() + 1, grid, pieces, "up");
	}
	
	public void checkBlockedPath(int xPos, int yPos, Square[][] grid, Piece[] pieces, String direction) {
		
		if(xPos < 6 && xPos > 0 &&
				yPos < 6 && yPos > 0 )
		{
			if (grid[xPos][yPos].getOccupied() != false)
			{
				if (direction.equals("up"))
				{
					super.checkPosition(xPos, yPos + 1, grid, pieces);
				}
				if (direction.equals("down"))
				{
					super.checkPosition(xPos, yPos - 1, grid, pieces);
				}
				if (direction.equals("left"))
				{
					super.checkPosition(xPos - 1, yPos, grid, pieces);
				}
				if (direction.equals("right"))
				{
					super.checkPosition(xPos + 1, yPos, grid, pieces);
				}
			}
			
		}
	}

}

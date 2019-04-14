
public class Knight extends Piece
{

	public Knight(Square position, String team)
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
		
		checkPosition(this.getSquare().getXAxis() + 2, this.getSquare().getYAxis() - 1, grid, pieces);
		checkPosition(this.getSquare().getXAxis() + 2, this.getSquare().getYAxis() + 1, grid, pieces);
		checkPosition(this.getSquare().getXAxis() - 2, this.getSquare().getYAxis()  - 1, grid, pieces);
		checkPosition(this.getSquare().getXAxis() - 2, this.getSquare().getYAxis() + 1, grid, pieces);
		
		checkPosition(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis() + 2, grid, pieces);
		checkPosition(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis() + 2, grid, pieces);
		checkPosition(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis() - 1, grid, pieces);
		checkPosition(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis() - 1, grid, pieces);

	}


}

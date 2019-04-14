
public class Knight extends Piece
{

	public Knight(Square position, String team)
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
		
		super.checkPosition(this.getSquare().getXAxis() + 2, this.getSquare().getYAxis() - 1, board);
		super.checkPosition(this.getSquare().getXAxis() + 2, this.getSquare().getYAxis() + 1, board);
		super.checkPosition(this.getSquare().getXAxis() - 2, this.getSquare().getYAxis()  - 1, board);
		super.checkPosition(this.getSquare().getXAxis() - 2, this.getSquare().getYAxis() + 1, board);
		
		super.checkPosition(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis() + 2, board);
		super.checkPosition(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis() + 2, board);
		super.checkPosition(this.getSquare().getXAxis() - 1, this.getSquare().getYAxis() - 1, board);
		super.checkPosition(this.getSquare().getXAxis() + 1, this.getSquare().getYAxis() - 1, board);

	}


}

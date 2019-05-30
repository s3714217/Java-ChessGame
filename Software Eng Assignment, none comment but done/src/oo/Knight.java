package oo;

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
		
		super.checkPosition(this.getPosition().getXAxis() + 2, this.getPosition().getYAxis() - 1, board);
		super.checkPosition(this.getPosition().getXAxis() + 2, this.getPosition().getYAxis() + 1, board);
		super.checkPosition(this.getPosition().getXAxis() - 2, this.getPosition().getYAxis()  - 1, board);
		super.checkPosition(this.getPosition().getXAxis() - 2, this.getPosition().getYAxis() + 1, board);
		
		super.checkPosition(this.getPosition().getXAxis() - 1, this.getPosition().getYAxis() + 2, board);
		super.checkPosition(this.getPosition().getXAxis() + 1, this.getPosition().getYAxis() + 2, board);
		super.checkPosition(this.getPosition().getXAxis() - 1, this.getPosition().getYAxis() - 2, board);
		super.checkPosition(this.getPosition().getXAxis() + 1, this.getPosition().getYAxis() - 2, board);

	}


}

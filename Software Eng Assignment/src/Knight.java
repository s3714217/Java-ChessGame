
public class Knight extends Piece
{

	public Knight(Square position, String team)
	{
		super(position, team);
		// TODO Auto-generated constructor stub
	}

	@Override
	void updatePossibleMoves(Square[][] grid)
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid.length; j++)
			{
				if (grid[i][j].gets)
			}
		}

	}

	@Override
	void updatePossibleAttacks()
	{
		// TODO Auto-generated method stub

	}

}


public class Board
{
	private Square[][] grid = new Square[6][6];

	public Board()
	{
		// TODO Auto-generated constructor stub
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 6; j++)
			{
				grid[i][j] = new Square(i,j);
			}
		}
		
	}

}

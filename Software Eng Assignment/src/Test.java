
public class Test
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Board test = new Board(new Player("p1", "Bob", "White"), new Player("p2", "Fred", "Black"));
		
		(test.getSpecPiece(0, 0)).updatePossibleMoves(test);
		Square[] result = test.getSpecPiece(0, 0).getPossibleMoves();
		
		for (int i = 0; i < result.length; i++)
		{
			
			if (result[i] != null)
			{
				System.out.println(result[i].getXAxis() + ", " + result[i].getYAxis());
			}
		}
	}

}

package oo;

public class Test
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Board test = new Board(new Player("Bob", null), new Player("Fred", null));
		
		(test.getSpecPiece(2, 0)).updatePossibleMoves(test);
		Square[] result = test.getSpecPiece(2, 0).getPossibleMoves();
		
		for (int i = 0; i < result.length; i++)
		{
			
			if (result[i] != null)
			{
				System.out.println(result[i].getXAxis() + ", " + result[i].getYAxis());
			}
		}
		
		
		(test.getSpecPiece(2, 0)).move(4, 1, test);
		
	}

}

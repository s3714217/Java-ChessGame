import static org.junit.jupiter.api.Assertions.*;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PossibleMovesTest
{

	@Test
	public void KnightTest()
	{
		Board test = new Board(new Player("p1", "Bob", "White"), new Player("p2", "Fred", "Black"));
		
		
		Square[] expectedMovesList = new Square[8];
		expectedMovesList[0] = test.getSquare(4, 1);
		expectedMovesList[1] = test.getSquare(0, 1);
		expectedMovesList[2] = test.getSquare(1, 2);
		expectedMovesList[3] = test.getSquare(3, 2);
		
		test.getSpecPiece(2, 0).updatePossibleMoves(test);
		Square[] result = test.getSpecPiece(2, 0).getPossibleMoves();
		
		
		Assert.assertArrayEquals(expectedMovesList, result);
	}
	
	@Test
	public void BishopTest()
	{
		Board test = new Board(new Player("p1", "Bob", "White"), new Player("p2", "Fred", "Black"));
		
		
		Square[] expectedMovesList = new Square[8];
		expectedMovesList[0] = test.getSquare(2, 1);
		expectedMovesList[1] = test.getSquare(0, 1);
		expectedMovesList[2] = test.getSquare(3, 2);
		
		test.getSpecPiece(1, 0).updatePossibleMoves(test);
		Square[] result = test.getSpecPiece(1, 0).getPossibleMoves();
		
		Assert.assertArrayEquals(expectedMovesList, result);
	}
	
	@Test
	public void RookTest()
	{
		Board test = new Board(new Player("p1", "Bob", "White"), new Player("p2", "Fred", "Black"));
		
		
		Square[] expectedMovesList = new Square[8];
		expectedMovesList[0] = test.getSquare(0, 1);
		expectedMovesList[1] = test.getSquare(0, 2);
		
		test.getSpecPiece(0, 0).updatePossibleMoves(test);
		Square[] result = test.getSpecPiece(0, 0).getPossibleMoves();
		
		Assert.assertArrayEquals(expectedMovesList, result);
	}
	
	@Test 
	public void KillTest()
	{
       Board test = new Board(new Player("p1", "Bob", "White"), new Player("p2", "Fred", "Black"));
	   Square[] expectedMovesList = new Square[8];
	   test.getSpecPiece(0, 0).move(0, 2, test);
	   // test with Rook
	   test.getSpecPiece(0, 5).move(0, 4, test);
	   test.getSpecPiece(0,2).move(0, 4, test);
	   test.getSpecPiece(0, 
	   
	   Assert.assertEquals(test.getSpecPiece(0, 4).getTeam()== test.getPlayer1().getColour()));
	   Assert.assertEquals(test.getPlayer1().getScore() == 5);
	}
	
	
}

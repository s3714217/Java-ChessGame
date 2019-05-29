package oo;
import static org.junit.jupiter.api.Assertions.*;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PossibleMovesTest
{

	@Test
	public void KnightTest()
	{
		Board test = new  Board(new Player("Bob", null), new Player("Fred", null));
		
		
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
		Board test = new  Board(new Player("Bob", null), new Player("Fred", null));
		
		
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
		Board test = new  Board(new Player("Bob", null), new Player("Fred", null));
		
		
		Square[] expectedMovesList = new Square[8];
		expectedMovesList[0] = test.getSquare(0, 1);
		expectedMovesList[1] = test.getSquare(0, 2);
		
		test.getSpecPiece(0, 0).updatePossibleMoves(test);
		Square[] result = test.getSpecPiece(0, 0).getPossibleMoves();
		
		Assert.assertArrayEquals(expectedMovesList, result);
	}
	@Test 
	   // test with Rook
	public void KillRookTest()
	{
 Board test = new  Board(new Player("Bob", null), new Player("Fred", null));

	   test.getSpecPiece(0, 0).move(0, 2, test);//player 1 move Rook
	   test.getSpecPiece(0, 5).move(0, 4, test);//player 2 move Rook
	   test.getSpecPiece(0,2).move(0, 4, test);//player 1 move Rook and kill player 2's Rook
	    
	   
	   Assert.assertEquals(test.getPlayer1().getScore(), 5);
	}
	
	@Test 
	   // test with Knight
	public void KillKnightTest()
	{
 Board test = new  Board(new Player("Bob", null), new Player("Fred", null));
	
	   test.getSpecPiece(2, 0).move(1, 2, test);//player 1 move Knight
	   test.getSpecPiece(0, 5).move(0, 4, test);//player 1 move Knight
	   test.getSpecPiece(1,2).move(0, 4, test);//player 1 move Knight and kill player 2's Rook
	   
	   
	   Assert.assertEquals(test.getPlayer1().getScore(), 5);
	  
	}
	
	@Test 
	// test with Bishop
	public void KillBishopTest()
	{
		Board test = new  Board(new Player("Bob", null), new Player("Fred", null));
	
	   test.getSpecPiece(1, 0).move(3, 2, test);//player 1 move Bishop
	   test.getSpecPiece(5, 5).move(5, 4, test);//player 2 move Rook
	   test.getSpecPiece(3,2).move(5, 4, test);//player 1 move Bishop and kill player 2's Rook
	   
	   
	   Assert.assertEquals(test.getPlayer1().getScore(), 5);

}
}

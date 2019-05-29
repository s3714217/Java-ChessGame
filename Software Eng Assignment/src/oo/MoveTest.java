package oo;
import static org.junit.jupiter.api.Assertions.*;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MoveTest
{

	@Test
    public void KnightTest()
    {
		Board test = new Board(new Player("Bob", null), new Player("Fred", null));
        
        test.getSpecPiece(2,0).move(4, 1, test);
        assertEquals(test.getGrid()[4][1], test.getSpecPiece(4,1).getSquare());
    }
	
	@Test
	public void BishopTest()
	{
		Board test = new Board(new Player("Bob", null), new Player("Fred", null));
		
		test.getSpecPiece(1,0).move(3, 2, test);
		assertEquals(test.getGrid()[3][2], test.getSpecPiece(3,2).getSquare());
	}
	
	@Test
	public void RookTest()
	{
		Board test = new Board(new Player("Bob", null), new Player("Fred", null));
		
		test.getSpecPiece(0,0).move(0, 1, test);
		assertEquals(test.getGrid()[0][1], test.getSpecPiece(0,1).getSquare());
	}
}

import static org.junit.jupiter.api.Assertions.*;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MovesTest
{

	@Test
    public void KnightTest()
    {
        Board test = new Board(new Player("p1", "Bob", "White"), new Player("p2", "Fred", "Black"));
        
        test.getSpecPiece(2,0).move(4, 1, test);
        assertEquals(test.getGrid()[4][1], test.getSpecPiece(4,1).getSquare());
    }
	
	@Test
	public void BishopTest()
	{
		Board test = new Board(new Player("p1", "Bob", "White"), new Player("p2", "Fred", "Black"));
		
		test.getSpecPiece(3,0).move(5, 2, test);
		assertEquals(test.getGrid()[5][2], test.getSpecPiece(5,2).getSquare());
	}
	
	@Test
	public void RookTest()
	{
		Board test = new Board(new Player("p1", "Bob", "White"), new Player("p2", "Fred", "Black"));
		
		test.getSpecPiece(1,0).move(1, 2, test);
		assertEquals(test.getGrid()[1][2], test.getSpecPiece(1,2).getSquare());
	}
}

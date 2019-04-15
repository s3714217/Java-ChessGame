import org.junit.Assert;
import org.junit.jupiter.api.Test;

class KillTest
{
	
	@Test 
	   // test with Rook
	public void KillRookTest()
	{
    Board test = new Board(new Player("p1", "Bob", "White"), new Player("p2", "Fred", "Black"));

	   test.getSpecPiece(0, 0).move(0, 2, test);//player 1 move Rook
	   test.getSpecPiece(0, 5).move(0, 4, test);//player 2 move Rook
	   test.getSpecPiece(0,2).move(0, 4, test);//player 1 move Rook and kill player 2's Rook
	    
	   Assert.assertEquals(test.getSpecPiece(0, 4).getTeam(), test.getPlayer1().getColour());
	   Assert.assertEquals(test.getPlayer1().getScore(), 5);
	}
	
	@Test 
	   // test with Knight
	public void KillKnightTest()
	{
    Board test = new Board(new Player("p1", "Bob", "White"), new Player("p2", "Fred", "Black"));
	
	   test.getSpecPiece(2, 0).move(1, 2, test);//player 1 move Knight
	   test.getSpecPiece(0, 5).move(0, 4, test);//player 1 move Knight
	   test.getSpecPiece(1,2).move(0, 4, test);//player 1 move Knight and kill player 2's Rook
	   
	   Assert.assertEquals(test.getSpecPiece(0, 4).getTeam(),test.getPlayer1().getColour());
	   Assert.assertEquals(test.getPlayer1().getScore(), 5);
	  
	}
	
	@Test 
	// test with Bishop
	public void KillBishopTest()
	{
    Board test = new Board(new Player("p1", "Bob", "White"), new Player("p2", "Fred", "Black"));
	
	   test.getSpecPiece(1, 0).move(3, 2, test);//player 1 move Bishop
	   test.getSpecPiece(5, 5).move(5, 4, test);//player 2 move Rook
	   test.getSpecPiece(3,2).move(5, 4, test);//player 1 move Bishop and kill player 2's Rook
	   
	   Assert.assertEquals(test.getSpecPiece(5, 4).getTeam(), test.getPlayer1().getColour());
	   Assert.assertEquals(test.getPlayer1().getScore(), 5);

 }
	
}

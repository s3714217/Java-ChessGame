
public abstract class Piece
{

	private Square position;
	private Square[] possibleMoves = new Square[8];
	private Square[] possibleAttacks = new Square[8];
	private boolean aliveStatus = true;
	private String team = null;

	Piece(Square position, String team)
	{
		this.position = position;
		this.team = team;
	}

	public Square getSquare()
	{
		return position;
	}

	public Square[] getPossibleMoves()
	{
		return possibleMoves;
	}
	
	public Square[] getPossibleAttacks()
	{
		return possibleAttacks;
	}

	public boolean getAliveStatus()
	{
		return aliveStatus;
	}

	public void setPosition(Square position)
	{
		this.position = position;
	}

	public String positionToString()
	{
		String stringPos = position.getXAxis() + "-" + position.getYAxis();
		return stringPos;
	}

	public void clearPossibleMoves()
	{
		for (int i = 0; i < 8; i++)
		{
			possibleMoves[i] = null;
		}
	}

	abstract void updatePossibleMoves(Square[][] grid);

	public void killPiece()
	{
		aliveStatus = false;
	}
	
	abstract void updatePossibleAttacks();

}

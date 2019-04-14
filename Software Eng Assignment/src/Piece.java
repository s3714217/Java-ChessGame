
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
	
	public String getTeam()
	{
		return team;
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
	
	// where you need to implement in your piece class
	abstract void updatePossibleMoves(Board board);
	
	public void addPossibleMoves(Square square)
	{
		for (int i = 0; i < possibleMoves.length; i++)
		{
			if (possibleMoves[i] == null)
			{
				
				possibleMoves[i] = square;
				break;
			}
		}
	}
	
	public void killPiece()
	{
		aliveStatus = false;
	}
	
	public void clearPossibleAttacks()
	{
		for (int i = 0; i < 8; i++)
		{
			possibleAttacks[i] = null;
		}
	}
	
	public void addPossibleAttacks(Square square)
	{
		for (int i = 0; i < possibleAttacks.length; i++)
		{
			if (possibleAttacks[i] == null)
			{
				
				possibleAttacks[i] = square;
				break;
			}
		}
	}
	
	//checks the position if it is a viable pos and check if the position is a attack or not
	public void checkPosition(int xPos, int yPos, Board board)
	{
		if (xPos < 6 && xPos >= 0 && yPos < 6 && yPos >= 0)
		{
			if (board.checkOccupied(xPos, yPos) == true)
			{
				
				if (board.checkPieceTeam(xPos, yPos).equals(team) == false)
				{
					addPossibleMoves(board.getSquare(xPos, yPos));
					addPossibleAttacks(board.getSquare(xPos, yPos));
				}
				
			}
			else 
			{
				addPossibleMoves(board.getSquare(xPos, yPos));
			}
		}

	}
	
	//moves the pieces checking the positions able to be moved first, and checks the position matches with the possible Moves
	public void move(int xPos, int yPos, Board board)
	{
		updatePossibleMoves(board);
		
		for (int i = 0; i < possibleMoves.length; i++)
		{
			
			if (possibleMoves[i] != null)
			{
				if (possibleMoves[i].getXAxis() == xPos && possibleMoves[i].getYAxis() == yPos)
				{
					for (int j = 0; j < possibleAttacks.length; j++)
					{
						if (possibleAttacks[j] != null)
						{
							if (possibleAttacks[j].getXAxis() == xPos && possibleAttacks[j].getYAxis() == yPos)
							{
									
								board.getSpecPiece(xPos, yPos).killPiece();
								board.updateScore();
								break;
							}
						}
						
					}
					
					board.getSquare(position.getXAxis(), position.getYAxis()).setOccupied(false);
					
					board.getSquare(xPos, yPos).setOccupied(true);
					position = board.getSquare(xPos, yPos);
					
					break;
				}
			}
		}
	}
	
	
}

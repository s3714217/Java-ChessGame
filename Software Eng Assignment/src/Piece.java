
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
	abstract void updatePossibleMoves(Square[][] grid, Piece[] pieces);
	
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
	public void checkPosition(int xPos, int yPos, Square[][] grid, Piece[] pieces)
	{
		if (xPos < 6 && xPos >= 0 && yPos < 6 && yPos >= 0)
		{
			if (grid[xPos][yPos].getOccupied() == true)
			{
				
				for (int i = 0; i < pieces.length; i++)
				{
					if (pieces[i] != null)
					{
						if (pieces[i].getSquare().getXAxis() == xPos && pieces[i].getSquare().getYAxis() == yPos )
						{
							if (pieces[i].getTeam().contentEquals(team) == false)
							{
								
								addPossibleMoves(grid[xPos][yPos]);
								addPossibleAttacks(grid[xPos][yPos]);
								break;
							}
						}
					}
					
				}
				
				
			}
			else 
			{
				addPossibleMoves(grid[xPos][yPos]);
			}
		}

	}
	
	//moves the pieces checking the positions able to be moved first, and checks the position matches with the possible Moves
	public void move(int xPos, int yPos, Square[][] grid, Piece[] pieces)
	{
		updatePossibleMoves(grid, pieces);
		
		for (int i = 0; i < possibleMoves.length; i++)
		{
			
			if (possibleMoves[i] != null)
			{
				if (possibleMoves[i].getXAxis() == xPos && possibleMoves[i].getYAxis() == yPos)
				{
					for (int j = 0; j < possibleAttacks.length; j++)
					{
						if (possibleAttacks[j].getXAxis() == xPos && possibleAttacks[j].getYAxis() == yPos)
						{
							for (int k = 0; k < possibleAttacks.length; k++)
							{
								if (pieces[i].getSquare().getXAxis() == xPos && pieces[i].getSquare().getYAxis() == yPos)
								{
									
									pieces[i].killPiece();
									break;
								}
							}
							break;
						}
					}
					
					grid[position.getXAxis()][position.getYAxis()].setOccupied(false);
					
					grid[xPos][yPos].setOccupied(true);
					position = grid[xPos][yPos];
					
					break;
				}
			}
		}
	}
	
}

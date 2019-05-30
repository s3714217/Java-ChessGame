package oo;

public abstract class Piece
{
	//square that holds the position of the piece
	private Square position;
	
	//arrays to store possibleMoves and Possible attacks
	//possible moves are the squares where the pieces can be placed
	private Square[] possibleMoves = new Square[8];
	//areas where the piece can move to but has a enemy piece on
	private Square[] possibleAttacks = new Square[8];
	
	//represent aliveStatus
	private boolean aliveStatus = true;
	
	//string to represent teams
	private String team = null;

	public Piece(Square position, String team)
	{
		this.position = position;
		this.team = team;
	}
	
	public String getTeam()
	{
		return team;
	}

	public Square getPosition()
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
	
	//returns string for the position of the piece
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
	
	// finds the possible moves for the piece
	abstract void updatePossibleMoves(Board board);
	
	//adds the square to possible moves
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
	
	//adds the square to possible attacks
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
	
	//checks the position if it is a viable position and check if the position is a attack or not
	public void checkPosition(int xPos, int yPos, Board board)
	{
		//checking if the position entered is on the board
		if (xPos < 6 && xPos >= 0 && yPos < 6 && yPos >= 0)
		{
			//checking if it is a attack
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
				//adding to moves if not
				addPossibleMoves(board.getSquare(xPos, yPos));
			}
		}

	}
	
}

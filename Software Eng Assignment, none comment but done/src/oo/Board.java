package oo;

import java.lang.Integer; 
import java.util.ArrayList;
import java.util.Collection;

import view.BoardObserver;
import view.EndObserver;
import view.MoveObserver;

public class Board
{
	//grid for the squares
	private Square[][] grid = new Square[6][6];
	
	// all the pieces on the board
	private Piece[] pieces = new Piece[12];
	
	// players in the game
	private Player[] players = new Player[2];
	
	// a int to represent whos turn it is
	private int currentPlayer = 0;
	
	// the number of moves left
	private int numMoves = 0;
	
	// collection of observers for GUI
	// used for Tiles to update when selecting a tile
	private final Collection<BoardObserver> boardObservers;
	
	// used for updating when a player has finished there turn
	private final Collection<MoveObserver> moveObservers;
	
	// observers for ending when game is ended
	private final Collection<EndObserver> endObservers;
	
	
	public Board(Player player1, Player player2)
	{
		//initializing the observer arrayList
		this.boardObservers = new ArrayList<>();
		this.moveObservers = new ArrayList<>();
		this.endObservers = new ArrayList<>();
		
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 6; j++)
			{
				grid[i][j] = new Square(i, j);
			}
		}
		
		
		players[0] = player1;
		players[1] = player2;
		
		// pieces for player 1/ white
		pieces[0] = new Rook(grid[0][0], "player1");
		pieces[1] = new Bishop(grid[1][0], "player1");
		pieces[2] = new Knight(grid[2][0], "player1");
		pieces[3] = new Knight(grid[3][0], "player1");
		pieces[4] = new Bishop(grid[4][0], "player1");
		pieces[5] = new Rook(grid[5][0], "player1");
		
		// pieces for player 2/ black
		pieces[6] = new Rook(grid[0][5], "player2");
		pieces[7] = new Bishop(grid[1][5], "player2");
		pieces[8] = new Knight(grid[2][5], "player2");
		pieces[9] = new Knight(grid[3][5], "player2");
		pieces[10] = new Bishop(grid[4][5], "player2");
		pieces[11] = new Rook(grid[5][5], "player2");
		
		// setting the square with pieces 
		grid[0][0].setOccupied(true);
		grid[1][0].setOccupied(true);
		grid[2][0].setOccupied(true);
		grid[3][0].setOccupied(true);
		grid[4][0].setOccupied(true);
		grid[5][0].setOccupied(true);
		grid[0][5].setOccupied(true);
		grid[1][5].setOccupied(true);
		grid[2][5].setOccupied(true);
		grid[3][5].setOccupied(true);
		grid[4][5].setOccupied(true);
		grid[5][5].setOccupied(true);
	}
	
	public Board()
	{
		
		this(null, null);
	}
	
	public Square[][] getGrid() 
	{
		return grid;
	}
	
	public Piece[] getPieces()
	{
		return pieces;
	}
	
	public void setNumMoves(int numMoves)
	{
		this.numMoves = numMoves;
	}
	
	public int getNumMoves()
	{
		return numMoves;
	}

	// get specific piece at the position
	public Piece getSpecPiece(int xPos, int yPos)
	{
		if (xPos < 6 && xPos >= 0 && yPos < 6 && yPos >= 0)
		{
			if (grid[xPos][yPos].getOccupied() == true)
			{
				for (int i = 0; i < pieces.length; i++)
				{
					if (pieces[i].getPosition() == grid[xPos][yPos])
					{
						return pieces[i];
					}
				}
			}
		}
		return null;
	}
	
	// set specific piece at the position
	public void setSpecPiece(int xPos, int yPos, Piece piece)
	{
		if (xPos < 6 && xPos >= 0 && yPos < 6 && yPos >= 0)
		{
			if (grid[xPos][yPos].getOccupied() == true)
			{
				for (int i = 0; i < pieces.length; i++)
				{
					if (pieces[i].getPosition() == grid[xPos][yPos])
					{
						pieces[i] = piece;
					}
				}
			}
		}
	}	

	// get square at the position
	public Square getSquare(int xPos, int yPos)
	{
		if (xPos < 6 && xPos >= 0 && yPos < 6 && yPos >= 0)
		{

			return grid[xPos][yPos];
		}
		
		return null;
	}
	
	// set square at the position
	public void setSquare(int xPos, int yPos, Square square)
	{
		if (xPos < 6 && xPos >= 0 && yPos < 6 && yPos >= 0)
		{

			grid[xPos][yPos] = square;
		}
	}
	
	// get square at the position
	public boolean checkOccupied(int xPos, int yPos)
	{
		if (xPos < 6 && xPos >= 0 && yPos < 6 && yPos >= 0)
		{
			if (grid[xPos][yPos].getOccupied() == true)
			{
				
				return true;
			}
		}
		
		return false;
	}
	
	//check the specific piece at the positions team
	public String checkPieceTeam(int xPos, int yPos) 
	{
		if (xPos < 6 && xPos >= 0 && yPos < 6 && yPos >= 0)
		{
			if (grid[xPos][yPos].getOccupied() == true)
			{
				for (int i = 0; i < pieces.length; i++)
				{
					if (pieces[i].getPosition() == grid[xPos][yPos])
					{
						return pieces[i].getTeam();
					}
				}
			}
		}
		
		return null;
	}
	
	// update score for players
	public void updateScore () 
	{
		int white = 0;
		int black = 0;
		
		// if piece is dead add 5 points to enemy
		for (int i = 0; i < pieces.length; i++)
		{
			if (pieces[i].getTeam().equals("player1") && pieces[i].getAliveStatus() == false)
			{
				black += 5;
			}
			else if (pieces[i].getTeam().equals("player2") && pieces[i].getAliveStatus() == false)
			{
				white += 5;
			}
		}
		
		// setting the score
		players[0].setScore(white);
		players[1].setScore(black);
	}
	
	public Player getPlayer1()
	{
		return players[0];
	}
	
	public Player getPlayer2() {
		return players[1];
	}
	
	public void setPlayer1(Player p1)
	{
		players[0] = p1;
	}
	
	public void setPlayer2(Player p2) {
		players[1] = p2;
	}
	
	public int getCurrentPlayerInt()
	{
		return currentPlayer;
	}
	
	public Player getCurrentPlayer()
	{
		return players[currentPlayer];
	}
	
	// checks if game is over
	public boolean checkGameOver()
	{
		boolean gameOver = false;
		
		// check if player has the max points
		for (int i = 0; i < players.length; i++)
		{
			if (players[i].getScore() == 30)
			{
				gameOver = true;
			}
		}
		
		//check if no more turns left
		if (numMoves == 0)
		{
			gameOver = true;
		}
		
		return gameOver;
	}
	
	// add a player to the game
	public boolean addPlayer(Player player)
	{
		boolean added = false;
		
		for (int i = 0; i < players.length; i++)
		{
			if (players[i] == null)
			{
				players[i] = player;
				added = true;
				break;
			}
		}
		
		return added;
	}
	
	// updates all the pieces possible moves
	public void updatePieces()
	{
		for(int i = 0; i < pieces.length; i++)
		{
			if (pieces[i] != null)
			{
				if (pieces[i].getPosition() != null)
				{
					pieces[i].updatePossibleMoves(this);
				}
			}
		}
	}
	
	// moving operations
	public void move(int xPos, int yPos, int tarXPos, int tarYPos)
	{
		updatePieces();
		
		// getting the piece that we selected
		for (int i = 0; i < pieces.length; i++)
		{
			if (pieces[i].getPosition() != null)
			{
				if (pieces[i].getPosition().getXAxis() == xPos
						&& pieces[i].getPosition().getYAxis() == yPos)
				{
					//checking if placed at a possible attack
					Square[] posAttack = pieces[i].getPossibleAttacks();
					
					
					for (int j = 0; j < posAttack.length; j++)
					{
						if (posAttack[j] != null)
						{
							int attackXAxis = posAttack[j].getXAxis();
							int attackYAxis = posAttack[j].getYAxis();
							
							//comparing the ints of the attack and the wanted position
							if (Integer.compare(attackXAxis, tarXPos) == 0
									&& Integer.compare(attackYAxis, tarYPos) == 0)
							{
								
								for (int k = 0; k < pieces.length; k++)
								{
									if (pieces[k].getPosition() != null)
									{
										if (pieces[k].getPosition().getXAxis() == tarXPos
												&& pieces[k].getPosition().getYAxis() == tarYPos)
										{
											//killing the piece at the attack
											pieces[k].killPiece();
											pieces[k].setPosition(null);
											updateScore();
										}
									}
									
								}
								
							}
						}
						else
						{
							break;
						}
					}
					
					//updating the position, of the piece moved
					grid[xPos][yPos].setOccupied(false);
					grid[tarXPos][tarYPos].setOccupied(true);
					
					pieces[i].setPosition(grid[tarXPos][tarYPos]);
					
					// updating current player
					if (currentPlayer == 1)
					{
						currentPlayer--;
						numMoves--;
					}
					else
					{
						currentPlayer++;
						
					}
					updateBoard();
					
					if(checkGameOver() == true)
					{
						endGame();
					}
				}
			}
		}
	}
	
	public void addBoardObserver(BoardObserver boardObserver)
	{
		boardObservers.add(boardObserver);
	}
	
	public void addMoveObserver(MoveObserver moveObserver)
	{
		moveObservers.add(moveObserver);
	}
	
	public void addEndObserver(EndObserver endObserver)
	{
		endObservers.add(endObserver);
	}
	
	// updating the board visuals after turn
	public void updateBoard()
	{
		updatePieces();
		for (MoveObserver moveObserver : moveObservers)
		{
			moveObserver.updateBoard(this);
		}
	}
	
	// after selected a tile
	public void pieceSelected(int xPos, int yPos)
	{
		updatePieces();
		for (BoardObserver boardObserver : boardObservers)
		{
			boardObserver.pieceSelected(this, xPos, yPos);
		}
	}
	
	// after deselected a tile
	public void deselected()
	{
		for (BoardObserver boardObserver : boardObservers)
		{
			boardObserver.deselected(this);
		}
	}
	
	// end the game
	public void endGame()
	{
		for (EndObserver endObserver : endObservers)
		{
			endObserver.endGame(this);
		}
	}
	
	
}
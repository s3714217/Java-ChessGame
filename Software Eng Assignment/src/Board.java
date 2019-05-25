
public class Board {
	private Square[][] grid = new Square[6][6];
	private Piece[] pieces = new Piece[12];
	private Player[] players = new Player[2];

	public Board() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				grid[i][j] = new Square(i, j);
			}
		}
		players[0] = new Player("null", "null", "null");
		players[1] = new Player("null", "null", "null");
		
		pieces[0] = new Rook(grid[0][0], players[0].getColour());
		pieces[1] = new Bishop(grid[1][0], players[0].getColour());
		pieces[2] = new Knight(grid[2][0], players[0].getColour());
		pieces[3] = new Knight(grid[3][0], players[0].getColour());
		pieces[4] = new Bishop(grid[4][0], players[0].getColour());
		pieces[5] = new Rook(grid[5][0], players[0].getColour());

		pieces[6] = new Rook(grid[0][5], players[1].getColour());
		pieces[7] = new Bishop(grid[1][5], players[1].getColour());
		pieces[8] = new Knight(grid[2][5], players[1].getColour());
		pieces[9] = new Knight(grid[3][5], players[1].getColour());
		pieces[10] = new Bishop(grid[4][5], players[1].getColour());
		pieces[11] = new Rook(grid[5][5], players[1].getColour());

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

	public Square[][] getGrid() {
		return grid;
	}

	public Piece[] getPieces() {
		return pieces;
	}

	public Piece getSpecPiece(int xPos, int yPos) {
		if (xPos < 6 && xPos >= 0 && yPos < 6 && yPos >= 0) {
			if (grid[xPos][yPos].getOccupied() == true) {
				for (int i = 0; i < pieces.length; i++) {
					if (pieces[i].getSquare() == grid[xPos][yPos]) {
						return pieces[i];
					}
				}
			}
		}
		return null;
	}

	public Square getSquare(int xPos, int yPos) {
		if (xPos < 6 && xPos >= 0 && yPos < 6 && yPos >= 0) {

			return grid[xPos][yPos];
		}

		return null;
	}

	public boolean checkOccupied(int xPos, int yPos) {
		if (xPos < 6 && xPos >= 0 && yPos < 6 && yPos >= 0) {
			if (grid[xPos][yPos].getOccupied() == true) {

				return true;
			}
		}

		return false;
	}

	public String checkPieceTeam(int xPos, int yPos) {
		if (xPos < 6 && xPos >= 0 && yPos < 6 && yPos >= 0) {
			if (grid[xPos][yPos].getOccupied() == true) {
				for (int i = 0; i < pieces.length; i++) {
					if (pieces[i].getSquare() == grid[xPos][yPos]) {
						return pieces[i].getTeam();
					}
				}
			}
		}

		return null;
	}

	public void updateScore() {
		int white = 0;
		int black = 0;

		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i].getTeam() == players[0].getColour() && pieces[i].getAliveStatus() == false) {
				black += 5;
			} else if (pieces[i].getTeam() == players[1].getColour() && pieces[i].getAliveStatus() == false) {
				white += 5;
			}
		}

		players[0].setScore(white);
		players[1].setScore(black);
	}

	public Player[] getPlayer() {
		return players;
	}

	public void addPlayer(Player[] loggedPlayer) {
		this.players[0] = loggedPlayer[0];
		this.players[1] = loggedPlayer[1];
		this.players[0].setColor("BLACK");
		this.players[1].setColor("WHITE");	}
}



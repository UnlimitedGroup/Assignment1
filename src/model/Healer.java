package model;

public class Healer extends Piece{

	//private final int maxHealth = 100;

	public Healer(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
	}
	
	private boolean moveCheck(int row, int column) {
		int currentRow = this.getCurrentSquare().getRow();
		int currentColumn = this.getCurrentSquare().getColumn();
		if (row == currentRow || row == currentRow + 1 || row == currentRow - 1) {
			if (column == currentColumn || column == currentColumn + 1 || column == currentColumn - 1 ) {
			return true;
			}
		}
		return false;
	}
	@Override
	public boolean move(int row, int column) {
		if (moveCheck(row, column)) {
			this.setCurrentSquare(Board.squares[row][column]);
				return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		return "healer";
		}
	
	/*
	 * UNIQUE SPELL, heal ALL units for 75 damage in its vertical northern path, within 2 tiles
	 */
	public boolean spell() {
		int currentRow = this.getCurrentSquare().getRow();
		int currentColumn = this.getCurrentSquare().getColumn();
		
		for (int i=0; i<2;i++) {
			if (currentRow+i <= Board.squares.length-1) {
				Square checkSquare = Board.squares[currentRow+i][currentColumn];
				for (Piece j: Board.pieceSet) {
					//Check only pieces on other team and Check if the piece is in the spell path square
					if (j.getTeam() == this.getTeam() && j.getCurrentSquare() == checkSquare) {
						j.increaseHealth(75);
					}
				}
			}
		}
		return true;	
	}
}


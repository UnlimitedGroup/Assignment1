package model;

public class Rogue extends Piece {
	
	//private final int maxHealth = 100;

	public Rogue(int health, Square currentSquare, int team) {
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
	public boolean spell() {
		int currentRow = this.getCurrentSquare().getRow();
		int currentColumn = this.getCurrentSquare().getColumn();
		/*
		 * UNIQUE SPELL, hit ONE unit for 100 damage in its vertical northern path, 1 tiles 
		 */
		for (int i=0; i<1;i++) {
			if (currentRow+i <= Board.squares.length-1) {
				Square checkSquare = Board.squares[currentRow+i][currentColumn];
				for (Piece j: Board.pieceSet) {
					if (j.getTeam() != this.getTeam() && j.getCurrentSquare() == checkSquare) {
						j.decreaseHealth(100);
						return true;
					}
				}
			}
		}
		return true;	
	}
	
	
	public String toString() {
		return "rogue";
		}
}

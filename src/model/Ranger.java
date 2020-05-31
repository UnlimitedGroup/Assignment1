package model;

public class Ranger extends Piece {

	//private final int maxHealth = 100;

	public Ranger(int health, Square currentSquare, int team) {
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
		return "ranger";
		}
	public boolean spell() {
		int currentRow = this.getCurrentSquare().getRow();
		int currentColumn = this.getCurrentSquare().getColumn();
		/*
		 * UNIQUE SPELL, hit ALL units for 50 damage in its vertical southern path, 4 tiles 
		 */
		for (int i=0; i<4;i++) {
			if (currentRow+i <= Board.squares.length-1) {
				Square checkSquare = Board.squares[currentRow+i][currentColumn];
				for (Piece j: Board.pieceSet) {
					if (j.getTeam() != this.getTeam() && j.getCurrentSquare() == checkSquare) {
						j.decreaseHealth(50);
						System.out.println("enemy hit");
					}
				}
			}
		}
		return true;
		
	}
	
}

package model;

public class Power extends Piece {

	//private final int maxHealth = 100;

	public Power(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
	}
	
	private boolean moveCheck(int column, int row) {
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
	public boolean move(int column, int row) {
		if (moveCheck(column, row)) {
			this.setCurrentSquare(Board.squares[column][row]);
				return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		return "power";
		}
}

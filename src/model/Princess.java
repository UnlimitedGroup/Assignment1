package model;

public class Princess extends Piece {

	public Princess(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
	}
	public String toString() {
		if (this.getTeam() == 1) {
			return "princess1";
		}
		else {
			return "princess2";
		}
	}
    /*
	@Override
	public void spell() {
	
	}
    */
	@Override
	public boolean move(int row, int column) {
		int currentRow = this.getCurrentSquare().getRow();
		int currentColumn = this.getCurrentSquare().getColumn();

		//Check row is in range
		if (row == currentRow || row == currentRow + 1 || row == currentRow - 1) {
		    //Check column is in range
			if (column == currentColumn || column == currentColumn + 1 || column == currentColumn - 1 ) {
			this.setCurrentSquare(Board.squares[row][column]);
			return true;
			}
		}
		return false;
	}
}

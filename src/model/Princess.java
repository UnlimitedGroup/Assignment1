package model;

import exceptions.healthException;

public class Princess extends Piece {

	public Princess(int health, Square currentSquare, int team) throws healthException {
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
	public boolean movePreModifier(int row, int column) {
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
		if (movePreModifier(row, column)) {
			this.setCurrentSquare(Board.squares[row][column]);
				return true;
		}
		else {
			return false;
		}
	}
}


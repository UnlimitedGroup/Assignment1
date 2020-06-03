package model;

import java.util.ArrayList;

public class Princess extends Piece {

	//private final int maxHealth = 100;

	public Princess(int health, Square currentSquare, int team) {
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
		if (this.getTeam() == 1) {
			return "princess1";
		}
		else {
			return "princess2";
		}
	}
	public ArrayList<Square> prepareSpell() {
		return null;
	}
	public boolean castSpell(ArrayList<Square> targetSquares) {
		return false;
	}	
}


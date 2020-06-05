package model;
import java.util.ArrayList;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

public class Princess extends Piece {

	public Princess(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
	}
	
	@Requires({"row <=7 && row >= 0", "column <= 5 && column >= 0"})
	@Ensures({"currentRow <=7 && currentRow >= 0", "currentColumn <= 5 && currentColumn >= 0"})
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
	@Requires({"row <=7 && row >= 0", "column <= 5 && column >= 0"})
	@Ensures("Board.squares[row][column] != null")
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


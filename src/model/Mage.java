package model;

import java.util.ArrayList;
import com.google.java.contract.*;

public class Mage extends Piece {

	public Mage(int health, Square currentSquare, int team) {
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
	@Ensures({"currentRow <=7 && currentRow >= 0", "currentColumn <= 5 && currentColumn >= 0"})
	public ArrayList<Square> prepareSpell() {
		int currentRow = this.getCurrentSquare().getRow();
		int currentColumn = this.getCurrentSquare().getColumn();
		int maxRow = Board.squares.length -1;
		int maxColumn = Board.squares[0].length -1;
		ArrayList<Square> squareCheck = new ArrayList<Square>();
		
		for (int i=1; i<=1;i++) {
				squareCheck.add(Board.squares[(currentRow+i <= maxRow) ? currentRow+i: maxRow][currentColumn]);
				squareCheck.add(Board.squares[(currentRow-i >= 0) ? currentRow-i: 0][currentColumn]);
				squareCheck.add(Board.squares[currentRow][(currentColumn+i <= maxColumn) ? currentColumn+i: maxColumn]);
				squareCheck.add(Board.squares[currentRow][(currentColumn-i >= 0) ? currentColumn-i: 0]);
				squareCheck.add(Board.squares[(currentRow-i >= 0) ? currentRow-i: 0][(currentColumn-i >= 0) ? currentColumn-i: 0]);
				squareCheck.add(Board.squares[(currentRow-i >= 0) ? currentRow-i: 0][(currentColumn+i <= maxColumn) ? currentColumn+i: maxColumn]);
				squareCheck.add(Board.squares[(currentRow+i <= maxRow) ? currentRow+i: maxRow][(currentColumn-i >= 0) ? currentColumn-i: 0]);
				squareCheck.add(Board.squares[(currentRow+i <= maxRow) ? currentRow+i: maxRow][(currentColumn+i <= maxColumn) ? currentColumn+i: maxColumn]);
		}
		return squareCheck;
	}
	public boolean castSpell(ArrayList<Square> targetSquares) {
		for (Square s: targetSquares) {
			for (Piece j: Board.pieceSet) {
				if (j.getTeam() != this.getTeam() && j.getCurrentSquare() == s) {
						j.decreaseHealth(50);
				}
			}
		}
	return true;
	}
	public String toString() {
		return "mage";
		}
}

package model;

import java.util.ArrayList;

public class Mage extends Piece {

	//private final int maxHealth = 100;

	public Mage(int health, Square currentSquare, int team) {
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
		int maxRow = Board.squares.length -1;
		int maxColumn = Board.squares[0].length -1;
		
		//Team 1
		for (int i=1; i<=1;i++) {
			//Check if a piece in in the square infront square
				ArrayList<Square> squareCheck = new ArrayList<Square>();
				squareCheck.add(Board.squares[(currentRow+i <= maxRow) ? currentRow+i: maxRow][currentColumn]);
				squareCheck.add(Board.squares[(currentRow-i >= 0) ? currentRow-i: 0][currentColumn]);
				squareCheck.add(Board.squares[currentRow][(currentColumn+i <= maxColumn) ? currentColumn+i: maxColumn]);
				squareCheck.add(Board.squares[currentRow][(currentColumn-i >= 0) ? currentColumn-i: 0]);
				squareCheck.add(Board.squares[(currentRow-i >= 0) ? currentRow-i: 0][(currentColumn-i >= 0) ? currentColumn-i: 0]);
				squareCheck.add(Board.squares[(currentRow-i >= 0) ? currentRow-i: 0][(currentColumn+i <= maxColumn) ? currentColumn+i: maxColumn]);
				squareCheck.add(Board.squares[(currentRow+i <= maxRow) ? currentRow+i: maxRow][(currentColumn-i >= 0) ? currentColumn-i: 0]);
				squareCheck.add(Board.squares[(currentRow+i <= maxRow) ? currentRow+i: maxRow][(currentColumn+i <= maxColumn) ? currentColumn+i: maxColumn]);
			
			for (Square s: squareCheck) {
				System.out.println(s.getRow());
				System.out.println(s.getColumn());
				for (Piece j: Board.pieceSet) {
					//Check only pieces on other team and Check if the piece is in the spell path square
					if (j.getTeam() != this.getTeam() && j.getCurrentSquare() == s) {
							j.decreaseHealth(50);
							System.out.println("enemy hit");
					}
				}
			}
		}
		return true;
	}
	public String toString() {
		return "mage";
		}
}

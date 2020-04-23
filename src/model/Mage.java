package model;

import java.util.ArrayList;

import exceptions.healthException;

public class Mage extends Piece {

	public Mage(int health, Square currentSquare, int team) throws healthException {
		super(health, currentSquare, team);	
	}
	public String toString() {
		return "mage";
		}
	/*
	Unique Spell - Damage all surrounding units by 50 
	X X X
	X U X 
	X X X
	 */
	/*
	@Override
	public void spell() {
		int currentRow = this.getCurrentSquare().getRow();
		int currentColumn = this.getCurrentSquare().getColumn();
		Square SquareList[][] = Board.getSquareList();
		ArrayList<Piece> PieceList = Board.getPieceSet();
		
		try {
				Square checkUp = SquareList[currentRow--][currentColumn];
				Square checkDown = SquareList[currentRow++][currentColumn];
				Square checkLeft = SquareList[currentRow][currentColumn--];
				Square checkRight = SquareList[currentRow][currentColumn++];
				Square checkTopLeft = SquareList[currentRow--][currentColumn--];
				Square checkTopRight = SquareList[currentRow--][currentColumn++];
				Square checkBottomLeft = SquareList[currentRow++][currentColumn--];
				Square checkBottomRight = SquareList[currentRow++][currentColumn++];
				for (int j = 0; j<PieceList.size()-1; j++) {
					//Check only pieces on other team
					if (PieceList.get(j).getTeam() != this.getTeam()) {
						//Check if the piece is in the spell path square
						if (PieceList.get(j).getCurrentSquare() == checkUp) {
							//Deal 25 Damage
							PieceList.get(j).takeDamage(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkDown) {
							//Deal 25 Damage
							PieceList.get(j).takeDamage(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkLeft) {
							//Deal 25 Damage
							PieceList.get(j).takeDamage(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkRight) {
							//Deal 25 Damage
							PieceList.get(j).takeDamage(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkTopLeft) {
							//Deal 25 Damage
							PieceList.get(j).takeDamage(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkTopRight) {
							//Deal 25 Damage
							PieceList.get(j).takeDamage(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkBottomLeft) {
							//Deal 25 Damage
							PieceList.get(j).takeDamage(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkBottomRight) {
							//Deal 25 Damage
							PieceList.get(j).takeDamage(25);
						}
					}
				}
		} catch (Exception e) {
			System.out.println(e);
		}
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

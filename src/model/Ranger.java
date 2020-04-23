package model;

import java.util.ArrayList;

public class Ranger extends Piece {

	public Ranger(int health, Square currentSquare, int team) throws healthException {
		super(health, currentSquare, team);
	}
	public String toString() {
		return "ranger";
		}
	/*
	Unique Spell - Damage unit up to 7 squares away in a straight line by 20
	 */
	/*
	public void spell() {
		int currentRow = this.getCurrentSquare().getRow();
		int currentColumn = this.getCurrentSquare().getColumn();
		Square SquareList[][] = Board.getSquareList();
		ArrayList<Piece> PieceList = Board.getPieceSet();
		
		if (this.getTeam() == 0) {
			for (int i=0; i<6;i++) {
				Square checkSquare = SquareList[currentRow++][currentColumn];
				for (int j = 0; j<PieceList.size()-1; j++) {
					//Check only pieces on other team
					if (PieceList.get(j).getTeam() != this.getTeam()) {
						//Check if the piece is in the spell path square
						if (PieceList.get(j).getCurrentSquare() == checkSquare) {
							//Deal 25 Damage
							PieceList.get(j).takeDamage(20);
							return;
						
						}
					}
				}
			}
		}
		if (this.getTeam() == 1) {
			for (int i=0; i<6;i++) {
				Square checkSquare = SquareList[currentRow--][currentColumn];
				for (int j = 0; j<PieceList.size()-1; j++) {
					//Check only pieces on other team
					if (PieceList.get(j).getTeam() != this.getTeam()) {
						//Check if the piece is in the spell path square
						if (PieceList.get(j).getCurrentSquare() == checkSquare) {
							//Deal 25 Damage
							PieceList.get(j).takeDamage(20);
							return;
						}
					}
				}
			}
		}
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

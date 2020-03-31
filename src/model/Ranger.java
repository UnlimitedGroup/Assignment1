package model;

import java.util.ArrayList;

public class Ranger extends Piece {

	public Ranger(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
	}
	/*
	Unique Spell - Damage unit up to 7 squares away in a straight line by 20
	 */
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
							
						}
					}
				}
			}
		}
	}
}

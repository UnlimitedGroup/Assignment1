package model;

import java.util.ArrayList;

public class Paladin extends Piece {

	public Paladin(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
	}
	/*
	 Unique spell is healing beam in forward direction 4 squares healing first piece hit for 25 healt
	 */
	@Override
	public void spell() {
		int currentRow = this.getCurrentSquare().getRow();
		int currentColumn = this.getCurrentSquare().getColumn();
		Square SquareList[][] = Board.getSquareList();
		ArrayList<Piece> PieceList = Board.getPieceSet();
		
		if (this.getTeam() == 0) {
			for (int i=0; i<3;i++) {
				Square checkSquare = SquareList[currentRow++][currentColumn];
				for (int j = 0; j<PieceList.size()-1; j++) {
					//Check only pieces on other team
					if (PieceList.get(j).getTeam() != this.getTeam()) {
						//Check if the piece is in the spell path square
						if (PieceList.get(j).getCurrentSquare() == checkSquare) {
							//Deal 25 Damage
							PieceList.get(j).heal(25);
							
						}
					}
				}
			}
		}
		if (this.getTeam() == 1) {
			for (int i=0; i<3;i++) {
				Square checkSquare = SquareList[currentRow--][currentColumn];
				for (int j = 0; j<PieceList.size()-1; j++) {
					//Check only pieces on other team
					if (PieceList.get(j).getTeam() != this.getTeam()) {
						//Check if the piece is in the spell path square
						if (PieceList.get(j).getCurrentSquare() == checkSquare) {
							//Deal 25 Damage
							PieceList.get(j).heal(25);
							
						}
					}
				}
			}
		}
		
	}

}

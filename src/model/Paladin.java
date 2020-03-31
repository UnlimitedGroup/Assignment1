package model;

import java.util.ArrayList;

public class Paladin extends Piece {

	public Paladin(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
	}
	/*
	Unique Spell - Heal unit up to 4 squares away in a straight line by 50
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
							PieceList.get(j).heal(50);
							return;
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
							PieceList.get(j).heal(50);
							return;
							
						}
					}
				}
			}
		}
		
	}
	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		return false;
	}

}

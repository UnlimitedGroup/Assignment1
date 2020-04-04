package model;

import java.util.ArrayList;

public class Rogue extends Piece {

	public Rogue(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
	}
	public String toString() {
		return "rogue";
		}
	/*
	Unique Spell - Damage unit in front by 75
	 */
	/*
	public void spell() {
		int currentRow = this.getCurrentSquare().getRow();
		int currentColumn = this.getCurrentSquare().getColumn();
		Square SquareList[][] = Board.getSquareList();
		ArrayList<Piece> PieceList = Board.getPieceSet();
		
		if (this.getTeam() == 0) {
			for (int i=0; i<1;i++) {
				Square checkSquare = SquareList[currentRow++][currentColumn];
				for (int j = 0; j<PieceList.size()-1; j++) {
					//Check only pieces on other team
					if (PieceList.get(j).getTeam() != this.getTeam()) {
						//Check if the piece is in the spell path square
						if (PieceList.get(j).getCurrentSquare() == checkSquare) {
							//Deal 25 Damage
							PieceList.get(j).takeDamage(75);
							return;
						
						}
					}
				}
			}
		}
		if (this.getTeam() == 1) {
			for (int i=0; i<1;i++) {
				Square checkSquare = SquareList[currentRow--][currentColumn];
				for (int j = 0; j<PieceList.size()-1; j++) {
					//Check only pieces on other team
					if (PieceList.get(j).getTeam() != this.getTeam()) {
						//Check if the piece is in the spell path square
						if (PieceList.get(j).getCurrentSquare() == checkSquare) {
							//Deal 25 Damage
							PieceList.get(j).takeDamage(75);
							
						}
					}
				}
			}
		}
	}
	*/
	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		return false;
	}
}

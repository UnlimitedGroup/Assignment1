package model;

import java.util.ArrayList;

public class Power extends Piece {

public Power(int health, Square currentSquare, Player team) {
	super(health, currentSquare, team);
}

/*
 Unique spell is laser beam in forward direction 4 squares damaging first piece hit for 25 health
 */
public boolean spell() {
	int currentRow = this.getCurrentSquare().getRow();
	int currentColumn = this.getCurrentSquare().getColumn();
	Square SquareList[][] = Board.getSquareList();
	ArrayList<Piece> PieceList = Board.getPieceSet();
	
	for (int i=0; i<3;i++) {
		Square checkSquare = SquareList[currentRow++][currentColumn];
		for (int j = 0; j<PieceList.size()-1; j++) {
			//Check only pieces on other team
			if (PieceList.get(j).getTeam() != this.getTeam()) {
				//Check if the piece is in the spell path square
				if (PieceList.get(j).getCurrentSquare() == checkSquare) {
					//Deal 25 Damage
					PieceList.get(j).takeDamage(25);
					return true;
				}
			}
		}
	}return false;
}







}

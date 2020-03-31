package model;

import java.util.ArrayList;

public class Mage extends Piece {

	public Mage(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
		
	}

	@Override
	public boolean spell() {
		int currentRow = this.getCurrentSquare().getRow();
		int currentColumn = this.getCurrentSquare().getColumn();
		Square SquareList[][] = Board.getSquareList();
		ArrayList<Piece> PieceList = Board.getPieceSet();
		
	
		
		try {
		
			for (int i=0; i<3;i++) {
				Square checkSquare0 = SquareList[currentRow++][currentColumn];
				Square checkSquare1 = SquareList[currentRow++][currentColumn];
				Square checkSquare2 = SquareList[currentRow++][currentColumn];
				Square checkSquare3 = SquareList[currentRow++][currentColumn];
				Square checkSquare4 = SquareList[currentRow++][currentColumn];
				Square checkSquare5 = SquareList[currentRow++][currentColumn];
				Square checkSquare6 = SquareList[currentRow++][currentColumn];
				Square checkSquare7 = SquareList[currentRow++][currentColumn];
				for (int j = 0; j<PieceList.size()-1; j++) {
					//Check only pieces on other team
					if (PieceList.get(j).getTeam() != this.getTeam()) {
						//Check if the piece is in the spell path square
						if (PieceList.get(j).getCurrentSquare() == checkSquare) {
							//Deal 25 Damage
							PieceList.get(j).heal(25);
							return true;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Square out of bounds");
		}
		return false;
	}

}

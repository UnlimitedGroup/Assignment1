package model;

import java.util.ArrayList;

public class Healer extends Piece{

	public Healer(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
		
	}
	/*
	Unique Spell - Heal all surrounding units by 25 
	X X X
	X U X 
	X X X
	 */
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
							PieceList.get(j).heal(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkDown) {
							PieceList.get(j).heal(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkLeft) {
							PieceList.get(j).heal(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkRight) {
							PieceList.get(j).heal(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkTopLeft) {
							PieceList.get(j).heal(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkTopRight) {
							PieceList.get(j).heal(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkBottomLeft) {
							PieceList.get(j).heal(25);
						}
						if (PieceList.get(j).getCurrentSquare() == checkBottomRight) {
							PieceList.get(j).heal(25);
						}
					}
				}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		return false;
	}

}

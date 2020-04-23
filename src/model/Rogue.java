package model;

import java.util.ArrayList;

import exceptions.healthException;

public class Rogue extends Piece {

	public Rogue(int health, Square currentSquare, int team) throws healthException {
		super(health, currentSquare, team);
	}
	public String toString() {
		return "rogue";
		}
	/*
	Unique Spell - Damage unit in front by 75} catch (squareBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

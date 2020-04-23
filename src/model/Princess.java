package model;

import exceptions.healthException;

public class Princess extends Piece {

	private final int maxHealth = 100;
	private int health;

	public Princess(int health, Square currentSquare, int team) throws healthException {
		super(currentSquare, team);
		if (healthPreModifier(health)) {
			this.health = health;
		}
		else {
			throw new healthException();
		}
	}
	
	public int getHealth () {
		return this.health;
	}
	public void setHealth(int health) throws healthException {
		if (health <= maxHealth) {
			this.health = health;
		}
		else {
			throw new healthException();
		}
	}
	public boolean healthPreModifier(int health) {
	    	if (health <= maxHealth) {
	    		return true;
	    	}
	    	return false;
	    }
	public void heal(int heal) {
	}
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
	public String toString() {
		if (this.getTeam() == 1) {
			return "princess1";
		}
		else {
			return "princess2";
		}
	}
	
	
	/*
	SPELL TEMPLATE CODE FOR PART 2
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

}


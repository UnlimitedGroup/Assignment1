package model;

import exceptions.healthException;

public class Mage extends Piece {

	private final int maxHealth = 100;
	private int health;

	public Mage(int health, Square currentSquare, int team) throws healthException {
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
		return "mage";
		}
}

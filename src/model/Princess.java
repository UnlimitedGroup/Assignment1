package model;

import exceptions.healthException;

public class Princess extends Piece {

	public Princess(int health, Square currentSquare, int team) throws healthException {
		super(health, currentSquare, team);
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
	@Override
	public void spell() {
	
	}
    */
	
	//Princess can't move
	@Override
	public boolean movePreModifier(int row, int column) {
		return false;
	}
	@Override
	public boolean move(int row, int column) {
		return false;
		}
	}


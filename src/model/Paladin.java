package model;

public class Paladin extends Piece {

	public Paladin(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
	}

	@Override
	public boolean spell() {	
		return false;
	}

}

package model;

public class Paladin extends Piece {

	public Paladin(int health, Square currentSquare, String team) {
		super(health, currentSquare, team);
	}

	@Override
	public boolean spell() {	
		return false;
	}

}

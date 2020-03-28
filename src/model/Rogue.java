package model;

public class Rogue extends Piece {

	public Rogue(int health, Square currentSquare, String team) {
		super(health, currentSquare, team);
	}

	@Override
	public boolean spell() {
		return false;
	}

}

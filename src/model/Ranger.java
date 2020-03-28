package model;

public class Ranger extends Piece {

	public Ranger(int health, Square currentSquare, String team) {
		super(health, currentSquare, team);
	}

	@Override
	public boolean spell() {
		return false;
	}

}

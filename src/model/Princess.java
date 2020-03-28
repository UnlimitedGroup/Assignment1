package model;

public class Princess extends Piece {

	public Princess(int health, Square currentSquare, String team) {
		super(health, currentSquare, team);
	}

	@Override
	public boolean spell() {
		return false;
	}

}

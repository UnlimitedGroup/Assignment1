package model;

public class Mage extends Piece {

	public Mage(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
		
	}

	@Override
	public boolean spell() {
		return false;
	}

}

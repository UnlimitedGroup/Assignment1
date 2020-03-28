package model;

public class Healer extends Piece{

	public Healer(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
		
	}

	@Override
	public boolean spell() {
		return false;
	}

}

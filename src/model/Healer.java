package model;

public class Healer extends Piece{

	public Healer(int health, Square currentSquare, String team) {
		super(health, currentSquare, team);
		
	}

	@Override
	public boolean spell() {
		return false;
	}

}

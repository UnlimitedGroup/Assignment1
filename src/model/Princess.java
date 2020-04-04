package model;

public class Princess extends Piece {

	public Princess(int health, Square currentSquare, int team) {
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
	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		return false;
	}

}

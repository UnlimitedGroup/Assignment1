package model;

public class Player {
	private int team;
	private boolean turn;
	
	//exceptions done later
	public Player(int team, boolean turn) throws teamException {
		if (team == 0 || team == 1) {
			this.team = team;
		}else{
		 throw new teamException();
		}
		this.turn = turn;
	}
	
	public int getTeam() {
		return this.team;
	}
	public boolean getTurn() {
		return this.turn;
	}
	
	public void setTurn (boolean turn) {
		this.turn = turn;
	}
	
	
}
	

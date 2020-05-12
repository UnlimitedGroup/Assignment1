package model;

public class Player {
	private int team;
	private boolean turn;
	
	public Player(int team, boolean turn)  {
		this.team = team;
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
	

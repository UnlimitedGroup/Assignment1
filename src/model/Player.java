package model;

import exceptions.teamException;

public class Player {
	private int team;
	private boolean turn;
	
	public Player(int team, boolean turn) throws teamException {
		if (checkTeamPremodifer(team)) {
			this.team = team;
		}else{
		 throw new teamException();
		}
		this.turn = turn;
	}
	
	public boolean checkTeamPremodifer(int team) {
		if (team == 0 || team == 1) {
			return true;
		}
		return false;
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
	

package model;

public class Player {
	private int team;
	private boolean turn;
	private int undoTokens;
	private int moveTokens;
	
	public Player(int team, boolean turn, int undoTokens, int moveTokens)  {
		this.team = team;
		this.turn = turn;
		this.undoTokens = undoTokens;
		this.moveTokens = moveTokens;
	}
	
	public int getTeam() {
		return this.team;
	}
	public boolean getTurn() {
		return this.turn;
	}
	public int getUndoTokens() {
		return this.undoTokens;
	}
	public int getMoveTokens() {
		return this.moveTokens;
	}
	public void removeUndoToken() {
		if (this.undoTokens > 0) {
			this.undoTokens = this.undoTokens - 1;
		}
		else {
			this.undoTokens = 0;
		}
	}
	public void removeMoveToken() {
		if (this.moveTokens > 0) {
			this.moveTokens = this.moveTokens - 1;
		}
		else {
			this.moveTokens = 0;
		}
	}
	public void restoreMoveTokens() {
		this.moveTokens = 2;
	}
	public void setTurn (boolean turn) {
		this.turn = turn;
	}
}
	

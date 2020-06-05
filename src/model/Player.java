package model;
import com.google.java.contract.*;

@Invariant({
	"team == 1 || team  == 0",
	"undoTokens <= 2 && undoTokens >=0",
	"moveTokens <= 2 && moveTokens >=0"})
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
	@Ensures("team == 0 || team == 1")
	public int getTeam() {
		return this.team;
	}
	public boolean getTurn() {
		return this.turn;
	}
	@Ensures("undoTokens <= 2 && undoTokens >=0")
	public int getUndoTokens() {
		return this.undoTokens;
	}
	@Ensures("moveTokens <= 2 && moveTokens >=0")
	public int getMoveTokens() {
		return this.moveTokens;
	}
	@Requires("undoTokens <= 2 && undoTokens >=0")
	@Ensures("undoTokens <= 2 && undoTokens >=0")
	public void removeUndoToken() {
		if (this.undoTokens > 0) {
			this.undoTokens = this.undoTokens - 1;
		}
		else {
			this.undoTokens = 0;
		}
	}
	@Requires("moveTokens <= 2 && moveTokens >=0")
	@Ensures("moveTokens <= 2 && moveTokens >=0")
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
	

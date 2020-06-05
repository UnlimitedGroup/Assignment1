package model;

import java.util.ArrayList;

import com.google.java.contract.*;

@Invariant({
	"health <= 100 && health >= 0",
	"team == 0 || team == 1"})
public abstract class Piece {
	
	private int health;
	private Square currentSquare;
	private int team; 
	
	public Piece(int health, Square currentSquare, int team) {
		this.currentSquare = currentSquare;
		this.team = team;
		this.health = health;
	}
	@Ensures("health <= 100")
	public int getHealth() {
		return this.health;
	}
	public Square getCurrentSquare() {
		return this.currentSquare;
	}
	@Ensures("team == 0 || team == 1")
	public int getTeam() {
		return this.team;
	}
	@Requires("health >= 0 && health <= 100")
	@Ensures("health >= 0 && health <= 100")
	public void setHealth(int health) {
		this.health = health;
	}
	public void setCurrentSquare(Square newSquare) {
		this.currentSquare = newSquare;
	}
	@Requires("damage >= 0 && damage <= 100")
	@Ensures("health >= 0 && health <= 100")
	public void decreaseHealth (int damage) {
		if (this.health - damage > 0) {
			this.health = this.health - damage;
		}
		else
			this.health = 0;
	}
	@Requires("health >= 0 && health <= 100")
	@Ensures("health >= 0 && health <= 100")
	public void increaseHealth(int heal) {
		if (this.health + heal < 100) {
			this.health = this.health + heal;
		}
		else {
			this.health = 100;
		}
	}
    abstract public boolean move(int row, int column);
    public boolean spell() {
    	this.AreaOfEffectDamage();
    	this.HealPrincess();
    	if (this.castSpell(this.prepareSpell())) {
    		return true;
    	}
    return false;
    }
    public void AreaOfEffectDamage() {
    	for (Piece i: Board.pieceSet) {
    		i.decreaseHealth(5);
    	}
    }
    public void HealPrincess() {
    	for (Piece j: Board.pieceSet) {
    		if (j instanceof Princess) {
    			j.increaseHealth(15);
    		}
    	}
    }
    abstract public ArrayList<Square> prepareSpell();
    abstract public boolean castSpell(ArrayList<Square> targetSquares);
}
 



package model;

import java.util.ArrayList;

public abstract class Piece {
	
	private int health;
	private Square currentSquare;
	private int team; 

	public Piece(int health, Square currentSquare, int team) {
		this.currentSquare = currentSquare;
		this.team = team;
		this.health = health;
	}
	
	//Gets
	public int getHealth() {
		return this.health;
	}
	public Square getCurrentSquare() {
		return this.currentSquare;
	}	
	public int getTeam() {
		return this.team;
	}
	//Sets
	public void setHealth(int health) {
		this.health = health;
	}
	public void setCurrentSquare(Square newSquare) {
		this.currentSquare = newSquare;
	}
	//Action
	public void decreaseHealth (int damage) {
		if (this.health - damage > 0) {
			this.health = this.health - damage;
		}
		else
			this.health = 0;
	}
	public void increaseHealth(int heal) {
		if (this.health + heal < 100) {
			this.health = this.health + heal;
		}
		else {
			this.health = 100;
		}
	}
    abstract public boolean move(int row, int column);
    /*
     * Template behavioral pattern - used to eliminate code duplication of AreaOfEffect() and HealPrincess() code 
     * and improves extensibility for adding additional pieces in the future.
    */
    public boolean spell() {
    	this.AreaOfEffectDamage();
    	this.HealPrincess();
    	if (this.castSpell(this.prepareSpell())) {
    		return true;
    	}
    return false;
    }
    /*
     * Steps for template pattern
     * 
     * Step 1: AreaOfEffect() method: damages ALL units for 5 damage after every spell, this functions as a 
     * 		   "closing blue circle" like that you would find in a Battle Royale game. It is used to 
     *         speed up games and prevent continual healing which would result in a endless game
     * Step 2: HealPrincess() method: after each spell BOTH princesses are healed 15 health, this mechanic 
     *         prevents users from "rushing" the enemy princess and instead encourages combat amongst other units
     * Step 3: Abstract prepareSpell(): returns the units that the spell will affect, different units can attack
     *         at different ranges, thus this method is overridden in subclasses
     * Step 4: Abstract castSpell(): defines the spell as a healing or damaging spell and executes it, calls 
     *         prepareSpell();
     */
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
 



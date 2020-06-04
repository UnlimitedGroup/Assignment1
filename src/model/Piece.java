package model;

import java.util.ArrayList;

public abstract class Piece {
	
	private int health;
	private Square currentSquare;
	private int team; 
	/**
	 * Super class for all pieces
	 * @param health
	 * @param currentSquare
	 * @param team
	 */
	public Piece(int health, Square currentSquare, int team) {
		this.currentSquare = currentSquare;
		this.team = team;
		this.health = health;
	}
	/**
	 * @return Return unit health
	 */
	public int getHealth() {
		return this.health;
	}
	/**
	 * Return units current square position
	 * @return
	 */
	public Square getCurrentSquare() {
		return this.currentSquare;
	}
	/**
	 * Return units team
	 * @return
	 */
	public int getTeam() {
		return this.team;
	}
	/**
	 * Set a units health 
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	/**
	 * Set a units currentSquare
	 * @param newSquare
	 */
	public void setCurrentSquare(Square newSquare) {
		this.currentSquare = newSquare;
	}
	/**
	 * Decrease a units health, cannot fall below 0
	 * @param damage
	 */
	public void decreaseHealth (int damage) {
		if (this.health - damage > 0) {
			this.health = this.health - damage;
		}
		else
			this.health = 0;
	}
	/**
	 * Increase a units health, health cannot exceed 100
	 * @param heal
	 */
	public void increaseHealth(int heal) {
		if (this.health + heal < 100) {
			this.health = this.health + heal;
		}
		else {
			this.health = 100;
		}
	}
	/**
	 * Abstract move method to be overridden in subclasses to allow pieces to move
	 * @param row
	 * @param column 
	 */
    abstract public boolean move(int row, int column);
    /**
     * Piece can cast a spell, beginning of template method
     * @return a boolean, all pieces except princess return true, as princess cannot cast a spell
     */
    public boolean spell() {
    	this.AreaOfEffectDamage();
    	this.HealPrincess();
    	if (this.castSpell(this.prepareSpell())) {
    		return true;
    	}
    return false;
    }
    /**
     * Damages all units after every spell to reduce game duration
     */
    public void AreaOfEffectDamage() {
    	for (Piece i: Board.pieceSet) {
    		i.decreaseHealth(5);
    	}
    }
    /**
     * Heals the princess each round to eliminate rushing
     */
    public void HealPrincess() {
    	for (Piece j: Board.pieceSet) {
    		if (j instanceof Princess) {
    			j.increaseHealth(15);
    		}
    	}
    }
    /**
     * Fetches squares that the units spell with affect, overridden in piece subclasses 
     * @return a list of target squares
     */
    abstract public ArrayList<Square> prepareSpell();
    /**
     * Executes the affect of the spell
     * @param targetSquares, passed from prepareSpell()
     * @return a boolean indicating if the spell can be cast
     */
    abstract public boolean castSpell(ArrayList<Square> targetSquares);
}
 



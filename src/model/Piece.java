package model;

import exceptions.healthException;

public abstract class Piece {
	
	private int health;
	private Square currentSquare;
	private int team; 

	public Piece(Square currentSquare, int team) {
		this.currentSquare = currentSquare;
		this.team = team;
	}
	
	//Gets
	abstract public int getHealth();
	public Square getCurrentSquare() {
		return this.currentSquare;
	}	
	public int getTeam() {
		return this.team;
	}
	//Sets
	abstract public void setHealth(int health) throws healthException;
	public void setCurrentSquare(Square newSquare) {
		this.currentSquare = newSquare;
	}
	//Action
	public void takeDamage (int damage) {
		this.health = this.health - damage;
	}
	abstract public void heal(int heal);
    abstract public boolean move(int row, int column);
    //Premodifiers
    abstract public boolean healthPreModifier(int health);
    abstract public boolean movePreModifier(int row, int column);
}




package model;

public abstract class Piece {
	
	private int health;
	private Square currentSquare;
	private int team; 

	public Piece(Square currentSquare, int team, int health) {
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
	public void takeDamage (int damage) {
		this.health = this.health - damage;
	}
	public void heal(int heal) {
		//to do
	}
    abstract public boolean move(int row, int column);
}




package model;

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
    abstract public boolean spell();
}
 



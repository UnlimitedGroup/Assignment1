package model;

public abstract class Piece {
	
	private int health;
	private Square currentSquare;
	private String team;

	
	public Piece(int health, Square currentSquare, String team) {
		this.health = health;
		this.currentSquare = currentSquare;
		this.team = team;
	}
	public int getHealth() {
		return this.health;
	}
	public Square getCurrentSquare() {
		return this.currentSquare;
	}
	public String getTeam() {
		return this.team;
	}
	//Set
	public void setCurrentSquare(Square newSquare) {
		this.currentSquare = newSquare;
	}
	//Action
	public void takeDamage (int damage) {
		this.health = this.health - damage;
	}
    abstract public boolean spell();
}




package model;

public abstract class Piece {
	
	private int health;
	private Square currentSquare;
	private int team;

	
	public Piece(int health, Square currentSquare, int team) {
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
	public int getTeam() {
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
	public void heal(int heal) {
		int newHealth = this.getHealth() + heal;
			if (newHealth > 100) {
				newHealth = 100;
				this.health = newHealth;
			}
			else {
				this.health = this.health + heal;
			}
	}
    abstract public void spell();
}




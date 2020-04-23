package model;

public abstract class Piece {
	
	private int health;
	private Square currentSquare;
	private int team;
	private final int maxHealth = 100; 

	public Piece(int health, Square currentSquare, int team) throws healthException {
		if (healthPreModifier(health)) {
			this.health = health;
		}
		else {
			throw new healthException();
		}
		this.currentSquare = currentSquare;
		this.team = team;
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
	public boolean moveCheck() {
		return true;
	}
    abstract public boolean move(int row, int column);
    
    //Premodifiers
    public boolean healthPreModifier(int health) {
    	if (health <= maxHealth) {
    		return true;
    	}
    	return false;
    }
}




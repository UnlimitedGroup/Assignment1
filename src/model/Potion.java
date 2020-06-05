package model;

public interface Potion {
	
	abstract public Square getCurrentSquare();
	abstract public int getHealAmount();
	abstract public void drinkPotion(Piece i);
	abstract public int getStatus();
	abstract public void setStatus(int s);
}

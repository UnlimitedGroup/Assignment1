package model;

public interface Potion {
	/**
	 * @return current Square of potion, overridden in subclass
	 */
	abstract public Square getCurrentSquare();
	/**
	 * @return heal amount of potion, overridden in subclass
	 */
	abstract public int getHealAmount();
	/**
	 * Consume potion, activating its effect
	 * @param i
	 */
	abstract public void drinkPotion(Piece i);
	/**
	 * @return return whether potion has been consumed, 0 is depleted, 1 is active
	 */
	abstract public int getStatus();
	/**
	 * Sets a potions status to depleted or active, 1 or 0 respectively
	 * @param s
	 */
	abstract public void setStatus(int s);
}

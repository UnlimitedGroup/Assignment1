package model;

abstract public class PotionDecorator implements Potion {
	protected Potion wrappee;
	
	/**
	 * Build the potion decorator
	 * @param source
	 */
	public PotionDecorator(Potion source) {
		this.wrappee = source;
	}
	/**
	 * @return current square of wrapped potion
	 */
	@Override
	public Square getCurrentSquare() {
		return wrappee.getCurrentSquare();
	}
	/**
	 * @return heal amount of wrapped potion
	 */
	@Override
	public int getHealAmount() {
		return wrappee.getHealAmount();
	}
	/**
	 * Consume wrapped potion
	 */
	@Override
	public void drinkPotion(Piece i) {
		wrappee.drinkPotion(i);
	}
	/**
	 * Get status of wrapped potion, 0 is depleted, 1 is active
	 */
	@Override
	public int getStatus() {
		return wrappee.getStatus();
	}
	/**
	 * Set status of wrapped potion, 0 is depleted, 1 is active
	 */
	@Override
	public void setStatus(int s) {
		wrappee.setStatus(s);
	}
}

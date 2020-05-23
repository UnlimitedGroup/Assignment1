package model;

abstract public class PotionDecorator implements Potion {
	protected Potion wrappee;
	
	public PotionDecorator(Potion source) {
		this.wrappee = source;
	}
	@Override
	public Square getCurrentSquare() {
		return wrappee.getCurrentSquare();
	}
	@Override
	public int getHealAmount() {
		return wrappee.getHealAmount();
	}
	@Override
	public void drinkPotion(Piece i) {
		wrappee.drinkPotion(i);
	}
	@Override
	public int getStatus() {
		return wrappee.getStatus();
	}
	@Override
	public void setStatus(int s) {
		wrappee.setStatus(s);
	}
}

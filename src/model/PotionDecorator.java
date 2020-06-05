package model;
import com.google.java.contract.*;

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
	@Ensures("wrappee.getStatus == 0 || wrappee.getStatus == 1")
	public int getStatus() {
		return wrappee.getStatus();
	}
	@Override
	@Requires("wrappee.getStatus == 0 || wrappee.getStatus == 1")
	@Ensures("wrappee.getStatus == 0 || wrappee.getStatus == 1")
	public void setStatus(int s) {
		wrappee.setStatus(s);
	}
}

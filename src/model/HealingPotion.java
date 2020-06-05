package model;
import com.google.java.contract.*;

@Invariant({
	"healAmount <= 100",
	"status == 0 || status == 1"})
public class HealingPotion implements Potion {

	final private int healAmount;
	private Square currentSquare;
	private int status;
	
	public HealingPotion(Square currentSquare, int s) {
		this.healAmount = 25;
		this.currentSquare = currentSquare;
		this.status = s;	
	}
	
	@Override
	public Square getCurrentSquare() {
		return this.currentSquare;
	}
	@Override
	public int getHealAmount() {
		return this.healAmount;
	}
	@Override
	public int getStatus() {
		return this.status;
	}
	@Override
	@Requires("s == 0 || s == 1")
	@Ensures("s == 0 || s == 1")
	public void setStatus(int s) {
		this.status = s;
	}
	@Override
	@Requires("i != null")
	public void drinkPotion(Piece i) {
		i.increaseHealth(50);
		this.setStatus(0);
		System.out.println(i + "just drank" + this.toString());
		System.out.println(i.getHealth());
		}
	
	public String toString() {
		return "healing potion";
	}
}



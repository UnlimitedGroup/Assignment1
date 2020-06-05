package model;

import com.google.java.contract.*;

public class DestructionDecorator extends PotionDecorator {

	public DestructionDecorator(Potion source) {
		super(source);
	}
	@Requires("i != null")
	@Override
	public void drinkPotion(Piece i) {
		wrappee.drinkPotion(i);
		for (Piece j: Board.pieceSet) {
			j.decreaseHealth(10);
		}
	}
	
	public String toString() {
		return "destruction potion";
	}

}

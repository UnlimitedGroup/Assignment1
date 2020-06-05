package model;

import com.google.java.contract.*;

public class MajorHealDecorator extends PotionDecorator {

	public MajorHealDecorator(Potion source) {
		super(source);
	}
	@Requires("i != null")
	@Override
	public void drinkPotion(Piece i) {
		wrappee.drinkPotion(i);
		for (Piece j: Board.pieceSet) {
			if (j.getTeam() == 1 && i.getTeam() == 1) {
				if (j.toString() == "princess1") {
					j.increaseHealth(100);
				}
			}
			if (j.getTeam() == 0 && i.getTeam() == 0) {
				if (j.toString() == "princess2") {
					j.increaseHealth(100);
				}
			}
			
		}
	}
	
	public String toString() {
		return "major";
	}

}

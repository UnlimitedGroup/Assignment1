package model;

public class DestructionDecorator extends PotionDecorator {

	public DestructionDecorator(Potion source) {
		super(source);
	}
	@Override
	public void drinkPotion(Piece i) {
		wrappee.drinkPotion(i);
		//Additional functionality/decoration, damage all units for 10hp
		for (Piece j: Board.pieceSet) {
			j.decreaseHealth(10);
		}
		System.out.println(i + "just drank" + this.toString());
		System.out.println(i.getHealth());
	}
	
	public String toString() {
		return "destruction potion";
	}

}

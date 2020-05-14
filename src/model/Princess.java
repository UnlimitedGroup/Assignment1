package model;

public class Princess extends Piece {

	//private final int maxHealth = 100;

	public Princess(int health, Square currentSquare, int team) {
		super(health, currentSquare, team);
	}
	
	private boolean moveCheck(int column, int row) {
		int currentRow = this.getCurrentSquare().getRow();
		int currentColumn = this.getCurrentSquare().getColumn();
		if (row == currentRow || row == currentRow + 1 || row == currentRow - 1) {
			if (column == currentColumn || column == currentColumn + 1 || column == currentColumn - 1 ) {
			return true;
			}
		}
		return false;
	}
	@Override
	public boolean move(int column, int row) {
		if (moveCheck(column, row)) {
			this.setCurrentSquare(Board.squares[column][row]);
				return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		if (this.getTeam() == 1) {
			return "princess1";
		}
		else {
			return "princess2";
		}
	}
	
	
	/*
	SPELL TEMPLATE CODE FOR PART 2
		}
	public void spell(amount) {
		int currentRow = this.getCurrentSquare().getRow();
		int currentColumn = this.ggetCurrentSquare().getColumn();
		Square SquareList[][] = Board.getSquareList();
		ArrayList<Piece> PieceList = Board.getPieceSet();
		
		//Check team
		if (this.getTeam() == 0) {
			for (int i=0; i<1;i++) {
				//Check if a piece in in the square infront square
				Square checkSquare = SquareList[currentRow++][currentColumn];
				for (int j = 0; j<PieceList.size()-1; j++) {
					//Check only pieces on other team and Check if the piece is in the spell path square
					if (PieceList.get(j).getTeam() != this.getTeam() && PieceList.get(j).getCurrentSquare() == checkSquare) {
							PieceList.get(j).takeDamage(amount)
							
							* The decorator
							* spell(amount) 
							*- i.e. damage all units for amount, then pass amount **THIS IS THE ADDITIONAL FUNCTIONALITY THE DECORATOR ADDS
							*- then piece.spell(amount)
							
							;
							
						
						}
					}
				}
			}
		}
		if (this.getTeam() == 1) {
			for (int i=0; i<1;i++) {
				Square checkSquare = SquareList[currentRow--][currentColumn];
				for (int j = 0; j<PieceList.size()-1; j++) {
					//Check only pieces on other team
					if (PieceList.get(j).getTeam() != this.getTeam()) {
						//Check if the piece is in the spell path square
						if (PieceList.get(j).getCurrentSquare() == checkSquare) {
							//Deal 25 Damage
							PieceList.get(j).takeDamage(75);
							
						}
					}
				}
			}
		}
	}
	*/

}


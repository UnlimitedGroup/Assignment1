package model;

public class BackupCommand extends Command {

	//Backs up current state of game
	@Override
	public void execute() {
		Piece piece = null;
		int row;
		int column;
		Square currentSquare;
		int health;
		
		for (Piece i: Board.pieceSet) {
			if (i.toString() == "power") {
				row = i.getCurrentSquare().getRow();
				column = i.getCurrentSquare().getColumn();
				currentSquare = Board.squares[row][column];
				health = i.getHealth();
				piece = new Power(health, currentSquare, 0);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "paladin") {
				row = i.getCurrentSquare().getRow();
				column = i.getCurrentSquare().getColumn();
				currentSquare = Board.squares[row][column];
				health = i.getHealth();
				piece = new Paladin(health, currentSquare, 0);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "mage") {
				row = i.getCurrentSquare().getRow();
				column = i.getCurrentSquare().getColumn();
				currentSquare = Board.squares[row][column];
				health = i.getHealth();
				piece = new Mage(health, currentSquare, 0);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "ranger") {
				row = i.getCurrentSquare().getRow();
				column = i.getCurrentSquare().getColumn();
				currentSquare = Board.squares[row][column];
				health = i.getHealth();
				piece = new Ranger(health, currentSquare, 1);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "healer") {
				row = i.getCurrentSquare().getRow();
				column = i.getCurrentSquare().getColumn();
				currentSquare = Board.squares[row][column];
				health = i.getHealth();
				piece = new Healer(health, currentSquare, 1);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "rogue") {
				row = i.getCurrentSquare().getRow();
				column = i.getCurrentSquare().getColumn();
				currentSquare = Board.squares[row][column];
				health = i.getHealth();
				piece = new Rogue(health, currentSquare, 1);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "princess1") {
				row = i.getCurrentSquare().getRow();
				column = i.getCurrentSquare().getColumn();
				currentSquare = Board.squares[row][column];
				health = i.getHealth();
				piece = new Princess(health, currentSquare, 1);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "princess2") {
				row = i.getCurrentSquare().getRow();
				column = i.getCurrentSquare().getColumn();
				currentSquare = Board.squares[row][column];
				health = i.getHealth();
				piece = new Princess(health, currentSquare, 0);
				this.getPieceSet().add(piece);
			}
			
			//TO DO: REFACTOR TO THIS TO AVOID DUPLICATE CODE - USE REFLECTION
			/*
				row = i.getCurrentSquare().getRow();
				column = i.getCurrentSquare().getColumn();
				currentSquare = Board.squares[row][column];
				health = i.getHealth();
				team = i.getTeam();
				Class cl = Class.forName(i.toString());
				Constructor con = cl.getConstructor(int.class, Square.class, int.class);
				piece = (Piece) con.newInstance(health, currentSquare, team);
				this.getPieceSet().add(piece);
			*/
		}
	}
}

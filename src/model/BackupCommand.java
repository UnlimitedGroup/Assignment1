package model;

public class BackupCommand extends Command {

	@Override
	public void execute() {
		Piece piece = null;
		int row;
		int column;
		Square currentSquare;
		int health;
		
		for (Piece i: Board.pieceSet) {
			if (i.toString() == "power") {
				if (i.getCurrentSquare() != null) {
					row = i.getCurrentSquare().getRow();
					column = i.getCurrentSquare().getColumn();
					currentSquare = Board.squares[row][column];
				}
				else {
					currentSquare = null;
				}
				health = i.getHealth();
				piece = new Power(health, currentSquare, 0);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "paladin") {
				if (i.getCurrentSquare() != null) {
					row = i.getCurrentSquare().getRow();
					column = i.getCurrentSquare().getColumn();
					currentSquare = Board.squares[row][column];
				}
				else {
					currentSquare = null;
				}
				health = i.getHealth();
				piece = new Paladin(health, currentSquare, 0);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "mage") {
				if (i.getCurrentSquare() != null) {
					row = i.getCurrentSquare().getRow();
					column = i.getCurrentSquare().getColumn();
					currentSquare = Board.squares[row][column];
				}
				else {
					currentSquare = null;
				}
				health = i.getHealth();
				piece = new Mage(health, currentSquare, 0);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "ranger") {
				if (i.getCurrentSquare() != null) {
					row = i.getCurrentSquare().getRow();
					column = i.getCurrentSquare().getColumn();
					currentSquare = Board.squares[row][column];
				}
				else {
					currentSquare = null;
				}
				health = i.getHealth();
				piece = new Ranger(health, currentSquare, 1);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "healer") {
				if (i.getCurrentSquare() != null) {
					row = i.getCurrentSquare().getRow();
					column = i.getCurrentSquare().getColumn();
					currentSquare = Board.squares[row][column];
				}
				else {
					currentSquare = null;
				}
				health = i.getHealth();
				piece = new Healer(health, currentSquare, 1);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "rogue") {
				if (i.getCurrentSquare() != null) {
					row = i.getCurrentSquare().getRow();
					column = i.getCurrentSquare().getColumn();
					currentSquare = Board.squares[row][column];
				}
				else {
					currentSquare = null;
				}
				health = i.getHealth();
				piece = new Rogue(health, currentSquare, 1);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "princess1") {
				if (i.getCurrentSquare() != null) {
					row = i.getCurrentSquare().getRow();
					column = i.getCurrentSquare().getColumn();
					currentSquare = Board.squares[row][column];
				}
				else {
					currentSquare = null;
				}
				health = i.getHealth();
				piece = new Princess(health, currentSquare, 1);
				this.getPieceSet().add(piece);
			}
			if (i.toString() == "princess2") {
				if (i.getCurrentSquare() != null) {
					row = i.getCurrentSquare().getRow();
					column = i.getCurrentSquare().getColumn();
					currentSquare = Board.squares[row][column];
				}
				else {
					currentSquare = null;
				}
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

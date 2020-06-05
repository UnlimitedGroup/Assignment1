package model;
import java.util.ArrayList;

abstract public class Command {
	private ArrayList<Piece> pieceSetBackup = new ArrayList<Piece>();
	
	public void undo() {
		Board.undoMove(this.pieceSetBackup);
	}
	public ArrayList<Piece> getPieceSet() {
		return this.pieceSetBackup;
	}
	abstract public void execute();
}

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
	public void setPieces(ArrayList<Piece> pieceSet) {
		this.pieceSetBackup = pieceSet;
		
	}
	abstract public void execute();
}

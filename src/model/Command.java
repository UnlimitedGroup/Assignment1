package model;
import java.util.ArrayList;

abstract public class Command {
	private ArrayList<Piece> pieceSetBackup = new ArrayList<Piece>();
	/**
	 * Undos a command
	 */
	public void undo() {
		Board.undoMove(this.pieceSetBackup);
	}
	/**
	 * @return the command objects pieceSet
	 */
	public ArrayList<Piece> getPieceSet() {
		return this.pieceSetBackup;
	}
	/**
	 * updates the command objects pieceSet
	 * @param pieceSet
	 */
	public void setPieces(ArrayList<Piece> pieceSet) {
		this.pieceSetBackup = pieceSet;	
	}
	/**
	 * Execute the command, overridden in subclasses
	 */
	abstract public void execute();
}

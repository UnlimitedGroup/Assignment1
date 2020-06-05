package model;

import java.sql.SQLException;
import java.util.ArrayList;
import database.DatabaseController;
import exceptions.PieceInvalidName;
import exceptions.squareBoundsException;
import com.google.java.contract.*;

@Invariant({
	"Player.length == 2",
	"pieceSet.size <= 8",
	"obstacles.length == 2",
	"squares.length <= 7",
	"squares.length[0] <= 5"})
public class Board {
	public static Player[] Players = new Player[2];
	public static ArrayList<Piece> pieceSet = new ArrayList<Piece>();
	public static Obstacle[] obstacles = new Obstacle[2];
	public static ArrayList<Potion> potions = new ArrayList<Potion>();
	public static Square[][] squares = new Square[7][5];
	
	@Requires({"row <=7 && row >= 0", "column <= 5 && column >= 0",
			   "command == start || command == load || command || update"})
	public static void create(String command, int row, int column, Boolean Power, Boolean Paladin, Boolean Mage, Boolean Ranger, Boolean Healer, Boolean Rogue) throws  ClassNotFoundException, SQLException, squareBoundsException, PieceInvalidName {
		initializePlayers(command);
		initializeSquares(command, row, column);
		initializePieces(command, Power, Paladin, Mage, Ranger, Healer, Rogue);
		initializeObstacles(command);
		initializePotions(command);
	return;
	}
	private static void initializePlayers(String command) throws SQLException, ClassNotFoundException {
		DatabaseController db = DatabaseController.getInstance();
		if (command == "start") {
			db.insertUpdatePlayers("start");	
		}
		if (command == "load") {
			db.loadPlayers();
		}
		if (command == "update") {
			db.insertUpdatePlayers("update");
		}
	}
	private static void initializeSquares(String command,int rows, int columns) throws SQLException, ClassNotFoundException, squareBoundsException {
		DatabaseController db = DatabaseController.getInstance();
		if (command == "start") {
			db.loadBoard("start", rows, columns);
		}
		if (command == "load") {
			db.loadBoard("load", rows, columns);
		}
		if (command == "update") {
			db.insertBoard(rows, columns);
		}
	return;
	}
	private static void initializePieces(String command, Boolean Power, Boolean Paladin, Boolean Mage, Boolean Ranger, Boolean Healer, Boolean Rogue) throws SQLException, ClassNotFoundException, squareBoundsException, PieceInvalidName {
		DatabaseController db = DatabaseController.getInstance();
		if (command == "start") {
			db.insertUpdatePiece("start", Power, Paladin, Mage, Ranger, Healer, Rogue);	
		}
		if (command == "load") {
			db.loadPieces();
		}
		if (command == "update") {
			db.insertUpdatePiece("update", null, null, null, null, null, null);
		}
	}
	private static void initializeObstacles(String command) throws SQLException, ClassNotFoundException {
		DatabaseController db = DatabaseController.getInstance();
		if (command == "start") {
			db.insertUpdateObstacles("start");	
		}
		if (command == "load") {
			db.loadObstacles();
		}
		if (command == "update") {
			db.insertUpdateObstacles("update");
		}
	}
	private static void initializePotions(String command) throws SQLException, ClassNotFoundException, squareBoundsException {
		DatabaseController db = DatabaseController.getInstance();
		if (command == "start") {
			db.insertUpdatePotions("start");	
		}
		if (command == "load") {
			db.loadPotions();
		}
		if (command == "update") {
			db.insertUpdatePotions("update");
		}
	}
	@Requires("PiecesBackup != null")
	public static void undoMove(ArrayList<Piece> PiecesBackup) {		
		for (Piece i: PiecesBackup) {
			for (Piece j: pieceSet) {
				if (i.toString() == j.toString()) {
					j.setCurrentSquare(i.getCurrentSquare());
					j.setHealth(i.getHealth());
				}
			}
		}
	}
}











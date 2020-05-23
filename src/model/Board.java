package model;

import java.awt.event.ActionEvent;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import controller.MainController;
import database.DatabaseController;
import exceptions.PieceInvalidName;
import exceptions.squareBoundsException;
import view.Main;

public class Board {
	public static Player[] Players = new Player[2];
	public static ArrayList<Piece> pieceSet = new ArrayList<Piece>();
	public static Obstacle[] obstacles = new Obstacle[2];
	public static ArrayList<Potion> potions = new ArrayList<Potion>();
	public static Square[][] squares = new Square[7][5];
	
	public static void create(String command, int row, int column, Boolean Power, Boolean Paladin, Boolean Mage, Boolean Ranger, Boolean Healer, Boolean Rogue) throws  ClassNotFoundException, SQLException, squareBoundsException, PieceInvalidName {
		initializePlayers(command);
		initializeSquares(command, row, column);
		initializePieces(command, Power, Paladin, Mage, Ranger, Healer, Rogue);
		initializeObstacles(command);
		initializeHealingPotions();
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
	return;
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
	private static void initializeHealingPotions() {
		int counter = 4;
		int randomRowInitial = ThreadLocalRandom.current().nextInt(2, 4 + 1);
		int randomColumnInitial = ThreadLocalRandom.current().nextInt(2, 3 + 1);
		potions.add(new HealingPotion(Board.squares[randomRowInitial][randomColumnInitial], 1));
		
		for (int j = 0; j < counter; j++) {
			int randomRow = ThreadLocalRandom.current().nextInt(2, 4 + 1);
			int randomColumn = ThreadLocalRandom.current().nextInt(2, 3 + 1);
			int randomizer = ThreadLocalRandom.current().nextInt(1, 2 + 1);
			
			if (randomizer == 1) {
				if (randomRow != potions.get(potions.size()-1).getCurrentSquare().getRow() && randomColumn != potions.get(potions.size()-1).getCurrentSquare().getColumn()) {
					potions.add(new HealingPotion(Board.squares[randomRow][randomColumn], 1));
				}
			}
			else {
				if (randomRow != potions.get(potions.size()-1).getCurrentSquare().getRow() && randomColumn != potions.get(potions.size()-1).getCurrentSquare().getColumn()) {
					potions.add(new DestructionDecorator(new HealingPotion (Board.squares[randomRow][randomColumn], 1)));
				}
			}
		}
	}
}










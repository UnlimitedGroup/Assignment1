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
	public static Square[][] squares = new Square[7][5];
	
	public static void create(String command, int column, int row, Boolean Power, Boolean Paladin, Boolean Mage, Boolean Ranger, Boolean Healer, Boolean Rogue) throws  ClassNotFoundException, SQLException, squareBoundsException, PieceInvalidName {
		initializePlayers(command);
		initializeSquares(command, column, row);
		initializePieces(command, Power, Paladin, Mage, Ranger, Healer, Rogue);
		initializeObstacles();
	return;
	}
	private static void initializePlayers(String command) {
		if (command != "update") {
			Players[0] = new Player(0, true);
			Players[1] = new Player(1, false);
		}
	return;
	}
	private static void initializeSquares(String command,int columns, int rows) throws SQLException, ClassNotFoundException, squareBoundsException {
		DatabaseController db = DatabaseController.getInstance();
		if (command == "start") {
			db.insertBoard(columns, rows);	
			db.loadBoard();
		}
		if (command == "load") {
			db.loadBoard();
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
			db.insertUpdatePiece(command);
		}
	return;
	}
	private static void initializeObstacles() {
		
		Obstacle rock = new Rock();
		for (int j = 0; j <= 1; j++) {
			int randomRow = ThreadLocalRandom.current().nextInt(2, 4 + 1);
			int randomColumn = ThreadLocalRandom.current().nextInt(2, 3 + 1);
			obstacles[j] = rock.clone();
			obstacles[j].setCurrentSquare(Board.squares[randomRow][randomColumn]);
		}
		
		
	}
	
}










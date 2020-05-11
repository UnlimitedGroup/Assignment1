package model;

import java.sql.SQLException;
import java.util.ArrayList;

import database.DatabaseController;
import exceptions.PieceInvalidName;
import exceptions.healthException;
import exceptions.squareBoundsException;
import exceptions.teamException;

public class Board {
	public static Player[] Players = new Player[2];
	public static ArrayList<Piece> pieceSet = new ArrayList<Piece>();
	public static Square[][] squares = new Square[7][5];
	
	public static void create(String command, int row, int column) throws teamException, ClassNotFoundException, SQLException, squareBoundsException, healthException, PieceInvalidName {
		initializePlayers();
		initializeSquares(command, row, column);
		initializePieces(command);
	}
	
	private static void initializePlayers() throws teamException {
		Players[0] = new Player(0, true);
		Players[1] = new Player(1, false);
	}
	private static void initializeSquares(String command,int rows, int columns) throws SQLException, ClassNotFoundException, squareBoundsException {
		DatabaseController db = DatabaseController.getInstance();
		if (command == "start") {
			db.insertBoard(rows, columns);	
			db.loadBoard();
		}
		if (command == "load") {	
			db.loadBoard();
		}
	}
	private static void initializePieces(String command) throws SQLException, healthException, ClassNotFoundException, squareBoundsException, PieceInvalidName {
		DatabaseController db = DatabaseController.getInstance();
		if (command == "start") {
			db.insertUpdatePiece("insert");
		}
		if (command == "load") {
			db.loadPieces();
		}
		if (command == "save") {
		}
		
	}




}

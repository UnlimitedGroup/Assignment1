package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.MainController;
import database.DatabaseController;
import exceptions.PieceInvalidName;
import exceptions.squareBoundsException;
import view.Main;

public class Board {
	public static Player[] Players = new Player[2];
	public static ArrayList<Piece> pieceSet = new ArrayList<Piece>();
	public static Square[][] squares = new Square[7][5];
	
	public static void create(String command, int row, int column) throws  ClassNotFoundException, SQLException, squareBoundsException, PieceInvalidName {
		initializePlayers(command);
		initializeSquares(command, row, column);
		initializePieces(command);
	return;
	}
	private static void initializePlayers(String command) {
		if (command != "update") {
			Players[0] = new Player(0, true);
			Players[1] = new Player(1, false);
		}
	return;
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
	return;
	}
	private static void initializePieces(String command) throws SQLException, ClassNotFoundException, squareBoundsException, PieceInvalidName {
		DatabaseController db = DatabaseController.getInstance();
		if (command == "start") {
			db.insertUpdatePiece("start");	
		}
		if (command == "load") {
			db.loadPieces();
		}
		if (command == "update") {
			db.insertUpdatePiece(command);
		}
	return;
	}
	
}









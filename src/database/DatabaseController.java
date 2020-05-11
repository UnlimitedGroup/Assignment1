package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.*;
import exceptions.PieceInvalidName;
import exceptions.healthException;
import exceptions.squareBoundsException;
import model.Board;
import model.Healer;
import model.Mage;
import model.Paladin;
import model.Piece;
import model.Power;
import model.Princess;
import model.Ranger;
import model.Rogue;
import model.Square;

public class DatabaseController {
	private final String DB_NAME;
	private Connection con;
	private static DatabaseController instance;
	
	private DatabaseController() {
		DB_NAME = "game";
		try {
			con = ConnectionTest.getConnection(DB_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	synchronized public static DatabaseController getInstance() {
		if (DatabaseController.instance == null) { 
                DatabaseController.instance = new DatabaseController();
            }
    return DatabaseController.instance;	
	}
	
	//Prepare insert and update queries
	private String prepQueryBoard(int rows, int columns) {
		String boardName = "mainboard";
		int boardRows = rows;
		int boardColumns = columns;
		String query;
		
		query = "INSERT INTO BOARD  " +
				" ( BOARD_NAME, ROWS, COLUMNS)" +
				" " + "VALUES (" +
				"'" + boardName + "'," +
				"'" + boardRows + "'," +
				"'" + boardColumns +
				"')";
		
		return query;
	}
	private String prepQueryPiece(Piece piece, String action) {
		String pieceName = piece.toString();
		int pieceRow = piece.getCurrentSquare().getRow();
		int pieceColumn = piece.getCurrentSquare().getColumn();
		int pieceHealth = piece.getHealth();
		String query;
		
		if (action.equals("update")) {
			query = "UPDATE PIECES SET " +
					"ROW = " + pieceRow + "," +
					"COLUMN = '" + pieceColumn + "'," +
					"HEALTH = '" + pieceHealth + "'," +
					" WHERE PIECE_NAME = '" + pieceName + "'";
		} 
		else {
			query = "INSERT INTO PIECES " +
					" (PIECE_NAME, ROW, COLUMN, HEALTH)" +
					" " + "VALUES (" +
					"'" + pieceName + "'," +
					"'" + pieceRow + "'," +
					"'" + pieceColumn + "'," +
					"'" + pieceHealth + 
					"')";
		} 
		return query;
	}
	private Piece getPieceFromStmt(ResultSet result) throws healthException, SQLException, squareBoundsException, PieceInvalidName {
		Piece piece = null;
		Square currentSquare = null;
		String pieceName = result.getString("PIECE_NAME");
		int row = result.getInt("ROW");
		int column = result.getInt("COLUMN");
		int health = result.getInt("HEALTH");
	
		switch (pieceName.toLowerCase()) {
			case "power":
				currentSquare = new Square (row, column, false);
				piece = new Power(health, currentSquare, 0);
				return piece;
			case "paladin":
				currentSquare = new Square (row, column, false);
				piece = new Power(health, currentSquare, 0);
				return piece; 
			case "mage":
				currentSquare = new Square (row, column, false);
				piece = new Power(health, currentSquare, 0);
				return piece;
			case "ranger":
				currentSquare = new Square (row, column, false);
				piece = new Power(health, currentSquare, 1);
				return piece; 
			case "healer":
				currentSquare = new Square (row, column, false);
				piece = new Power(health, currentSquare, 1);
				return piece; 
			case "rogue":
				currentSquare = new Square (row, column, false);
				piece = new Power(health, currentSquare, 1);
				return piece; 
		}
		throw new PieceInvalidName();
	}
	
	//Committing Queries
	public void insertBoard(int rows, int columns) throws SQLException {
			Statement stmt = con.createStatement();
			//Clear previous board
			this.clearBoard(stmt);
			//Insert new board
			stmt.executeUpdate(prepQueryBoard(rows, columns));
			con.commit();
	}
	public void insertUpdatePiece(String action) throws SQLException, healthException {
			Statement stmt = con.createStatement();
			//If its an insert Query, pieces are initialized
			if (action != "update") {
				this.clearPieces(stmt);
				/*
				 * Pieces are always initialized in the same spots, these squares will always 
				 * exist due to minimum board size constraints
				 */
				Piece power = new Power(100, Board.squares[5][1], 0);
				Piece paladin = new Paladin(100, Board.squares[5][2], 0);
				Piece mage = new Mage(100, Board.squares[5][3], 0);
				Piece ranger = new Ranger(100, Board.squares[1][1], 1);
				Piece healer = new Healer(100, Board.squares[1][2], 1);
				Piece rogue = new Rogue(100, Board.squares[1][3], 1);
				Piece princess1 = new Princess(100, Board.squares[0][2], 1);
				Piece princess2 = new Princess(100, Board.squares[6][2], 0);
				Board.pieceSet.add(power);
				Board.pieceSet.add(paladin);
				Board.pieceSet.add(mage);
				Board.pieceSet.add(ranger);
				Board.pieceSet.add(healer);
				Board.pieceSet.add(rogue);
				Board.pieceSet.add(princess1);
				Board.pieceSet.add(princess2);
			}
			for (Piece p : Board.pieceSet) {
				String pieceQuery;
				pieceQuery = prepQueryPiece(p, action);
				stmt.executeUpdate(pieceQuery);
				con.commit();
			}
	}
	public void loadBoard() throws ClassNotFoundException, SQLException, squareBoundsException {
		Statement stmt;
		ResultSet result;

			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = ConnectionTest.getConnection(DB_NAME);
			stmt = con.createStatement();
			result = stmt.executeQuery(
					"SELECT * FROM BOARD");
			//There's only going to be one result
			while(result.next()){
				int rows = result.getInt("ROWS");
				int columns = result.getInt("COLUMNS");
				//Build board
				for (int i = 0; i <= rows; i++) {
			        for (int j = 0; j <= columns; j++) {
			        	Board.squares[i][j] = new Square(i,j, false);
			        }
				}
			}	
	}
	public void loadPieces() throws ClassNotFoundException, SQLException, healthException, squareBoundsException, PieceInvalidName {
		Statement stmt;
		ResultSet result;


			
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = ConnectionTest.getConnection(DB_NAME);
			stmt = con.createStatement();
			result = stmt.executeQuery(
					"SELECT * FROM PIECES");

			while(result.next()){		
				Piece piece = this.getPieceFromStmt(result);
				Board.pieceSet.add(piece);
			}
	}
	
	//Utility 
	private void clearBoard(Statement stmt) throws SQLException {
		String clearBoard = "DELETE FROM BOARD";
		stmt.executeUpdate(clearBoard);
	}
	private void clearPieces(Statement stmt) throws SQLException {
		String clearPieces = "DELETE FROM PIECES";
		stmt.executeUpdate(clearPieces);
	}
	

	
	
	
	
	
	
}

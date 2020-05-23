package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import database.*;
import exceptions.PieceInvalidName;
import exceptions.squareBoundsException;
import model.Board;
import model.Healer;
import model.Mage;
import model.Obstacle;
import model.Paladin;
import model.Piece;
import model.Player;
import model.Power;
import model.Princess;
import model.Ranger;
import model.Rock;
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
	private String prepQueryObstacle(Obstacle ob, int incrementor) {
		String obName = ob.toString() + incrementor;
		int obRow = ob.getCurrentSquare().getRow();
		int obColumn = ob.getCurrentSquare().getColumn();
		
		String query;
		
			query = "INSERT INTO OBSTACLE " +
					" (TYPE, ROW, COLUMN)" +
					" " + "VALUES (" +
					"'" + obName + "'," +
					"'" + obRow + "'," +
					"'" + obColumn + 
					"')";
		
		return query;
	}
	private String prepQueryPiece(Piece piece, String action) {
		String pieceName = piece.toString();
		int pieceRow = piece.getCurrentSquare().getRow();
		int pieceColumn = piece.getCurrentSquare().getColumn();
		int pieceHealth = piece.getHealth();
		String query;
		
		
		query = "INSERT INTO PIECES " +
				" (PIECE_NAME, ROW, COLUMN, HEALTH)" +
				" " + "VALUES (" +
				"'" + pieceName + "'," +
				"'" + pieceRow + "'," +
				"'" + pieceColumn + "'," +
				"'" + pieceHealth + 
				"')";
		
		return query;
	}
	private String prepQueryPlayer(Player p, String action) {
		int playerTeam = p.getTeam();
		boolean playerTurn = p.getTurn();
		int playerTurnInt;
		
		if (playerTurn) {
			playerTurnInt = 1;
		}
		else {
			playerTurnInt = 0;
		}
		String query;
		
		query = "INSERT INTO PLAYER " +
				" (TEAM, TURN)" +
				" " + "VALUES (" +
				"'" + playerTeam + "'," +
				"'" + playerTurnInt +  
				"')";
		return query;
	}
	private Piece getPieceFromStmt(ResultSet result) throws SQLException, squareBoundsException, PieceInvalidName {
		Piece piece = null;
		String pieceName = result.getString("PIECE_NAME");
		int row = result.getInt("ROW");
		int column = result.getInt("COLUMN");
		Square currentSquare = Board.squares[row][column];
		int health = result.getInt("HEALTH");
	
		switch (pieceName.toLowerCase()) {
			case "power":
				piece = new Power(health, currentSquare, 0);
				return piece;
			case "paladin":
				piece = new Paladin(health, currentSquare, 0);
				return piece; 
			case "mage":
				piece = new Mage(health, currentSquare, 0);
				return piece;
			case "ranger":
				piece = new Ranger(health, currentSquare, 1);
				return piece; 
			case "healer":
				piece = new Healer(health, currentSquare, 1);
				return piece; 
			case "rogue":
				piece = new Rogue(health, currentSquare, 1);
				return piece;
			case "princess1":
				piece = new Princess(health, currentSquare, 1);
				return piece;
			case "princess2":		
				piece = new Princess(health, currentSquare, 0);
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
	public void insertUpdatePiece(String action, Boolean Power, Boolean Paladin, Boolean Mage, Boolean Ranger, Boolean Healer, Boolean Rogue) throws SQLException {
		
		Statement stmt = con.createStatement();
		
		if (action == "start") {
			Board.pieceSet.clear();
			/*
			 * Pieces are always initialized in the same spots, these squares will always 
			* exist due to minimum board size constraints
			*/
			if (Power) {
				Piece power = new Power(100, Board.squares[5][1], 0);
				Board.pieceSet.add(power);
			}
			if (Paladin) {
				Piece paladin = new Paladin(100, Board.squares[5][2], 0);
				Board.pieceSet.add(paladin);
			}
			if (Mage) {
				Piece mage = new Mage(100, Board.squares[5][3], 0);
				Board.pieceSet.add(mage);
			}
			if (Ranger) {
				Piece ranger = new Ranger(100, Board.squares[1][1], 1);
				Board.pieceSet.add(ranger);
			}
			if (Healer) {
				Piece healer = new Healer(100, Board.squares[1][2], 1);
				Board.pieceSet.add(healer);
			}
			if (Rogue) {
				Piece rogue = new Rogue(100, Board.squares[1][3], 1);
				Board.pieceSet.add(rogue);
			}
			Piece princess1 = new Princess(100, Board.squares[0][2], 1);
			Piece princess2 = new Princess(100, Board.squares[6][2], 0);
			Board.pieceSet.add(princess1);
			Board.pieceSet.add(princess2);
		}
		
	if (action == "update") {
		clearPieces(stmt);
		for (Piece p : Board.pieceSet) {
			String pieceQuery;
			pieceQuery = prepQueryPiece(p, action);
			stmt.executeUpdate(pieceQuery);
			con.commit();
			}
		}
	}
	public void insertUpdateObstacles(String action) throws SQLException {
		Statement stmt = con.createStatement();
		
		if (action == "start") {
			Obstacle rock = new Rock();
			for (int j = 0; j <= 1; j++) {
				int randomRow = ThreadLocalRandom.current().nextInt(2, 4 + 1);
				int randomColumn = ThreadLocalRandom.current().nextInt(2, 3 + 1);
				Board.obstacles[j] = rock.clone();
				Board.obstacles[j].setCurrentSquare(Board.squares[randomRow][randomColumn]);
			}
		}
		if (action == "update") {
		clearObstacles(stmt);
			for (int i = 0; i<Board.obstacles.length; i++) {
				String obstacleQuery;
				obstacleQuery = prepQueryObstacle(Board.obstacles[i], i);
				stmt.executeUpdate(obstacleQuery);
				con.commit();
			}
		}
	}
	public void insertUpdatePlayers(String action) throws SQLException {
		Statement stmt = con.createStatement();
		//If its an insert Query, pieces are initialize
		if (action =="start") {
			Board.Players[0] = new Player(0, true);
			Board.Players[1] = new Player(1, false);
		}
		//Insert data into table
		if (action == "update") {
			clearPlayers(stmt);
			for (int i = 0; i<Board.Players.length; i++) {
				String playerQuery;
				playerQuery = prepQueryPlayer(Board.Players[i], action);
				stmt.executeUpdate(playerQuery);
				con.commit();
			}
		}
	}
	
	public void loadBoard(String command, int r, int c) throws ClassNotFoundException, SQLException, squareBoundsException {
		
		if (command == "start") {
			//Build large board
			if (c >= 4 && r >= 6) {
				for (int i = 0; i <= r; i++) {
			        for (int j = 0; j <= c; j++) {
			        	Board.squares[i][j] = new Square(i,j, false);
			        }
				}
			}
			//Build small board
			if (c < 4 && r < 6) {
				for (int i = 0; i <= 6; i++) {
			        for (int j = 0; j <= 4; j++) {
			        	if (j == 0 || j == 4) {
			        		Board.squares[i][j] = null;
			        	}
			        	else {
			        		Board.squares[i][j] = new Square(i,j, false);
			        	}
			        }
				}
			}
		}
		if (command == "load") {
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
				System.out.println("number" + result.getInt("ROWS"));
				System.out.println("number" + result.getInt("COLUMNS"));
				
				//Build large board
				if (columns >= 4 && rows >= 6) {
					for (int i = 0; i <= rows; i++) {
				        for (int j = 0; j <= columns; j++) {
				        	Board.squares[i][j] = new Square(i,j, false);
				        }
					}
				}
				//Build small board
				if (columns < 4 && rows < 6) {
					System.out.println("building small board");
					for (int i = 0; i <= 6; i++) {
				        for (int j = 0; j <= 4; j++) {
				        	if (j == 0 || j == 4) {
				        		Board.squares[i][j] = null;
				        	}
				        	else {
				        		Board.squares[i][j] = new Square(i,j, false);
				        	}
				        }
					}
				}
			} con.commit();
		}
	}
	public void loadPieces() throws ClassNotFoundException, SQLException, squareBoundsException, PieceInvalidName {
		Statement stmt;
		ResultSet result;
			
			Board.pieceSet.clear();
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = ConnectionTest.getConnection(DB_NAME);
			stmt = con.createStatement();
			result = stmt.executeQuery(
					"SELECT * FROM PIECES");

			while(result.next()){		
				Piece piece = getPieceFromStmt(result);
				Board.pieceSet.add(piece);
			}
			con.commit();
	}
	public void loadObstacles() throws ClassNotFoundException, SQLException {
		Statement stmt;
		ResultSet result;
			
		Obstacle rock = new Rock();
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		con = ConnectionTest.getConnection(DB_NAME);
		stmt = con.createStatement();
		result = stmt.executeQuery("SELECT * FROM OBSTACLE");
		int counter = 0;	
			
		while(result.next()){
			int row = result.getInt("ROW");
			int column = result.getInt("COLUMN");
			Board.obstacles[counter] = rock.clone();
			Board.obstacles[counter].setCurrentSquare(Board.squares[row][column]);
			counter++;
		}
		con.commit();
	}
	public void loadPlayers() throws ClassNotFoundException, SQLException {
		Statement stmt;
		ResultSet result;
			
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		con = ConnectionTest.getConnection(DB_NAME);
		stmt = con.createStatement();
		result = stmt.executeQuery("SELECT * FROM PLAYER");
		int counter = 0;	
			
		while(result.next()){
			int team = result.getInt("TEAM");
			int turn = result.getInt("TURN");
			boolean turnBool;
			if (turn == 1) {
				turnBool = true;
			}
			else 
				turnBool = false;
			Board.Players[counter] = new Player(team, turnBool);
			counter++;
		}
		con.commit();
	}

	//Utility 
	private void clearBoard(Statement stmt) throws SQLException {
		String clearBoard = "DELETE FROM BOARD";
		stmt.executeUpdate(clearBoard);
	}
	private void clearPieces(Statement stmt) throws SQLException {
		String clearPieces = "DELETE FROM PIECES";
		stmt.executeUpdate(clearPieces);
		con.commit();
	}
	private void clearPlayers(Statement stmt) throws SQLException {
		String clearPlayers = "DELETE FROM PLAYER";
		stmt.executeUpdate(clearPlayers);
		con.commit();
	}
	private void clearObstacles(Statement stmt) throws SQLException {
		String clearObstacles = "DELETE FROM OBSTACLE";
		stmt.executeUpdate(clearObstacles);
		con.commit();
	}
		
}

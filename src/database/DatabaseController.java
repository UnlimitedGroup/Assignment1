package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;
import controller.MainController;
import exceptions.PieceInvalidName;
import exceptions.squareBoundsException;
import model.BackupCommand;
import model.Board;
import model.Command;
import model.DestructionDecorator;
import model.Healer;
import model.HealingPotion;
import model.Mage;
import model.MajorHealDecorator;
import model.Obstacle;
import model.Paladin;
import model.Piece;
import model.Player;
import model.Potion;
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
		int pieceRow;
		int pieceColumn;
		
		if (piece.getCurrentSquare() == null) {
			pieceRow = -1;
			pieceColumn = -1;
		}
		else {
			pieceRow = piece.getCurrentSquare().getRow();
			pieceColumn = piece.getCurrentSquare().getColumn();
		}
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
		int undoTokens = p.getUndoTokens();
		int moveTokens = p.getMoveTokens();
		
		if (playerTurn) {
			playerTurnInt = 1;
		}
		else {
			playerTurnInt = 0;
		}
		String query;
		
		query = "INSERT INTO PLAYER " +
				" (TEAM, TURN, UNDOTOKENS, MOVETOKENS)" +
				" " + "VALUES (" +
				"'" + playerTeam + "'," +
				"'" + playerTurnInt + "'," +
				"'" + undoTokens + "'," +
				"'" + moveTokens +  
				"')";
		return query;
	}
	private Piece getPieceFromStmt(ResultSet result) throws SQLException, squareBoundsException, PieceInvalidName {
		Piece piece = null;
		String pieceName = result.getString("PIECE_NAME");
		int row = result.getInt("ROW");
		int column = result.getInt("COLUMN");
		Square currentSquare;
		if (row == -1 || column == -1) {
			currentSquare = null;
		}
		else {
			currentSquare = Board.squares[row][column];
		}
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
	private Potion getPotionFromStmt(ResultSet result) throws SQLException, squareBoundsException {
		Potion potion = null;
		String potionName = result.getString("ID");
		int row = result.getInt("ROW");
		int column = result.getInt("COLUMN");
		int status = result.getInt("STATUS");
		
		Square currentSquare = Board.squares[row][column];
	
			if (potionName.contains("healing")) {
				potion = new HealingPotion(currentSquare, status);
				return potion;
			}
			if (potionName.contains("destruction")) {
				potion = new DestructionDecorator(new HealingPotion (currentSquare, status)); 			
				return potion;
			}
			if (potionName.contains("major")) {
				potion = new MajorHealDecorator(new DestructionDecorator(new HealingPotion (currentSquare, status))); 			
				return potion;
			}
			else {
				return null;
			}
	}
	private String prepQueryPotion(Potion pot, int incrementor) {
		String potName = pot.toString() + incrementor;
		int potRow = pot.getCurrentSquare().getRow();
		int potColumn = pot.getCurrentSquare().getColumn();
		int potStatus = pot.getStatus();
		
		String query;
		
			query = "INSERT INTO POTION" +
					" (ID, ROW, COLUMN, STATUS)" +
					" " + "VALUES (" +
					"'" + potName + "'," +
					"'" + potRow + "'," +
					"'" + potColumn + "'," +
					"'" + potStatus + 
					"')";
		
		return query;
	}
	
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
    public void insertUpdateBackupCommand(Stack<Command> commandHistory) throws SQLException {
		
		Statement stmt = con.createStatement();	
		clearBackups(stmt);
		clearCommands(stmt);
		int counter = 0;
		for (Command c : commandHistory) {
			counter++;
			String commandName = c.toString();
			String query;
			
			query = "INSERT INTO COMMANDS " +
					" (COMMAND_ID, ROW_ID)" +
					" " + "VALUES (" +
					"'" + commandName + "'," +
					"'" + counter +
					"')";
			
			stmt.executeUpdate(query);
			con.commit();
		}
		int rowID = 0;
		for (Command c : commandHistory) {
			for (Piece i: c.getPieceSet()) {
				rowID++;
				if (i != null) {
				String pieceName = i.toString();
				int pieceRow = i.getCurrentSquare().getRow();
				int pieceColumn = i.getCurrentSquare().getColumn();
				int pieceHealth = i.getHealth();
				String query;
				
				query = "INSERT INTO BACKUP " +
						" (ROW_ID, COMMAND_ID, PIECE_NAME, ROW, COLUMN, HEALTH)" +
						" " + "VALUES (" +
						"'" + rowID + "'," +
						"'" + c.toString() + "'," +
						"'" + pieceName + "'," +
						"'" + pieceRow + "'," +
						"'" + pieceColumn + "'," +
						"'" + pieceHealth + 
						"')";
		
		stmt.executeUpdate(query);
		con.commit();
				}
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
			Board.Players[0] = new Player(0, true, 2, 2);
			Board.Players[1] = new Player(1, false, 2, 2);
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
	public void insertUpdatePotions(String action) throws SQLException {
		Statement stmt = con.createStatement();
		
		if (action == "start") {
			Board.potions.clear();
			int counter = 4;
			int randomRowInitial = ThreadLocalRandom.current().nextInt(2, 4 + 1);
			int randomColumnInitial = ThreadLocalRandom.current().nextInt(2, 3 + 1);
			Board.potions.add(new HealingPotion(Board.squares[randomRowInitial][randomColumnInitial], 1));
			
			for (int j = 0; j < counter; j++) {
				int randomRow = ThreadLocalRandom.current().nextInt(2, 4 + 1);
				int randomColumn = ThreadLocalRandom.current().nextInt(2, 3 + 1);
				int randomizer = ThreadLocalRandom.current().nextInt(1, 2 + 1);
				
				if (randomizer == 1) {
					if (randomRow != Board.potions.get(Board.potions.size()-1).getCurrentSquare().getRow() && randomColumn != Board.potions.get(Board.potions.size()-1).getCurrentSquare().getColumn()) {
						Board.potions.add(new HealingPotion(Board.squares[randomRow][randomColumn], 1));
					}
				}
				else {
					if (randomRow != Board.potions.get(Board.potions.size()-1).getCurrentSquare().getRow() && randomColumn != Board.potions.get(Board.potions.size()-1).getCurrentSquare().getColumn()) {
						Board.potions.add(new MajorHealDecorator(new MajorHealDecorator(new DestructionDecorator(new HealingPotion (Board.squares[randomRow][randomColumn], 1)))));
						
					}
				}
			}
		}
		if (action == "update") {
		clearPotions(stmt);
		int counter = 0;
			for (Potion i:Board.potions) {
				counter++;
				String potionQuery;
				potionQuery = prepQueryPotion(i, counter);
				stmt.executeUpdate(potionQuery);
				con.commit();
			}
		}
	}
	
	public void loadBoard(String command, int r, int c) throws ClassNotFoundException, SQLException, squareBoundsException {
		
		if (command == "start") {
			if (c >= 4 && r >= 6) {
				for (int i = 0; i <= r; i++) {
			        for (int j = 0; j <= c; j++) {
			        	Board.squares[i][j] = new Square(i,j, false);
			        }
				}
			}
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
			while(result.next()){
				int rows = result.getInt("ROWS");
				int columns = result.getInt("COLUMNS");
				System.out.println("number" + result.getInt("ROWS"));
				System.out.println("number" + result.getInt("COLUMNS"));
				
				if (columns >= 4 && rows >= 6) {
					for (int i = 0; i <= rows; i++) {
				        for (int j = 0; j <= columns; j++) {
				        	Board.squares[i][j] = new Square(i,j, false);
				        }
					}
				}
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
			int undoTokens = result.getInt("UNDOTOKENS");
			int moveTokens = result.getInt("MOVETOKENS");
			boolean turnBool;
			if (turn == 1) {
				turnBool = true;
			}
			else 
				turnBool = false;
			Board.Players[counter] = new Player(team, turnBool, undoTokens, moveTokens);
			counter++;
		}
		con.commit();
	}
	public void loadPotions() throws ClassNotFoundException, SQLException, squareBoundsException {
		Statement stmt;
		ResultSet result;
			
			Board.potions.clear();
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = ConnectionTest.getConnection(DB_NAME);
			stmt = con.createStatement();
			result = stmt.executeQuery(
					"SELECT * FROM POTION");

			while(result.next()){		
				Potion p = getPotionFromStmt(result);
				Board.potions.add(p);
			}
			con.commit();
	}
	public void loadBackupCommands() throws ClassNotFoundException, SQLException, squareBoundsException, PieceInvalidName {
		Statement stmt;
		ResultSet result1;
		ResultSet result2;
		MainController.commandHistory.empty();
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		con = ConnectionTest.getConnection(DB_NAME);
		stmt = con.createStatement();
		
		
		result1 = stmt.executeQuery(
				"SELECT * FROM COMMANDS ORDER BY ROW_ID");
		while(result1.next()){		
			Command command = new BackupCommand();
			MainController.commandHistory.push(command);
			
	    	result2 = stmt.executeQuery(
				"SELECT * FROM BACKUP WHERE COMMAND_ID='" + result1.getString("COMMAND_ID") + "'");
	    	while(result2.next()){
	    		Piece piece = null;
	    		String pieceName = result2.getString("PIECE_NAME");
	    		int row = result2.getInt("ROW");
	    		int column = result2.getInt("COLUMN");
	    		Square currentSquare = Board.squares[row][column];
	    		int health = result2.getInt("HEALTH");
	    	
	    		switch (pieceName.toLowerCase()) {
	    			case "power":
	    				piece = new Power(health, currentSquare, 0);
	    				command.getPieceSet().add(piece);
	    			case "paladin":
	    				piece = new Paladin(health, currentSquare, 0);
	    				command.getPieceSet().add(piece);
	    			case "mage":
	    				piece = new Mage(health, currentSquare, 0);
	    				command.getPieceSet().add(piece);
	    			case "ranger":
	    				piece = new Ranger(health, currentSquare, 1);
	    				command.getPieceSet().add(piece);
	    			case "healer":
	    				piece = new Healer(health, currentSquare, 1);
	    				command.getPieceSet().add(piece);
	    			case "rogue":
	    				piece = new Rogue(health, currentSquare, 1);
	    				command.getPieceSet().add(piece);
	    			case "princess1":
	    				piece = new Princess(health, currentSquare, 1);
	    				command.getPieceSet().add(piece);
	    			case "princess2":		
	    				piece = new Princess(health, currentSquare, 0);
	    				command.getPieceSet().add(piece);
	    		}
			}
	    	con.commit();
		}
		con.commit();
	}
	
	private void clearBoard(Statement stmt) throws SQLException {
		String clearBoard = "DELETE FROM BOARD";
		stmt.executeUpdate(clearBoard);
	}
	private void clearPieces(Statement stmt) throws SQLException {
		String clearPieces = "DELETE FROM PIECES";
		stmt.executeUpdate(clearPieces);
		con.commit();
	}
	private void clearBackups(Statement stmt) throws SQLException {
		String clearBackup = "DELETE FROM BACKUP";
		stmt.executeUpdate(clearBackup);
		con.commit();
	}
	private void clearCommands(Statement stmt) throws SQLException {
		String clearCommands = "DELETE FROM COMMANDS";
		stmt.executeUpdate(clearCommands);
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
	private void clearPotions(Statement stmt) throws SQLException {
		String clearPotions = "DELETE FROM POTION";
		stmt.executeUpdate(clearPotions);
		con.commit();
	}
		
}

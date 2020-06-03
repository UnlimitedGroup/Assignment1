package controller;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.ImageIcon;

import database.DatabaseController;
import exceptions.PieceInvalidName;
import exceptions.squareBoundsException;
import model.BackupCommand;
import model.Board;
import model.Command;
import model.CommandHistory;
import model.Obstacle;
import model.Piece;
import model.Player;
import model.Potion;
import model.Square;
import view.Main;

public class MainController {
	
	private static ImageIcon healer = new ImageIcon(Main.class.getResource("/imgs/healer.png"));
	private static ImageIcon mage = new ImageIcon(Main.class.getResource("/imgs/mage.png"));
	private static ImageIcon paladin = new ImageIcon(Main.class.getResource("/imgs/paladin.png"));
	private static ImageIcon power = new ImageIcon(Main.class.getResource("/imgs/power.png"));
	private static ImageIcon princess1 = new ImageIcon(Main.class.getResource("/imgs/princess1.png"));
	private static ImageIcon princess2 = new ImageIcon(Main.class.getResource("/imgs/princess2.png"));
	private static ImageIcon ranger = new ImageIcon(Main.class.getResource("/imgs/ranger.png"));
	private static ImageIcon rogue = new ImageIcon(Main.class.getResource("/imgs/rogue.png"));
	private static ImageIcon rock = new ImageIcon(Main.class.getResource("/imgs/rock.png"));
	private static ImageIcon destructionPotion = new ImageIcon(Main.class.getResource("/imgs/destructionPotion.png"));
	private static ImageIcon healingPotion = new ImageIcon(Main.class.getResource("/imgs/healingPotion.png"));
	private static Command command;
	public static CommandHistory commandHistory = new CommandHistory();
	
	//Commands
	public static void executeCommand(Command c) {
		c.execute();
		System.out.println(c);
		commandHistory.push(c);
	}
	public static void undo() {
		for (Player p: Board.Players) {
			if (p.getTurn()) {
				if (p.getUndoTokens() > 0) {
					command = commandHistory.pop();	
					p.removeUndoToken();
					if (command != null) {
						command.undo();
					}
				}
			}
		}
	}
	public static void loadCommands() throws ClassNotFoundException, SQLException, squareBoundsException, PieceInvalidName {
		DatabaseController db = DatabaseController.getInstance();
		db.loadBackupCommands();
	}
	public static void saveCommands() throws ClassNotFoundException, SQLException, squareBoundsException, PieceInvalidName {
		DatabaseController db = DatabaseController.getInstance();
		db.insertUpdateBackupCommand(commandHistory.getStack());
	}
	
	//utility
	public static String displayTurn() {
		if (Board.Players[0].getTurn()) {
			return "Player 1";
		}
		if (Board.Players[1].getTurn()) {
			return "Player 2";
		}
		return null;
	}
	public static String displayMoveTokens() {
		if (Board.Players[0].getTurn()) {
			return Integer.toString(Board.Players[0].getMoveTokens());
		}
		if (Board.Players[1].getTurn()) {
			return Integer.toString(Board.Players[1].getMoveTokens());
		}
		return null;
	}
	public static String displayUndoTokens() {
		if (Board.Players[0].getTurn()) {
			return Integer.toString(Board.Players[0].getUndoTokens());
		}
		if (Board.Players[1].getTurn()) {
			return Integer.toString(Board.Players[1].getUndoTokens());
		}
		return null;
	}
	public static String displayHealth(int row, int column) {
		for (Piece i: Board.pieceSet) {
			if (Board.squares[row][column] == i.getCurrentSquare()) {
				return Integer.toString(i.getHealth());
			}
		}
		return null;
	}
	public static ImageIcon displayImg(int row, int column) {
		for (Piece i: Board.pieceSet) {
			if(i.getCurrentSquare() == Board.squares[row][column]) {
				if(i.toString() == "healer" && i.getHealth() > 0) {
					return healer;
				}
				if(i.toString() == "mage" && i.getHealth() > 0) {
					return mage;
				}
				if(i.toString() == "paladin" && i.getHealth() > 0) {
					return paladin;
				}
				if(i.toString() == "power" && i.getHealth() > 0) {
					return power;
				}
				if(i.toString() == "princess1" && i.getHealth() > 0) {
					return princess1;
				}
				if(i.toString() == "princess2" && i.getHealth() > 0) {
					return princess2;
				}
				if(i.toString() == "rogue" && i.getHealth() > 0) {
					return rogue;
				}
				if(i.toString() == "ranger" && i.getHealth() > 0) {
					return ranger;
				}
			}	
		}
		for (int i = 0; i < Board.obstacles.length; i++) {
			if (Board.obstacles[i] != null) {
				if(Board.obstacles[i].getCurrentSquare() == Board.squares[row][column]) {
					if(Board.obstacles[i].toString() == "rock") {
						return rock;
					}
				}
			}
		}
		for (Potion i: Board.potions) {
			if (i != null) {
				if(i.getCurrentSquare() == Board.squares[row][column]) {
					if (i.getStatus() == 1) {
						if(i.toString() == "healing potion") {
							return healingPotion;
						}
						if(i.toString() == "destruction potion") {
							return destructionPotion;
						}
					}
				}
			}
		}
		return null;
	}
	public static void resetSquares() {
		for (int i = 0; i < Board.squares.length; i++) {
	        for (int j = 0; j < Board.squares[i].length; j++) {
	        	if (Board.squares[i][j] != null) {
		        	if (Board.squares[i][j].getSelectStatus() == true) {
		        		Board.squares[i][j].setSelectStatus(false);
		        	}
	        	}
	        }
		}
	}
	public static void drinkPotionCheck() {
		for (Piece i: Board.pieceSet) {
			for (Potion j: Board.potions) {
				if (i.getCurrentSquare() == j.getCurrentSquare()) {
					if (j.getStatus() == 1) {
						j.drinkPotion(i);
						j.setStatus(0);
					}
				}
			}
		}
	}
	public static void removeDeadUnits() {
		//INSTEAD SET THEIR CURRENT SQUARE TO NULL
		/*
		for (Iterator<Piece> it = Board.pieceSet.iterator(); it.hasNext();) {
		    Piece p = it.next();
		    if (p.getHealth() <= 0) {
		        it.remove();   
		    }
		}
		*/
		for (Piece j: Board.pieceSet) {
			if (j.getHealth() <= 0) {
				j.setCurrentSquare(null);
			}
		}
	}
	public static boolean turnHandler(Player p) {
		p.removeMoveToken();
		if (p.getMoveTokens() <= 0) {
			p.setTurn(false);
			p.restoreMoveTokens();
			return true;
		}
		return false;
	}
	
	//move piece
	public static void move() {
		Square selectedSquares[] = fetchSelectedSquares();
		executeCommand(new BackupCommand());
		
		if (Board.Players[0].getTurn()) {
			for (Piece i : Board.pieceSet) {
				if (i.getCurrentSquare() != null) {
					if (selectedSquares[0].getRow() == i.getCurrentSquare().getRow()) {
						if (selectedSquares[0].getColumn() == i.getCurrentSquare().getColumn()) {
							if (i.getTeam() == 0) {
								if (i.move(selectedSquares[1].getRow(),selectedSquares[1].getColumn())) {
									System.out.println(i.toString() + " " + "moves");
									System.out.println(i.getHealth());
									i.move(selectedSquares[1].getRow(),selectedSquares[1].getColumn());
									drinkPotionCheck();
									if (turnHandler(Board.Players[0])) {
									Board.Players[1].setTurn(true);
									}
									return;
								}
							}
						}
					}
				}
				if (i.getCurrentSquare() != null) {
					if (selectedSquares[1].getRow() == i.getCurrentSquare().getRow()) {
						if (selectedSquares[1].getColumn() == i.getCurrentSquare().getColumn()) {
							if (i.getTeam() == 0) {
								if (i.move(selectedSquares[0].getRow(), selectedSquares[0].getColumn())) {
									i.move(selectedSquares[0].getRow(), selectedSquares[0].getColumn());
									System.out.println(i.toString() + " " + "moves");
									System.out.println(i.getHealth());
									drinkPotionCheck();
									if (turnHandler(Board.Players[0])) {
									Board.Players[1].setTurn(true);
									}
									return;
								}
								}
							}
						}
					}
				}
			}
		if (Board.Players[1].getTurn()) {
			for (Piece i : Board.pieceSet) {
				if (i.getCurrentSquare() != null) {
					if (selectedSquares[0].getRow() == i.getCurrentSquare().getRow()) {
						if (selectedSquares[0].getColumn() == i.getCurrentSquare().getColumn()) {
							if (i.getTeam() == 1) {
								if (i.move(selectedSquares[1].getRow(), selectedSquares[1].getColumn())) {
									System.out.println(i.toString() + " " + "moves");
									System.out.println(i.getHealth());
									i.move(selectedSquares[1].getRow(), selectedSquares[1].getColumn());
									drinkPotionCheck();
									if (turnHandler(Board.Players[1])) {
									Board.Players[0].setTurn(true);
									}
									return;
								}
							}
						}
					}
				}
				if (i.getCurrentSquare() != null) {
					if (selectedSquares[1].getRow() == i.getCurrentSquare().getRow()) {
						if (selectedSquares[1].getColumn() == i.getCurrentSquare().getColumn()) {
							if (i.getTeam() == 1) {
								if (i.move(selectedSquares[0].getRow(), selectedSquares[0].getColumn())) {
									System.out.println(i.toString() + " " + "moves");
									System.out.println(i.getHealth());
									i.move(selectedSquares[0].getRow(), selectedSquares[0].getColumn());
									drinkPotionCheck();
									if (turnHandler(Board.Players[1])) {
									Board.Players[0].setTurn(true);
									}
									return;
									}
								}
							}
						}
					}
				}
			}
	}
	public static void spell() {
		Square selectedSquares[] = fetchSelectedSquares();
		executeCommand(new BackupCommand());
		
		if (Board.Players[0].getTurn()) {
			for (Piece i : Board.pieceSet) {
				if (selectedSquares[0] != null) {
					if (i.getCurrentSquare() != null) {
						if (selectedSquares[0].getRow() == i.getCurrentSquare().getRow()) {
							if (selectedSquares[0].getColumn() == i.getCurrentSquare().getColumn()) {
								if (i.getTeam() == 0) {
									if (i.spell()) {
										if (turnHandler(Board.Players[0])) {
											Board.Players[1].setTurn(true);
										}
										return;
									}
								}
							}
						}
					}
				}
				if (selectedSquares[1] != null) {
					if (i.getCurrentSquare() != null) {
						if (selectedSquares[1].getRow() == i.getCurrentSquare().getRow()) {
							if (selectedSquares[1].getColumn() == i.getCurrentSquare().getColumn()) {
								if (i.getTeam() == 0) {
									if (i.spell()) {
										if (turnHandler(Board.Players[0])) {
											Board.Players[1].setTurn(true);
										}
										return;
									}
								}
							}
						}
					}
				}
			}
		}
		if (Board.Players[1].getTurn()) {
			for (Piece i : Board.pieceSet) {
				if (selectedSquares[0] != null) {
					if (i.getCurrentSquare() != null) {
						if (selectedSquares[0].getRow() == i.getCurrentSquare().getRow()) {
							if (selectedSquares[0].getColumn() == i.getCurrentSquare().getColumn()) {
								if (i.getTeam() == 1) {
									if (i.spell()) {
										if (turnHandler(Board.Players[1])) {
											Board.Players[0].setTurn(true);
										}
										return;
									}
								}
							}
						}
					}
				}
				if (selectedSquares[1] != null) {
					if (i.getCurrentSquare() != null) {
						if (selectedSquares[1].getRow() == i.getCurrentSquare().getRow()) {
							if (selectedSquares[1].getColumn() == i.getCurrentSquare().getColumn()) {
								if (i.getTeam() == 0) {
									if (i.spell()) {
										if (turnHandler(Board.Players[1])) {
											Board.Players[0].setTurn(true);
										}
										return;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	//select squares related
	private static boolean selectPreCondition() {
		int count = 0;
		for (int i = 0; i < Board.squares.length; i++) {
		    for (int j = 0; j < Board.squares[i].length; j++) {
		    	if (Board.squares[i][j] != null) {
			        if (Board.squares[i][j].getSelectStatus() == true) {
			        count++;
			        	}
			        }
		    	}
			}
			if (count < 2) {
	    		return true;
	    	}
			else {
				return false;
			}
		}
	private static Square[] fetchSelectedSquares() {
		Square selectedSquares[] = new Square[2];
		int count = 0;
		for (int i = 0; i < Board.squares.length; i++) {
	        for (int j = 0; j < Board.squares[i].length; j++) {
	        	if (Board.squares[i][j] != null) {
		        	if (Board.squares[i][j].getSelectStatus()) {
		        		selectedSquares[count] = Board.squares[i][j];
		        		count++;
		        	}
	        	}
	        }
		}
		return selectedSquares;	
	}
	public static void select(int row, int column) {
		Square selectedSquares[] = fetchSelectedSquares();
		System.out.println(selectedSquares[0]);
		System.out.println(selectedSquares[1]);
		
		for (int i = 0; i < Board.obstacles.length; i++) {
			if (Board.squares[row][column] == Board.obstacles[i].getCurrentSquare()) {
				return;
			}
		}
		
		//deselect
		if(Board.squares[row][column] == selectedSquares[0]) {
			Board.squares[row][column].setSelectStatus(false);
			return;
		}
		if(Board.squares[row][column] == selectedSquares[1]) {
			Board.squares[row][column].setSelectStatus(false);
			return;
		}
		
		//Ensures only two squares can be selected
		else if (selectPreCondition()) {
			
			//if square with piece is selected
			for (Piece i: Board.pieceSet) {
				if (i.getCurrentSquare() == Board.squares[row][column]) {
					//Check no other selected square has a piece
					for (Piece j: Board.pieceSet) {
						if(j.getCurrentSquare() == selectedSquares[0] && j.getCurrentSquare() != null) {
							System.out.println("please select an empty square or deselect the piece selected");
							return;
						}
						if(j.getCurrentSquare() == selectedSquares[1] && j.getCurrentSquare() != null) {
							System.out.println("please select an empty square or deselect the piece selected");
							return;
						}
					}
					//if no other square has a piece, set square select status as true
					Board.squares[row][column].setSelectStatus(true);
					return;	
				}
			}
			//if blank square is selected
			for (Piece x: Board.pieceSet) {
				if (x.getCurrentSquare() != Board.squares[row][column]) {
					//Check if a square with a piece is selected  
					for (Piece j: Board.pieceSet) {
						if(j.getCurrentSquare() == selectedSquares[0] && j.getCurrentSquare() != null) {
							Board.squares[row][column].setSelectStatus(true);
							return;
						}
						if(j.getCurrentSquare() == selectedSquares[1] && j.getCurrentSquare() != null) {
							Board.squares[row][column].setSelectStatus(true);
							return;
						}
					}
				}
			}
		    //selecting first square
		    if (selectedSquares[0] == null) {
				Board.squares[row][column].setSelectStatus(true);
				return;
			}
			/*
			if the selected square is blank when an already selected 
			square is blank too 
			*/
			else {
				System.out.println("please select a square with a piece");
				return;
				}				
			}
		else {
			System.out.println("two pieces are already selected");
			return;
		}
	}
	public static Color changeButtonColour(int row, int column) {
		if (Board.squares[row][column] == null) {
			return Color.GRAY;
		}
		if (Board.squares[row][column].getSelectStatus() && Board.squares[row][column] != null) {
			return Color.BLUE;
		}
		return new Color(255,255,204);   
	}
	
	//start, load, save game
	public static void startGame(int row, int column, Boolean Power, Boolean Paladin, Boolean Mage, Boolean Ranger, Boolean Healer, Boolean Rogue) throws ClassNotFoundException, SQLException, squareBoundsException, PieceInvalidName {
		commandHistory.empty();
		Board.create("start", row, column, Power, Paladin, Mage, Ranger, Healer, Rogue);
	} 
	public static void loadGame() throws ClassNotFoundException, SQLException, squareBoundsException, PieceInvalidName {
		Board.create("load", 0, 0, null, null, null, null, null, null);
		loadCommands();
		
	}
	public static void saveGame(int row, int column) throws ClassNotFoundException, SQLException, squareBoundsException, PieceInvalidName {
		Board.create("update", row, column, null, null, null, null, null, null);
		saveCommands();
	}	
}


	
	
	


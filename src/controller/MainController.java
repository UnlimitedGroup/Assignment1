package controller;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import exceptions.PieceInvalidName;
import exceptions.squareBoundsException;
import model.Board;
import model.Obstacle;
import model.Piece;
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
	public static ImageIcon displayImg(int row, int column) {
		for (Piece i: Board.pieceSet) {
			if(i.getCurrentSquare() == Board.squares[row][column]) {
				if(i.toString() == "healer") {
					return healer;
				}
				if(i.toString() == "mage") {
					return mage;
				}
				if(i.toString() == "paladin") {
					return paladin;
				}
				if(i.toString() == "power") {
					return power;
				}
				if(i.toString() == "princess1") {
					return princess1;
				}
				if(i.toString() == "princess2") {
					return princess2;
				}
				if(i.toString() == "rogue") {
					return rogue;
				}
				if(i.toString() == "ranger") {
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
	
	//move piece
	public static void move() {
		Square selectedSquares[] = fetchSelectedSquares();
		
		if (Board.Players[0].getTurn()) {
			for (Piece i : Board.pieceSet) {
				if (selectedSquares[0].getRow() == i.getCurrentSquare().getRow()) {
					if (selectedSquares[0].getColumn() == i.getCurrentSquare().getColumn()) {
						if (i.getTeam() == 0) {
							if (i.move(selectedSquares[1].getRow(),selectedSquares[1].getColumn())) {
								System.out.println(i.toString() + " " + "moves");
								System.out.println(i.getHealth());
								i.move(selectedSquares[1].getRow(),selectedSquares[1].getColumn());
								drinkPotionCheck();
								Board.Players[0].setTurn(false);
								Board.Players[1].setTurn(true);
								return;
							}
						}
					}
				}
				if (selectedSquares[1].getRow() == i.getCurrentSquare().getRow()) {
					if (selectedSquares[1].getColumn() == i.getCurrentSquare().getColumn()) {
						if (i.getTeam() == 0) {
							if (i.move(selectedSquares[0].getRow(), selectedSquares[0].getColumn())) {
								i.move(selectedSquares[0].getRow(), selectedSquares[0].getColumn());
								System.out.println(i.toString() + " " + "moves");
								System.out.println(i.getHealth());
								drinkPotionCheck();
								Board.Players[0].setTurn(false);
								Board.Players[1].setTurn(true);
								return;
							}
							}
						}
					}
				}
			}
		if (Board.Players[1].getTurn()) {
			for (Piece i : Board.pieceSet) {
				if (selectedSquares[0].getRow() == i.getCurrentSquare().getRow()) {
					if (selectedSquares[0].getColumn() == i.getCurrentSquare().getColumn()) {
						if (i.getTeam() == 1) {
							if (i.move(selectedSquares[1].getRow(), selectedSquares[1].getColumn())) {
								System.out.println(i.toString() + " " + "moves");
								System.out.println(i.getHealth());
								i.move(selectedSquares[1].getRow(), selectedSquares[1].getColumn());
								drinkPotionCheck();
								Board.Players[1].setTurn(false);
								Board.Players[0].setTurn(true);
								return;
							}
						}
					}
				}
				if (selectedSquares[1].getRow() == i.getCurrentSquare().getRow()) {
					if (selectedSquares[1].getColumn() == i.getCurrentSquare().getColumn()) {
						if (i.getTeam() == 1) {
							if (i.move(selectedSquares[0].getRow(), selectedSquares[0].getColumn())) {
								System.out.println(i.toString() + " " + "moves");
								System.out.println(i.getHealth());
								i.move(selectedSquares[0].getRow(), selectedSquares[0].getColumn());
								drinkPotionCheck();
								Board.Players[1].setTurn(false);
								Board.Players[0].setTurn(true);
								return;
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
						if(j.getCurrentSquare() == selectedSquares[0]) {
							System.out.println("please select an empty square or deselect the piece selected");
							return;
						}
						if(j.getCurrentSquare() == selectedSquares[1]) {
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
						if(j.getCurrentSquare() == selectedSquares[0]) {
							Board.squares[row][column].setSelectStatus(true);
							return;
						}
						if(j.getCurrentSquare() == selectedSquares[1]) {
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
		Board.create("start", row, column, Power, Paladin, Mage, Ranger, Healer, Rogue);
	} 
	public static void loadGame() throws ClassNotFoundException, SQLException, squareBoundsException, PieceInvalidName {
		Board.create("load", 0, 0, null, null, null, null, null, null);
	}
	public static void saveGame(int row, int column) throws ClassNotFoundException, SQLException, squareBoundsException, PieceInvalidName {
		Board.create("update", row, column, null, null, null, null, null, null);
	}	
}


	
	
	


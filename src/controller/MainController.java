package controller;

import javax.swing.ImageIcon;

import model.Board;
import model.Piece;
import model.Square;
import view.Main;

public class MainController {
	
	private ImageIcon healer = new ImageIcon(Main.class.getResource("/imgs/healer.png"));
	private ImageIcon mage = new ImageIcon(Main.class.getResource("/imgs/mage.png"));
	private ImageIcon paladin = new ImageIcon(Main.class.getResource("/imgs/paladin.png"));
	private ImageIcon power = new ImageIcon(Main.class.getResource("/imgs/power.png"));
	private ImageIcon princess1 = new ImageIcon(Main.class.getResource("/imgs/princess1.png"));
	private ImageIcon princess2 = new ImageIcon(Main.class.getResource("/imgs/princess2.png"));
	private ImageIcon ranger = new ImageIcon(Main.class.getResource("/imgs/ranger.png"));
	private ImageIcon rogue = new ImageIcon(Main.class.getResource("/imgs/rogue.png"));
	
	
	public  ImageIcon displayImg(String row, String column) {
		return healer;
	}
	
	
	public static void move() {
		return;
	}
	
	
	public static boolean selectPreCondition() {
		int count = 0;
		for (int i = 0; i < Board.squares.length; i++) {
	        for (int j = 0; j < Board.squares[i].length; j++) {
	        	if (Board.squares[i][j].getSelectStatus() == true) {
	        	count++;
	        	}
	        }
		}
		if (count >= 2) {
    		return false;
    	}
		else {
			return true;
		}
	}
	
	public static Square[] fetchSelectedSquares() {
		Square selectedSquares[] = new Square[1];
		int count = 0;
		for (int i = 0; i < Board.squares.length; i++) {
	        for (int j = 0; j < Board.squares[i].length; j++) {
	        	if (Board.squares[i][j].getSelectStatus() == true) {
	        		selectedSquares[count] = Board.squares[i][j];
	        		count++;
	        	}
	        }
		}
		return selectedSquares;	
	}
	
	
	public static void select(int row, int column) {
		Square selectedSquares[] = fetchSelectedSquares();
		
		if (selectPreCondition()) {
			for (Piece i: Board.pieceSet) {
				//if square with piece is selected
				if (i.getCurrentSquare() == Board.squares[row][column]) {
					//Check no other selected square has a piece
					for (Piece j: Board.pieceSet) {
						if(j.getCurrentSquare() == selectedSquares[0]) {
							System.out.println("please select an empty square or deselect the piece selected");
						}
						if(j.getCurrentSquare() == selectedSquares[1]) {
							System.out.println("please select an empty square or deselect the piece selected");
						}
						//if no other square has a piece, set square select status as true
						else {	
							Board.squares[row][column].setSelectStatus(); 
						}
					}
				}
				//if blank square is selected
				if (i.getCurrentSquare() != Board.squares[row][column]) {
					//Check if a square with a piece is selected  
					for (Piece j: Board.pieceSet) {
						if(j.getCurrentSquare() == selectedSquares[0]) {
							Board.squares[row][column].setSelectStatus();
							return;
						}
						if(j.getCurrentSquare() == selectedSquares[1]) {
							Board.squares[row][column].setSelectStatus();
							return;
						}
					}
					//if no squares selected
					if (selectedSquares[0] == null) {
						Board.squares[row][column].setSelectStatus();
						return;
					}
					/*
					if the selected square is blank when an already selected 
					square is blank too 
					*/
					else {
						System.out.println("please select a square with a piece");
					}	
				}
			}			
		}
		else {
			System.out.println("two pieces are already selected");
		}
	}
}

	
	
	


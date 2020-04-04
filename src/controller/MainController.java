package controller;

import java.awt.Color;

import javax.swing.ImageIcon;

import model.Board;
import model.Piece;
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
		return null;
	}
	
	public static Color changeButtonColour(int row, int column) {
		if (Board.squares[row][column].getSelectStatus()) {
			return Color.RED;
		}
		return Color.WHITE;
	        		
	     
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
		if (count < 2) {
    		return true;
    	}
		else {
			return false;
		}
	}
	public static Square[] fetchSelectedSquares() {
		Square selectedSquares[] = new Square[2];
		int count = 0;
		for (int i = 0; i < Board.squares.length; i++) {
	        for (int j = 0; j < Board.squares[i].length; j++) {
	        	if (Board.squares[i][j].getSelectStatus()) {
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
							return;
						}
						if(j.getCurrentSquare() == selectedSquares[1]) {
							System.out.println("please select an empty square or deselect the piece selected");
							return;
						}
					}
						//if no other square has a piece, set square select status as true
						System.out.println("1");
						Board.squares[row][column].setSelectStatus(true);
						return;	
				}
			}
			
			for (Piece x: Board.pieceSet) {
				//if blank square is selected
				if (x.getCurrentSquare() != Board.squares[row][column]) {
					//Check if a square with a piece is selected  
					for (Piece j: Board.pieceSet) {
						if(j.getCurrentSquare() == selectedSquares[0]) {
							Board.squares[row][column].setSelectStatus(true);
							System.out.println("2");
							return;
						}
						if(j.getCurrentSquare() == selectedSquares[1]) {
							Board.squares[row][column].setSelectStatus(true);
							System.out.println("3");
							return;
						}
					}
				}
			}
		    //if no squares selected
		    if (selectedSquares[0] == null) {
				Board.squares[row][column].setSelectStatus(true);
				System.out.println("4");
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
}

	
	
	


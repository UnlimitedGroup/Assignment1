package controller;

import java.util.ArrayList;

import model.Board;
import model.Piece;
import model.Square;

public class MainController {
	
	public static void move() {
		return;
	}
	
	
	public boolean selectPreCondition() {
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
		
		for (Piece i: Board.pieceSet) {
			//Check if selected Square has a piece on it
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
			else {
				
			}
		
						
					
				
				
			        	
				
			
			
		
		
		
	}

	
	
	
}

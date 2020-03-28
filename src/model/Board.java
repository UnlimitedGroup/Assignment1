package model;

import java.util.ArrayList;

//Static class
public class Board {
	private static ArrayList<Piece> PieceSet = new ArrayList<Piece>();
	private static Square Squares[][];
	
	public static void initialize() {
		try {
		
		} catch () {
			//something
		}	
	}
	
	public static void initializePlayers() {
		try {
			Player Player1 = new Player(1);
			Player Player2 = new Player(2);
			
		} catch (idException e) {
			//something
		}	
	}
	public static void initializeSquares() {
			//8x8 Grid
			Squares[0][0] = new Square(0,0);
			Squares[0][1] = new Square(0,1);
			Squares[0][2] = new Square(0,2);
			Squares[0][3] = new Square(0,3);
			Squares[0][4] = new Square(0,4);
			Squares[0][5] = new Square(0,5);
			Squares[0][6] = new Square(0,6);
			Squares[0][7] = new Square(0,7);
			Squares[1][0] = new Square(1,0);
			Squares[1][1] = new Square(1,1);
			Squares[1][2] = new Square(1,2);
			Squares[1][3] = new Square(1,3);
			Squares[1][4] = new Square(1,4);
			Squares[1][5] = new Square(1,5);
			Squares[1][6] = new Square(1,6);
			Squares[1][7] = new Square(1,7);
			Squares[2][0] = new Square(2,0);
			Squares[2][1] = new Square(2,1);
			Squares[2][2] = new Square(2,2);
			Squares[2][3] = new Square(2,3);
			Squares[2][4] = new Square(2,4);
			Squares[2][5] = new Square(2,5);
			Squares[2][6] = new Square(2,6);
			Squares[2][7] = new Square(2,7);
			Squares[3][0] = new Square(3,0);
			Squares[3][1] = new Square(3,1);
			Squares[3][2] = new Square(3,2);
			Squares[3][3] = new Square(3,3);
			Squares[3][4] = new Square(3,4);
			Squares[3][5] = new Square(3,5);
			Squares[3][6] = new Square(3,6);
			Squares[3][7] = new Square(3,7);
			Squares[4][0] = new Square(4,0);
			Squares[4][1] = new Square(4,1);
			Squares[4][2] = new Square(4,2);
			Squares[4][3] = new Square(4,3);
			Squares[4][4] = new Square(4,4);
			Squares[4][5] = new Square(4,5);
			Squares[4][6] = new Square(4,6);
			Squares[4][7] = new Square(4,7);
			Squares[5][0] = new Square(5,0);
			Squares[5][1] = new Square(5,1);
			Squares[5][2] = new Square(5,2);
			Squares[5][3] = new Square(5,3);
			Squares[5][4] = new Square(5,4);
			Squares[5][5] = new Square(5,5);
			Squares[5][6] = new Square(5,6);
			Squares[5][7] = new Square(5,7);
			Squares[6][0] = new Square(6,0);
			Squares[6][1] = new Square(6,1);
			Squares[6][2] = new Square(6,2);
			Squares[6][3] = new Square(6,3);
			Squares[6][4] = new Square(6,4);
			Squares[6][5] = new Square(6,5);
			Squares[6][6] = new Square(6,6);
			Squares[6][7] = new Square(6,7);
			Squares[7][0] = new Square(7,0);
			Squares[7][1] = new Square(7,1);
			Squares[7][2] = new Square(7,2);
			Squares[7][3] = new Square(7,3);
			Squares[7][4] = new Square(7,4);
			Squares[7][5] = new Square(7,5);
			Squares[7][6] = new Square(7,6);
			Squares[7][7] = new Square(7,7);
			Squares[8][0] = new Square(8,0);
			Squares[8][1] = new Square(8,1);
			Squares[8][2] = new Square(8,2);
			Squares[8][3] = new Square(8,3);
			Squares[8][4] = new Square(8,4);
			Squares[8][5] = new Square(8,5);
			Squares[8][6] = new Square(8,6);
			Squares[8][7] = new Square(8,7);		
	}
	public static void initializePieces() {
		try {
			//Initialize Player Objects
			Player Player1 = new Player(1);
			Player Player2 = new Player(2);
			
			
		} catch (idException e) {
			//something
		}	
	}
	
	//Static get methods
	public static ArrayList<Piece> getPieceSet() {
		return PieceSet;
	}
	public static Square[][] getSquareList() {
		return Square;
	}

}

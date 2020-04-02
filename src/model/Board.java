package model;

import java.util.ArrayList;

public class Board {
	private static ArrayList<Piece> pieceSet = new ArrayList<Piece>();
	private static Square squares[][];
	
	public static void initialize() {
		initializePlayers();
		initializeSquares();
		initializePieces();
	}
	
	public static void initializePlayers() {
		try {
			Player Player1 = new Player(0);
			Player Player2 = new Player(1);
			
		} catch (teamException e) {
			//handle
		}	
	}
	public static void initializeSquares() {
		//5x7 Grid
		squares[0][0] = new Square(0,0, false);
		squares[0][1] = new Square(0,1, false);
		squares[0][2] = new Square(0,2, false);
		squares[0][3] = new Square(0,3, false);
		squares[0][4] = new Square(0,4, false);
		squares[1][0] = new Square(1,0, false);
		squares[1][1] = new Square(1,1, false);
		squares[1][2] = new Square(1,2, false);
		squares[1][3] = new Square(1,3, false);
		squares[1][4] = new Square(1,4, false);
		squares[2][0] = new Square(2,0, false);
		squares[2][1] = new Square(2,1, false);
		squares[2][2] = new Square(2,2, false);
		squares[2][3] = new Square(2,3, false);
		squares[2][4] = new Square(2,4, false);
		squares[3][0] = new Square(3,0, false);
		squares[3][1] = new Square(3,1, false);
		squares[3][2] = new Square(3,2, false);
		squares[3][3] = new Square(3,3, false);
		squares[3][4] = new Square(3,4, false);
		squares[4][0] = new Square(4,0, false);
		squares[4][1] = new Square(4,1, false);
		squares[4][2] = new Square(4,2, false);
		squares[4][3] = new Square(4,3, false);
		squares[4][4] = new Square(4,4, false);
		squares[5][0] = new Square(5,0, false);
		squares[5][1] = new Square(5,1, false);
		squares[5][2] = new Square(5,2, false);
		squares[5][3] = new Square(5,3, false);
		squares[5][4] = new Square(5,4, false);
		squares[6][0] = new Square(6,0, false);
		squares[6][1] = new Square(6,1, false);
		squares[6][2] = new Square(6,2, false);
		squares[6][3] = new Square(6,3, false);
		squares[6][4] = new Square(6,4, false);	
	}
	public static void initializePieces() {
		Piece power0 = new Power(100, null, 0);
		Piece power1 = new Power(100, null, 1);
		Piece paladin0 = new Paladin(100, null, 0);
		Piece paladin1 = new Paladin(100, null, 1);
		Piece mage0 = new Mage(100, null, 0);
		Piece mage1 = new Mage(100, null, 1);
		Piece ranger0 = new Ranger(100, null, 0);
		Piece ranger1 = new Ranger(100, null, 1);
		Piece healer0 = new Healer(100, null, 0);
		Piece healer1= new Healer(100, null, 1);
		Piece rogue0 = new Rogue(100, null, 0);
		Piece rogue1 = new Rogue(100, null, 1);
		Piece princess0 = new Princess(100, null, 0);
		Piece princess1 = new Princess(100, null, 1);
		pieceSet.add(power0);
		pieceSet.add(power1);
		pieceSet.add(paladin0);
		pieceSet.add(paladin1);
		pieceSet.add(mage0);
		pieceSet.add(mage1);
		pieceSet.add(ranger0);
		pieceSet.add(ranger1);
		pieceSet.add(healer0);
		pieceSet.add(healer1);
		pieceSet.add(rogue0);
		pieceSet.add(rogue1);
		pieceSet.add(princess0);
		pieceSet.add(princess1);
	}
	public static ArrayList<Piece> getPieceSet() {
		return pieceSet;
	}
	public static Square[][] getSquareList() {
		return squares;
	}

}

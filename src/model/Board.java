package model;

import java.util.ArrayList;

//Static class
public class Board {
	private static ArrayList<Piece> PieceSet = new ArrayList<Piece>();
	private static Square Square[][]; 
	
	//Initialize Board
	public static void initialize() {
		
	}
	
	//Static get methods
	public static ArrayList<Piece> getPieceSet() {
		return PieceSet;
	}
	public static Square[][] getSquareList() {
		return Square;
	}

}

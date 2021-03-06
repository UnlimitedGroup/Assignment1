package model;

import java.util.ArrayList;

import exceptions.healthException;
import exceptions.squareBoundsException;
import exceptions.teamException;

public class Board {
	public static Player[] Players = new Player[2];
	public static ArrayList<Piece> pieceSet = new ArrayList<Piece>();
	//5x7 Grid
	public static Square[][] squares = new Square[7][5];
	
	public static void create() {
		initializePlayers();
		initializeSquares();
		initializePieces();
	}
	
	public static void initializePlayers() {
		try {
			Players[0] = new Player(0, true);
			Players[1] = new Player(1, false);
		} catch (teamException e) {
			System.out.println("select either 0 or 1 as a team number for player");
		}	
	}
	public static void initializeSquares() {
		try {
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
		} catch (squareBoundsException e) {
			System.out.println("Square out of bounds exception");
		}
	}
	public static void initializePieces() {
		
		try {
			Piece power = new Power(100, squares[5][1], 0);
			Piece paladin = new Paladin(100, squares[5][2], 0);
			Piece mage = new Mage(100, squares[5][3], 0);
			Piece ranger = new Ranger(100, squares[1][1], 1);
			Piece healer = new Healer(100, squares[1][2], 1);
			Piece rogue = new Rogue(100, squares[1][3], 1);
			Piece princess1 = new Princess(100, squares[0][2], 1);
			Piece princess2 = new Princess(100, squares[6][2], 0);
			pieceSet.add(power);
			pieceSet.add(paladin);
			pieceSet.add(mage);
			pieceSet.add(ranger);
			pieceSet.add(healer);
			pieceSet.add(rogue);
			pieceSet.add(princess1);
			pieceSet.add(princess2);
		} catch (healthException e) {
			System.out.println("Health not within range of 0 - 100");
		}
	}
}

package model;

import java.util.ArrayList;

public class Power extends Piece {
	
private int health;
private Square currentSquare;
private Player team;

public Power(int health, Square currentSquare, Player team) {
	this.health = health;
	this.currentSquare = currentSquare;
	this.team = team;
}
//Gets
public int getHealth() {
	return this.health;
}

public Square getCurrentSquare() {
	return this.currentSquare;
}

public Player getTeam() {
	return this.team;
}
//Set
public void setCurrentSquare(Square newSquare) {
	this.currentSquare = newSquare;
}

//Action
public void takeDamage (int damage) {
	this.health = this.health - damage;
}

/*
 Unique spell is laser beam in forward direction 4 squares damaging players for 25 health
 */
public boolean spell() {
	currentRow = this.currentSquare.getRow();
	currentColumn = this.currentSquare.getColumn();
	SquareList[][] = board.getSquareList();
	ArrayList<Piece> PieceList = board.getPieceSet();
	
	for (int i=0; i<3;i++) {
		Square checkSquare = SquareList[currentRow++][currentColumn];
		for (int j = 0; j<PieceList.size()-1; j++) {
			//Check only pieces on other team
			if (PieceList.get(j).getTeam() != this.getTeam()) {
				//Check if the piece is in the spell path square
				if (PieceList(j).get(j).getCurrentSquare() == checkSquare) {
					//Deal 25 Damage
					PieceList(j).get(j).takeDamage(25);
				}
			}
			
		}
	
	}
	
}







}

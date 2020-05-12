package model;

import java.awt.EventQueue;
import java.sql.SQLException;

import exceptions.PieceInvalidName;
import exceptions.squareBoundsException;
import view.Main;

//Initializer class

public class KillThePrincess {
	
	public static void main(String[] args) throws squareBoundsException {
		
		//Initialize default settings and objects
		Board.Players[0] = new Player(0, true);
		Board.Players[1] = new Player(1, false);
		Board.squares[0][0] = new Square(0,0, false);
		Board.squares[0][1] = new Square(0,1, false);
		Board.squares[0][2] = new Square(0,2, false);
		Board.squares[0][3] = new Square(0,3, false);
		Board.squares[0][4] = new Square(0,4, false);
		Board.squares[1][0] = new Square(1,0, false);
		Board.squares[1][1] = new Square(1,1, false);
		Board.squares[1][2] = new Square(1,2, false);
		Board.squares[1][3] = new Square(1,3, false);
		Board.squares[1][4] = new Square(1,4, false);
		Board.squares[2][0] = new Square(2,0, false);
		Board.squares[2][1] = new Square(2,1, false);
		Board.squares[2][2] = new Square(2,2, false);
		Board.squares[2][3] = new Square(2,3, false);
		Board.squares[2][4] = new Square(2,4, false);
		Board.squares[3][0] = new Square(3,0, false);
		Board.squares[3][1] = new Square(3,1, false);
		Board.squares[3][2] = new Square(3,2, false);
		Board.squares[3][3] = new Square(3,3, false);
		Board.squares[3][4] = new Square(3,4, false);
		Board.squares[4][0] = new Square(4,0, false);
		Board.squares[4][1] = new Square(4,1, false);
		Board.squares[4][2] = new Square(4,2, false);
		Board.squares[4][3] = new Square(4,3, false);
		Board.squares[4][4] = new Square(4,4, false);
		Board.squares[5][0] = new Square(5,0, false);
		Board.squares[5][1] = new Square(5,1, false);
		Board.squares[5][2] = new Square(5,2, false);
		Board.squares[5][3] = new Square(5,3, false);
		Board.squares[5][4] = new Square(5,4, false);
		Board.squares[6][0] = new Square(6,0, false);
		Board.squares[6][1] = new Square(6,1, false);
		Board.squares[6][2] = new Square(6,2, false);
		Board.squares[6][3] = new Square(6,3, false);
		Board.squares[6][4] = new Square(6,4, false);	
		
		
		//Open Window
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.initialize();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		
	}

}

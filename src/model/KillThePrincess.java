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
		Board.squares[0][0] = null;
		Board.squares[0][1] = null;
		Board.squares[0][2] = null;
		Board.squares[0][3] = null;
		Board.squares[0][4] = null;
		Board.squares[1][0] = null;
		Board.squares[1][1] = null;
		Board.squares[1][2] = null;
		Board.squares[1][3] = null;
		Board.squares[1][4] = null;
		Board.squares[2][0] = null;
		Board.squares[2][1] = null;
		Board.squares[2][2] = null;
		Board.squares[2][3] = null;
		Board.squares[2][4] = null;
		Board.squares[3][0] = null;
		Board.squares[3][1] = null;
		Board.squares[3][2] = null;
		Board.squares[3][3] = null;
		Board.squares[3][4] = null;
		Board.squares[4][0] = null;
		Board.squares[4][1] = null;
		Board.squares[4][2] = null;
		Board.squares[4][3] = null;
		Board.squares[4][4] = null;
		Board.squares[5][0] = null;
		Board.squares[5][1] = null;
		Board.squares[5][2] = null;
		Board.squares[5][3] = null;
		Board.squares[5][4] = null;
		Board.squares[6][0] = null;
		Board.squares[6][1] = null;
		Board.squares[6][2] = null;
		Board.squares[6][3] = null;
		Board.squares[6][4] = null;	
		
		
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

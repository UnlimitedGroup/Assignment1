package model;

import java.awt.EventQueue;
import java.sql.SQLException;

import exceptions.PieceInvalidName;
import exceptions.squareBoundsException;
import view.Main;

//Initializer class

public class KillThePrincess {
	
	public static void main(String[] args) {
		
		//Initialize default settings
		try {
			Board.create("start", 6, 4);
		} catch (ClassNotFoundException | SQLException | squareBoundsException | PieceInvalidName e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
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

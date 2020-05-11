package model;

import java.awt.EventQueue;
import java.sql.SQLException;

import exceptions.PieceInvalidName;
import exceptions.healthException;
import exceptions.squareBoundsException;
import exceptions.teamException;
import view.Main;

//Initializer class

public class KillThePrincess {
	
	public static void main(String[] args) {
		
		//Initialize Game Objects
		//this won't be here
		try {
			Board.create("start", 6, 4);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (teamException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (squareBoundsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (healthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (PieceInvalidName e1) {
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

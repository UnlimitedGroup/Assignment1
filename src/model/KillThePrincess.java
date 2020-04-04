package model;

import java.awt.EventQueue;
import view.Main;

//Initializer class

public class KillThePrincess {
	
	public static void main(String[] args) {
		
		//Initialize Game Objects
		Board.create();
		
		
		
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

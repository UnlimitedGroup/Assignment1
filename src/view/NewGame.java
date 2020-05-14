package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;

import controller.MainController;
import exceptions.PieceInvalidName;
import exceptions.squareBoundsException;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.Color;

public class NewGame {

	public JFrame newGameFrame;

	public NewGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		newGameFrame = new JFrame();
		newGameFrame.setBounds(100, 100, 450, 300);
		newGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newGameFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		newGameFrame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 102));
		newGameFrame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel team1Label = new JLabel("Team 1");
		panel_1.add(team1Label);
		
		JLabel lblNewLabel_1 = new JLabel("Team 2");
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Arena Size");
		panel_1.add(lblNewLabel_2);
		
		JCheckBox powerBox = new JCheckBox("Power");
		powerBox.setBackground(new Color(255, 204, 102));
		panel_1.add(powerBox);
		
		JCheckBox rangerBox = new JCheckBox("Ranger");
		rangerBox.setBackground(new Color(255, 204, 102));
		panel_1.add(rangerBox);
		
		JCheckBox largeBox = new JCheckBox("Large");
		largeBox.setBackground(new Color(255, 204, 102));
		panel_1.add(largeBox);
		
		JCheckBox paladinBox = new JCheckBox("Paladin");
		paladinBox.setBackground(new Color(255, 204, 102));
		panel_1.add(paladinBox);
		
		JCheckBox healerBox = new JCheckBox("Healer");
		healerBox.setBackground(new Color(255, 204, 102));
		panel_1.add(healerBox);
		
		JCheckBox smallBox = new JCheckBox("Small");
		smallBox.setBackground(new Color(255, 204, 102));
		panel_1.add(smallBox);
		
		JCheckBox mageBox = new JCheckBox("Mage");
		mageBox.setBackground(new Color(255, 204, 102));
		panel_1.add(mageBox);
		
		JCheckBox rogueBox = new JCheckBox("Rogue");
		rogueBox.setBackground(new Color(255, 204, 102));
		panel_1.add(rogueBox);
		
		JButton Start = new JButton("Start Game");
		panel.add(Start);
		Start.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int column = 0;
					int row = 0;
					Boolean power = false;
					Boolean paladin = false;
					Boolean mage = false;
					Boolean ranger = false;
					Boolean healer = false;
					Boolean rogue = false;
					if (powerBox.isSelected()) {
						power = true;	
					}
					if (paladinBox.isSelected()) {
						paladin = true;	
					}
					if (mageBox.isSelected()) {
						mage = true;	
					}
					if (rangerBox.isSelected()) {
						ranger = true;	
					}
					if (healerBox.isSelected()) {
						healer = true;	
					}
					if (rogueBox.isSelected()) {
						rogue = true;	
					}
					if (smallBox.isSelected()) {
						column = 5;
						row = 3;
					}
					if (largeBox.isSelected()) {
						column = 6;
						row = 4;
					}
					MainController.startGame(column, row, power, paladin, mage, ranger, healer, rogue);
					newGameFrame.setVisible(false);
					Main mainFrame = new Main();
					mainFrame.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException | squareBoundsException | PieceInvalidName e1) {
						
				}
			}});
		
	}
}

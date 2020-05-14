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
		
		JButton Start = new JButton("Start Game");
		panel.add(Start);
		Start.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						MainController.startGame();
						newGameFrame.setVisible(false);
						Main mainFrame = new Main();
						mainFrame.frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException | squareBoundsException | PieceInvalidName e1) {
						
					}
			}});
		
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
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Power");
		chckbxNewCheckBox_1.setBackground(new Color(255, 204, 102));
		panel_1.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Ranger");
		chckbxNewCheckBox_3.setBackground(new Color(255, 204, 102));
		panel_1.add(chckbxNewCheckBox_3);
		
		JCheckBox arenaLargeCheck = new JCheckBox("Large");
		arenaLargeCheck.setBackground(new Color(255, 204, 102));
		panel_1.add(arenaLargeCheck);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Paladin");
		chckbxNewCheckBox_4.setBackground(new Color(255, 204, 102));
		panel_1.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Healer");
		chckbxNewCheckBox_6.setBackground(new Color(255, 204, 102));
		panel_1.add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Small");
		chckbxNewCheckBox_2.setBackground(new Color(255, 204, 102));
		panel_1.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Mage");
		chckbxNewCheckBox.setBackground(new Color(255, 204, 102));
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("Rogue");
		chckbxNewCheckBox_7.setBackground(new Color(255, 204, 102));
		panel_1.add(chckbxNewCheckBox_7);
		
	}
}

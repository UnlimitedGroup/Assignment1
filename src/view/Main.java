package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 495, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel userPanel = new JPanel();
		frame.getContentPane().add(userPanel, BorderLayout.WEST);
		userPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Move");
		userPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cast Spell");
		userPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Finish Turn");
		userPanel.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		userPanel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Unit Health");
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Moves left");
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Turn");
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_57 = new JPanel();
		userPanel.add(panel_57);
		
		JLabel lblNewLabel_3 = new JLabel("Status");
		panel_57.add(lblNewLabel_3);
		
		JPanel board = new JPanel();
		board.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(board, BorderLayout.CENTER);
		board.setLayout(new GridLayout(8, 7, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_9);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_11);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_10);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_13);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_15);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_17);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_14);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_16);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_20);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_21);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_22);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_23);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_24);
		
		JPanel panel_29 = new JPanel();
		panel_29.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_29);
		
		JPanel panel_28 = new JPanel();
		panel_28.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_28);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_25);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_26);
		
		JPanel panel_33 = new JPanel();
		panel_33.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_33);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_27);
		
		JPanel panel_30 = new JPanel();
		panel_30.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_30);
		
		JPanel panel_31 = new JPanel();
		panel_31.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_31);
		
		JPanel panel_37 = new JPanel();
		panel_37.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_37);
		
		JPanel panel_32 = new JPanel();
		panel_32.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_32);
		
		JPanel panel_34 = new JPanel();
		panel_34.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_34);
		
		JPanel panel_41 = new JPanel();
		panel_41.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_41);
		
		JPanel panel_35 = new JPanel();
		panel_35.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_35);
		
		JPanel panel_36 = new JPanel();
		panel_36.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_36);
		
		JPanel panel_38 = new JPanel();
		panel_38.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_38);
		
		JPanel panel_39 = new JPanel();
		panel_39.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_39);
		
		JPanel panel_46 = new JPanel();
		panel_46.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_46);
		
		JPanel panel_40 = new JPanel();
		panel_40.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_40);
		
		JPanel panel_49 = new JPanel();
		panel_49.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_49);
		
		JPanel panel_42 = new JPanel();
		panel_42.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_42);
		
		JPanel panel_43 = new JPanel();
		panel_43.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_43);
		
		JPanel panel_44 = new JPanel();
		panel_44.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_44);
		
		JPanel panel_45 = new JPanel();
		panel_45.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_45);
		
		JPanel panel_47 = new JPanel();
		panel_47.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_47);
		
		JPanel panel_55 = new JPanel();
		panel_55.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_55);
		
		JPanel panel_48 = new JPanel();
		panel_48.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_48);
		
		JPanel panel_50 = new JPanel();
		panel_50.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_50);
		
		JPanel panel_51 = new JPanel();
		panel_51.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_51);
		
		JPanel panel_52 = new JPanel();
		panel_52.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_52);
		
		JPanel panel_53 = new JPanel();
		panel_53.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_53);
		
		JPanel panel_54 = new JPanel();
		panel_54.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_54);
		
		JPanel panel_56 = new JPanel();
		panel_56.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		board.add(panel_56);
	}

}

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
import javax.swing.BoxLayout;

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
		
		JButton moveButton = new JButton("Move");
		userPanel.add(moveButton);
		
		JButton spellButton = new JButton("Cast Spell");
		userPanel.add(spellButton);
		
		JButton turnButton = new JButton("Finish Turn");
		userPanel.add(turnButton);
		
		JPanel infoPanel = new JPanel();
		userPanel.add(infoPanel);
		infoPanel.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel unitHealth = new JLabel("Unit Health");
		infoPanel.add(unitHealth);
		
		JLabel movesLeft = new JLabel("Moves left");
		infoPanel.add(movesLeft);
		
		JLabel turnStatus = new JLabel("Turn");
		infoPanel.add(turnStatus);
		
		JPanel statusPanel = new JPanel();
		userPanel.add(statusPanel);
		
		JLabel status = new JLabel("Status");
		statusPanel.add(status);
		
		JPanel board = new JPanel();
		board.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(board, BorderLayout.CENTER);
		board.setLayout(new GridLayout(8, 7, 0, 0));
		
		JPanel p00 = new JPanel();
		p00.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p00);
		p00.setLayout(new BorderLayout(0, 0));
		
		JButton b00 = new JButton("");
		p00.add(b00, BorderLayout.CENTER);
		
		JPanel p01 = new JPanel();
		p01.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p01);
		p01.setLayout(new BorderLayout(0, 0));
		
		JButton b01 = new JButton("");
		p01.add(b01, BorderLayout.CENTER);
		
		JPanel p02 = new JPanel();
		p02.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p02);
		p02.setLayout(new BorderLayout(0, 0));
		
		JButton b02 = new JButton("");
		p02.add(b02, BorderLayout.CENTER);
		
		JPanel p03 = new JPanel();
		p03.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p03);
		p03.setLayout(new BorderLayout(0, 0));
		
		JButton b03 = new JButton("");
		p03.add(b03, BorderLayout.CENTER);
		
		JPanel p04 = new JPanel();
		p04.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p04);
		p04.setLayout(new BorderLayout(0, 0));
		
		JButton b04 = new JButton("");
		p04.add(b04, BorderLayout.CENTER);
		
		JPanel p05 = new JPanel();
		p05.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p05);
		p05.setLayout(new BorderLayout(0, 0));
		
		JButton b05 = new JButton("");
		p05.add(b05, BorderLayout.CENTER);
		
		JPanel p06 = new JPanel();
		p06.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p06);
		p06.setLayout(new BorderLayout(0, 0));
		
		JButton b06 = new JButton("");
		p06.add(b06, BorderLayout.CENTER);
		
		JPanel p10 = new JPanel();
		p10.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p10);
		p10.setLayout(new BorderLayout(0, 0));
		
		JButton b10 = new JButton("");
		p10.add(b10, BorderLayout.CENTER);
		
		JPanel p11 = new JPanel();
		p11.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p11);
		p11.setLayout(new BorderLayout(0, 0));
		
		JButton b11 = new JButton("");
		p11.add(b11, BorderLayout.CENTER);
		
		JPanel p12 = new JPanel();
		p12.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p12);
		p12.setLayout(new BorderLayout(0, 0));
		
		JButton b12 = new JButton("");
		p12.add(b12, BorderLayout.CENTER);
		
		JPanel p13 = new JPanel();
		p13.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p13);
		p13.setLayout(new BorderLayout(0, 0));
		
		JButton b13 = new JButton("");
		p13.add(b13, BorderLayout.CENTER);
		
		JPanel p14 = new JPanel();
		p14.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p14);
		p14.setLayout(new BorderLayout(0, 0));
		
		JButton b14 = new JButton("");
		p14.add(b14, BorderLayout.CENTER);
		
		JPanel p15 = new JPanel();
		p15.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p15);
		p15.setLayout(new BorderLayout(0, 0));
		
		JButton b15 = new JButton("");
		p15.add(b15, BorderLayout.CENTER);
		
		JPanel p16 = new JPanel();
		p16.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p16);
		p16.setLayout(new BorderLayout(0, 0));
		
		JButton b16 = new JButton("");
		p16.add(b16, BorderLayout.CENTER);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_13 = new JButton("");
		panel_17.add(btnNewButton_13, BorderLayout.CENTER);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_14 = new JButton("");
		panel_14.add(btnNewButton_14, BorderLayout.CENTER);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_15 = new JButton("");
		panel_16.add(btnNewButton_15, BorderLayout.CENTER);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_16 = new JButton("");
		panel_18.add(btnNewButton_16, BorderLayout.CENTER);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_17 = new JButton("");
		panel_19.add(btnNewButton_17, BorderLayout.CENTER);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_19 = new JButton("");
		panel_20.add(btnNewButton_19, BorderLayout.CENTER);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_21);
		panel_21.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_23 = new JButton("");
		panel_21.add(btnNewButton_23, BorderLayout.CENTER);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_22);
		panel_22.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_24 = new JButton("");
		panel_22.add(btnNewButton_24, BorderLayout.CENTER);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_23);
		panel_23.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_25 = new JButton("");
		panel_23.add(btnNewButton_25, BorderLayout.CENTER);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_24);
		panel_24.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_26 = new JButton("");
		panel_24.add(btnNewButton_26, BorderLayout.CENTER);
		
		JPanel panel_29 = new JPanel();
		panel_29.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_29);
		panel_29.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_56 = new JButton("");
		panel_29.add(btnNewButton_56, BorderLayout.CENTER);
		
		JPanel panel_28 = new JPanel();
		panel_28.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_28);
		panel_28.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_57 = new JButton("");
		panel_28.add(btnNewButton_57, BorderLayout.CENTER);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_25);
		panel_25.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_27 = new JButton("");
		panel_25.add(btnNewButton_27, BorderLayout.CENTER);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_26);
		panel_26.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_28 = new JButton("");
		panel_26.add(btnNewButton_28, BorderLayout.CENTER);
		
		JPanel panel_33 = new JPanel();
		panel_33.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_33);
		panel_33.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_29 = new JButton("");
		panel_33.add(btnNewButton_29, BorderLayout.CENTER);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_27);
		panel_27.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_30 = new JButton("");
		panel_27.add(btnNewButton_30, BorderLayout.CENTER);
		
		JPanel panel_30 = new JPanel();
		panel_30.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_30);
		panel_30.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_31 = new JButton("");
		panel_30.add(btnNewButton_31, BorderLayout.CENTER);
		
		JPanel panel_31 = new JPanel();
		panel_31.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_31);
		panel_31.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_32 = new JButton("");
		panel_31.add(btnNewButton_32, BorderLayout.CENTER);
		
		JPanel panel_37 = new JPanel();
		panel_37.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_37);
		panel_37.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_33 = new JButton("");
		panel_37.add(btnNewButton_33, BorderLayout.CENTER);
		
		JPanel panel_32 = new JPanel();
		panel_32.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_32);
		panel_32.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_34 = new JButton("");
		panel_32.add(btnNewButton_34, BorderLayout.CENTER);
		
		JPanel panel_34 = new JPanel();
		panel_34.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_34);
		panel_34.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_58 = new JButton("");
		panel_34.add(btnNewButton_58, BorderLayout.CENTER);
		
		JPanel panel_41 = new JPanel();
		panel_41.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_41);
		panel_41.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_35 = new JButton("");
		panel_41.add(btnNewButton_35, BorderLayout.CENTER);
		
		JPanel panel_35 = new JPanel();
		panel_35.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_35);
		panel_35.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_36 = new JButton("");
		panel_35.add(btnNewButton_36, BorderLayout.CENTER);
		
		JPanel panel_36 = new JPanel();
		panel_36.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_36);
		panel_36.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_37 = new JButton("");
		panel_36.add(btnNewButton_37, BorderLayout.CENTER);
		
		JPanel panel_38 = new JPanel();
		panel_38.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_38);
		panel_38.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_38 = new JButton("");
		panel_38.add(btnNewButton_38, BorderLayout.CENTER);
		
		JPanel panel_39 = new JPanel();
		panel_39.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_39);
		panel_39.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_39 = new JButton("");
		panel_39.add(btnNewButton_39, BorderLayout.CENTER);
		
		JPanel panel_46 = new JPanel();
		panel_46.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_46);
		panel_46.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_40 = new JButton("");
		panel_46.add(btnNewButton_40, BorderLayout.CENTER);
		
		JPanel panel_40 = new JPanel();
		panel_40.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_40);
		panel_40.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_41 = new JButton("");
		panel_40.add(btnNewButton_41, BorderLayout.CENTER);
		
		JPanel panel_49 = new JPanel();
		panel_49.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_49);
		panel_49.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_45 = new JButton("");
		panel_49.add(btnNewButton_45, BorderLayout.CENTER);
		
		JPanel panel_42 = new JPanel();
		panel_42.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_42);
		panel_42.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_44 = new JButton("");
		panel_42.add(btnNewButton_44, BorderLayout.CENTER);
		
		JPanel panel_43 = new JPanel();
		panel_43.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_43);
		panel_43.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_43 = new JButton("");
		panel_43.add(btnNewButton_43, BorderLayout.CENTER);
		
		JPanel panel_44 = new JPanel();
		panel_44.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_44);
		panel_44.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_42 = new JButton("");
		panel_44.add(btnNewButton_42, BorderLayout.CENTER);
		
		JPanel panel_45 = new JPanel();
		panel_45.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_45);
		panel_45.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_46 = new JButton("");
		panel_45.add(btnNewButton_46, BorderLayout.CENTER);
		
		JPanel panel_47 = new JPanel();
		panel_47.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_47);
		panel_47.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_47 = new JButton("");
		panel_47.add(btnNewButton_47, BorderLayout.CENTER);
		
		JPanel panel_55 = new JPanel();
		panel_55.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_55);
		panel_55.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_48 = new JButton("");
		panel_55.add(btnNewButton_48, BorderLayout.CENTER);
		
		JPanel panel_48 = new JPanel();
		panel_48.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_48);
		panel_48.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_49 = new JButton("");
		panel_48.add(btnNewButton_49, BorderLayout.CENTER);
		
		JPanel panel_50 = new JPanel();
		panel_50.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_50);
		panel_50.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_50 = new JButton("");
		panel_50.add(btnNewButton_50, BorderLayout.CENTER);
		
		JPanel panel_51 = new JPanel();
		panel_51.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_51);
		panel_51.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_51 = new JButton("");
		panel_51.add(btnNewButton_51, BorderLayout.CENTER);
		
		JPanel panel_52 = new JPanel();
		panel_52.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_52);
		panel_52.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_52 = new JButton("");
		panel_52.add(btnNewButton_52, BorderLayout.CENTER);
		
		JPanel panel_53 = new JPanel();
		panel_53.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_53);
		panel_53.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_53 = new JButton("");
		panel_53.add(btnNewButton_53, BorderLayout.CENTER);
		
		JPanel panel_54 = new JPanel();
		panel_54.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_54);
		panel_54.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_54 = new JButton("");
		panel_54.add(btnNewButton_54, BorderLayout.CENTER);
		
		JPanel panel_56 = new JPanel();
		panel_56.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(panel_56);
		panel_56.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_55 = new JButton("");
		panel_56.add(btnNewButton_55, BorderLayout.CENTER);
	}

}

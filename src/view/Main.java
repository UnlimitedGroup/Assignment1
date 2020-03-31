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
		
		JPanel p20 = new JPanel();
		p20.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p20);
		p20.setLayout(new BorderLayout(0, 0));
		
		JButton b20 = new JButton("");
		p20.add(b20, BorderLayout.CENTER);
		
		JPanel p21 = new JPanel();
		p21.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p21);
		p21.setLayout(new BorderLayout(0, 0));
		
		JButton b21 = new JButton("");
		p21.add(b21, BorderLayout.CENTER);
		
		JPanel p22 = new JPanel();
		p22.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p22);
		p22.setLayout(new BorderLayout(0, 0));
		
		JButton b22 = new JButton("");
		p22.add(b22, BorderLayout.CENTER);
		
		JPanel p23 = new JPanel();
		p23.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p23);
		p23.setLayout(new BorderLayout(0, 0));
		
		JButton b23 = new JButton("");
		p23.add(b23, BorderLayout.CENTER);
		
		JPanel p24 = new JPanel();
		p24.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p24);
		p24.setLayout(new BorderLayout(0, 0));
		
		JButton b24 = new JButton("");
		p24.add(b24, BorderLayout.CENTER);
		
		JPanel p25 = new JPanel();
		p25.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p25);
		p25.setLayout(new BorderLayout(0, 0));
		
		JButton b25 = new JButton("");
		p25.add(b25, BorderLayout.CENTER);
		
		JPanel p26 = new JPanel();
		p26.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p26);
		p26.setLayout(new BorderLayout(0, 0));
		
		JButton b26 = new JButton("");
		p26.add(b26, BorderLayout.CENTER);
		
		JPanel p30 = new JPanel();
		p30.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p30);
		p30.setLayout(new BorderLayout(0, 0));
		
		JButton b30 = new JButton("");
		p30.add(b30, BorderLayout.CENTER);
		
		JPanel p31 = new JPanel();
		p31.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p31);
		p31.setLayout(new BorderLayout(0, 0));
		
		JButton b31 = new JButton("");
		p31.add(b31, BorderLayout.CENTER);
		
		JPanel p32 = new JPanel();
		p32.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p32);
		p32.setLayout(new BorderLayout(0, 0));
		
		JButton b32 = new JButton("");
		p32.add(b32, BorderLayout.CENTER);
		
		JPanel p33 = new JPanel();
		p33.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p33);
		p33.setLayout(new BorderLayout(0, 0));
		
		JButton b33 = new JButton("");
		p33.add(b33, BorderLayout.CENTER);
		
		JPanel p34 = new JPanel();
		p34.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p34);
		p34.setLayout(new BorderLayout(0, 0));
		
		JButton b34 = new JButton("");
		p34.add(b34, BorderLayout.CENTER);
		
		JPanel p35 = new JPanel();
		p35.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p35);
		p35.setLayout(new BorderLayout(0, 0));
		
		JButton b35 = new JButton("");
		p35.add(b35, BorderLayout.CENTER);
		
		JPanel p36 = new JPanel();
		p36.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p36);
		p36.setLayout(new BorderLayout(0, 0));
		
		JButton b36 = new JButton("");
		p36.add(b36, BorderLayout.CENTER);
		
		JPanel p40 = new JPanel();
		p40.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p40);
		p40.setLayout(new BorderLayout(0, 0));
		
		JButton b40 = new JButton("");
		p40.add(b40, BorderLayout.CENTER);
		
		JPanel p41 = new JPanel();
		p41.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p41);
		p41.setLayout(new BorderLayout(0, 0));
		
		JButton b41 = new JButton("");
		p41.add(b41, BorderLayout.CENTER);
		
		JPanel p42 = new JPanel();
		p42.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p42);
		p42.setLayout(new BorderLayout(0, 0));
		
		JButton b42 = new JButton("");
		p42.add(b42, BorderLayout.CENTER);
		
		JPanel p43 = new JPanel();
		p43.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p43);
		p43.setLayout(new BorderLayout(0, 0));
		
		JButton b43 = new JButton("");
		p43.add(b43, BorderLayout.CENTER);
		
		JPanel p44 = new JPanel();
		p44.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p44);
		p44.setLayout(new BorderLayout(0, 0));
		
		JButton b44 = new JButton("");
		p44.add(b44, BorderLayout.CENTER);
		
		JPanel p45 = new JPanel();
		p45.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p45);
		p45.setLayout(new BorderLayout(0, 0));
		
		JButton b45 = new JButton("");
		p45.add(b45, BorderLayout.CENTER);
		
		JPanel p46 = new JPanel();
		p46.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p46);
		p46.setLayout(new BorderLayout(0, 0));
		
		JButton b46 = new JButton("");
		p46.add(b46, BorderLayout.CENTER);
		
		JPanel p50 = new JPanel();
		p50.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p50);
		p50.setLayout(new BorderLayout(0, 0));
		
		JButton b50 = new JButton("");
		p50.add(b50, BorderLayout.CENTER);
		
		JPanel p51 = new JPanel();
		p51.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p51);
		p51.setLayout(new BorderLayout(0, 0));
		
		JButton b51 = new JButton("");
		p51.add(b51, BorderLayout.CENTER);
		
		JPanel p52 = new JPanel();
		p52.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p52);
		p52.setLayout(new BorderLayout(0, 0));
		
		JButton b52 = new JButton("");
		p52.add(b52, BorderLayout.CENTER);
		
		JPanel p53 = new JPanel();
		p53.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p53);
		p53.setLayout(new BorderLayout(0, 0));
		
		JButton b53 = new JButton("");
		p53.add(b53, BorderLayout.CENTER);
		
		JPanel p54 = new JPanel();
		p54.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p54);
		p54.setLayout(new BorderLayout(0, 0));
		
		JButton b54 = new JButton("");
		p54.add(b54, BorderLayout.CENTER);
		
		JPanel p55 = new JPanel();
		p55.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p55);
		p55.setLayout(new BorderLayout(0, 0));
		
		JButton b55 = new JButton("");
		p55.add(b55, BorderLayout.CENTER);
		
		JPanel p56 = new JPanel();
		p56.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p56);
		p56.setLayout(new BorderLayout(0, 0));
		
		JButton b56 = new JButton("");
		p56.add(b56, BorderLayout.CENTER);
		
		JPanel p60 = new JPanel();
		p60.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p60);
		p60.setLayout(new BorderLayout(0, 0));
		
		JButton b60 = new JButton("");
		p60.add(b60, BorderLayout.CENTER);
		
		JPanel p61 = new JPanel();
		p61.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p61);
		p61.setLayout(new BorderLayout(0, 0));
		
		JButton b61 = new JButton("");
		p61.add(b61, BorderLayout.CENTER);
		
		JPanel p62 = new JPanel();
		p62.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p62);
		p62.setLayout(new BorderLayout(0, 0));
		
		JButton b62 = new JButton("");
		p62.add(b62, BorderLayout.CENTER);
		
		JPanel p63 = new JPanel();
		p63.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p63);
		p63.setLayout(new BorderLayout(0, 0));
		
		JButton b63 = new JButton("");
		p63.add(b63, BorderLayout.CENTER);
		
		JPanel p64 = new JPanel();
		p64.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p64);
		p64.setLayout(new BorderLayout(0, 0));
		
		JButton b64 = new JButton("");
		p64.add(b64, BorderLayout.CENTER);
		
		JPanel p65 = new JPanel();
		p65.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p65);
		p65.setLayout(new BorderLayout(0, 0));
		
		JButton b65 = new JButton("");
		p65.add(b65, BorderLayout.CENTER);
		
		JPanel p66 = new JPanel();
		p66.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p66);
		p66.setLayout(new BorderLayout(0, 0));
		
		JButton b66 = new JButton("");
		p66.add(b66, BorderLayout.CENTER);
		
		JPanel p70 = new JPanel();
		p70.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p70);
		p70.setLayout(new BorderLayout(0, 0));
		
		JButton b70 = new JButton("");
		p70.add(b70, BorderLayout.CENTER);
		
		JPanel p71 = new JPanel();
		p71.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p71);
		p71.setLayout(new BorderLayout(0, 0));
		
		JButton b71 = new JButton("");
		p71.add(b71, BorderLayout.CENTER);
		
		JPanel p72 = new JPanel();
		p72.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p72);
		p72.setLayout(new BorderLayout(0, 0));
		
		JButton b72 = new JButton("");
		p72.add(b72, BorderLayout.CENTER);
		
		JPanel p73 = new JPanel();
		p73.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p73);
		p73.setLayout(new BorderLayout(0, 0));
		
		JButton b73 = new JButton("");
		p73.add(b73, BorderLayout.CENTER);
		
		JPanel p74 = new JPanel();
		p74.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p74);
		p74.setLayout(new BorderLayout(0, 0));
		
		JButton b74 = new JButton("");
		p74.add(b74, BorderLayout.CENTER);
		
		JPanel p75 = new JPanel();
		p75.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p75);
		p75.setLayout(new BorderLayout(0, 0));
		
		JButton b75 = new JButton("");
		p75.add(b75, BorderLayout.CENTER);
		
		JPanel p76 = new JPanel();
		p76.setBorder(new LineBorder(new Color(0, 0, 0)));
		board.add(p76);
		p76.setLayout(new BorderLayout(0, 0));
		
		JButton b76 = new JButton("");
		p76.add(b76, BorderLayout.CENTER);
	}

}

package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import controller.MainController;
import java.awt.Color;
import javax.swing.JTextArea;

public class Main {
	
	public JFrame frame;
	
	public Main() {
		initialize();
	}
	
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 495, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		JPanel board = new JPanel();
		board.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(board, BorderLayout.CENTER);
		board.setLayout(new GridLayout(0, 5, 0, 0));
		
			JPanel p10 = new JPanel();
			p10.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p10);
			p10.setLayout(new BorderLayout(0, 0));
			
			    JButton b10 = new JButton("");
				b10.setIcon(MainController.displayImg(0, 0));
				p10.add(b10, BorderLayout.CENTER);
				b10.setBackground(MainController.changeButtonColour(0, 0));
				b10.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(0, 0);
						b10.setBackground(MainController.changeButtonColour(0, 0));
						return;
					}});
			
			JPanel p11 = new JPanel();
			p11.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p11);
			p11.setLayout(new BorderLayout(0, 0));
			
				JButton b11 = new JButton("");
				b11.setBackground(Color.WHITE);
				b11.setIcon(MainController.displayImg(0, 1));
				p11.add(b11, BorderLayout.CENTER);
				b11.setBackground(MainController.changeButtonColour(0, 1));
				b11.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(0, 1);
						b11.setBackground(MainController.changeButtonColour(0, 1));
						return;
					}});
			
			JPanel p12 = new JPanel();
			p12.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p12);
			p12.setLayout(new BorderLayout(0, 0));
			
				JButton b12 = new JButton("");
				b12.setIcon(MainController.displayImg(0, 2));
				p12.add(b12, BorderLayout.CENTER);
				b12.setBackground(MainController.changeButtonColour(0, 2));
				b12.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(0, 2);
						b12.setBackground(MainController.changeButtonColour(0, 2));
						return;
					}});
			
			JPanel p13 = new JPanel();
			p13.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p13);
			p13.setLayout(new BorderLayout(0, 0));
			
				JButton b13 = new JButton("");
				b13.setIcon(MainController.displayImg(0, 3));
				p13.add(b13, BorderLayout.CENTER);
				b13.setBackground(MainController.changeButtonColour(0, 3));
				b13.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(0, 3);
						b13.setBackground(MainController.changeButtonColour(0, 3));
						return;
					}});
			
			JPanel p14 = new JPanel();
			p14.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p14);
			p14.setLayout(new BorderLayout(0, 0));
			
				JButton b14 = new JButton("");
				b14.setIcon(MainController.displayImg(0, 4));
				p14.add(b14, BorderLayout.CENTER);
				b14.setBackground(MainController.changeButtonColour(0, 4));
				b14.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(0, 4);
						b14.setBackground(MainController.changeButtonColour(0, 4));
						return;
					}});
			
			JPanel p20 = new JPanel();
			p20.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p20);
			p20.setLayout(new BorderLayout(0, 0));
			
				JButton b20 = new JButton("");
				b20.setIcon(MainController.displayImg(1, 0));
				p20.add(b20, BorderLayout.CENTER);
				b20.setBackground(MainController.changeButtonColour(1, 0));
				b20.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(1, 0);
						b20.setBackground(MainController.changeButtonColour(1, 0));
						return;
					}});
			
			JPanel p21 = new JPanel();
			p21.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p21);
			p21.setLayout(new BorderLayout(0, 0));
			
				JButton b21 = new JButton("");
				b21.setIcon(MainController.displayImg(1, 1));
				p21.add(b21, BorderLayout.CENTER);
				b21.setBackground(MainController.changeButtonColour(1, 1));
				b21.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(1, 1);
						b21.setBackground(MainController.changeButtonColour(1, 1));
						return;
					}});
			
			JPanel p22 = new JPanel();
			p22.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p22);
			p22.setLayout(new BorderLayout(0, 0));
			
			
				JButton b22 = new JButton("");
				b22.setIcon(MainController.displayImg(1, 2));
				p22.add(b22, BorderLayout.CENTER);
				b22.setBackground(MainController.changeButtonColour(1, 2));
				b22.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(1, 2);
						b22.setBackground(MainController.changeButtonColour(1, 2));
						return;
					}});
			
			JPanel p23 = new JPanel();
			p23.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p23);
			p23.setLayout(new BorderLayout(0, 0));
			
				JButton b23 = new JButton("");
				b23.setIcon(MainController.displayImg(1, 3));
				p23.add(b23, BorderLayout.CENTER);
				b23.setBackground(MainController.changeButtonColour(1, 3));
				b23.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(1, 3);
						b23.setBackground(MainController.changeButtonColour(1, 3));
						return;
					}});
				
				
			
			JPanel p24 = new JPanel();
			p24.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p24);
			p24.setLayout(new BorderLayout(0, 0));
			
				JButton b24 = new JButton("");
				b24.setIcon(MainController.displayImg(1, 4));
				p24.add(b24, BorderLayout.CENTER);
				b24.setBackground(MainController.changeButtonColour(1, 4));
				b24.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(1, 4);
						b24.setBackground(MainController.changeButtonColour(1, 4));
						return;
					}});
			
			JPanel p30 = new JPanel();
			p30.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p30);
			p30.setLayout(new BorderLayout(0, 0));
			
				JButton b30 = new JButton("");
				b30.setIcon(MainController.displayImg(2, 0));
				p30.add(b30, BorderLayout.CENTER);
				b30.setBackground(MainController.changeButtonColour(2, 0));
				b30.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(2, 0);
						b30.setBackground(MainController.changeButtonColour(2, 0));
						return;
					}});
			
			JPanel p31 = new JPanel();
			p31.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p31);
			p31.setLayout(new BorderLayout(0, 0));
			
				JButton b31 = new JButton("");
				b31.setIcon(MainController.displayImg(2, 1));
				p31.add(b31, BorderLayout.CENTER);
				b31.setBackground(MainController.changeButtonColour(2, 1));
				b31.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(2, 1);
						b31.setBackground(MainController.changeButtonColour(2, 1));
						return;
					}});
			
			JPanel p32 = new JPanel();
			p32.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p32);
			p32.setLayout(new BorderLayout(0, 0));
			
				JButton b32 = new JButton("");
				b32.setIcon(MainController.displayImg(2, 2));
				p32.add(b32, BorderLayout.CENTER);
				b32.setBackground(MainController.changeButtonColour(2, 2));
				b32.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(2, 2);
						b32.setBackground(MainController.changeButtonColour(2, 2));
						return;
					}});
			
			JPanel p33 = new JPanel();
			p33.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p33);
			p33.setLayout(new BorderLayout(0, 0));
			
				JButton b33 = new JButton("");
				b33.setIcon(MainController.displayImg(2, 3));
				p33.add(b33, BorderLayout.CENTER);
				b33.setBackground(MainController.changeButtonColour(2, 3));
				b33.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(2, 3);
						b33.setBackground(MainController.changeButtonColour(2, 3));
						return;
					}});
			
			JPanel p34 = new JPanel();
			p34.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p34);
			p34.setLayout(new BorderLayout(0, 0));
			
				JButton b34 = new JButton("");
				b34.setIcon(MainController.displayImg(2, 4));
				p34.add(b34, BorderLayout.CENTER);
				b34.setBackground(MainController.changeButtonColour(2, 4));
				b34.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(2, 4);
						b34.setBackground(MainController.changeButtonColour(2, 4));
						return;
					}});
				
			
			JPanel p40 = new JPanel();
			p40.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p40);
			p40.setLayout(new BorderLayout(0, 0));
			
				JButton b40 = new JButton("");
				b40.setIcon(MainController.displayImg(3, 0));
				p40.add(b40, BorderLayout.CENTER);
				b40.setBackground(MainController.changeButtonColour(3, 0));
				b40.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(3, 0);
						b40.setBackground(MainController.changeButtonColour(3, 0));
						return;
					}});
			
			JPanel p41 = new JPanel();
			p41.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p41);
			p41.setLayout(new BorderLayout(0, 0));
			
				JButton b41 = new JButton("");
				b41.setIcon(MainController.displayImg(3, 1));
				p41.add(b41, BorderLayout.CENTER);
				b41.setBackground(MainController.changeButtonColour(3, 1));
				b41.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(3, 1);
						b41.setBackground(MainController.changeButtonColour(3, 1));
						return;
					}});
			
			JPanel p42 = new JPanel();
			p42.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p42);
			p42.setLayout(new BorderLayout(0, 0));
			
				JButton b42 = new JButton("");
				b42.setIcon(MainController.displayImg(3, 2));
				p42.add(b42, BorderLayout.CENTER);
				b42.setBackground(MainController.changeButtonColour(3, 2));
				b42.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(3, 2);
						b42.setBackground(MainController.changeButtonColour(3, 2));
						return;
					}});
			
			JPanel p43 = new JPanel();
			p43.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p43);
			p43.setLayout(new BorderLayout(0, 0));
			
				JButton b43 = new JButton("");
				b43.setIcon(MainController.displayImg(3, 3));
				p43.add(b43, BorderLayout.CENTER);
				b43.setBackground(MainController.changeButtonColour(3, 3));
				b43.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(3, 3);
						b43.setBackground(MainController.changeButtonColour(3, 3));
						return;
					}});
			
			JPanel p44 = new JPanel();
			p44.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p44);
			p44.setLayout(new BorderLayout(0, 0));
			
				JButton b44 = new JButton("");
				b44.setIcon(MainController.displayImg(3, 4));
				p44.add(b44, BorderLayout.CENTER);
				b44.setBackground(MainController.changeButtonColour(3, 4));
				b44.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(3, 4);
						b44.setBackground(MainController.changeButtonColour(3, 4));
						return;
					}});
			
			JPanel p50 = new JPanel();
			p50.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p50);
			p50.setLayout(new BorderLayout(0, 0));
			
				JButton b50 = new JButton("");
				b50.setIcon(MainController.displayImg(4, 0));
				p50.add(b50, BorderLayout.CENTER);
				b50.setBackground(MainController.changeButtonColour(4, 0));
				b50.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(4, 0);
						b50.setBackground(MainController.changeButtonColour(4, 0));
						return;
					}});
			
			JPanel p51 = new JPanel();
			p51.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p51);
			p51.setLayout(new BorderLayout(0, 0));
			
				JButton b51 = new JButton("");
				b51.setIcon(MainController.displayImg(4, 1));
				p51.add(b51, BorderLayout.CENTER);
				b51.setBackground(MainController.changeButtonColour(4, 1));
				b51.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(4, 1);
						b51.setBackground(MainController.changeButtonColour(4, 1));
						return;
					}});
				
			
			JPanel p52 = new JPanel();
			p52.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p52);
			p52.setLayout(new BorderLayout(0, 0));
			
				JButton b52 = new JButton("");
				b52.setIcon(MainController.displayImg(4, 2));
				p52.add(b52, BorderLayout.CENTER);
				b52.setBackground(MainController.changeButtonColour(4, 2));
				b52.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(4, 2);
						b52.setBackground(MainController.changeButtonColour(4, 2));
						return;
					}});
			
			JPanel p53 = new JPanel();
			p53.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p53);
			p53.setLayout(new BorderLayout(0, 0));
			
				JButton b53 = new JButton("");
				b53.setIcon(MainController.displayImg(4, 3));
				p53.add(b53, BorderLayout.CENTER);
				b53.setBackground(MainController.changeButtonColour(4, 3));
				b53.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(4, 3);
						b53.setBackground(MainController.changeButtonColour(4, 3));
						return;
					}});
			
			JPanel p54 = new JPanel();
			p54.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p54);
			p54.setLayout(new BorderLayout(0, 0));
			
				JButton b54 = new JButton("");
				b54.setIcon(MainController.displayImg(4, 4));
				p54.add(b54, BorderLayout.CENTER);
				b54.setBackground(MainController.changeButtonColour(4, 4));
				b54.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(4, 4);
						b54.setBackground(MainController.changeButtonColour(4, 4));
						return;
					}});
			
			JPanel p60 = new JPanel();
			p60.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p60);
			p60.setLayout(new BorderLayout(0, 0));
			
				JButton b60 = new JButton("");
				b60.setIcon(MainController.displayImg(5, 0));
				p60.add(b60, BorderLayout.CENTER);
				b60.setBackground(MainController.changeButtonColour(5, 0));
				b60.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(5, 0);
						b60.setBackground(MainController.changeButtonColour(5, 0));
						return;
					}});
			
			JPanel p61 = new JPanel();
			p61.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p61);
			p61.setLayout(new BorderLayout(0, 0));
			
				JButton b61 = new JButton("");
				b61.setIcon(MainController.displayImg(5, 1));
				p61.add(b61, BorderLayout.CENTER);
				b61.setBackground(MainController.changeButtonColour(5, 1));
				b61.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(5, 1);
						b61.setBackground(MainController.changeButtonColour(5, 1));
						return;
					}});
				
			JPanel p62 = new JPanel();
			p62.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p62);
			p62.setLayout(new BorderLayout(0, 0));
			
				JButton b62 = new JButton("");
				b62.setIcon(MainController.displayImg(5, 2));
				p62.add(b62, BorderLayout.CENTER);
				b62.setBackground(MainController.changeButtonColour(5, 2));
				b62.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(5, 2);
						b62.setBackground(MainController.changeButtonColour(5, 2));
						return;
					}});
			
			JPanel p63 = new JPanel();
			p63.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p63);
			p63.setLayout(new BorderLayout(0, 0));
			
				JButton b63 = new JButton("");
				b63.setIcon(MainController.displayImg(5, 3));
				p63.add(b63, BorderLayout.CENTER);
				b63.setBackground(MainController.changeButtonColour(5, 3));
				b63.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(5, 3);
						b63.setBackground(MainController.changeButtonColour(5, 3));
						return;
					}});
			
			JPanel p64 = new JPanel();
			p64.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p64);
			p64.setLayout(new BorderLayout(0, 0));
			
				JButton b64 = new JButton("");
				b64.setIcon(MainController.displayImg(5, 4));
				p64.add(b64, BorderLayout.CENTER);
				b64.setBackground(MainController.changeButtonColour(5, 4));
				b64.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(5, 4);
						b64.setBackground(MainController.changeButtonColour(5, 4));
						return;
					}});
			
			JPanel p70 = new JPanel();
			p70.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p70);
			p70.setLayout(new BorderLayout(0, 0));
			
				JButton b70 = new JButton("");
				b70.setIcon(MainController.displayImg(6, 0));
				p70.add(b70, BorderLayout.CENTER);
				b70.setBackground(MainController.changeButtonColour(6, 0));
				b70.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(6, 0);
						b70.setBackground(MainController.changeButtonColour(6, 0));
						return;
					}});
			
			JPanel p71 = new JPanel();
			p71.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p71);
			p71.setLayout(new BorderLayout(0, 0));
			
				JButton b71 = new JButton("");
				b71.setIcon(MainController.displayImg(6, 1));
				p71.add(b71, BorderLayout.CENTER);
				b71.setBackground(MainController.changeButtonColour(6, 1));
				b71.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(6, 1);
						b71.setBackground(MainController.changeButtonColour(6, 1));
						return;
					}});
			
			JPanel p72 = new JPanel();
			p72.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p72);
			p72.setLayout(new BorderLayout(0, 0));
			
				JButton b72 = new JButton("");
				b72.setIcon(MainController.displayImg(6, 2));
				p72.add(b72, BorderLayout.CENTER);
				b72.setBackground(MainController.changeButtonColour(6, 2));
				b72.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(6, 2);
						b72.setBackground(MainController.changeButtonColour(6, 2));
						return;
					}});
			
			JPanel p73 = new JPanel();
			p73.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p73);
			p73.setLayout(new BorderLayout(0, 0));
			
				JButton b73 = new JButton("");
				b73.setIcon(MainController.displayImg(6, 3));
				p73.add(b73, BorderLayout.CENTER);
				b73.setBackground(MainController.changeButtonColour(6, 3));
				b73.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(6, 3);
						b73.setBackground(MainController.changeButtonColour(6, 3));
						return;
					}});
			
			JPanel p74 = new JPanel();
			p74.setBorder(new LineBorder(new Color(0, 0, 0)));
			board.add(p74);
			p74.setLayout(new BorderLayout(0, 0));
			
				JButton b74 = new JButton("");
				b74.setIcon(MainController.displayImg(6, 4));
				p74.add(b74, BorderLayout.CENTER);
				b74.setBackground(MainController.changeButtonColour(6, 4));
				b74.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController.select(6, 4);
						b74.setBackground(MainController.changeButtonColour(6, 4));
						return;
					}});
				
				JPanel userPanel = new JPanel();
				frame.getContentPane().add(userPanel, BorderLayout.WEST);
				userPanel.setLayout(new GridLayout(0, 1, 0, 0));
				
				
				JPanel infoPanel = new JPanel();
				userPanel.add(infoPanel);
				infoPanel.setLayout(new GridLayout(3, 3, 0, 0));
				
					JLabel unitHealth = new JLabel("Unit Health");
					infoPanel.add(unitHealth);
					
					JTextArea textArea_1 = new JTextArea();
					infoPanel.add(textArea_1);
					
					JLabel movesLeft = new JLabel("Moves left");
					infoPanel.add(movesLeft);
					
					JTextArea textArea = new JTextArea();
					infoPanel.add(textArea);
					
					JLabel turnStatus = new JLabel("Turn");
					infoPanel.add(turnStatus);
					
					JTextArea turnDisplay = new JTextArea();
					turnDisplay.setText(MainController.displayTurn());
					infoPanel.add(turnDisplay);
				
				JPanel statusPanel = new JPanel();
				userPanel.add(statusPanel);
					
					JLabel status = new JLabel("Status");
					statusPanel.add(status);
				
					JButton moveButton = new JButton("Move");
					userPanel.add(moveButton);
					moveButton.addActionListener(new ActionListener () {
						@Override
						public void actionPerformed(ActionEvent e) {
							MainController.move();
						
							MainController.resetSquares();
							//refresh all squares
							b10.setIcon(MainController.displayImg(0, 0));
							b11.setIcon(MainController.displayImg(0, 1));
							b12.setIcon(MainController.displayImg(0, 2));
							b13.setIcon(MainController.displayImg(0, 3));
							b14.setIcon(MainController.displayImg(0, 4));
							b20.setIcon(MainController.displayImg(1, 0));
							b21.setIcon(MainController.displayImg(1, 1));
							b22.setIcon(MainController.displayImg(1, 2));
							b23.setIcon(MainController.displayImg(1, 3));
							b24.setIcon(MainController.displayImg(1, 4));
							b30.setIcon(MainController.displayImg(2, 0));
							b31.setIcon(MainController.displayImg(2, 1));
							b32.setIcon(MainController.displayImg(2, 2));
							b33.setIcon(MainController.displayImg(2, 3));
							b34.setIcon(MainController.displayImg(2, 4));
							b40.setIcon(MainController.displayImg(3, 0));
							b41.setIcon(MainController.displayImg(3, 1));
							b42.setIcon(MainController.displayImg(3, 2));
							b43.setIcon(MainController.displayImg(3, 3));
							b44.setIcon(MainController.displayImg(3, 4));
							b50.setIcon(MainController.displayImg(4, 0));
							b51.setIcon(MainController.displayImg(4, 1));
							b52.setIcon(MainController.displayImg(4, 2));
							b53.setIcon(MainController.displayImg(4, 3));
							b54.setIcon(MainController.displayImg(4, 4));
							b60.setIcon(MainController.displayImg(5, 0));
							b61.setIcon(MainController.displayImg(5, 1));
							b62.setIcon(MainController.displayImg(5, 2));
							b63.setIcon(MainController.displayImg(5, 3));
							b64.setIcon(MainController.displayImg(5, 4));
							b70.setIcon(MainController.displayImg(6, 0));
							b71.setIcon(MainController.displayImg(6, 1));
							b72.setIcon(MainController.displayImg(6, 2));
							b73.setIcon(MainController.displayImg(6, 3));
							b74.setIcon(MainController.displayImg(6, 4));
							b10.setBackground(MainController.changeButtonColour(0, 0));
							b11.setBackground(MainController.changeButtonColour(0, 1));
							b12.setBackground(MainController.changeButtonColour(0, 2));
							b13.setBackground(MainController.changeButtonColour(0, 3));
							b14.setBackground(MainController.changeButtonColour(0, 4));
							b20.setBackground(MainController.changeButtonColour(1, 0));
							b21.setBackground(MainController.changeButtonColour(1, 1));
							b22.setBackground(MainController.changeButtonColour(1, 2));
							b23.setBackground(MainController.changeButtonColour(1, 3));
							b24.setBackground(MainController.changeButtonColour(1, 4));
							b30.setBackground(MainController.changeButtonColour(2, 0));
							b31.setBackground(MainController.changeButtonColour(2, 1));
							b32.setBackground(MainController.changeButtonColour(2, 2));
							b33.setBackground(MainController.changeButtonColour(2, 3));
							b34.setBackground(MainController.changeButtonColour(2, 4));
							b40.setBackground(MainController.changeButtonColour(3, 0));
							b41.setBackground(MainController.changeButtonColour(3, 1));
							b42.setBackground(MainController.changeButtonColour(3, 2));
							b43.setBackground(MainController.changeButtonColour(3, 3));
							b44.setBackground(MainController.changeButtonColour(3, 4));
							b50.setBackground(MainController.changeButtonColour(4, 0));
							b51.setBackground(MainController.changeButtonColour(4, 1));
							b52.setBackground(MainController.changeButtonColour(4, 2));
							b53.setBackground(MainController.changeButtonColour(4, 3));
							b54.setBackground(MainController.changeButtonColour(4, 4));
							b60.setBackground(MainController.changeButtonColour(5, 0));
							b61.setBackground(MainController.changeButtonColour(5, 1));
							b62.setBackground(MainController.changeButtonColour(5, 2));
							b63.setBackground(MainController.changeButtonColour(5, 3));
							b64.setBackground(MainController.changeButtonColour(5, 4));
							b70.setBackground(MainController.changeButtonColour(6, 0));
							b71.setBackground(MainController.changeButtonColour(6, 1));
							b72.setBackground(MainController.changeButtonColour(6, 2));
							b73.setBackground(MainController.changeButtonColour(6, 3));
							b74.setBackground(MainController.changeButtonColour(6, 4));
							turnDisplay.setText(MainController.displayTurn());
							
							
							}});
			
					JButton spellButton = new JButton("Cast Spell");
					userPanel.add(spellButton);
					
					JButton turnButton = new JButton("Finish Turn");
					userPanel.add(turnButton);
				
					
	}			
}

package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import AI.AI;
import AI.Win;
import java.awt.Font;

@SuppressWarnings("serial")
public class Mainframe extends JFrame {

	private JButton btnButtonp2, btnButtonp1, btnPlayer1, btnPlayer2, btnBack;
	private JLabel lbplayer1, lbplayer2, lbTitle;
	private int tal1, tal2;
	private Controller controller;
	private Controller2 controller2;
	private ArrayList<JButton> aButton = new ArrayList<JButton>();
	private ArrayList<JButton> bButton = new ArrayList<JButton>();
	private boolean player2 = false;
	private boolean ai2 = false;
	private ImageIcon ks = (new ImageIcon(getClass().getResource("image/ks.jpg")));
	private ImageIcon cirkel = (new ImageIcon(getClass().getResource("image/cirkel.jpg")));
	private ImageIcon black = (new ImageIcon(getClass().getResource("image/black.jpg")));

	public Mainframe(){
		this.setTitle("Tac Tic");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(400, 200);
		this.setSize(415, 475);
		getContentPane().setLayout(null);
		controller = new Controller();
		controller2 = new Controller2();

		lbplayer1 = new JLabel("Player 1 wins: "+tal1);
		lbplayer1.setVisible(false);
		lbplayer1.setLocation(50, 15);
		lbplayer1.setSize(100, 25);
		getContentPane().add(lbplayer1);

		lbplayer2 = new JLabel("Player 2 wins: "+tal2);
		lbplayer2.setLocation(250, 15);
		lbplayer2.setVisible(false);
		lbplayer2.setSize(100, 25);
		getContentPane().add(lbplayer2);

		btnPlayer1 = new JButton("1 Player");
		btnPlayer1.setLocation(50, 200);
		btnPlayer1.setSize(100, 25);
		getContentPane().add(btnPlayer1);
		btnPlayer1.addActionListener(controller2);

		btnPlayer2 = new JButton("2 Player");
		btnPlayer2.setLocation(250, 200);
		btnPlayer2.setSize(100, 25);
		getContentPane().add(btnPlayer2);
		btnPlayer2.addActionListener(controller);

		btnBack = new JButton("Back");
		btnBack.setLocation(150, 380);
		btnBack.setSize(100, 25);
		getContentPane().add(btnBack);
		
		lbTitle = new JLabel("Tac Tic Toe");
		lbTitle.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lbTitle.setBounds(125, 61, 147, 25);
		getContentPane().add(lbTitle);
		btnBack.setVisible(false);
		btnBack.addActionListener(controller2);

		int sx = 50;
		int sy = 50;
		for(int x = 1; x <= 9;x++){	
			btnButtonp2 = new JButton(black);
			btnButtonp2.setLocation(sx, sy);
			btnButtonp2.setSize(100, 100);
			getContentPane().add(btnButtonp2);
			btnButtonp2.setVisible(false);
			btnButtonp2.addActionListener(controller);
			aButton.add(btnButtonp2);
			if(x <= 2){sx += 100;}
			else if(x == 3){sy = 150; sx = 50;}
			else if(x <= 5){sx += 100;}
			else if(x == 6){sy = 250; sx = 50;}
			else if(x <= 8){sx += 100;}
		}
		sx = 50;
		sy = 50;
		for(int x = 1; x <= 9;x++){	
			btnButtonp1 = new JButton(black);
			btnButtonp1.setLocation(sx, sy);
			btnButtonp1.setSize(100, 100);
			btnButtonp1.setVisible(false);
			getContentPane().add(btnButtonp1);
			btnButtonp1.addActionListener(controller2);
			bButton.add(btnButtonp1);
			if(x <= 2){sx += 100;}
			else if(x == 3){sy = 150; sx = 50;}
			else if(x <= 5){sx += 100;}
			else if(x == 6){sy = 250; sx = 50;}
			else if(x <= 8){sx += 100;}
		}
	}
	private class Controller implements ActionListener {
		public int getBlack(){
			int x = 0;
			for(JButton b : aButton){
				if(b.getIcon() == black)
					x++;
			}
			return x;
		}
		public void clearB(){
			for(JButton b : aButton){
				b.setIcon(black);
			}
		}
		public void clearA(){
			if(getBlack() == 0){
				JOptionPane.showMessageDialog(Mainframe.this, "Draw");
				clearB();
				ai2 = false;
			}
		}
		public void findWin(){
			if(Win.win(aButton,ks,cirkel) == "ks"){
				JOptionPane.showMessageDialog(Mainframe.this, "Player 1 Win");
				tal1++;
				lbplayer1.setText("Player 1 wins: "+tal1);
				clearB();
			}
			else if(Win.win(aButton,ks,cirkel) == "cirkel"){
				JOptionPane.showMessageDialog(Mainframe.this, "Player 2 Win");
				tal2++;
				lbplayer2.setText("Player 2 wins: "+tal2);
				clearB();
			}
		}
		@Override
		public void actionPerformed(ActionEvent a) {
			for(int x = 0; x <= aButton.size()-1; x++){
				if(a.getSource() == aButton.get(x)){
					if(aButton.get(x).getIcon() != ks && aButton.get(x).getIcon() != cirkel ){
						if(player2){
							aButton.get(x).setIcon(ks);
							player2 = false;
							findWin();
							clearA();
						}
						else{
							aButton.get(x).setIcon(cirkel);
							player2 = true;
							findWin();
							clearA();
						}
					}
				}
			}
			if(a.getSource() == btnPlayer2){
				for(int x = 0; x <= aButton.size()-1; x++){
					lbplayer2.setVisible(true);
					lbplayer1.setVisible(true);
					lbplayer2.setText("Player 2 wins: "+tal2);
					lbplayer1.setText("Player 1 wins: "+tal1);
					btnPlayer1.setVisible(false);
					btnPlayer2.setVisible(false);
					aButton.get(x).setVisible(true);
					btnBack.setVisible(true);
					lbTitle.setVisible(false);
				}
			}
		}
	}
	private class Controller2 implements ActionListener {
		public ArrayList<JButton> getArray(){
			return new ArrayList<JButton>(bButton);
		}
		public int getBlack(){
			int x = 0;
			for(JButton b : bButton){
				if(b.getIcon() == black)
					x++;
			}
			return x;
		}
		public void clearB(){
			for(JButton b : bButton){
				b.setIcon(black);
			}
		}
		public void clearA(){
			if(getBlack() == 0){
				JOptionPane.showMessageDialog(Mainframe.this, "Draw");
				clearB();
				ai2 = false;
				System.out.println("AI<reset>");
			}
		}
		public void findWin(){
			if(Win.win(bButton,ks,cirkel) == "ks"){
				JOptionPane.showMessageDialog(Mainframe.this, "You Win");
				tal1++;
				lbplayer1.setText("Player wins: "+tal1);
				clearB();
				ai2 = false;
				System.out.println("Player Won");
				System.out.println("New Game....AI adds new data");
			}
			else if(Win.win(bButton,ks,cirkel) == "cirkel"){
				JOptionPane.showMessageDialog(Mainframe.this, "AI Win");
				tal2++;
				lbplayer2.setText("AI wins: "+tal2);
				clearB();
				ai2 = false;
				System.out.println("AI Won");
				System.out.println("New Game AI<Reset>");
			}
		}
		@Override
		public void actionPerformed(ActionEvent a) {
			for(int x = 0; x <= bButton.size()-1; x++){
				if(a.getSource() == bButton.get(x)){
					if(bButton.get(x).getIcon() != ks && bButton.get(x).getIcon() != cirkel){
						bButton.get(x).setIcon(ks);
						findWin();
						clearA();

						//AI----------------------------------------------
						if(!ai2){bButton.get(AI.Start(getArray(), ks, cirkel, black)).setIcon(cirkel); ai2 = true; }
						else if( AI.AiWin(bButton, ks, cirkel, black) != 10){
							System.out.println("AI use P1: "+AI.AiWin(getArray(), ks, cirkel, black));
							bButton.get(AI.AiWin(bButton, ks, cirkel, black)).setIcon(cirkel);
							}
						else if(AI.PWin(bButton, ks, cirkel, black) != 10){
							System.out.println("AI use P2: "+AI.PWin(getArray(), ks, cirkel, black));
							bButton.get(AI.PWin(bButton, ks, cirkel, black)).setIcon(cirkel);
							}
						else {bButton.get(AI.Start(getArray(), ks, cirkel, black)).setIcon(cirkel);}
						//AI----------------------------------------------

						findWin();
						clearA();
					}

				}
			}
			if(a.getSource() == btnPlayer1){
				for(int x = 0; x <= aButton.size()-1; x++){
					lbplayer2.setVisible(true);
					lbplayer2.setText("AI wins: "+tal2);
					lbplayer1.setText("Player wins: "+tal1);
					lbplayer1.setVisible(true);
					btnPlayer1.setVisible(false);
					btnPlayer2.setVisible(false);
					bButton.get(x).setVisible(true);
					btnBack.setVisible(true);
					lbTitle.setVisible(false);
				}
			}
			else if(a.getSource() == btnBack){
				for(int x = 0; x <= aButton.size()-1; x++){
					lbplayer2.setVisible(false);
					lbplayer1.setVisible(false);
					btnPlayer1.setVisible(true);
					btnPlayer2.setVisible(true);
					bButton.get(x).setVisible(false);
					aButton.get(x).setVisible(false);
					btnBack.setVisible(false);
					lbTitle.setVisible(true);
					tal1 = 0;
					tal2 = 0;
				}
			}
		}
	}
}

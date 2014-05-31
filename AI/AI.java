package AI;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AI {
	private static Random randomGenerator = new Random();
	
//Start----------------------------------------
	public static int Start(ArrayList<JButton> array,ImageIcon ks, ImageIcon cirkel, ImageIcon black){
		int random = randomGenerator.nextInt(9);
		int set = 0;
		boolean free = false;
		while(!free){
			if(array.get(random).getIcon() == black){
				free = true;
				set = random;
			}
			random = randomGenerator.nextInt(9);
		}
		System.out.println("AI Random: " +set);
		return set;
	}
	
//p1----------------------------------------
	public static int AiWin(ArrayList<JButton> array,ImageIcon ks, ImageIcon cirkel, ImageIcon black){		
		ArrayList<JButton> ai = new ArrayList<JButton>(array);
		int set = 10;
		int x = 0;
		boolean win = false;
		while(!win && x < ai.size()){
			if(ai.get(x).getIcon() == black ){
				ai.get(x).setIcon(cirkel);
				if(Win.win(ai, ks, cirkel) == "cirkel"){
					set = x;
					ai.get(x).setIcon(black);
					win = true;
				}
				else{
					ai.get(x).setIcon(black);
				}
			}
			
			x++;
		}
		return set;
	}
//p2-----------------------------------------
	public static int PWin(ArrayList<JButton> array,ImageIcon ks, ImageIcon cirkel, ImageIcon black){		
		ArrayList<JButton> ai = new ArrayList<JButton>(array);
		int set = 10;
		int x = 0;
		boolean win = false;
		while(!win && x < ai.size()){
			if(ai.get(x).getIcon() == black ){
				ai.get(x).setIcon(ks);
				if(Win.win(ai, ks, cirkel) == "ks"){
					set = x;
					ai.get(x).setIcon(black);
					win = true;
				}
				else{
					ai.get(x).setIcon(black);
				}
			}
			x++;
		}
		return set;
	}
}
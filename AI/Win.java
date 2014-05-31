package AI;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Win {
	
	public static String win(ArrayList<JButton> array,ImageIcon ks, ImageIcon cirkel ){
		String win = "ingen";
//KS------------------------------------------------
		//henad
		if(array.get(0).getIcon() == ks && array.get(1).getIcon() == ks && array.get(2).getIcon() == ks){
			win = "ks";
		}
		else if(array.get(3).getIcon() == ks && array.get(4).getIcon() == ks && array.get(5).getIcon() == ks){
			win = "ks";
		}
		else if(array.get(6).getIcon() == ks && array.get(7).getIcon() == ks && array.get(8).getIcon() == ks){
			win = "ks";
		}
		//nedad
		else if(array.get(0).getIcon() == ks && array.get(3).getIcon() == ks && array.get(6).getIcon() == ks){
			win = "ks";
		}
		else if(array.get(1).getIcon() == ks && array.get(4).getIcon() == ks && array.get(7).getIcon() == ks){
			win = "ks";
		}
		else if(array.get(2).getIcon() == ks && array.get(5).getIcon() == ks && array.get(8).getIcon() == ks){
			win = "ks";
		}
		//andet
		else if(array.get(0).getIcon() == ks && array.get(4).getIcon() == ks && array.get(8).getIcon() == ks){
			win = "ks";
		}
		else if(array.get(6).getIcon() == ks && array.get(4).getIcon() == ks && array.get(2).getIcon() == ks){
			win = "ks";
		}
//Cirkel---------------------------------------------
		//henad
		else if(array.get(0).getIcon() == cirkel && array.get(1).getIcon() == cirkel && array.get(2).getIcon() == cirkel){
			win = "cirkel";
		}
		else if(array.get(3).getIcon() == cirkel && array.get(4).getIcon() == cirkel && array.get(5).getIcon() == cirkel){
			win = "cirkel";
		}
		else if(array.get(6).getIcon() == cirkel && array.get(7).getIcon() == cirkel && array.get(8).getIcon() == cirkel){
			win = "cirkel";
		}
		//nedad
		else if(array.get(0).getIcon() == cirkel && array.get(3).getIcon() == cirkel && array.get(6).getIcon() == cirkel){
			win = "cirkel";
		}
		else if(array.get(1).getIcon() == cirkel && array.get(4).getIcon() == cirkel && array.get(7).getIcon() == cirkel){
			win = "cirkel";
		}
		else if(array.get(2).getIcon() == cirkel && array.get(5).getIcon() == cirkel && array.get(8).getIcon() == cirkel){
			win = "cirkel";
		}
		//andet
		else if(array.get(0).getIcon() == cirkel && array.get(4).getIcon() == cirkel && array.get(8).getIcon() == cirkel){
			win = "cirkel";
		}
		else if(array.get(6).getIcon() == cirkel && array.get(4).getIcon() == cirkel && array.get(2).getIcon() == cirkel){
			win = "cirkel";
		}
		return win;
	}
}

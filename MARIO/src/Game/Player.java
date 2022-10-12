package Game;

import java.awt.Graphics;

public class Player extends Mario{
	
	Graphics gra = frame.panel.image.createGraphics();
	public Player(){
		System.out.println("");
	}
	public void PlayerPaint() {
		gra.fillRect(PlayerX, PlayerY,30,30);
		//gra.drawImage(player,PlayerX,PlayerY,null);
		
	}
	
	public void PlayerReset() {
		
	}
}

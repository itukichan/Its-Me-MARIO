package Game;

import java.awt.Graphics;

public class PlayerAction extends Mario{
	
	Graphics gra = frame.panel.image.createGraphics();
	
	public PlayerAction() {
		
	}
	
	public void PlayerPaint(int x , int y) {
		gra.drawImage(player,PlayerY+x,PlayerX,null);
	}
}

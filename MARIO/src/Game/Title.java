package Game;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Title extends Mario {
	Graphics gra = frame.panel.image.createGraphics();
	static int frag =0;
	public void TitlePaint() {
		//Color clr = new Color(51,153,255);
		//gra.setColor(clr);
		//gra.fillRect(0, 0, 1000, 600);
		
		gra.setColor(Color.white);
		//gra.fillRect(410, 300, 150,50);
		gra.drawImage(play,410, 300,null);
		
		gra.setColor(Color.white);
		//gra.fillRect(410, 400, 150,50);
		gra.drawImage(play2,410,400,null);
		

		if(Keyboard.isKeyPressed(KeyEvent.VK_DOWN) && !(Keyboard.isKeyPressed(KeyEvent.VK_UP))) {
			frag = 1;
		}else if (Keyboard.isKeyPressed(KeyEvent.VK_UP) && !(Keyboard.isKeyPressed(KeyEvent.VK_DOWN))) {
			frag = 0;
		}
		
		if(frag == 0) {
			gra.setColor(Color.white);
			//gra.fillRect(370, 313, 25,25);
			gra.drawImage(enemy,370, 313,null);
			
		}else if(frag == 1) {
			gra.setColor(Color.white);
			//gra.fillRect(370, 413, 25,25);
			gra.drawImage(enemy,370, 413,null);
		}
	
		
		if(frag == 0 && Keyboard.isKeyPressed(KeyEvent.VK_ENTER) || Keyboard.isKeyPressed(KeyEvent.VK_SPACE) ) {
			screen = EnumScreen.PLAY;
		}else if (frag == 1 && Keyboard.isKeyPressed(KeyEvent.VK_ENTER) || Keyboard.isKeyPressed(KeyEvent.VK_SPACE)) {
			//遊び方
			screen = EnumScreen.RULE;
		}
	}
	
}

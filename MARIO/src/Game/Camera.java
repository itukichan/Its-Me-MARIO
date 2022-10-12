package Game;

import java.awt.event.KeyEvent;

public class Camera extends Mario{
	public int CameraX = 0;
	
	public Camera() {
		System.out.println();
	}
	
	public int Coordinate() {
		
		int center = 480;
		
		if(Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && PlayerX >=480) {
			CameraX -= 3;
		}
		
		if(Keyboard.isKeyPressed(KeyEvent.VK_LEFT) && PlayerX <=PlayerX-CameraX) {
			CameraX += 3;
		}
		System.out.println("PlayerX"+PlayerX + "  CameraX"+CameraX);
		
		return CameraX;
	}
}

package Game;

import java.awt.event.KeyEvent;

public class Camera extends Mario{
	public int CameraX = 0;
	
	public Camera() {
		System.out.println();
	}
	
	public int Coordinate() {
		
		
		if(Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && PlayerX >480) {
			CameraX -= 5;
		}
		/*　左スクロール実装予定
		if(Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && PlayerX <480) {
			CameraX += 5;
		}
		*/
		
		return CameraX;
	}
}

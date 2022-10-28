package Game;

import java.awt.event.KeyEvent;

import Game.Map.MapSelect;

public class Camera extends Mario {
	public static int CameraX = 0;
	public static boolean CameraSet = true;
	static int map[][] = {};
	MapSelect MapS = new MapSelect();
	Collision coll = new Collision();

	public Camera() {
	}

	public void CameraMap(int num) {
		map = MapS.Map(num);
	}

	public int Coordinate() {
		Camera came = new Camera();
		int center = 480;

		if ((Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && !(Keyboard.isKeyPressed(KeyEvent.VK_LEFT))
				|| (Keyboard.isKeyPressed(KeyEvent.VK_D) && !(Keyboard.isKeyPressed(KeyEvent.VK_A)))) && PlayerX > 480
				&& coll.Detection_Left() && CameraSet) {

			// マップの右端の中心超えたらfalse

			CameraX -= 3;

		}

		if ((Keyboard.isKeyPressed(KeyEvent.VK_LEFT) && !(Keyboard.isKeyPressed(KeyEvent.VK_RIGHT))
				|| (Keyboard.isKeyPressed(KeyEvent.VK_A) && !(Keyboard.isKeyPressed(KeyEvent.VK_D))))
				&& PlayerX < PlayerX - CameraX && coll.Detection_Right() && CameraSet) {
			CameraX += 3;
		}
		// System.out.println("PlayerX"+PlayerX + " CameraX"+CameraX);

		switch (screen) {
		case GOAL:
			came.CameraReset();
			break;
		}

		return CameraX;
	}

	public void CameraReset() {
		CameraX = 0;
		CameraSet = false;
	}

	public void CameraStart() {
		CameraX = 0;
		CameraSet = true;
	}
}

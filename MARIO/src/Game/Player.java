package Game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends Mario {

	static boolean marioL_flag = false;
	static boolean marioR_flag = false;
	Graphics gra = frame.panel.image.createGraphics();

	public Player() {
		System.out.println("");
	}

	public void PlayerPaint() {
		// gra.fillRect(PlayerX, PlayerY,30,30);

		// 初期状態右
		if (!Keyboard.isKeyPressed(KeyEvent.VK_LEFT) && !(Keyboard.isKeyPressed(KeyEvent.VK_RIGHT))
				&& !Keyboard.isKeyPressed(KeyEvent.VK_A) && !(Keyboard.isKeyPressed(KeyEvent.VK_D)) && !marioL_flag
				&& !marioR_flag) {
			gra.drawImage(marioR, PlayerX, PlayerY, null);

		}

		if ((Keyboard.isKeyPressed(KeyEvent.VK_LEFT) && !(Keyboard.isKeyPressed(KeyEvent.VK_RIGHT))
				|| Keyboard.isKeyPressed(KeyEvent.VK_A) && !(Keyboard.isKeyPressed(KeyEvent.VK_D))) || marioL_flag) {
			gra.drawImage(marioL, PlayerX, PlayerY, null);
			marioL_flag = true;
			marioR_flag = false;
		}

		if ((Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && !(Keyboard.isKeyPressed(KeyEvent.VK_LEFT))
				|| Keyboard.isKeyPressed(KeyEvent.VK_D) && !(Keyboard.isKeyPressed(KeyEvent.VK_A))) || marioR_flag) {
			gra.drawImage(marioR, PlayerX, PlayerY, null);
			marioR_flag = true;
			marioL_flag = false;
		}

	}

	public void PlayerReset() {
		PlayerX = 60;
		PlayerY = 510;
	}
}

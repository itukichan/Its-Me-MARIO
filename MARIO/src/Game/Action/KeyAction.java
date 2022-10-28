package Game.Action;

import java.awt.event.KeyEvent;

import Game.Collision;
import Game.Keyboard;
import Game.Mario;

public class KeyAction extends Mario {
	static boolean jflag = false;
	static boolean jflag2 = false;
	static boolean jflag3 = true;
	static int PlayerY_prev = 0;
	static int PlayerY_temp = 0;
	static int PlayerY_down = 0;
	static int PlayerY_hozi = 0;
	Collision coll = new Collision();

	// キー入力
	public void keyAction() {

		// System.out.println(jflag);
		// 左矢印入力時
		if ((Keyboard.isKeyPressed(KeyEvent.VK_LEFT) && !(Keyboard.isKeyPressed(KeyEvent.VK_RIGHT))
				|| Keyboard.isKeyPressed(KeyEvent.VK_A) && !(Keyboard.isKeyPressed(KeyEvent.VK_D)))
				&& coll.Detection_Right()) {

			PlayerX = PlayerX - 3;
		}
		// 右矢印入力時
		if ((Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && !(Keyboard.isKeyPressed(KeyEvent.VK_LEFT))
				|| Keyboard.isKeyPressed(KeyEvent.VK_D) && !(Keyboard.isKeyPressed(KeyEvent.VK_A)))
				&& coll.Detection_Left()) {
			PlayerX = PlayerX + 3;
		}

		// 落下処理////////////////////////////////////////////////////////////////////////////
		if (jflag2) {
			if (jflag3) { // 一回の落下につき一度だけ実行(ジャンプ処理の落下部分のみ取り出すため）
				while (PlayerY_down <= PlayerY) {
					PlayerY_temp = PlayerY_down;
					PlayerY_down += (PlayerY_down - PlayerY_prev) + 1;
					// PlayerY +=(PlayerY+PlayerY_prev)+1;
					PlayerY_prev = PlayerY_temp;
				}
			}
			jflag3 = false;
			PlayerY_temp = PlayerY;
			// ブロックの上の１ブロック分の範囲に侵入(落下用)
			if (coll.Detection_blockup()) {

				int num = (PlayerY - PlayerY_prev) + 1;
				int result = 0;
				if (coll.Detection_blockup(num)) {
					result = num - (PlayerY + num) % 30;
					PlayerY += result - 30;
					PlayerY_prev = PlayerY_temp;
					jflag2 = false;
					jflag3 = true;
					System.out.println("a" + PlayerY);
				}

			}
			if (!coll.Detection_Top()) {
				jflag2 = false;
				jflag3 = true;
			}
			if (jflag2) {

				PlayerY += (PlayerY - PlayerY_prev) + 1;
				PlayerY_prev = PlayerY_temp;
			}
		}

		if (coll.Detection_Top() && !jflag && !jflag2) {
			PlayerY_prev = PlayerY;
			PlayerY = PlayerY - 8;
			PlayerY_down = PlayerY - 8;
			jflag2 = true;
		}

		// 落下処理ここまで//////////////////////////////////////////////////////////////////////

		// ジャンプ処理/////////////////////////////////////////////////////////////////////////////
		if (jflag) {
			PlayerY_temp = PlayerY;

			System.out.println(PlayerY);
			// ブロックの上の１ブロック分の範囲に侵入(落下用)
			if (coll.Detection_blockup()) {

				int num = (PlayerY - PlayerY_prev) + 1;
				int result = 0;
				if (coll.Detection_blockup(num)) {
					result = num - (PlayerY + num) % 30;
					PlayerY += result - 30;
					PlayerY_prev = PlayerY_temp;
					jflag = false;
					System.out.println("a" + PlayerY);
				}

			}

			// ブロックの下の１ブロック分の範囲に侵入（上昇用)
			if (coll.Detection_blockdown()) {

				System.out.println("入ったよ" + "Y " + PlayerY);
				int num = (PlayerY - PlayerY_prev) + 1;
				int result = 0;
				if (coll.Detection_blockdown(num)) {
					result = num - (PlayerY + num) % 30;
					PlayerY += result + 30;
					PlayerY_prev = PlayerY_temp;
					jflag = false;

				}

			}

			if (!coll.Detection_Top()) {
				jflag = false;
			}
			if (jflag) {

				PlayerY += (PlayerY - PlayerY_prev) + 1;
				PlayerY_prev = PlayerY_temp;

			}
		}

		if ((Keyboard.isKeyPressed(KeyEvent.VK_UP) || Keyboard.isKeyPressed(KeyEvent.VK_SPACE)) && jflag == false
				&& !coll.Detection_Top()) {
			jflag = true;
			PlayerY_prev = PlayerY;
			PlayerY = PlayerY - 18;
		}
		// ジャンプ処理ここまで///////////////////////////////////////////////////////////
	}
}

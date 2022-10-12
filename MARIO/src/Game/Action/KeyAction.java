package Game.Action;
import java.awt.event.KeyEvent;

import Game.Keyboard;
import Game.Mario;
public class KeyAction extends Mario{
	static boolean jflag = false;
	static int PlayerY_prev = 0;
	static int PlayerY_temp = 0;
	//キー入力
	public void keyAction(){
		
		
		//System.out.println(jflag);
		//左矢印入力時
		if(Keyboard.isKeyPressed(KeyEvent.VK_LEFT)&&!(Keyboard.isKeyPressed(KeyEvent.VK_RIGHT))) {
			PlayerX = PlayerX - 3;
		}
		//右矢印入力時
		if(Keyboard.isKeyPressed(KeyEvent.VK_RIGHT)&&!(Keyboard.isKeyPressed(KeyEvent.VK_LEFT))) {
			PlayerX = PlayerX + 3;
		}
		
		
		//ジャンプ処理
		
		if(jflag == true) {
			PlayerY_temp = PlayerY;
			PlayerY +=(PlayerY-PlayerY_prev)+1;
			PlayerY_prev = PlayerY_temp;
			//if(jflag)System.out.println("a");
			if(PlayerY == 510)jflag=false;

		}
		
		if(Keyboard.isKeyPressed(KeyEvent.VK_UP)&&jflag == false) {
			jflag = true;
			//System.out.println("aa");
			PlayerY_prev = PlayerY;
			PlayerY = PlayerY-20;
		}
		
		
	}
}

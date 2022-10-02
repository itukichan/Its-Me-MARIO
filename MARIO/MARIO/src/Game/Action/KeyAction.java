package Game.Action;
import java.awt.event.KeyEvent;

import Game.Keyboard;
import Game.Mario;
public class KeyAction extends Mario{
	//キー入力
	public KeyAction(){
		//左矢印入力時
		if(Keyboard.isKeyPressed(KeyEvent.VK_LEFT)) {
			PlayerX = PlayerX - 5;
		}
		//右矢印入力時
		if(Keyboard.isKeyPressed(KeyEvent.VK_RIGHT)) {
			PlayerX = PlayerX + 5;
		}
		/*スペース入力時
		if(Keyboard.isKeyPressed(KeyEvent.VK_SPACE)) {
			PlayerY = PlayerY - 10;
		}
		*/
	}
}

package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import Game.Action.KeyAction;
public class Mario {
	public static Frame frame;
	public static boolean loop;
	public static Image brick = new ImageIcon("./model/brick.png").getImage();
	public static Image player = new ImageIcon("./model/mario.png").getImage();
	public static Image RamdomBlock = new ImageIcon("./model/RamdomBlock.png").getImage();
	public static Image enemy = new ImageIcon("./model/enemy01.png").getImage();
	public static int PlayerX = 60;
	public static int PlayerY = 510;
	
	public static void main(String[] args) {
		frame = new Frame();
		loop = true;
		KeyAction key = new KeyAction();
		System.out.println(brick);
		
		Graphics gra = frame.panel.image.createGraphics();
		Player player = new Player();
		//FPS
		long startTime;
		long fpsTime = 0;
		int FPS = 0;
		int fps = 60;
		int FPSCount = 0;
		EnumScreen screen = EnumScreen.START;
		
		//GAME
		while(loop){
			if((System.currentTimeMillis() - fpsTime) > 1000){
				fpsTime = System.currentTimeMillis();
				FPS = FPSCount;
				FPSCount = 0;
			}
			FPSCount++;
			startTime = System.currentTimeMillis();
			
			
		switch(screen) {
		
			//スタード画面
			case START:
				gra.setColor(Color.WHITE);
				
				if(Keyboard.isKeyPressed(KeyEvent.VK_SPACE)) {
					screen = EnumScreen.PLAY;
				}
				
				break;
				
			case PLAY:
				//ステージ描画（仮）
				MapCreate Map = new MapCreate(1);
				
				//プレイヤー描画
				player.PlayerPaint();
				
				//プレイヤー操作
				key.keyAction();
				break;
				
			case GAME_OVER:
				break;
				
			}
			
			frame.panel.draw();
			
			try {
				long runTime = System.currentTimeMillis() - startTime;
				if(runTime <(1000/fps)) {
					Thread.sleep((1000 / fps) - (runTime));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import Game.Action.KeyAction;

public class Mario {
	public static Frame frame;
	public static boolean loop;
	public static Image brick = new ImageIcon("./model/brick.png").getImage();
	public static Image marioR = new ImageIcon("./model/mario.png").getImage();
	public static Image marioL = new ImageIcon("./model/marioL.png").getImage();
	public static Image RamdomBlock = new ImageIcon("./model/RamdomBlock.png").getImage();
	public static Image toge = new ImageIcon("./model/toge.png").getImage();
	public static Image enemy = new ImageIcon("./model/enemy01.png").getImage();
	public static Image play = new ImageIcon("./model/play.png").getImage();
	public static Image play2 = new ImageIcon("./model/play2.png").getImage();
	public static Image cloud = new ImageIcon("./model/cloud.png").getImage();
	public static Image goal = new ImageIcon("./model/goal.png").getImage();
	public static int PlayerX = 60;
	public static int PlayerY = 510; // 510
	// public static boolean BDetection = true;
	public static EnumScreen screen = EnumScreen.START;

	public static void main(String[] args) {
		frame = new Frame();
		loop = true;
		KeyAction key = new KeyAction();
		Collision coll = new Collision();
		MapCreate Map = new MapCreate();
		Graphics gra = frame.panel.image.createGraphics();
		Player player = new Player();
		Title title = new Title();
		Rule rule = new Rule();
		Goal goal = new Goal();
		Camera came = new Camera();
		
		// FPS

		long startTime;
		long fpsTime = 0;
		int FPS = 0;
		int fps = 60;
		int FPSCount = 0;

		// GAME
		while (loop) {
			if ((System.currentTimeMillis() - fpsTime) > 1000) {
				fpsTime = System.currentTimeMillis();
				FPS = FPSCount;
				FPSCount = 0;
			}
			FPSCount++;
			startTime = System.currentTimeMillis();

			switch (screen) {

			// スタード画面
			case START:
				Map.MapSelect(1);
				Map.MapPaint();
				title.TitlePaint();

				break;
			// ルール説明画面
			case RULE:
				Map.MapSelect(1);
				rule.RulePaint();
				rule.Rule1();
				break;
			// ゲーム画面
			case PLAY:
				
				//カメラ設定（マップ指定)
				came.CameraMap(1);
				//マップ描画
				Map.MapSelect(1);
				Map.MapPaint();
				// 当たり判定するマップを選択
				coll.CollisionSelect(1);
				// プレイヤー描画
				player.PlayerPaint();
				// プレイヤー操作
				key.keyAction();
				
				//ゴール判定
				goal.Collision_Goal();
				break;
			// ゲームオーバー画面
			case GAME_OVER:
				break;
			case GOAL:
				
				gra.setColor(Color.black);
				gra.fillRect(0, 0, 1500, 600);
				gra.setColor(Color.white);
				gra.setFont(gra.getFont().deriveFont(Font.BOLD,30F));
	            String how1 = "GOAL!!";
	            gra.drawString(how1,300,450);
				break;
			}
			
			frame.panel.draw();

			try {
				long runTime = System.currentTimeMillis() - startTime;
				if (runTime < (1000 / fps)) {
					Thread.sleep((1000 / fps) - (runTime));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

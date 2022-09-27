package Game;

import java.awt.Color;
import java.awt.Graphics;

import Game.Map.Map01;

public class MapCreate extends Mario{
	Graphics gra = frame.panel.image.createGraphics();
	
	MapCreate(int stage){
		gra.setColor(Color.BLUE);
		gra.fillRect(0,0,1000,600);
		if(stage == 1) {
		Map01 map = new Map01();
		for(int i = 0; i<map.getMap01().length; i++) {
			for(int j = 0; j<map.getMap01()[i].length;j++) {
				//ブロック特定
				switch(map.getMap01()[i][j]) {
				case 0:
					break;
				case 1:
					gra.drawImage(brick,j*30,i*30,null);
					break;
				case 2:
					gra.drawImage(player,j*30,i*30,null);
					break;
				}
			 }
		  }
	   }
	}
}

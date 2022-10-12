package Game;

import java.awt.Color;
import java.awt.Graphics;

import Game.Map.Map01;

public class MapCreate extends Mario{
	Graphics gra = frame.panel.image.createGraphics();
	
	MapCreate(int stage){
		
		if(stage == 1) {
		Map01 map = new Map01();
		gra.setColor(Color.BLUE);
		//System.out.println(map.getMap01()[0].length);
		gra.fillRect(0,0,map.getMap01()[0].length*30,600);
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
					gra.drawImage(RamdomBlock,j*30,i*30,null);
					break;
				case 3:
					gra.drawImage(enemy,j*30,i*30,null);
					break;
				}
			 }
		  }
	   }
	}
}

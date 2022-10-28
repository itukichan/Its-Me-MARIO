package Game;

import java.awt.Color;
import java.awt.Graphics;

import Game.Map.MapSelect;
public class MapCreate extends Mario{
	Graphics gra = frame.panel.image.createGraphics();
	Color clr = new Color(51,153,255);
	MapSelect MapS = new MapSelect();
	static int[][] map = {};
	
	public void MapSelect(int i) {
		map = MapS.Map(i);
	}
	
	public void MapPaint(){
		gra.setColor(clr);
		//System.out.println(map.getMap01()[0].length);
		gra.fillRect(0,0,map[0].length*30,600);
		for(int i = 0; i<map.length; i++) {
			for(int j = 0; j<map[i].length;j++) {
				//ブロック特定
				switch(map[i][j]) {
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
				case 4:
					gra.drawImage(toge,j*30,i*30,null);
					break;
				case 5:
					gra.drawImage(cloud,j*30,i*30,null);
					break;
				case 6:
					gra.drawImage(goal,j*30,i*30,null);
					break;
				}
			 }
		  }
	   
	}
}

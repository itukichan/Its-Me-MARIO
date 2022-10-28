package Game;
import Game.Map.Map01;

public class Goal extends Mario{
	
	Collision coll = new Collision();
	Map01 map01 = new Map01();
	static int[][] map = {};
	
	public void GoalSelectMap(int i) {
		switch (i) {
		case 1:
			map = map01.getMap01();
			break;
		}
	}
	
	public void  Collision_Goal() {
		 if(!coll.Detection_Goal()) {
			 screen = EnumScreen.GOAL;
		 }
}
}

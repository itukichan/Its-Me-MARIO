package Game.Map;

public class MapSelect {
	Map01 map01 = new Map01();
	
	public int[][] Map (int num){
		
		int map[][]= {};
		switch (num) {
		case 1:
			map = map01.getMap01();
			break;
		}
		
		
		return map;
	}
}

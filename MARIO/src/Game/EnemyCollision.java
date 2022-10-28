package Game;

import Game.Map.Map01;

public class EnemyCollision extends Mario{
	Map01 map01 = new Map01();
	static int[][] map = {};

	public void CollisionSelect(int i) {

		switch (i) {
		case 1:
			map = map01.getMap01();
			break;
		}

	}
	
	// 右移動に実行
			//左面
			public boolean Detection_Left(int EnemyX, int EnemyY) {
				boolean BDetection = true;

				label: for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						int blockX_UPLeft = j * 30 - 30;
						int blockY_UPLeft = i * 30;
						int blockY_DOWNLeft = i * 30 + 30;
						if (map[i][j] == 1) {

							
							if (EnemyX == blockX_UPLeft) {

								if (blockY_DOWNLeft > EnemyY && blockY_UPLeft < EnemyY) {
									BDetection = false;
									break label;
								}

								if (blockY_DOWNLeft > EnemyY + 30 && blockY_UPLeft < EnemyY + 30) {
									
									BDetection = false;
									break label;
								}
								
								if(blockY_DOWNLeft == EnemyY+30 && blockY_UPLeft == EnemyY) {
									BDetection = false;
									break label;
								}
							} else if (EnemyX != blockX_UPLeft && EnemyY == blockY_UPLeft) {

								BDetection = true;
							}

						}

					}

				}

				return BDetection;

			}

			// 左移動時に実行
			//右面
			public boolean Detection_Right(int EnemyX, int EnemyY) {
				boolean BDetection = true;

				label: for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						int blockX_UPRight = j * 30 + 30;
						int blockY_UPRight = i * 30;
						int blockY_DOWNRight = i * 30 + 30;
						if (map[i][j] == 1) {

							
							if (EnemyX == blockX_UPRight) {

								if (blockY_DOWNRight > EnemyY && blockY_UPRight < EnemyY) {
									BDetection = false;
									break label;
								}
								
								if (blockY_DOWNRight > EnemyY + 30 && blockY_UPRight < EnemyY + 30) {
									BDetection = false;
									break label;
								}
								
								if(blockY_DOWNRight == EnemyY+30 && blockY_UPRight == EnemyY) {
									BDetection = false;
									break label;
								}
							} else if (EnemyX != blockX_UPRight && EnemyY == blockY_UPRight) {

								BDetection = true;
							}
						}

					}
				}
				return BDetection;

			}
}

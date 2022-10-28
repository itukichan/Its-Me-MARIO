package Game;

import Game.Map.MapSelect;

public class Collision extends Mario {
	MapSelect MapS = new MapSelect();
	static int[][] map = {};
	
	public Collision() {}

	public void CollisionSelect(int i) {

		map = MapS.Map(i);

	}

	// 右入力時に実行
	// 左面
	public boolean Detection_Left() {
		boolean BDetection = true;

		label: for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int blockX_UPLeft = j * 30 - 30;
				int blockY_UPLeft = i * 30;
				int blockY_DOWNLeft = i * 30 + 30;
				if (map[i][j] == 1) {

					if (PlayerX == blockX_UPLeft) {

						if (blockY_DOWNLeft > PlayerY && blockY_UPLeft < PlayerY) {
							BDetection = false;
							break label;
						}

						if (blockY_DOWNLeft > PlayerY + 30 && blockY_UPLeft < PlayerY + 30) {

							BDetection = false;
							break label;
						}

						if (blockY_DOWNLeft == PlayerY + 30 && blockY_UPLeft == PlayerY) {
							BDetection = false;
							break label;
						}
					} else if (PlayerX != blockX_UPLeft && PlayerY == blockY_UPLeft) {

						BDetection = true;
					}

				}

			}

		}

		return BDetection;

	}

	// 左入力時に実行
	// 右面
	public boolean Detection_Right() {
		boolean BDetection = true;

		label: for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int blockX_UPRight = j * 30 + 30;
				int blockY_UPRight = i * 30;
				int blockY_DOWNRight = i * 30 + 30;
				if (map[i][j] == 1) {

					if (PlayerX == blockX_UPRight) {

						if (blockY_DOWNRight > PlayerY && blockY_UPRight < PlayerY) {
							BDetection = false;
							break label;
						}

						if (blockY_DOWNRight > PlayerY + 30 && blockY_UPRight < PlayerY + 30) {
							BDetection = false;
							break label;
						}

						if (blockY_DOWNRight == PlayerY + 30 && blockY_UPRight == PlayerY) {
							BDetection = false;
							break label;
						}
					} else if (PlayerX != blockX_UPRight && PlayerY == blockY_UPRight) {

						BDetection = true;
					}
				}

			}
		}
		return BDetection;

	}

	// 上面
	public boolean Detection_Top() {
		boolean BDetection = true;

		label: for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int blockX_UPLeft = j * 30 - 30;
				int blockX_UPRight = j * 30 + 30;
				int blockY = i * 30;

				if (map[i][j] == 1) {

					if (PlayerY + 30 == blockY) {

						if (blockX_UPLeft < PlayerX && blockX_UPRight > PlayerX) {

							BDetection = false;
							break label;

						}
						if (blockX_UPLeft == PlayerX + 30 && blockX_UPRight == PlayerX) {
							System.out.println("aa");
							BDetection = false;
							break label;
						}
					}
				}
			}
		}

		return BDetection;
	}

	// 下面
	public boolean Detection_Bottom() {
		boolean BDetection = true;

		label: for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int blockX_UPLeft = j * 30 - 30;
				int blockX_UPRight = j * 30 + 30;
				int blockY = i * 30;

				if (map[i][j] == 1) {

					if (PlayerY == blockY + 30) {

						if (blockX_UPLeft < PlayerX && blockX_UPRight > PlayerX) {

							BDetection = false;
							break label;

						}

					}
				}
			}
		}

		return BDetection;
	}

	// ジャンプ用処理 落下
	// ブロックの一個上にプレイヤーが侵入したらtrue
	public boolean Detection_blockup() {
		boolean BDetection = false;

		label: for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int blockX_Left = j * 30;
				int blockX_Right = j * 30 + 30;

				int blockY = i * 30;
				int blockY_Up = i * 30 - 30;

				if (map[i][j] == 1) {
					// X座標
					if (blockX_Left <= PlayerX && blockX_Right >= PlayerX) {
						// Y座標
						if (blockY_Up <= PlayerY && blockY >= PlayerY) {
							
							BDetection = true;
							break label;
						}
					} else if (blockX_Left <= PlayerX + 30 && blockX_Right >= PlayerX + 30) {
						// Y座標
						if (blockY_Up <= PlayerY && blockY >= PlayerY) {
							
							BDetection = true;
							break label;
						}
					
					}

				}

			}
		}

		return BDetection;

	}

	// ブロックの中に侵入したらtrue
	public boolean Detection_blockup(int num) {
		boolean BDetection = false;

		label: for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int blockX_Left = j * 30;
				int blockX_Right = j * 30 + 30;

				int blockY = i * 30;
				int blockY_Up = i * 30 + 30;

				if (map[i][j] == 1) {
					// X座標
					if (blockX_Left <= PlayerX && blockX_Right >= PlayerX) {
						// Y座標

						if (blockY <= PlayerY + num&& blockY_Up >= PlayerY + num) {
							BDetection = true;
							break label;
						}
					} else if (blockX_Left <= PlayerX + 30 && blockX_Right >= PlayerX + 30) {

						if (blockY <= PlayerY + num && blockY_Up >= PlayerY + num) {
							BDetection = true;
							break label;
						}
					}
				}

			}

		}

		return BDetection;

	}
	
	//ジャンプ用処理上昇
	// ブロックの一個下にプレイヤーが侵入したらtrue
		public boolean Detection_blockdown() {
			boolean BDetection = false;

			label: for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					int blockX_Left = j * 30;
					int blockX_Right = j * 30 + 30;

					int blockY = i * 30+30;
					int blockY_down = i * 30 + 60;

					if (map[i][j] == 1) {
						// X座標
						if (blockX_Left <= PlayerX && blockX_Right >= PlayerX) {
							// Y座標
							if (blockY_down >= PlayerY && blockY <= PlayerY) {
								System.out.println("上");
								BDetection = true;
								break label;
							}
						} else if (blockX_Left <= PlayerX + 30 && blockX_Right >= PlayerX + 30) {
							// Y座標
							if (blockY_down >= PlayerY && blockY <= PlayerY) {
								System.out.println("下");

								BDetection = true;
								break label;
							}
						
						}

					}

				}
			}

			return BDetection;

		}

		// ブロックの中に侵入したらtrue
		public boolean Detection_blockdown(int num) {
			boolean BDetection = false;

			label: for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					int blockX_Left = j * 30;
					int blockX_Right = j * 30 + 30;

					int blockY = i * 30;
					int blockY_down = i * 30 + 30;

					if (map[i][j] == 1) {
						// X座標
						if (blockX_Left <= PlayerX && blockX_Right >= PlayerX) {
							// Y座標

							if (blockY <= PlayerY + num&& blockY_down >= PlayerY + num) {
								BDetection = true;
								break label;
							}
						} else if (blockX_Left <= PlayerX + 30 && blockX_Right >= PlayerX + 30) {

							if (blockY <= PlayerY + num && blockY_down >= PlayerY + num) {
								BDetection = true;
								break label;
							}
						}
					}

				}

			}

			return BDetection;

		}
	
	
	
	// ゴール
	public boolean Detection_Goal() {
		boolean GDetection = true;

		label: for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int GoalX_UPLeft = j * 30 - 9;
				int blockY_UPRight = i * 30;
				int blockY_DOWNRight = i * 30 * 13;

				if (map[i][j] == 6) {
					if (GoalX_UPLeft == PlayerX) {
						GDetection = false;
						break label;
					}
				}
			}
		}
		return GDetection;

	}
}

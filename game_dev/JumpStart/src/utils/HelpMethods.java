package utils;

import main.Game;

public class HelpMethods {

	public static boolean canMoveHere(float x, float y, int width, int height, int[][] levelData) {
		if (!isSolid(x, y, levelData)) {
			if (!isSolid(x + width, y + height, levelData)) {
				if (!isSolid(x + width, y, levelData)) {
					if (!isSolid(x, y + height, levelData)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean isSolid(float x, float y, int[][] levelData) {
		
		if (x < 0 || x > Game.GAME_WIDTH) {
			return true;
		}
		
		if (y < 0 || y > Game.GAME_HEIGHT) {
			return true;
		}
		
		float xIndex = x / Game.GAME_WIDTH;
		float yIndex = y / Game.GAME_HEIGHT;
		int value = levelData[(int) xIndex][(int) yIndex];
		
		if (value >= 242 || value < 0) {
			return true;
		}
		
		return false;
	}
}

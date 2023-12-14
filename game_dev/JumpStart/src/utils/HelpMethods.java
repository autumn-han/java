package utils;

import main.Game;

public class HelpMethods {

	public static boolean canMoveHere(float x, float y, float width, float height, int[][] levelData) {
		if (!isSolid(x, y, levelData)) 
			if (!isSolid(x + width, y + height, levelData)) 
				if (!isSolid(x + width, y, levelData)) 
					if (!isSolid(x, y + height, levelData)) 
						return true;
		return false;
	}
	
	private static boolean isSolid(float x, float y, int[][] levelData) {
		float xIndex = x / Game.TILES_SIZE;
		float yIndex = y / Game.TILES_SIZE;
		int value = levelData[(int) yIndex][(int) xIndex];
		System.out.println("yIndex: " + yIndex + " | xIndex: " + xIndex + " | value: " + value);
		
		if (x < 0 || x >= Game.GAME_WIDTH) {
			System.out.println("YOU'RE AT THE EDGE OF THE WORLD" + " | " + x);
			return true;
		}
		
		if (y < 0 || y >= Game.GAME_HEIGHT) {
			System.out.println("YOU'RE AT THE TOP OR BOTTOM" + " | " + y);
			return true;
		}
		
		if (value >= 242 || value < 0 || value != 11) {
			System.out.println("YOU SHALL NOT PASS" + " | " + value);
			return true;
		}
		return false;
	}
}
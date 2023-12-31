package utils;

import java.awt.geom.Rectangle2D;

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
		int maxWidth = levelData[0].length * Game.TILES_SIZE;
		System.out.println("yIndex: " + yIndex + " | xIndex: " + xIndex + " | value: " + value);
		
		if (x < 0 || x >= maxWidth) {
			return true;
		}
		
		if (y < 0 || y >= Game.GAME_HEIGHT) {
			return true;
		}
		
		if (value >= 242 || value < 0 || value != 11) {
			return true;
		}
		return false;
	}
	
	public static float getEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed) {
		int currentTile = (int) (hitbox.x / Game.TILES_SIZE);
		
		if (xSpeed > 0) {
			// right
			int tileXPos = currentTile * Game.TILES_SIZE;
			int xOffset = (int) (Game.TILES_SIZE - hitbox.width);
			return tileXPos + xOffset - 1;
		} else {
			// left
			return currentTile * Game.TILES_SIZE;
		}
	}
	
	public static float getEntityPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed) {
		int currentTile = (int) (hitbox.y / Game.TILES_SIZE);
		
		if (airSpeed > 0) {
			// falling - touching floor
			int tileYPos = currentTile * Game.TILES_SIZE;
			int yOffset = (int) (Game.TILES_SIZE - hitbox.height);
			return tileYPos + yOffset - 1;
		} else {
			// jumping - hitting roof
			return currentTile * Game.TILES_SIZE;
		}
	}
	
	public static boolean isEntityOnFloor(Rectangle2D.Float hitbox, int[][] levelData) {
		
		if (!isSolid(hitbox.x, hitbox.y + hitbox.height + 1, levelData))
			if (!isSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, levelData))
				return false;
		return true;
	}
}

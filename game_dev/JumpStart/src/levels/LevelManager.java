package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utils.LoadSave;

public class LevelManager {
	private Game game;
	private BufferedImage[] levelSprite;
	private Level levelOne;
	
	public LevelManager(Game game) {
		this.game = game;
//		this.levelSprite = LoadSave.getSpriteAtlas(LoadSave.LEVEL_ATLAS);
		importTerrain();
		levelOne = new Level(LoadSave.getLevelData());
	}
	
	private void importTerrain() {
		BufferedImage img = LoadSave.getSpriteAtlas(LoadSave.LEVEL_ATLAS);
		levelSprite = new BufferedImage[242];
		for (int j = 0; j < 11; j++) {
			for (int i = 0; i < 22; i++) {
				int ind = j*22 + i;
				levelSprite[ind] = img.getSubimage(i*16, j*16, 16, 16);
			}
		}
		
	}

	public void draw(Graphics g) {
		for (int j = 0; j < Game.TILES_IN_HEIGHT; j++) {
			for (int i = 0; i < Game.TILES_IN_WIDTH; i++) {
				int index = levelOne.getSpriteIndex(i, j);
				g.drawImage(levelSprite[index], i*Game.TILES_SIZE, j*Game.TILES_SIZE, Game.TILES_SIZE, Game.TILES_SIZE, null);
			}
		}
	}
	
	public void update() {
		// TODO
	}
	
	public Level getCurrentLevel() {
		return levelOne;
	}

}

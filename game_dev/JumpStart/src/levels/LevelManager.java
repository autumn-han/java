package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utils.LoadSave;

public class LevelManager {
	private Game game;
	private BufferedImage[] levelSprite;
	
	public LevelManager(Game game) {
		this.game = game;
//		this.levelSprite = LoadSave.getSpriteAtlas(LoadSave.LEVEL_ATLAS);
		importTerrain();
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
		g.drawImage(levelSprite[2], 0, 0, null);
	}
	
	public void update() {
		// TODO
	}

}

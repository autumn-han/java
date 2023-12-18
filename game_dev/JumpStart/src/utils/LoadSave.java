package utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.Game;

public class LoadSave {
	
	public static final String PLAYER_ATLAS = "ninjaFrogAll.png";
	public static final String LEVEL_ATLAS = "terrain.png";
//	public static final String LEVEL_ONE_DATA = "level_one_data.png";
	public static final String LEVEL_ONE_DATA = "level_one_data_long.png";
	public static final String MENU_BUTTONS = "button_atlas.png";
	public static final String MENU_BACKGROUND = "menu_background.png";
	public static final String HOME_SCREEN_BACKGROUND = "home_screen_background.png";
	public static final String PAUSE_BACKGROUND = "pause_menu.png";
	public static final String SOUND_BUTTONS = "sound_button.png";
	public static final String URM_BUTTONS = "urm_buttons.png";
	public static final String VOLUME_BUTTONS = "volume_buttons.png";

	
	public static BufferedImage getSpriteAtlas(String fileName) {
		
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}
	
	public static int[][] getLevelData() {
		BufferedImage img = getSpriteAtlas(LEVEL_ONE_DATA);
		int[][] levelData = new int[img.getHeight() + 1][img.getWidth()];
		
		for (int j = 0; j < img.getHeight(); j++) {
			for (int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int val = color.getRed();
				if (val >= 242) {
					val = 0;
				}
				levelData[j][i] = val;
			}
		}
		return levelData;
	}
}

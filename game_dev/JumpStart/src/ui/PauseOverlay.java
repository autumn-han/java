package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import main.Game;
import utils.LoadSave;

public class PauseOverlay {
	
	private BufferedImage backgroundImg;
	private int bgX, bgY, bgW, bgH;
	
	public PauseOverlay() {
		loadBackground();
		
	}
	
	private void loadBackground() {
		backgroundImg = LoadSave.getSpriteAtlas(LoadSave.PAUSE_BACKGROUND);
		bgW = (int) (backgroundImg.getWidth() * Game.SCALE);
		bgH = (int) (backgroundImg.getHeight() * Game.SCALE);
		bgX = Game.GAME_WIDTH / 2 - bgW / 2;
		bgY = 50;
		
	}

	public void update() {
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(backgroundImg, bgX, bgY, bgW, bgH, null);
		
	}
	
	public void mouseDragged(MouseEvent e) {
		// TODO
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}

package ui;

import static utils.Constants.UI.UrmButtons.URM_DEFAULT_SIZE;
import static utils.Constants.UI.UrmButtons.URM_SIZE;
import static utils.Constants.UI.VolumeButtons.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utils.LoadSave;

public class VolumeButton extends PauseButton {
	
	private BufferedImage[] imgs;
	private BufferedImage slider;
	private int index = 0;
	private boolean mouseOver, mousePressed;
	private int buttonX;

	public VolumeButton(int x, int y, int width, int height) {
		
		super(x + width / 2, y, VOLUME_WIDTH, height);
		buttonX = x + width / 2;
		this.x = x;
		this.width = width;
		loadImgs();
	}
	
	private void loadImgs() {
		BufferedImage temp = LoadSave.getSpriteAtlas(LoadSave.VOLUME_BUTTONS);
		imgs = new BufferedImage[3];
		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = temp.getSubimage(i * VOLUME_WIDTH_DEFAULT, 0, VOLUME_WIDTH_DEFAULT, VOLUME_HEIGHT_DEFAULT);
		}
		
		slider = temp.getSubimage(3 * VOLUME_WIDTH_DEFAULT, 0, SLIDER_WIDTH_DEFAULT, VOLUME_HEIGHT_DEFAULT);
		
		
	}

	public void update() {
		index = 0;
		
		if (mouseOver) 
			index = 1;
		if (mousePressed)
			index = 2;
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(slider, x, y, width, height, null);
		g.drawImage(imgs[index], buttonX, y, VOLUME_WIDTH, height, null);
		
	}
	
	public void resetBooleans() {
		mouseOver = false;
		mousePressed = false;
	}

	public boolean isMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}
	

}

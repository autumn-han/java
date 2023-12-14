package ui;

import static utils.Constants.UI.Buttons.B_HEIGHT;
import static utils.Constants.UI.Buttons.B_HEIGHT_DEFAULT;
import static utils.Constants.UI.Buttons.B_WIDTH;
import static utils.Constants.UI.Buttons.B_WIDTH_DEFAULT;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gameStates.GameState;
import utils.LoadSave;

public class MenuButton {
	private int xPos, yPos, rowIndex, index;

	private int xOffsetCenter = B_WIDTH / 2;
	private boolean mouseOver, mousePressed;
	private GameState state;
	private BufferedImage[] buttonImgs;
	private Rectangle bounds;
	
	public MenuButton(int xPos, int yPos, int rowIndex, GameState state) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.rowIndex = rowIndex;
		this.state = state;
		loadImgs();
		
		initBounds();
	
		
	}

	private void initBounds() {
		bounds = new Rectangle(xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT);
		
	}

	private void loadImgs() {
		buttonImgs = new BufferedImage[3];
		BufferedImage temp = LoadSave.getSpriteAtlas(LoadSave.MENU_BUTTONS);
		
		for (int i = 0; i < buttonImgs.length; i++) {
			buttonImgs[i] = temp.getSubimage(i * B_WIDTH_DEFAULT, rowIndex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
		}
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(buttonImgs[index], xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT, null);
	}
	
	public void update() {
		index = 0;
		
		if (mouseOver)
			index = 1;
		if (mousePressed)
			index = 2;
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

	public void applyGameState() {
		GameState.state = state;
	}
	
	public void resetBools() {
		mouseOver = false;
		mousePressed = false;
	}
	
}

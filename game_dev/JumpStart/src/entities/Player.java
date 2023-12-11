package entities;

import static utils.Constants.PlayerConstants.*;
import static utils.Constants.PlayerConstants.getSpriteAmount;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import utils.LoadSave;

public class Player extends Entity {
	
	private BufferedImage[][] ninjaFrogAni;
	private int ninjaFrogTick, ninjaFrogInd, ninjaFrogSpeed = 10;
	private int playerAction = IDLE;
	private boolean moving = false, doubleJump = false;
	private boolean left, up, right, down;
	private float x, y;
	private float playerSpeed = 2.0f;

	public Player(float x, float y) {
		super(x, y);
		loadAnimations();
	}
	
	public void update() {	
		updatePos();
		updateAnimationTick();		
		setAnimation();		
	}
	
	public void render(Graphics g) {	
		g.drawImage(ninjaFrogAni[playerAction][ninjaFrogInd], (int) x, (int) y, 40, 40, null);
	}
	
	private void updateAnimationTick() {	
		ninjaFrogTick++;
		if (ninjaFrogTick >= ninjaFrogSpeed) {
			ninjaFrogTick = 0;
			ninjaFrogInd++;
			if (ninjaFrogInd >= getSpriteAmount(playerAction)) {
				ninjaFrogInd = 0;
				doubleJump = false;
			}
		}	
	}
	
	private void setAnimation() {
		int startAni = playerAction;
		
		if (moving) {
			playerAction = RUNNING;
		}
		else {
			playerAction = IDLE;
		}
		
		if (doubleJump) {
			playerAction = DOUBLE_JUMP;
		}
		
		if (startAni != playerAction) {
			resetNinjaFrogTick();
		}
	}
	
	private void resetNinjaFrogTick() {
		ninjaFrogTick = 0;
		ninjaFrogInd = 0;
		
	}

	private void updatePos() {
		moving = false;
		
		if (left && !right ) {
			x -= playerSpeed;
			moving = true;
		}
		else if (!left && right) {
			x += playerSpeed;
			moving = true;
		}
		
		if (up && !down) {
			y -= playerSpeed;
			moving = true;
		}
		else if (!up && down) {
			y += playerSpeed;
			moving = true;
		}
	}
	
	private void loadAnimations() {
		BufferedImage img = LoadSave.getSpriteAtlas(LoadSave.PLAYER_ATLAS);
		
		ninjaFrogAni = new BufferedImage[7][12];
		for (int j = 0; j < ninjaFrogAni.length; j++) {
			for (int i = 0; i < ninjaFrogAni[j].length; i++) {
				ninjaFrogAni[j][i] = img.getSubimage(i*32, j*32, 32, 32);
			}
		}
	}
	
	public void resetDirBooleans() {
		this.left = false;
		this.up = false;
		this.right = false;
		this.down = false;
	}
	
	public void setDoubleJump(boolean doubleJump) {
		this.doubleJump = doubleJump;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}
	
	

}

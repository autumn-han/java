package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import static utils.Constants.PlayerConstants.*;
import static utils.Constants.Directions.*;

public class GamePanel extends JPanel {
	
	private MouseInputs mouseInputs;
	private float xDelta = 100f, yDelta = 100f;
	private BufferedImage img, subImg;
	private BufferedImage[][] ninjaFrogAni;
	private int ninjaFrogTick, ninjaFrogInd, ninjaFrogSpeed = 10;
	private int playerAction = IDLE;
	private int playerDirection = -1;
	private boolean moving = false;
	
	public GamePanel() {
		
		mouseInputs = new MouseInputs(this);
		importImg();
		loadAnimations();
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}

	private void setPanelSize() {
		Dimension size = new Dimension(1280, 800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}
	
	private void importImg() {
		InputStream is = getClass().getResourceAsStream("/ninjaFrogAll.png");
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
	}
	
	private void loadAnimations() {
		ninjaFrogAni = new BufferedImage[7][12];
		for (int j = 0; j < ninjaFrogAni.length; j++) {
			for (int i = 0; i < ninjaFrogAni[j].length; i++) {
				ninjaFrogAni[j][i] = img.getSubimage(i*32, j*32, 32, 32);
			}
		}
	}
	
	private void updateAnimationTick() {
		ninjaFrogTick++;
		if (ninjaFrogTick >= ninjaFrogSpeed) {
			ninjaFrogTick = 0;
			ninjaFrogInd++;
			if (ninjaFrogInd >= getSpriteAmount(playerAction)) {
				ninjaFrogInd = 0;
			}
		}
	}
	
	private void setAnimation() {
		if (moving) {
			playerAction = RUNNING;
		}
		else {
			playerAction = IDLE;
		}
	}
	
	private void updatePos() {
		if (moving) {
			switch (playerDirection) {
			case LEFT:
				xDelta -= 5;
				break;
			case UP: 
				yDelta -= 5;
				break;
			case RIGHT:
				xDelta += 5;
				break;
			case DOWN:
				yDelta += 5;
				break;
			}
		}
	}
	
	public void setDirection(int direction) {
		this.playerDirection = direction;
		moving = true;
	}
	
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public void updateGame() {
		
		updateAnimationTick();		
		setAnimation();		
		updatePos();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	

		g.drawImage(ninjaFrogAni[playerAction][ninjaFrogInd], (int) xDelta, (int) yDelta, 80, 80, null);
		
	}

}

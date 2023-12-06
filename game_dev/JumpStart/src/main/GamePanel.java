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

public class GamePanel extends JPanel {
	
	private MouseInputs mouseInputs;
	private float xDelta = 100f, yDelta = 100f;
	private BufferedImage img, subImg;
	private BufferedImage[][] ninjaFrogAni;
	private int idleNinjaFrogTick, idleNinjaFrogInd, idleNinjaFrogSpeed = 7;
	
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
//		idleNinjaFrogTick++;
//		if (idleNinjaFrogTick >= idleNinjaFrogSpeed) {
//			idleNinjaFrogTick = 0;
//			idleNinjaFrogInd++;
//			if (idleNinjaFrogInd >= ninjaFrogAni.length) {
//				idleNinjaFrogInd = 0;
//			}
//		}
	}
	
	public void changeXDelta(int value) {
		this.xDelta += value;
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
	}
	
	public void setCharPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		
		updateAnimationTick();

		g.drawImage(ninjaFrogAni[2][2], (int) xDelta, (int) yDelta, 80, 80, null);
		
	}

}

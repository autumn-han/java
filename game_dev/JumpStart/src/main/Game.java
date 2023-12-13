package main;

import java.awt.Graphics;

import entities.Player;
import levels.LevelManager;

public class Game implements Runnable {
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private LevelManager levelManager;
	private Player player;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	
	public static final int TILES_DEFAULT_SIZE = 32;
	public static final float SCALE = 1.5f;
	public static final int TILES_IN_WIDTH = 26;
	public static final int TILES_IN_HEIGHT = 14;
	public static final int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
	public static final int GAME_WIDTH = TILES_IN_WIDTH * TILES_SIZE;
	public static final int GAME_HEIGHT = TILES_IN_HEIGHT * TILES_SIZE;
	
	public Game() {
		initClasses();
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();
	}
	
	private void initClasses() {
		levelManager = new LevelManager(this);
		player = new Player(200, 200, (int) (32*SCALE), (int) (32*SCALE));
		player.loadLevelData(levelManager.getCurrentLevel().getLevelData());
		
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void update() {
		levelManager.update();
		player.update();
	}
	
	public void render(Graphics g) {
		levelManager.draw(g);
		player.render(g);
	}

	@Override
	public void run() {
		
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;
		
		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		long previousTime = System.nanoTime();
		
		double deltaU = 0;
		double deltaF = 0;
		
		while (true) {
			
			long currentTime = System.nanoTime();
			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;
			
			if (deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}
			
			if (deltaF >= 1) {		
				gamePanel.repaint();
				frames++;
				deltaF--;
			}
			
			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | " + "UPS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		
	}
	
	public void windowFocusLost() {
		player.resetDirBooleans();
	}
	
	public Player getPlayer() {
		return player;
	}
}

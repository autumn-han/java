package gameStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.Player;
import levels.LevelManager;
import main.Game;

public class Playing extends State implements StateMethods {
	
	private LevelManager levelManager;
	private Player player;
	
	public Playing(Game game) {
		super(game);
		initClasses();
	}
	
	private void initClasses() {
		levelManager = new LevelManager(game);
		player = new Player(200, 200, (int) (32*Game.SCALE), (int) (32*Game.SCALE));
		player.loadLevelData(levelManager.getCurrentLevel().getLevelData());
		
	}

	@Override
	public void update() {
		levelManager.update();
		player.update();
		
	}

	@Override
	public void draw(Graphics g) {
		levelManager.draw(g);
		player.render(g);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			player.setDoubleJump(true);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:			
			player.setLeft(true);
			break;
		case KeyEvent.VK_D:			
			player.setRight(true);
			break;	
		case KeyEvent.VK_SPACE:
			player.setJump(true);
			break;
		case KeyEvent.VK_BACK_SPACE:
			GameState.state = GameState.MENU;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			player.setLeft(false);
			break;
		case KeyEvent.VK_D:
			player.setRight(false);
			break;
		case KeyEvent.VK_SPACE:
			player.setJump(false);
			break;
		}
		
	}
	
	public Player getPlayer() {
		return player;
	}
}
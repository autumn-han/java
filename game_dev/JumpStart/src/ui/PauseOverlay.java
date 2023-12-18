package ui;

import static utils.Constants.UI.PauseButtons.SOUND_SIZE;
import static utils.Constants.UI.UrmButtons.URM_SIZE;
import static utils.Constants.UI.VolumeButtons.*;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import gameStates.GameState;
import gameStates.Playing;
import main.Game;
import utils.LoadSave;

public class PauseOverlay {
	
	private BufferedImage backgroundImg;
	private int bgX, bgY, bgW, bgH;
	private SoundButton musicButton, sfxButton;
	private UrmButton menuButton, replayButton, unpausedButton;
	private VolumeButton volumeButton;
	private Playing playing;
	
	public PauseOverlay(Playing playing) {
		this.playing = playing;
		loadBackground();
		createSoundButtons();
		createUrmButtons();
		createVolumeButton();
		
	}
	
	private void createVolumeButton() {
		int volX = (int) (309 * Game.SCALE);
		int volY = (int) (278 * Game.SCALE);
		volumeButton = new VolumeButton(volX, volY, SLIDER_WIDTH, VOLUME_HEIGHT);
		
	}

	private void createUrmButtons() {
		int menuX = (int) (313 * Game.SCALE);
		int replayX = (int) (387 * Game.SCALE);
		int unpausedX = (int) (462 * Game.SCALE);
		int buttonY = (int) (325 * Game.SCALE);
		
		menuButton = new UrmButton(menuX, buttonY, URM_SIZE, URM_SIZE, 2);
		replayButton = new UrmButton(replayX, buttonY, URM_SIZE, URM_SIZE, 1);
		unpausedButton = new UrmButton(unpausedX, buttonY, URM_SIZE, URM_SIZE, 0);
		
	}

	private void createSoundButtons() {
		int soundX = (int) (450 * Game.SCALE);
		int musicY = (int) (140 * Game.SCALE);
		int sfxY = (int) (186 * Game.SCALE);
		
		musicButton = new SoundButton(soundX, musicY, SOUND_SIZE, SOUND_SIZE);
		sfxButton = new SoundButton(soundX, sfxY, SOUND_SIZE, SOUND_SIZE);
	}

	private void loadBackground() {
		backgroundImg = LoadSave.getSpriteAtlas(LoadSave.PAUSE_BACKGROUND);
		bgW = (int) (backgroundImg.getWidth() * Game.SCALE);
		bgH = (int) (backgroundImg.getHeight() * Game.SCALE);
		bgX = Game.GAME_WIDTH / 2 - bgW / 2;
		bgY = (int) (25 * Game.SCALE);
		
	}

	public void update() {
		musicButton.update();
		sfxButton.update();
		menuButton.update();
		replayButton.update();
		unpausedButton.update();
		volumeButton.update();
	}
	
	public void draw(Graphics g) {
		// background menu
		g.drawImage(backgroundImg, bgX, bgY, bgW, bgH, null);
		
		// sound buttons
		musicButton.draw(g);
		sfxButton.draw(g);
		
		// urm buttons
		menuButton.draw(g);
		replayButton.draw(g);
		unpausedButton.draw(g);
		
		// volume slider
		volumeButton.draw(g);
		
	}
	
	public void mouseDragged(MouseEvent e) {
		if (volumeButton.isMousePressed())
			volumeButton.changeX(e.getX());
	}
	
	public void mousePressed(MouseEvent e) {
		if (isIn(e, musicButton))
			musicButton.setMousePressed(true);
		else if (isIn(e, sfxButton))
			sfxButton.setMousePressed(true);
		else if (isIn(e, menuButton))
			menuButton.setMousePressed(true);
		else if (isIn(e, replayButton)) 
			replayButton.setMousePressed(true);
		else if (isIn(e, unpausedButton))
			unpausedButton.setMousePressed(true);
		else if (isIn(e, volumeButton))
			volumeButton.setMousePressed(true);
		
	}

	public void mouseReleased(MouseEvent e) {
		if (isIn(e, musicButton)) {
			if (musicButton.isMousePressed()) 
				musicButton.setMuted(!musicButton.isMuted());
		} else if (isIn(e, sfxButton)) {
			if (sfxButton.isMousePressed())
				sfxButton.setMuted(!sfxButton.isMuted());
		} else if (isIn(e, menuButton)) {
			if (menuButton.isMousePressed())
				GameState.state = GameState.MENU;
				playing.unpauseGame();
		} else if (isIn(e, replayButton)) {
			if (replayButton.isMousePressed())
				System.out.println("REPLAY");
		} else if (isIn(e, unpausedButton)) {
			if (unpausedButton.isMousePressed())
				playing.unpauseGame();
		}
		
		musicButton.resetBools();
		sfxButton.resetBools();
		menuButton.resetBooleans();
		replayButton.resetBooleans();
		unpausedButton.resetBooleans();
		volumeButton.resetBooleans();
	}

	public void mouseMoved(MouseEvent e) {
		musicButton.setMouseOver(false);
		sfxButton.setMouseOver(false);
		menuButton.setMouseOver(false);
		replayButton.setMouseOver(false);
		unpausedButton.setMouseOver(false);
		volumeButton.setMouseOver(false);
		
		if (isIn(e, musicButton))
			musicButton.setMouseOver(true);
		else if (isIn(e, sfxButton))
			sfxButton.setMouseOver(true);
		else if (isIn(e, menuButton))
			menuButton.setMouseOver(true);
		else if (isIn(e, replayButton))
			replayButton.setMouseOver(true);
		else if (isIn(e, unpausedButton))
			unpausedButton.setMouseOver(true);
		else if (isIn(e, volumeButton))
			volumeButton.setMouseOver(true);
		
	}

	private boolean isIn(MouseEvent e, PauseButton b) {
		return b.getBounds().contains(e.getX(), e.getY());
	}
	

}

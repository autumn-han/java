package utils;

import main.Game;

public class Constants {
	
	public static class UI {
		
		public static class Buttons {
			public static final int B_WIDTH_DEFAULT = 140;
			public static final int B_HEIGHT_DEFAULT = 56;
			public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
		}
	
		public static class PauseButtons {
			public static final int SOUND_SIZE_DEFAULT = 42;
			public static final int SOUND_SIZE = (int) (SOUND_SIZE_DEFAULT * Game.SCALE);
		}
		
		public static class UrmButtons {
			public static final int URM_DEFAULT_SIZE = 56;
			public static final int URM_SIZE = (int) (URM_DEFAULT_SIZE * Game.SCALE);
		}
		
	}
	
	public static class Directions {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

	public static class PlayerConstants {
		public static final int DOUBLE_JUMP = 0;
		public static final int FALLING = 1;
		public static final int HIT = 2;
		public static final int IDLE = 3;
		public static final int JUMP = 4;
		public static final int RUNNING = 5;
		public static final int WALL_JUMP = 6;
		
		public static int getSpriteAmount(int player_action) {
			
			switch(player_action) {
			case DOUBLE_JUMP:
				return 6;
			case FALLING:
			case JUMP:
				return 1;
			case HIT:
				return 7;
			case IDLE:
				return 11;
			case RUNNING:
				return 12;
			case WALL_JUMP:
				return 5;
			default:
				return 1;
			}
		}
	}
}

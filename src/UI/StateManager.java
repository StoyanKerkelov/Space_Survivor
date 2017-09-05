package UI;

public class StateManager {

	public static enum GameState {

		MAINMENU, GAME, SCORESCREEN // there is no need for GameState.QUIT just:
									// System.exit(0);
	}

	public static GameState gameState = GameState.MAINMENU;

	public static void update() {

		switch (gameState) {

		case MAINMENU:
			System.out.println("mainMenu");
			break;

		case GAME:
			System.out.println("Game");
			break;

		case SCORESCREEN:
			System.out.println("Score screen");
			break;

		}
	}
}

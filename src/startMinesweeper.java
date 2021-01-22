import javafx.application.Application;
import javafx.stage.Stage;

public class startMinesweeper extends Application {
	int x,y,bombs;
	
	MinesweeperView view;
	MinesweeperModel model;
	MinesweeperController controller;
	
	// Main program file. Contains launch for JavaFX
	public static void main(String[] args) {
		launch(args);
	}
	
	
	/*
	 * The entire group
	 * Load arguments into game.
	 * creates a new Model, view and controller.
	 * Set options for game
	 * Open a game window
	 * 
	 * Input: arguments given by user(size of board and number of bombs)
	 * Output: new game window
	 * 	
	 */
	public void start(Stage topLevelStage) throws Exception {
		x = 10;
		y = 10;
		bombs = 10;
		
		view = new MinesweeperView();
		model = new MinesweeperModel(x,y,bombs);
		controller = new MinesweeperController(model, view);
		
		view.SetOptions(topLevelStage, controller, x, y, "basicgame");
		topLevelStage = view.basicGame();
		topLevelStage.show();
	}
}	
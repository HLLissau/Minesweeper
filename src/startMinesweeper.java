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
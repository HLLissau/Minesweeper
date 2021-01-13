import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class startMinesweeper extends Application {
	
	MinesweeperModel model;
	
	int gameState;
	int x,y,bombs;
	GridPane grid;
	MinesweeperController controller;
	MinesweeperView view;
	ObservableList<Node> childrens;
	// Main program file. Contains main and controllor
	
		
	public static void main(String[] args) {
	
		launch(args);
	}
	public static void victory() {
		System.out.println("Victory Royale!");
	}
	public static void defeat() {
		System.out.println("Defeat screen :(");
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
		
		
		
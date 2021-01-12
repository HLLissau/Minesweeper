import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Testfil extends Application {
	MinesweeperModel model;
	MinesweeperController controller;
	MinesweeperView view;
	
	
	public static void main(String args[]) {
//		this.model = new MinesweeperModel(10,10,10);
//		this.controller = new MinesweeperController(model);
//		this.view = new MinesweeperView(10,10,controller);
		
		launch(args);
	}
	
	public void start(Stage topLevelStage) throws Exception {
		this.model = new MinesweeperModel(10,10,10);
		this.controller = new MinesweeperController(model);
		this.view = new MinesweeperView(10,10,controller);
		view.loadstage(topLevelStage);
	}
	
}
	
	
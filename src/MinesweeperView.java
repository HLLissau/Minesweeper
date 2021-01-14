import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class MinesweeperView {
	MinesweeperController controller;
	Stage stage;
	String title;
	Image[] images;
	
	//MinesweeperView initiates constructor to make view
	public MinesweeperView() {
		setPictures();
	}
	
	//Set game parameters
	public void SetOptions(Stage topLevelStage, MinesweeperController controller, String title) {
		this.stage = topLevelStage;
		this.controller = controller;
		this.title = title;
	}
	
	//Load pictures to images array
	public void setPictures() {
		this.images = new Image[10];
		
		for(int i = 0; i<10; i++) {
			String name ="images\\" + i + ".png";
			images[i] = new Image(name);
			
		}
	}
	
	/*
	 * Load pictures from view to game. If out of bounds, last index is returned.
	 * Input: x (array index)
	 * Output: Image from array index (x)
	 */
	public Image getPicture(int x) {
		if (!(x<this.images.length)||(x<0)) {
			x = this.images.length-1;
		}
		
		return images[x];
	}
	
	
	//Sets the stage
	public Stage basicGame() {
		this.stage.setTitle(title);
		StackPane layout = new StackPane();
		layout.getChildren().add(controller.getGrid());
		Scene scene = new Scene(layout, 23*controller.model.getm(), 25*controller.model.getn());
		stage.setScene(scene);
		return stage;
	}
	
	/*
	 * Open game over window.
	 * Output: new Stage with game over window. This window contains a button, if pressed begins a new game.
	 */
	
	public Stage gameOver() {
		
		controller.clearButtonAction();
		Stage gameOverScreen = new Stage();
		gameOverScreen.setTitle("Game Over");
		
		//button (Begin new game)
		Button button = new Button();
		button.setText("New game");
		button.setOnAction(e -> controller.gotoNewGame(gameOverScreen));
		
		//Layout
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene= new Scene(layout,200,150);
		gameOverScreen.setScene(scene);
		gameOverScreen.show();
		
		
		return gameOverScreen;
	}
	
	/*
	 * Open victory window
	 * Output: new Stage with victory screen. This window contains a button, if pressed begins a new game.
	 */
	public Stage victory() {
		
		controller.clearButtonAction();
		Stage victoryScreen = new Stage();
		victoryScreen.setTitle("Victory");
		
		//button (Begin new game)
		Button button = new Button();
		button.setText("New game");
		button.setOnAction(e -> controller.gotoNewGame(victoryScreen));
		
		//Layout
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene= new Scene(layout,200,150);
		victoryScreen.setScene(scene);
		victoryScreen.show();
		controller.clearButtonAction();
		return victoryScreen;
	}
}
